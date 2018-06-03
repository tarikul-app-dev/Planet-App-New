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

public class ReportDashboard extends AppCompatActivity {
    Button btnAllReports,btnLogs;
    Toolbar toolbar;
    ImageView imgvHome;
    SessionClear sessionClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_dashboard);
        toolbar = (Toolbar)findViewById(R.id.toolbar_account_dashboard);
        setSupportActionBar(toolbar);
        imgvHome = (ImageView)findViewById(R.id.imgv_home);
        imgvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReportDashboard.this,MainActivity.class);
                startActivity(intent);
                ActivityCompat.finishAffinity(ReportDashboard.this);
            }
        });
        initViews();
    }


    public void initViews(){

        sessionClear = new SessionClear(ReportDashboard.this);
        btnAllReports = (Button)findViewById(R.id.btn_all_reports);
        btnLogs = (Button)findViewById(R.id.btn_logs);

        btnAllReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReportDashboard.this,AllReportActivity.class);
                startActivity(intent);
                ActivityCompat.finishAffinity(ReportDashboard.this);
            }
        });

        btnLogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReportDashboard.this,LogsReportActivity.class);
                startActivity(intent);
                ActivityCompat.finishAffinity(ReportDashboard.this);
            }
        });

    }
}
