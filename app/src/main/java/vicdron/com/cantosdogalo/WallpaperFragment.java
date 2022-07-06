package vicdron.com.cantosdogalo;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import java.io.IOException;
import java.util.ArrayList;

public class WallpaperFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        int image[] = {
                R.drawable.galo1,
                R.drawable.galo2,
                R.drawable.galo3,
                R.drawable.galo4,
                R.drawable.galo5,
                R.drawable.galo6,
                R.drawable.galo7,
                R.drawable.galo8,
                R.drawable.galo9,
                R.drawable.galo10,
                R.drawable.galo11,
                R.drawable.galo12,
        };
        GridView gridView;
        ArrayList<imageModel> arrayList;

        View view =  inflater.inflate(R.layout.fragment_wallpaper, container, false);
        ((AdView) view.findViewById(R.id.adView)).loadAd(new AdRequest.Builder().build());

        gridView = (GridView) view.findViewById(R.id.gridview);
        arrayList = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            imageModel imagemodel = new imageModel();
            imagemodel.setmThumbIds(image[i]);
            //add in array list
            arrayList.add(imagemodel);
        }

        imageAdapter adpter= new imageAdapter(getActivity().getApplicationContext(), arrayList);
        gridView.setAdapter(adpter);
        //item click listner
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), image[position]);
                WallpaperManager manager = WallpaperManager.getInstance(getActivity().getApplicationContext());
                try {
                    manager.setBitmap(bitmap);
                      Toast.makeText(getActivity(),"Definido como Wallpaper!",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(getActivity(),"Erro!",Toast.LENGTH_SHORT).show();
                }
            }

        });
        return view;
    }

}