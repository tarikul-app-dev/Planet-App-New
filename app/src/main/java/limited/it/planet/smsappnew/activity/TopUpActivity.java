package limited.it.planet.smsappnew.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import limited.it.planet.smsappnew.R;
import limited.it.planet.smsappnew.util.Constant;

public class TopUpActivity extends AppCompatActivity {
    Toolbar toolbar;
   EditText edtUserName,edtBTrans;
   Button btnRefresh,btnSubmit;
   String bKashAPI = "";
    private Dialog loadingDialog;
    String responseBodyText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        toolbar = (Toolbar)findViewById(R.id.toolbar_top_up_activity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // onBackPressed();
                Intent intent = new Intent(TopUpActivity.this,AccountDashboard.class);
                startActivity(intent);
                ActivityCompat.finishAffinity(TopUpActivity.this);
            }
        });


        initViews();

    }

    public void initViews(){
        edtUserName = (EditText)findViewById(R.id.edt_user_name);
        edtBTrans = (EditText)findViewById(R.id.edt_bkash_trxid);
        btnRefresh = (Button)findViewById(R.id.btn_refresh);
        btnSubmit = (Button)findViewById(R.id.btn_submit);
        //bKashAPI = Constant.bkashAPI;



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = edtUserName.getText().toString();
                String bKashTrxID = edtBTrans.getText().toString();
                bKashAPI =  Constant.bkashAPI + "user=" + userName + "&trx=" +  bKashTrxID;
                new SubmitPaymantAsync().execute();
            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtUserName.setText("");
                edtBTrans.setText("");
            }
        });


    }


    class SubmitPaymantAsync extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loadingDialog = ProgressDialog.show(TopUpActivity.this, "Please wait", "Loading...");
        }

        @Override
        protected String doInBackground(String... strings) {


            OkHttpClient client = new OkHttpClient();

            try {

                Request request = new Request.Builder()
                        .url(bKashAPI)

                        .build();


                Response response = null;

                response = client.newCall(request).execute();
                if (!response.isSuccessful()) {


                    throw new IOException("Okhttp Error: " + response);

                } else {
                    responseBodyText = response.body().string();


                  //  JSONObject jobject = new JSONObject(responseBodyText);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(TopUpActivity.this,responseBodyText, Toast.LENGTH_SHORT).show();
                        }
                    });

                }



            } catch (IOException e) {
                e.printStackTrace();
            }


            return responseBodyText;


        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            loadingDialog.dismiss();


        }
    }




    }
