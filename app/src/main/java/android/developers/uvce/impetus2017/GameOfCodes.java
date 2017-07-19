package android.developers.uvce.impetus2017;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class GameOfCodes extends AppCompatActivity {
    ImageView date,cash,group,call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_of_codes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        date=(ImageView)findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(GameOfCodes.this);
                alert.setTitle("Date");
                alert.setMessage("25th March");
                alert.setPositiveButton("OK", null);
                alert.show();
            }
        });

        cash=(ImageView)findViewById(R.id.cash);
        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(GameOfCodes.this);
                alert.setTitle("Cash Prize");
                alert.setMessage("1st Prize- Rs.2000\n" +
                        "2nd Prize -Rs.1000");
                alert.setPositiveButton("OK", null);
                alert.show();
            }
        });
        group=(ImageView)findViewById(R.id.group);
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(GameOfCodes.this);
                alert.setTitle("Team Size");
                alert.setMessage("2 in a team");
                alert.setPositiveButton("OK", null);
                alert.show();
            }
        });
        call=(ImageView)findViewById(R.id.phone);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(GameOfCodes.this);
                alert.setTitle("Organisers");
                alert.setMessage("Prathik-9035396466\nArya-9945020490\nVishwas-9482649254\n");
                alert.setPositiveButton("OK", null);
                alert.show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
