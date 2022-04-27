package th.ac.kmutnb.kmutnb_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import th.ac.kmutnb.kmutnb_bank.api.DataService;

public class User_Information extends AppCompatActivity {

    String accountEdit;
    final DataService dataService = new DataService(User_Information.this,"update");
    EditText et_name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        String account = getIntent().getStringExtra("account_number");
        accountEdit = account;



    }

    public void ProfileUpdate(View V){
        et_name = findViewById(R.id.et_name);

        Map<String, String> postParam= new HashMap<String, String>();
        postParam.put("name",et_name.getText().toString());
        postParam.put("account_number",accountEdit);




        dataService.UpdateProfile(postParam, new DataService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(User_Information.this,message, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(String answer) {
                Toast.makeText(User_Information.this,answer, Toast.LENGTH_SHORT).show();

            }
        });





    }


}