package android.developers.uvce.impetus2017;

/**
 * Created by Suhas on 02-03-2017.
 */

import android.app.Application;
import com.pushbots.push.Pushbots;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize Pushbots Library
        Pushbots.sharedInstance().init(this);
    }
}