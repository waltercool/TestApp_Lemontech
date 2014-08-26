package cl.slash.letstalkclone.activity;

import android.app.Activity;
import android.os.Bundle;

import letstalkclone.lemontechapp.slash.cl.testapp_lemontech.R;

/**
 * Created by waltercool on 25-08-14.
 */
public class Splash extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
