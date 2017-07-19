package android.developers.uvce.impetus2017;

/**
 * Created by Suhas on 28-02-2017.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * Created by Suhas on 23-03-2016.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ParseJSON_f {

    public static String[] headline;
    public static String[] content;
    public static String[] date;
    public static String[] name;
    public static String[] dummy;

    public static final String JSON_ARRAY = "server_response";

    public static final String KEY_HEADLINE = "headline";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_DATE = "date";
    public static final String KEY_NAME = "name";
    public static final String KEY_DUMMY = "dummy";

    private JSONArray users = null;

    private String json;

    public ParseJSON_f(String json){
        this.json = json;
    }

    protected void parseJSON_f(){
        JSONObject jsonObject=null;
        try {

            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);



            headline = new String[users.length()];
            content = new String[users.length()];
            date = new String[users.length()];
            name = new String[users.length()];
            dummy=new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);

                headline[i] = jo.getString(KEY_HEADLINE);
                content[i] = jo.getString(KEY_CONTENT);
                date[i]=jo.getString(KEY_DATE);
                name[i]=jo.getString(KEY_NAME);
                dummy[i]=jo.getString(KEY_DUMMY);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}