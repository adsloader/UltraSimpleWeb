package com.psw.ultrasimpleweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private WebView webview;
    private Button btnNaver;
    private Button btnGoogle;
    private Button btnMyHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUI();
    }

    private void setUpUI() {
        webview = (WebView)findViewById(R.id.wbMain);
        // webview client 객체를 넘긴다.
        webview.setWebViewClient(new WebClient());
        // 브라우저 세팅을 가져온다.
        WebSettings set = webview.getSettings();
        // 자바스크립트를 실행가능하게
        set.setJavaScriptEnabled(true);
        // 줌인아웃을 불가능하게
        set.setBuiltInZoomControls(false);

        btnNaver = (Button) findViewById(R.id.btnNaver);
        btnNaver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 이동한다.
                webview.loadUrl("http://www.naver.com");

            }
        });

        btnGoogle = (Button) findViewById(R.id.btnGoogle);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 이동한다.
                webview.loadUrl("http://www.google.com");

            }
        });

        btnMyHome = (Button) findViewById(R.id.btnMyHome);
        btnMyHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 이동한다.
                webview.loadUrl("http://blog.naver.com/adsloader");

            }
        });
    }

    // webview에서 필요한 클래스
    class WebClient extends WebViewClient {
        // URL을 요청했다면...
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
