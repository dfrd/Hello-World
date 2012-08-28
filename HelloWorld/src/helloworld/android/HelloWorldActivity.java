package helloworld.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;


public class HelloWorldActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new HelloView(this));
    }
}