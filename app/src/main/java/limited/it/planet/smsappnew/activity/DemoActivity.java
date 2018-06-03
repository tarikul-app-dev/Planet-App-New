package limited.it.planet.smsappnew.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import limited.it.planet.smsappnew.util.BaseApplication;

public class DemoActivity extends AppCompatActivity {

    BaseApplication baseApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseApplication = new BaseApplication(DemoActivity.this);
    }

    public void progressON() {
        baseApplication.progressON(DemoActivity.this, null);
    }

    public void progressON(String message) {
        baseApplication.progressON(DemoActivity.this, message);
    }

    public void progressOFF() {
        baseApplication.progressOFF();
    }

}
