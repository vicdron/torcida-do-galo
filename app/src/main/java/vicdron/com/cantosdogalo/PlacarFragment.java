package vicdron.com.cantosdogalo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class PlacarFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_placar, container, false);
        ((AdView) view.findViewById(R.id.adView)).loadAd(new AdRequest.Builder().build());

        WebView webView = (WebView) view.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/search?q=partidas+atletico+mg&rlz=1C5CHFA_enBR957BR957&oq=partidas+atletico&aqs=chrome.0.0i512l2j69i57j0i10i512j0i22i30j0i10i22i30.6681j1j7&sourceid=chrome&ie=UTF-8#sie=t;/m/019m6z;2;/m/0fnk7q;mt;fp;1;;");

        return view;
    }
}