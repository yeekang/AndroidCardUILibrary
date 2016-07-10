package com.jhy.androidcarduilibrary.network;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jhyha on 29-Jun-16.
 */
public class Connection {

    private String SIMPLE_CARD_URL = "http://www.jiran.org.my:8082/ACLWS/api/v1/simpleCards";
    private String MODERATE_CARD_URL = "http://www.jiran.org.my:8082/ACLWS/api/v1/moderateCards";

    public void getJSON(final Context context) {

        StringRequest sr = new StringRequest(SIMPLE_CARD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //System.out.println(response);
                        new ParseJSON().parseJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error.getMessage());
                        Toast.makeText(context, error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("redirect_uri", SIMPLE_CARD_URL);
                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> headers = new HashMap<String, String>();
                        headers.put("Accept", "application/json");
                        headers.put("Authorization", "24d977756d8a65e2fb1407db83c986f7");
                        return headers;
                    }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(sr);

    }

}
