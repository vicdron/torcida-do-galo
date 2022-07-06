package vicdron.com.cantosdogalo;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class InformacaoFragment extends Fragment {

    private ImageView imagemLogo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle   savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_informacao, container, false);

        ((AdView) view.findViewById(R.id.adView)).loadAd(new AdRequest.Builder().build());
        ImageView imageView = (ImageView) view.findViewById(R.id.imagemLogo);
        this.imagemLogo = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                try {
                    InformacaoFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/developer?id=Vicdron")));
                } catch (ActivityNotFoundException unused) {
                    InformacaoFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=cantosdomengao.vicdron.com.cantosdomengo")));
                }
            }
        });
        return view;

    }


}