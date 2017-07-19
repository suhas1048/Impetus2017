package android.developers.uvce.impetus2017;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baoyz.widget.PullRefreshLayout;

public class Forum_student extends AppCompatActivity {
    public static final String JSON_URL = "http://getgo.co.in/impetus/forum_json.php";
    ConnectivityManager connectivityManager;
    TextView important_topic;
    NetworkInfo networkInfo;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_student);
        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();
//important_topic=(TextView)findViewById(R.id.important);
        sendRequest();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isOnline()){
                    //go to nxt activity
                    Intent intent=new Intent("android.developers.uvce.impetus2017.Forum_form_submission");
                    startActivity(intent);

                }
                else {
                    Snackbar.make(view, "We cannot find an internet connection,please try again!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            }
        });
        listView = (ListView) findViewById(R.id.listView);
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
        pd = ProgressDialog.show(Forum_student.this, "Fetching articles",
                "Please wait", true);
        pd.setCanceledOnTouchOutside(true);

        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.dismiss();
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.dismiss();
                        Toast.makeText(Forum_student.this, "No internet available or there is a server error,try again later", Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json){
        ParseJSON_f pj = new ParseJSON_f(json);
        pj.parseJSON_f();
        // important_topic.setText(pj.dummy[0]);
        CustomList_f cl = new CustomList_f(this, ParseJSON_f.headline,ParseJSON_f.content,ParseJSON_f.date,ParseJSON_f.name,ParseJSON_f.dummy);
        listView.setAdapter(cl);
    }
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null &&
                cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }


}

