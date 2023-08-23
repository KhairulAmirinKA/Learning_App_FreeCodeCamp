package LibraryProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.freecodecampeg.R;

public class Website_Activity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity_website);

        //intent
        Intent intent= getIntent();

        if (intent!= null){

            String url= intent.getStringExtra("url");
            //the code is reusable
            //in LibraryApp.java,           intent.putExtra("url", "https://google.com");

            //init
            webView =findViewById(R.id.webView);

            webView.loadUrl(url);

            //to open the Url in the app
            webView.setWebViewClient(new WebViewClient());

            //enable JS
            webView.getSettings().setJavaScriptEnabled(true);
        }



    }

    @Override
    public void onBackPressed() {

        //prevent from going to the main page while browsing
        if (webView.canGoBack()){
            webView.goBack();
        }

        else {
            super.onBackPressed();
        }

    }
}