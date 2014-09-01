package cl.slash.letstalkclone.service;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by waltercool on 31-08-14.
 */
public class RegisterService extends IntentService {

    private static final String TAG = RegisterService.class.getCanonicalName();

    RegisterService(){
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //TODO
    }
}
