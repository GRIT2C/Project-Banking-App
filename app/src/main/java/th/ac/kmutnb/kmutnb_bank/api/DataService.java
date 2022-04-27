package th.ac.kmutnb.kmutnb_bank.api;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import th.ac.kmutnb.kmutnb_bank.model.DataModel;

public class DataService {

    private static final String TAG = "my_app" ;
    public static final String QUERY_FOR_API = "";
    static String answer;
    Context context;
    String ID;



    public DataService(Context context,String ID) {
        this.context = context;
        this.ID = ID;
    }

    public interface VolleyResponseListener {

        void onError(String message);

        void onResponse(String answer);
    }

    public interface CustomResponseListener {

        void onError(String message);

        void onResponse(DataModel DataTemp);
    }



    public void Register(Map postParam,VolleyResponseListener volleyResponseListener){

        String url = QUERY_FOR_API + ID;

        JsonObjectRequest ObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, new JSONObject(postParam), new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            answer = response.getString("message");
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                        volleyResponseListener.onResponse(answer);

                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        volleyResponseListener.onError("Something Wrong");

                    }
                }){
            protected Map getParams()
            {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        ServiceSingleton.getInstance(context).addToRequestQueue(ObjectRequest);

    }



    public void Login(Map postParam,VolleyResponseListener volleyResponseListener){

        String url = QUERY_FOR_API + ID;

        JsonObjectRequest ObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, new JSONObject(postParam), new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            answer = response.getString("message");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        volleyResponseListener.onResponse(answer);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        volleyResponseListener.onError("Something Wrong");

                    }
                }){
            protected Map getParams()
            {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        ServiceSingleton.getInstance(context).addToRequestQueue(ObjectRequest);


    }

    public void getDataByAccount(Map postParam,CustomResponseListener customResponseListener){
        String url = QUERY_FOR_API + ID;

        List<DataModel> Data = new ArrayList<>();
        JsonObjectRequest ObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, new JSONObject(postParam), new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject temp = response.getJSONObject("response");
                            DataModel DataTemp = new DataModel();
                            DataTemp.setId(temp.getString("_id"));
                            DataTemp.setName(temp.getString("name"));
                            DataTemp.setAccount_number(temp.getString("account_number"));
                            DataTemp.setPhone(temp.getString("phone"));
                            DataTemp.setPassword(temp.getString("password"));
                            DataTemp.setMoney(temp.getLong("money"));
                            DataTemp.setHistory(temp.getJSONArray("history"));

                            customResponseListener.onResponse(DataTemp);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Log.d(TAG, response.toString());



                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        customResponseListener.onError("Something Wrong");

                    }
                }){
            protected Map getParams()
            {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        ServiceSingleton.getInstance(context).addToRequestQueue(ObjectRequest);
    }

    public void Transfers(Map postParam, VolleyResponseListener volleyResponseListener){

        String url = QUERY_FOR_API + ID;

        JsonObjectRequest ObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, new JSONObject(postParam), new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            answer = response.getString("message");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        volleyResponseListener.onResponse(answer);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        volleyResponseListener.onError("Something Wrong");

                    }
                }){
            protected Map getParams()
            {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        ServiceSingleton.getInstance(context).addToRequestQueue(ObjectRequest);


    }

    public void UpdateProfile(Map postParam, VolleyResponseListener volleyResponseListener){

        String url = QUERY_FOR_API + ID;
        JsonObjectRequest ObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, new JSONObject(postParam), new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            answer = response.getString("message");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        volleyResponseListener.onResponse(answer);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        volleyResponseListener.onError("Something Wrong");

                    }
                }){
            protected Map getParams()
            {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        ServiceSingleton.getInstance(context).addToRequestQueue(ObjectRequest);

    }

    public void Delete(Map postParam, VolleyResponseListener volleyResponseListener){

        String url = QUERY_FOR_API + ID;
        JsonObjectRequest ObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, new JSONObject(postParam), new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            answer = response.getString("message");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        volleyResponseListener.onResponse(answer);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        volleyResponseListener.onError("Something Wrong");

                    }
                }){
            protected Map getParams()
            {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        ServiceSingleton.getInstance(context).addToRequestQueue(ObjectRequest);

    }




}