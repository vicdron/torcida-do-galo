package vicdron.com.cantosdogalo;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Cantos extends AppCompatActivity {
    private ImageView aumentarFonte;
    private ImageButton btshare;
    private ImageView diminuirFonte;
    private MediaPlayer mp;
    private ImageView grupoBotao, notificacao;
    private Handler handler;
    private Runnable runnable;
    private SeekBar seekBar;
    private float tamanhoTexto;
    private TextView textoCantico;
    private Toolbar toolbar;
    private TextView toolbarText;
    private InterstitialAd mInterstitialAd;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cantos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AdRequest adRequest = new AdRequest.Builder().build();
        ((AdView) findViewById(R.id.adView)).loadAd(new AdRequest.Builder().build());
        this.btshare = (ImageButton) findViewById(R.id.btshare);
        this.notificacao = (ImageView) findViewById(R.id.notificacao);
        this.grupoBotao = (ImageView) findViewById(R.id.grupo);
        this.seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.textoCantico = (TextView) findViewById(R.id.letra);
        this.aumentarFonte = (ImageView) findViewById(R.id.aumentarFonte);
        this.diminuirFonte = (ImageView) findViewById(R.id.diminuirFonte);
        this.tamanhoTexto = 15.0f;

        //-----------------Botões para alterar tamanho da fonte.----------------------------------------
        aumentarFonte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoCantico.setTextSize(tamanhoTexto++);
            }
        });
        diminuirFonte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoCantico.setTextSize(tamanhoTexto--);
            }
        });

        // Dados da canto selecionado -----------------------------------------------------------------
        this.textoCantico.setText(getIntent().getExtras().getString("letra"));
        String recebeToque = getIntent().getExtras().getString("ringtone");
        final int i = getIntent().getExtras().getInt("completo");
        this.mp = MediaPlayer.create(this, i);

   // Botão compartilhar ------------------------------------------------------------------------------
        this.btshare.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(Cantos.this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    try {
                        String copyFiletoExternalStorage = copyFiletoExternalStorage(i, "galo.mp3");
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.putExtra("android.intent.extra.STREAM", Uri.parse(copyFiletoExternalStorage));
                        intent.setType("audio/*");
                        Cantos.this.startActivity(Intent.createChooser(intent, "Compartilhado!"));
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    } catch (Exception unused) {
                        Toast.makeText(getApplicationContext(), "Aplicativo de mensagem não se encontra instalado", Toast.LENGTH_LONG).show();
                    }
                } else if (ActivityCompat.shouldShowRequestPermissionRationale(Cantos.this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    Toast.makeText(Cantos.this,
                            "Permissão WRITE_EXTERNAL_STORAGE foi negada!. Ative a opção de gravar em mémoria nas configurações do ANDROID. ", Toast.LENGTH_SHORT).show();
                } else {
                    ActivityCompat.requestPermissions(Cantos.this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
                }
            }

            private String copyFiletoExternalStorage(int i, String str) {
                String str2 = Environment.getExternalStorageDirectory() + "/Android/data/" + str;
                try {
                    InputStream openRawResource = Cantos.this.getResources().openRawResource(i);
                    FileOutputStream fileOutputStream = new FileOutputStream(str2);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        try {
                            int read = openRawResource.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        } finally {
                            openRawResource.close();
                            fileOutputStream.close();
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return str2;
            }
        });

   //  Ringtone -------- ------------------------------------------------------------------------------
        this.notificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(hassettingPermissions()==false && hasReadPermissions()==false && hasWritePermissions()==false) {

                    AlertDialog.Builder builderSingle1 = new AlertDialog.Builder(Cantos.this);
                    builderSingle1.setIcon(R.mipmap.ic_launcher);
                    builderSingle1.setTitle("Permissão");
                    builderSingle1.setMessage("Permitir que o aplicativo defina o toque do celular");
                    builderSingle1.setPositiveButton("Permitir", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            requestAppPermissions();
                            requestsettingpermission();
                        }
                    });
                    builderSingle1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    });
                    builderSingle1.show();

                } else {
                    AlertDialog.Builder builderSingle = new AlertDialog.Builder(Cantos.this);
                    builderSingle.setIcon(R.mipmap.ic_launcher);
                    builderSingle.setTitle("Definir como...");

                    final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Cantos.this, android.R.layout.select_dialog_item);
                    arrayAdapter.add("Ringtone");
                    arrayAdapter.add("Notification");
                    arrayAdapter.add("Alarm");
                    builderSingle.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {


                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String strName = arrayAdapter.getItem(which);

                            if (strName == "Ringtone") {

                                String hino =  "/raw/" + recebeToque;
                                Uri uri = Uri.parse("android.resource://" + getPackageName() + hino);
                                RingtoneManager.setActualDefaultRingtoneUri(Cantos.this, RingtoneManager.TYPE_RINGTONE, uri);
                                Toast.makeText(Cantos.this, "Hino Definido Como Toque Do Celular   ", Toast.LENGTH_LONG).show();

                            } else if (strName == "Notification") {
                                String hino =  "/raw/" + recebeToque;
                                Uri uri = Uri.parse("android.resource://" + getPackageName() + hino);
                                RingtoneManager.setActualDefaultRingtoneUri(Cantos.this, RingtoneManager.TYPE_NOTIFICATION, uri);
                                Toast.makeText(Cantos.this, "Hino Definido Como Toque De Notificação   ", Toast.LENGTH_LONG).show();

                            } else if (strName == "Alarm") {
                                String hino =  "/raw/" + recebeToque;
                                Uri uri = Uri.parse("android.resource://" + getPackageName() + hino);
                                RingtoneManager.setActualDefaultRingtoneUri(Cantos.this, RingtoneManager.TYPE_ALARM, uri);
                                Toast.makeText(Cantos.this, "Hino Definido Como Alarme Do Celular   ", Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                    builderSingle.show();
                    //

                }
            }
        });



        this.handler = new Handler();
        this.grupoBotao.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Cantos.this.seekBar.setVisibility(View.VISIBLE);
                Cantos.this.grupoBotao.setAlpha(50);
                if (Cantos.this.mp.isPlaying()) {
                    Cantos.this.mp.pause();
                    Cantos.this.grupoBotao.setAlpha(1000);
                    return;
                }
                Cantos.this.mp.start();
                Cantos.this.seekBar.setMax(Cantos.this.mp.getDuration());
                Cantos.this.mp.seekTo(Cantos.this.seekBar.getProgress());
                Cantos.this.mp.setLooping(true);
                Cantos.this.playGrupo();
            }
        });
        this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    Cantos.this.mp.seekTo(i);
                    seekBar.setProgress(i);
                }
            }
        });
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbarText = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("");
        this.toolbarText.setText(getIntent().getExtras().getString("titulo"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        InterstitialAd.load(this,"ca-app-pub-4782720719921842/8966807570", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                        // Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        //  Log.i(TAG, loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });
    }

    public void displayInterstitial() {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(Cantos.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }
    }
    @Override
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            displayInterstitial();
        }
        return super.onKeyDown(i, keyEvent);
    }


    private void playGrupo() {
        this.seekBar.setProgress(this.mp.getCurrentPosition());
        if (this.mp.isPlaying()) {
            runnable= new Runnable() {

                public void run() {
                    Cantos.this.playGrupo();
                }
            };
            this.runnable = runnable;
            this.handler.postDelayed(runnable, 100);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.mp.stop();
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onDestroy() {
        this.mp.stop();
        this.mp.release();
        this.mp = null;
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        this.mp.stop();
        finish();
    }

    // VERIFICAção de Permissoes -------------------------------------------------------------------
    private void requestAppPermissions() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }

        if (hasReadPermissions() && hasWritePermissions()) {
            return;
        }

        ActivityCompat.requestPermissions(this,
                new String[] {
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                } , MODE_ENABLE_WRITE_AHEAD_LOGGING); // your request code
    }
    private boolean hasReadPermissions() {
        return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }
    private boolean hasWritePermissions() {
        return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }
    private void requestsettingpermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }
        if (hassettingPermissions()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.System.canWrite(getApplicationContext())) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS, Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, 200);
            }
        }
    }
    private boolean hassettingPermissions() {
        return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.WRITE_APN_SETTINGS) == PackageManager.PERMISSION_GRANTED);
    }

}
