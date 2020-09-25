package com.thetehnocafe.gurleensethi.retrofitexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);

        NetworkService.getInstance()
                .getJSONApi()
                .readJson()
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                        try {
                            JSONObject jObject = new JSONObject(String.valueOf(response.body()));
                            textView.append(jObject.getString("Date") + "\n");
                            for (int i=0; i < jObject.length(); i++) {
                                Iterator keys = jObject.getJSONObject("Valute").keys();
                                while (keys.hasNext()) {
                                    String dynamicKey = (String)keys.next();
                                    JSONObject line = jObject.getJSONObject("Valute").getJSONObject(dynamicKey);
                                    textView.append(line.getString("Name") + "\n");
                                    textView.append("Now: " + line.getString("Value") + "\n");
                                    textView.append("Previous: " + line.getString("Previous") + "\n");
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                        textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }
}
