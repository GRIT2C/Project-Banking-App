package th.ac.kmutnb.kmutnb_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import th.ac.kmutnb.kmutnb_bank.api.DataService;

public class HistoryActivity extends AppCompatActivity {
    private static final String TAG = "my_history" ;
    JSONArray arr;
    ListView listView;
    DataService dataService = new DataService(HistoryActivity.this,"deletehistory");

    public void Delete(){


        String account = getIntent().getStringExtra("account_number");
        Map<String, String> postParam= new HashMap<String, String>();
        postParam.put("account_number",account);

        dataService.Delete(postParam, new DataService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(HistoryActivity.this,message, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(String answer) {
                Toast.makeText(HistoryActivity.this,answer, Toast.LENGTH_SHORT).show();

            }
        });





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        listView = findViewById(R.id.listviewy);
        Intent intent = getIntent();
        String jsonArray = intent.getStringExtra("history_array");
        ArrayList<String> arrayList = new ArrayList<>();

        try {
            JSONArray array = new JSONArray(jsonArray);
            arr = array;
            for (int i = 0; i < arr.length(); i++) {
                JSONObject finalObject = arr.getJSONObject(i);
                String item_number = finalObject.getString("item_number");
                String transfers = finalObject.getString("transfers");
                String plus_negative = finalObject.getString("plus_negative");
                arrayList.add(item_number + "                                                            " + plus_negative + transfers);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i(TAG, arrayList.toString());
        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HistoryActivity.this,"Removed the first one", Toast.LENGTH_SHORT).show();
                Delete();
                arrayList.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }
        });






    }








        //Log.i(TAG,array.toString(0));




    }
