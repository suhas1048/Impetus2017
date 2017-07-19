package android.developers.uvce.impetus2017;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class EventsActivity extends ListActivity {

    static final String[] FRUITS = new String[]{"Channel code", "Vaksamara", "Botnia",
            "ITWiz", "The Alchemist", "AutoMania", "Summit", "Game of codes",
            "Unlock", "Mock Placements", "Gaming", "Tech and Ladder","Robo Rally"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // no more this
        // setContentView(R.layout.list_fruit);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_fruit, FRUITS));

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                if (position == 0) {

                    Intent intent = new Intent("android.developers.uvce.impetus2017.ChannelCode");
                    startActivity(intent);

                }
                if(position==1){

                    Intent intent=new Intent("android.developers.uvce.impetus2017.Vaksamara");
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent=new Intent("android.developers.uvce.impetus2017.Botnia");
                    startActivity(intent);
                }

                if(position==3){
                    Intent intent=new Intent("android.developers.uvce.impetus2017.ITwiz");
                    startActivity(intent);

                }
                if(position==4){
                    Intent intent=new Intent("android.developers.uvce.impetus2017.TheAlchemist");
                    startActivity(intent);

                }
                if(position==5){
                    Intent intent=new Intent("android.developers.uvce.impetus2017.AutoMania");
                    startActivity(intent);

                }

                if(position==6){
                    Intent intent=new Intent("android.developers.uvce.impetus2017.Summit");
                    startActivity(intent);
                }
                if(position==7){
                    Intent intent=new Intent("android.developers.uvce.impetus2017.GameOfCodes");
                    startActivity(intent);
                }
                if(position==8){
                    Intent intent=new Intent("android.developers.uvce.impetus2017.Unlock");
                    startActivity(intent);
                }
                if(position==9){
                    Intent intent=new Intent("android.developers.uvce.impetus2017.MockPlacements");
                    startActivity(intent);
                }
                if(position==10){
                    Intent intent=new Intent("android.developers.uvce.impetus2017.Gaming");
                    startActivity(intent);
                }
                if(position==11){
                    Intent intent=new Intent("android.developers.uvce.impetus2017.TechAndLadder");
                    startActivity(intent);
                }
                if(position==12){
                    Intent intent=new Intent("android.developers.uvce.impetus2017.RoboRally");
                    startActivity(intent);
                }

            }

        });

    }

}