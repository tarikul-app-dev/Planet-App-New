package limited.it.planet.smsappnew.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import limited.it.planet.smsappnew.R;

import static limited.it.planet.smsappnew.util.SaveValueSharedPreference.saveBoleanValueSharedPreferences;

public class SMSLengthCheckerActivity extends AppCompatActivity {
    TextView txvIsUnicode,txvLengthOfText;
    EditText edtUnicodeCheck;
    Toolbar toolbar;
    ImageView imgvHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smslength_checker);
        toolbar = (Toolbar)findViewById(R.id.toolbar_sms_checker_app);
        setSupportActionBar(toolbar);
        imgvHome = (ImageView)findViewById(R.id.imgv_home);
        imgvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SMSLengthCheckerActivity.this,MainActivity.class);
                startActivity(intent);
                ActivityCompat.finishAffinity(SMSLengthCheckerActivity.this);
            }
        });

        initializeUI();

    }

    public void initializeUI(){
        edtUnicodeCheck = (EditText) findViewById(R.id.edt_unicode_checking);
        txvLengthOfText = (TextView)findViewById(R.id.txv_text_length);

        final TextWatcher txwatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.length()>0){
                    txvLengthOfText.setText(String.valueOf(s.length()));
                }

            }

            public void afterTextChanged(Editable s) {
            }
        };

        edtUnicodeCheck.addTextChangedListener(txwatcher);
    }

    //menu option
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sms_length_cheker, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //Sudip: 20170212
        switch (item.getItemId()) {

            case R.id.sms_length_logout:

                clearCookies(SMSLengthCheckerActivity.this);
                saveBoleanValueSharedPreferences("islogin",false,SMSLengthCheckerActivity.this);

                Intent intent = new Intent(SMSLengthCheckerActivity.this,LoginActivity.class);
                startActivity(intent);
                ActivityCompat.finishAffinity(SMSLengthCheckerActivity.this);
                break;


            default:
                return super.onOptionsItemSelected(item);
        }


        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("deprecation")
    public static void clearCookies(Context context)
    {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            // Log.d(C.TAG, "Using clearCookies code for API >=" + String.valueOf(Build.VERSION_CODES.LOLLIPOP_MR1));
            CookieManager.getInstance().removeAllCookies(null);
            CookieManager.getInstance().flush();
        } else
        {
            //Log.d(C.TAG, "Using clearCookies code for API <" + String.valueOf(Build.VERSION_CODES.LOLLIPOP_MR1));
            CookieSyncManager cookieSyncMngr=CookieSyncManager.createInstance(context);
            cookieSyncMngr.startSync();
            CookieManager cookieManager=CookieManager.getInstance();
            cookieManager.removeAllCookie();
            cookieManager.removeSessionCookie();
            cookieSyncMngr.stopSync();
            cookieSyncMngr.sync();
        }
    }
}
