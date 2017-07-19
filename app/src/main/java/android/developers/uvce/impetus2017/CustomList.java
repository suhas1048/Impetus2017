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

/**
 * Created by Belal on 9/22/2015.
 */

public class CustomList extends ArrayAdapter<String> {
    private String[] ids;
    private String[] headline;
    private String[] content;
    private String[] date;
    private String[] dummy;
    private Activity context;

    public CustomList(Activity context, String[] ids, String[] headline, String[] content,String[] date,String[] dummy) {
        super(context, R.layout.list_view_layout, ids);
        this.context = context;
        this.ids = ids;
        this.headline = headline;
        this.content = content;
        this.date=date;
        this.dummy=dummy;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_layout, null, true);
        TextView textViewHeadline = (TextView) listViewItem.findViewById(R.id.textViewHeadline);
        TextView textViewContent = (TextView) listViewItem.findViewById(R.id.textViewContent);
        TextView textViewDate = (TextView) listViewItem.findViewById(R.id.textViewDate);
        TextView Dummy=(TextView)listViewItem.findViewById(R.id.textViewDummy);
        textViewHeadline.setText(headline[position]);
        textViewContent.setText(content[position]);
        textViewDate.setText(date[position]);
        Dummy.setText(dummy[position]);

        return listViewItem;
    }
}
