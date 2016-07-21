package com.jhy.androidcarduilibrary.network;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jhy.androidcarduilibrary.adapter.RVAdapter;
import com.jhy.androidcarduilibrary.database.Retrieval;
import com.jhy.androidcarduilibrary.view.Setup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jhyha on 29-Jun-16.
 */
public class Connection {

    private String SIMPLE_CARD_URL = "http://www.jiran.org.my:8082/ACLWS/api/v1/simpleCards";
    private String MODERATE_CARD_URL = "http://www.jiran.org.my:8082/ACLWS/api/v1/moderateCards";
    private String ALL_CARD_URL = "http://www.jiran.org.my:8082/ACLWS/api/v1/allCards";

    public void getJSON(final Context context, final RVAdapter adapter, final SwipeRefreshLayout sc) {

        StringRequest sr = new StringRequest(ALL_CARD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //System.out.println(response);
                        new ParseJSON().parseJSON(response);
                        //new Setup().setUpItemTouchHelp(rv, context);

                        // Remove all current cards.
                        adapter.deleteAll();

                        // Add new ones.
                        adapter.update( new Retrieval().getDBCard() );

                        sc.setRefreshing(false);

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
                        params.put("redirect_uri", ALL_CARD_URL);
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
