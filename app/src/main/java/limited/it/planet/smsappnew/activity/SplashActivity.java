package limited.it.planet.smsappnew.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import limited.it.planet.smsappnew.R;
import limited.it.planet.smsappnew.util.SaveValueSharedPreference;

public class SplashActivity extends AppCompatActivity {
    boolean isLogin ;
    SaveValueSharedPreference saveValueSharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        isLogin = saveValueSharedPreference.getBoleanValueSharedPreferences("islogin",SplashActivity.this);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if(isLogin){
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                    ActivityCompat.finishAffinity(SplashActivity.this);
                }else {
                    waitSomeMin();
                }

            }
        }, 2000);


    }

    public void waitSomeMin(){
        Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
        startActivity(intent);
        ActivityCompat.finishAffinity(SplashActivity.this);
    }
}
