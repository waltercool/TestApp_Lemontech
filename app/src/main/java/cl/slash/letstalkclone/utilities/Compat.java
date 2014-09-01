package cl.slash.letstalkclone.utilities;

import android.content.Intent;
import android.os.Build;

/**
 * Created by waltercool on 28-08-14.
 */
public class Compat {
    public static Intent openDocumentIntent() {
        Intent intent;
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            intent = new Intent(Intent.ACTION_PICK); //For oldies :P
        } else {
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);    //4.4 beyond.
        }
        return intent;
    }
}
