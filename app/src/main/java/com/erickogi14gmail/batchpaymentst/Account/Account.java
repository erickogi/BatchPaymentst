package com.erickogi14gmail.batchpaymentst.Account;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.erickogi14gmail.batchpaymentst.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Account extends AppCompatActivity {
    EditText edtBalance;
    static RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Model> _model;
    private  String _URL="https://vitelco-demo.jumo.world/accounts/msisdn/+254720001100/balance";
    private String _url="https://vitelco-demo.jumo.world/accounts/msisdn/+254720001100/statemententries";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edtBalance=(EditText)findViewById(R.id.balance) ;
        fetchBalance();
        fetchBalance2();

    }
    private boolean fetchBalance(){
        boolean success=false;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, _URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //  Toast.makeText(getApplicationContext(), "dfghjkljhgfdddfgh"+response, Toast.LENGTH_LONG).show();
                        if(response!=null||!response.isEmpty()) {


                            try {
                                JSONObject jObj = new JSONObject(response);
                               edtBalance.setText(jObj.getString("availableBalance"));


                                 RecyclerView listView=(RecyclerView) findViewById(R.id.listview);

                               //  _model = JsonParser.parseData(response);


                              //  ModelAdapter adapter = new ModelAdapter( _model,getApplicationContext());

//listView.setAdapter(adapter);




                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "nul", Toast.LENGTH_LONG).show();
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("dinn",String.valueOf(error));
                        //  Toast.makeText(Register.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String>  params = new HashMap<String, String>();
                params.put("DATE", "23/4/2017");
                params.put("AUTHORIZATION", "api-key");
               // params.put("X-CORRELATIONID", String.valueOf(generateUuid()));
                params.put("Content-Type", "application/json");

                return params;
            }
        };






        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        return success;
    }

    private boolean fetchBalance2(){
        boolean success=false;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, _url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //  Toast.makeText(getApplicationContext(), "dfghjkljhgfdddfgh"+response, Toast.LENGTH_LONG).show();
                        if(response!=null||!response.isEmpty()) {


                            try {
                               // JSONObject jObj = new JSONObject(response);
                               // edtBalance.setText(jObj.getString("availableBalance"));


                                RecyclerView listView=(RecyclerView) findViewById(R.id.listview);

                                _model = JsonParser.parseData(response);


                                ModelAdapter adapter = new ModelAdapter( _model,getApplicationContext());
                                adapter.notifyDataSetChanged();


                                mLayoutManager =new LinearLayoutManager(getApplicationContext());
                                listView.setLayoutManager(mLayoutManager);
                                listView.setItemAnimator(new DefaultItemAnimator());



                               // lv.setAdapter(adapter);
                                listView.setAdapter(adapter);




                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "nul", Toast.LENGTH_LONG).show();
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("dinn",String.valueOf(error));
                        //  Toast.makeText(Register.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String>  params = new HashMap<String, String>();
                params.put("DATE", "23/4/2017");
                params.put("AUTHORIZATION", "api-key");
                // params.put("X-CORRELATIONID", String.valueOf(generateUuid()));
                params.put("Content-Type", "application/json");

                return params;
            }
        };






        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        return success;
    }


}
