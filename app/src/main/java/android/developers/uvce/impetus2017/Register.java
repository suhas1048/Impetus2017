package android.developers.uvce.impetus2017;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;

public class Register extends AppCompatActivity {
    WebView webView;
    ProgressDialog progressDialog;
    ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        if(networkInfo!=null && networkInfo.isConnected()){


            webView = (WebView) findViewById(R.id.webView);
            webView.setWebViewClient(new MyBrowser());
            webView.getSettings().setLoadsImagesAutomatically(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setLoadWithOverviewMode(true);

            webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webView.loadUrl("https://www.krispypapad.com/impetus2017");





        }
        else
        {
            Toast.makeText(getApplicationContext(),"No internet is available",Toast.LENGTH_LONG).show();
        }


//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final PullRefreshLayout layout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        layout.setRefreshStyle(PullRefreshLayout.STYLE_CIRCLES);
// listen refresh event
        layout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                sendRequest();
                layout.setRefreshing(false);
                // start refresh
            }
        });

// refresh complete


    }



    private void sendRequest() {
        final ProgressDialog pd;
        webView.loadUrl("http://www.impetus17.com/#/");
        pd = ProgressDialog.show(Register.this, "Refreshing",
                "Please wait", true);
        pd.setCanceledOnTouchOutside(true);


    }


    @Override


    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN ) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }




        return super.onKeyDown(keyCode, event);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progressDialog = new ProgressDialog(Register.this);
            progressDialog.setMessage("Taking you there");


            progressDialog.show();



            super.onPageStarted(view, url, favicon);

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            progressDialog = new ProgressDialog(Register.this);
            progressDialog.setMessage("Taking you there...");


            progressDialog.cancel();
            progressDialog.dismiss();
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            try{
                if (progressDialog.isShowing()|| progressDialog!= null) {
                    progressDialog.dismiss();
                    progressDialog.cancel();
                    progressDialog= null; /*** Add ***/
                }

            }catch(Exception exception){
                exception.printStackTrace();


            }

        }





        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText(Register.this,"You dont seem to have an active internet connection,Please try again later", Toast.LENGTH_SHORT).show();

        }
    }


}