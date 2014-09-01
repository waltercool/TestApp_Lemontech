package cl.slash.letstalkclone.service;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by waltercool on 31-08-14.
 */
public class LoginService extends IntentService {

    private static final String TAG = LoginService.class.getCanonicalName();
    public static final String USERNAME = "username", PASSWORD = "password";

    public LoginService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //TODO
    }
}
