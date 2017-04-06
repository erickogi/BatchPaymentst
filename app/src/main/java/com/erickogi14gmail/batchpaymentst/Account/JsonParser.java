package com.erickogi14gmail.batchpaymentst.Account;

import android.util.Log;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 3/17/2017.
 */

public class JsonParser {
    static ArrayList<Model> _list;

    public static ArrayList<Model> parseData(String content) throws JSONException {


        JSONArray _arry = null;
        Model model = null;

            _list = new ArrayList<>();
          JSONArray jsonArray=new JSONArray(content);
            for(int a=0;a<jsonArray.length();a++) {


      model=new Model();
                JSONObject jsonObject = jsonArray.getJSONObject(a);
                model.setModificationDate(jsonObject.getString("modificationDate"));
                model.setAmount(jsonObject.getString("amount"));
               model.setTransactionStatus( jsonObject.getString("transactionStatus"));




                JSONArray jsonArray1=jsonObject.getJSONArray("creditParty");
                JSONObject jsonObject1= jsonArray1.getJSONObject(0);
               model.setCreditor( jsonObject1.getString("value"));

                _list.add(model);

            }










                 return _list;
        }


}
