package android.developers.uvce.impetus2017;

/**
 * Created by Suhas on 28-02-2017.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



/**
 * Created by Suhas on 23-03-2016.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Belal on 9/22/2015.
 */

public class CustomList_f extends ArrayAdapter<String> {

    private String[] headline;
    private String[] content;
    private String[] date;
    private String[] name;
    private String[] dummy;
    private Activity context;

    public CustomList_f(Activity context,  String[] headline, String[] content,String[] date,String[] name,String[] dummy) {
        super(context, R.layout.list_view_layout_f,headline);
        this.context = context;

        this.headline = headline;
        this.content = content;
        this.date=date;
        this.name=name;
        this.dummy=dummy;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_layout_f, null, true);
        TextView textViewHeadline = (TextView) listViewItem.findViewById(R.id.textViewHeadline);
        TextView textViewContent = (TextView) listViewItem.findViewById(R.id.textViewContent);
        TextView textViewDate = (TextView) listViewItem.findViewById(R.id.textViewDate);
        TextView textViewName=(TextView)listViewItem.findViewById(R.id.textViewName);

        textViewHeadline.setText(headline[position]);
        textViewContent.setText(content[position]);
        textViewName.setText(name[position]);
        textViewDate.setText(date[position]);
        String important=dummy[0];


        return listViewItem;
    }
}
