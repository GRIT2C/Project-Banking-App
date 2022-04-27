package th.ac.kmutnb.kmutnb_bank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;


import com.google.android.material.tabs.TabLayout;

import th.ac.kmutnb.kmutnb_bank.api.DataService;
import th.ac.kmutnb.kmutnb_bank.ui.LoginAdapter;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "my_main" ;
    EditText R_name,R_phone,R_password,L_account,L_password;
    Button btn_register;
    TabLayout tabLayout;
    ViewPager viewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setText("Login"));
        tabLayout.addTab(tabLayout.newTab().setText("Signup"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(),this,tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setTranslationY(300);




//        tabLayout.setAlpha(v);

    }

    public void LoginFunction(View V){

        DataService dataService = new DataService(MainActivity.this,"login");
        L_account = findViewById(R.id.account_login);
        L_password = findViewById(R.id.password_login);

        Map<String, String> postParam= new HashMap<String, String>();
        postParam.put("username",L_account.getText().toString());
        postParam.put("password",L_password.getText().toString());

        dataService.Login(postParam, new DataService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this,message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String answer) {
                Toast.makeText(MainActivity.this,answer, Toast.LENGTH_SHORT).show();
                if (answer != null && answer.equalsIgnoreCase("Login Successful")) {
                    Intent itn = new Intent(MainActivity.this, Home_Screen.class);
                    itn.putExtra("phone", L_account.getText().toString());
                    MainActivity.this.startActivity(itn);

                }
                else{
                    Toast.makeText(MainActivity.this,"password or account number are not correct", Toast.LENGTH_SHORT).show();
                }
            }
        });


        /*Intent itn1 = new Intent(this,Home_Screen.class);
        startActivity(itn1);*/
    }

    public void RegisterFunction(View V){

        DataService dataService = new DataService(MainActivity.this,"register");
        R_name = findViewById(R.id.name_regis);
        R_phone = findViewById(R.id.phone_regis);
        R_password = findViewById(R.id.password_regis);
        btn_register = findViewById(R.id.btn_register);

        Map<String, String> postParam= new HashMap<String, String>();
        postParam.put("name",R_name.getText().toString());
        postParam.put("phone",R_phone.getText().toString());
        postParam.put("password",R_password.getText().toString());


        dataService.Register(postParam, new DataService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this,message, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(String answer) {
                Toast.makeText(MainActivity.this,answer, Toast.LENGTH_SHORT).show();

            }
        });

    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"run onStart");


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"run onRestart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"run onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"run onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"run onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"run onDestroy");

    }


}