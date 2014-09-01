package cl.slash.letstalkclone.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import cl.slash.letstalkclone.utilities.Compat;
import cl.slash.letstalkclone.utilities.Constants;
import cl.slash.letstalkclone.utilities.SystemUtils;
import letstalkclone.lemontechapp.slash.cl.testapp_lemontech.R;

/**
 * Created by waltercool on 27-08-14.
 */
public class Register extends Activity implements View.OnClickListener{

    private static final String TAG = Register.class.getCanonicalName();
    private static final int RESULT_OPEN_IMAGE = 11001100;

    private EditText etName, etEmail, etPhone, etPass, etPassConfirm;
    private Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText)findViewById(R.id.activity_register_name);
        etEmail = (EditText)findViewById(R.id.activity_register_email);
        etPhone = (EditText)findViewById(R.id.activity_register_phone);
        etPass = (EditText)findViewById(R.id.activity_register_pass);
        etPassConfirm = (EditText)findViewById(R.id.activity_register_pass_confirm);


        findViewById(R.id.activity_register_picture).setOnClickListener(this);
        findViewById(R.id.activity_register_create).setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.activity_register_picture: {
                Intent intentOpenDocument = Compat.openDocumentIntent();
                intentOpenDocument.setType("image/*");
                startActivityForResult(intentOpenDocument, RESULT_OPEN_IMAGE);
                break;
            }
            case R.id.activity_register_create:
                if(etName.getText().length() < 5) {
                    Toast.makeText(this, R.string.error_name_short, Toast.LENGTH_SHORT).show();
                } else if(!etEmail.getText().toString().matches(Constants.EMAIL_REGEX)) {
                    Toast.makeText(this, R.string.error_email_regex, Toast.LENGTH_SHORT).show();
                } else if(etPass.getText().length() < 8) {
                    Toast.makeText(this, R.string.error_pass_length, Toast.LENGTH_SHORT).show();
                } else if(!etPass.getText().toString().equals(etPassConfirm.getText().toString())) {
                    Toast.makeText(this, R.string.error_pass_not_equal, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_OPEN_IMAGE && resultCode == RESULT_OK) {
            Uri resultUri;
            if(data != null) {
                resultUri = data.getData();
                Log.d(TAG, resultUri.toString());
                try {
                    photo = SystemUtils.getBitmapFromUri(this, resultUri);
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, R.string.error_cant_open_image, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
