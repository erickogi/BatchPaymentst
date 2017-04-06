package com.erickogi14gmail.batchpaymentst.Payments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.erickogi14gmail.batchpaymentst.Account.*;
import com.erickogi14gmail.batchpaymentst.Payments.ModelAdapter;
import com.erickogi14gmail.batchpaymentst.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by kimani kogi on 3/23/2017.
 */

public class fragmentBatchPayement extends Fragment {
    static View view;
    static RecyclerView.LayoutManager mLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /**
         * Inflate the layout for this fragment
         */






        view=inflater.inflate(R.layout.batch,container,false);




        addItems();
        RecyclerView listView=(RecyclerView)view. findViewById(R.id.batch_list);
        Button btnSend=(Button)view.findViewById(R.id.btnSend) ;
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Payments Done Succesfully Thank You", Toast.LENGTH_SHORT).show();
            }
        });





        mLayoutManager =new LinearLayoutManager(getContext());
        listView.setLayoutManager(mLayoutManager);
        listView.setItemAnimator(new DefaultItemAnimator());

        ModelAdapter modelAdapter=new ModelAdapter(moList,getContext());

        listView.setAdapter(modelAdapter);

for(int a=0;a<2;a++){

}
        return  view;
    }
    private List<ModelB> moList = new ArrayList<>();
    public  void addItems(){
        ModelB items = new ModelB("Liz", "+254720001100");
        moList.add(items);
         items = new ModelB("Morgan", "+254720001101");
        moList.add(items);
        items = new ModelB("Mark", "+254720001102");
        moList.add(items);

        items = new ModelB("Faith", "+254720001100");
        moList.add(items);




    }


    public UUID generateUuid(){
        UUID uniqueKey = UUID.randomUUID();
        System.out.println (uniqueKey);
        return uniqueKey;
    }




    /*private boolean registerUser(){
        boolean success=false;
        JSONObject obj = new JSONObject();
        try {
            obj.put("amount",send_amount_edt.getText().toString());
            obj.put("currency","KES");
            obj.put("type","transfer");
            obj.put("requestDate","2017-03-26 16:00:00");
            obj.put("requestingOrganisationTransactionRefrence","MWCAPIworkshop001");

            JSONArray array = new JSONArray();
            JSONObject item = new JSONObject();
            item.put("key", "msisdn");
            item.put("value", "+254720001100");

            array.put(item);

            obj.put("debitParty",array);


            JSONArray jsonArray=new JSONArray();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("key","msisdn");
            jsonObject.put("value",phone[1]);

            jsonArray.put(jsonObject);
            obj.put("creditParty",jsonArray);



        } catch (JSONException e) {
            e.printStackTrace();
        }
        // final  String name = _nameText.getText().toString();
        // final String email = _emailText.getText().toString();
        // final String password = _passwordText.getText().toString();
        //  final String user_key= key_generator();


        Log.d("resobj",String.valueOf(obj));

        // StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
        JsonObjectRequest json = new JsonObjectRequest(
                Request.Method.POST,_URL, obj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.d("response",String.valueOf(response));
                        Toast.makeText(getContext(), ""+String.valueOf(response), Toast.LENGTH_SHORT).show();
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
                params.put("X-CORRELATIONID", String.valueOf(generateUuid()));
                params.put("Content-Type", "application/json");

                return params;
            }
        };






        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(json);

        return success;
    }


*/


}
