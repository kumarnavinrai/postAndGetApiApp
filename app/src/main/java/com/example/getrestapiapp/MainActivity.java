package com.example.getrestapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          String url = "https://sandhu22.com/indexp.php";

          AndroidNetworking.initialize(this);
          AndroidNetworking.post(url)
                  .setPriority(Priority.HIGH)
                  .build()
                  .getAsJSONObject(new JSONObjectRequestListener() {
                      @Override
                      public void onResponse(JSONObject response) {
                                Log.d("RES",response.toString());
                      }

                      @Override
                      public void onError(ANError anError) {
                            anError.printStackTrace();
                            Log.d("ERROR", anError.toString());
                      }
                  });
//        String url = "https://dummyjson.com/products/1";

//        AndroidNetworking.get(url)
//                .setPriority(Priority.HIGH)
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            Log.d("RES",response.getString("title"));
//                        } catch (JSONException e) {
//                            throw new RuntimeException(e);
//                        }
//
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//                        anError.printStackTrace();
//                        Log.d("ERROR", anError.toString());
//                    }
//                });

    }
}