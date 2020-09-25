package com.thetehnocafe.gurleensethi.retrofitexample;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {
    @GET("/daily_json.js")
    public Call<JsonObject> readJson();

    @GET("/posts/{id}")
    public Call<CBR> getPostWithID(@Path("id") int id);

    @GET("/posts")
    public Call<List<CBR>> getAllCBRs();

    @GET("/CBRs")
    public Call<List<CBR>> getCBROfUser(@Query("userId") int id);

    @POST("/posts")
    public Call<CBR> postData(@Body CBR data);
}
