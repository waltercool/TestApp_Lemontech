package cl.slash.letstalkclone.utilities;

import java.text.SimpleDateFormat;

/**
 * Created by waltercool on 26-08-14.
 */
public class DateToolkit {
    public static SimpleDateFormat commonDateFormat(){
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }
}
