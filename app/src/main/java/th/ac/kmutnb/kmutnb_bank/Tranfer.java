package th.ac.kmutnb.kmutnb_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import th.ac.kmutnb.kmutnb_bank.api.DataService;

public class Tranfer extends AppCompatActivity {



    EditText tf_acc,tf_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tranfer);
        tf_acc = findViewById(R.id.tf_accountQR);
        tf_value = findViewById(R.id.tf_valueQR);



        String getName = getIntent().getStringExtra("lastActivityName");

        if(getName.equals("ScanCam")){
            String result = getIntent().getStringExtra("result");
            tf_acc.setText(result);
        }



    }

    //-
    public void PayFunction(){
        DataService dataService = new DataService(Tranfer.this,"sender");

        String accountOwner = getIntent().getStringExtra("account_number");

        Map<String, String> postParam= new HashMap<String, String>();
        postParam.put("store",tf_acc.getText().toString());
        postParam.put("account_number",accountOwner);
        postParam.put("money",tf_value.getText().toString());
        postParam.put("plus_negative","-");

        dataService.Transfers(postParam, new DataService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(Tranfer.this,message, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(String answer) {
                Toast.makeText(Tranfer.this,answer, Toast.LENGTH_SHORT).show();
            }
        });


    }

    //+
    public void TransfersFunction(View V) {
        DataService dataService = new DataService(Tranfer.this,"receiver");

        String accountSender = getIntent().getStringExtra("account_number");
        Map<String, String> postParam= new HashMap<String, String>();

        postParam.put("store",accountSender);
        postParam.put("account_number",tf_acc.getText().toString());
        postParam.put("money",tf_value.getText().toString());
        postParam.put("plus_negative","+");

        dataService.Transfers(postParam, new DataService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(Tranfer.this,message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String answer) {
                Toast.makeText(Tranfer.this,answer, Toast.LENGTH_SHORT).show();
            }
        });

        PayFunction();




    }



}