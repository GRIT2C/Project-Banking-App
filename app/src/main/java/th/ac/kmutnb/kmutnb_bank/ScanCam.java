package th.ac.kmutnb.kmutnb_bank;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.common.StringUtils;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CaptureActivity;

public class ScanCam extends AppCompatActivity {
    Button btScan;
    String activityName = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_cam);

        btScan = findViewById(R.id.bt_scan);



        IntentIntegrator  intentIntegrator = new IntentIntegrator(ScanCam.this);

        intentIntegrator.setPrompt("For flash use valume up");

        intentIntegrator.setBeepEnabled(true);

        intentIntegrator.setOrientationLocked(true);


        intentIntegrator.initiateScan();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(
                requestCode, resultCode, data);

        if(intentResult.getContents() != null){


            String result = intentResult.getContents() ;
            String originalstring = "This Test is from Simple Testing Code to Test function ";
            String Modified = result.replaceAll("http://", "");


            //TextView err = (TextView)findViewById(R.id.textView15);
//            err.setText(intentResult.getContents());
            //err.setText(Modified);

            String account_number = getIntent().getStringExtra("account_number");
            Intent itn1 = new Intent(this,Tranfer.class);
            itn1.putExtra("account_number", account_number);
            itn1.putExtra("result", result);
            itn1.putExtra("lastActivityName", activityName);
            startActivity(itn1);

        }else {
            Toast.makeText(getApplicationContext(), "you did not scan anything", Toast.LENGTH_SHORT).show();
        }
    }
}