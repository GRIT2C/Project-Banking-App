package th.ac.kmutnb.kmutnb_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

import th.ac.kmutnb.kmutnb_bank.api.DataService;
import th.ac.kmutnb.kmutnb_bank.model.DataModel;

public class Home_Screen extends AppCompatActivity {

    String activityName = this.getClass().getSimpleName();
    String storeID;
    final DataService dataService = new DataService(Home_Screen.this,"show");
    private static final String TAG = "my_home" ;
    TextView tv_money,tv_name,tv_accountNumber;
    JSONArray HistoryArray;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home_screen);
        String phone = getIntent().getStringExtra("phone");
        storeID = phone;




    }



    public void openQR(View V){


        Intent itn3 = new Intent(this,ScanCam.class);
        itn3.putExtra("account_number", tv_accountNumber.getText().toString());
        startActivity(itn3);
    }

    public void openQRgen(View V){
        Intent itn6 = new Intent(this,QRGENERATE.class);
        itn6.putExtra("account_number", tv_accountNumber.getText().toString());
        startActivity(itn6);
    }

    public void openTranfer(View V){
        Intent itn4 = new Intent(this,Tranfer.class);
        itn4.putExtra("account_number", tv_accountNumber.getText().toString());
        itn4.putExtra("lastActivityName", activityName);
        startActivity(itn4);
    }

    public void openUserIm(View V){

        Intent itn5 = new Intent(this,User_Information.class);
        itn5.putExtra("account_number", tv_accountNumber.getText().toString());
        startActivity(itn5);
    }

    public void openHistory(View V){

        Intent itn6 = new Intent(this,HistoryActivity.class);
        itn6.putExtra("history_array", HistoryArray.toString());
        itn6.putExtra("account_number", tv_accountNumber.getText().toString());
        startActivity(itn6);
    }


    public void ShowFunction(String phone){


        tv_money = findViewById(R.id.tv_money);
        tv_name = findViewById(R.id.tv_name);
        tv_accountNumber = findViewById(R.id.tv_accountNumber);



        Map<String, String> postParam= new HashMap<String, String>();
        postParam.put("phone",phone);

        dataService.getDataByAccount(postParam, new DataService.CustomResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(Home_Screen.this,"Error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(DataModel DataTemp) {
                        tv_money.setText(String.valueOf(DataTemp.getMoney()));
                        tv_name.setText(DataTemp.getName());
                        tv_accountNumber.setText(DataTemp.getAccount_number());
                        HistoryArray = DataTemp.getHistory();

                    }
                }
        );



    }

    @Override
    protected void onStart() {
        super.onStart();
        ShowFunction(storeID);


    }


}