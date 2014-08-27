package cl.slash.letstalkclone.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cl.slash.letstalkclone.utilities.Constants;
import letstalkclone.lemontechapp.slash.cl.testapp_lemontech.R;

/**
 * Created by waltercool on 25-08-14.
 */
public class Login extends Activity implements View.OnClickListener
{
    private TextView tvEmail, tvPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvEmail = (TextView)findViewById(R.id.activity_login_email);
        tvPass = (TextView)findViewById(R.id.activity_login_password);

        findViewById(R.id.activity_login_btnlogin).setOnClickListener(this);
        findViewById(R.id.activity_login_btnregister).setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.activity_login_btnlogin:
                String email = tvEmail.getText().toString();
                String pass = tvPass.getText().toString();
                if(!email.matches(Constants.EMAIL_REGEX))
                    Toast.makeText(this, R.string.error_email_regex, Toast.LENGTH_SHORT).show();
                else if(pass.length() < 8)
                    Toast.makeText(this, R.string.error_pass_length, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, android.R.string.ok, Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_login_btnregister:
                Intent intentRegister = new Intent(this, Register.class);
                startActivity(intentRegister);
                break;
        }
    }
}
