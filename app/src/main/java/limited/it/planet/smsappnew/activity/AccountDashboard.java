package limited.it.planet.smsappnew.activity;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import limited.it.planet.smsappnew.R;
import limited.it.planet.smsappnew.util.SessionClear;

public class AccountDashboard extends AppCompatActivity {
    Button btnAllAccounts,btnMyAccount;
    Toolbar toolbar;
    ImageView imgvHome;
    SessionClear sessionClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_dashboard);
        toolbar = (Toolbar)findViewById(R.id.toolbar_account_dashboard);
        setSupportActionBar(toolbar);
        imgvHome = (ImageView)findViewById(R.id.imgv_home);
        imgvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountDashboard.this,MainActivity.class);
                startActivity(intent);
                ActivityCompat.finishAffinity(AccountDashboard.this);
            }
        });

        initViews();
    }

    public void initViews(){
        btnAllAccounts = (Button)findViewById(R.id.btn_view_all_accounts);
        btnMyAccount = (Button)findViewById(R.id.btn_view_my_account);
        sessionClear = new SessionClear(AccountDashboard.this);

        btnAllAccounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountDashboard.this,AllAccountsActivity.class);
                startActivity(intent);
                ActivityCompat.finishAffinity(AccountDashboard.this);
            }
        });

        btnMyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountDashboard.this,MyAccountActivity.class);
                startActivity(intent);
                ActivityCompat.finishAffinity(AccountDashboard.this);
            }
        });

    }


//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        sessionClear.clearSessionWhenPause();
//    }
}
