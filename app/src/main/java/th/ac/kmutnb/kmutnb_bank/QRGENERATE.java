package th.ac.kmutnb.kmutnb_bank;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class QRGENERATE extends AppCompatActivity {
    EditText qrvalue;
    Button generateBtn,scanBtn;
    ImageView qrImage;
    private static final String TAG = "QR_gen" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_qrgenerate);
        String account = getIntent().getStringExtra("account_number");

        qrvalue = findViewById(R.id.qrInput);
        generateBtn = findViewById(R.id.generateBtn);
        scanBtn = findViewById(R.id.scanBtn);
        qrImage = findViewById(R.id.qrPlaceHolder);
        Log.i(TAG, account);

        QRGEncoder qrgEncoder = new QRGEncoder(account,null, QRGContents.Type.TEXT,500);
        Bitmap qrBits = qrgEncoder.getBitmap();
        qrImage.setImageBitmap(qrBits);

//       generateBtn.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               String data = qrvalue.getText().toString();
//               if(data.isEmpty()){
//                   qrvalue.setError("value request");
//               }
//               else {
//                   QRGEncoder qrgEncoder = new QRGEncoder("KMUTNB_6204062620143",null, QRGContents.Type.TEXT,500);
//                   Bitmap qrBits = qrgEncoder.getBitmap();
//                   qrImage.setImageBitmap(qrBits);
//
//               }
//           }
//       });



    }

    public void onClickScan(View view) {
        Intent itn1 = new Intent(this,ScanCam.class);
        startActivity(itn1);
    }

}