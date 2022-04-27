package th.ac.kmutnb.kmutnb_bank.api;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class ServiceSingleton {
    private static ServiceSingleton instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    private ServiceSingleton(Context  context) {
        ctx = context;
        requestQueue = getRequestQueue();


    }

    public static synchronized ServiceSingleton getInstance(Context context) {
        if (instance == null) {
            instance = new ServiceSingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(JsonObjectRequest req) {
        getRequestQueue().add(req);
    }
}


