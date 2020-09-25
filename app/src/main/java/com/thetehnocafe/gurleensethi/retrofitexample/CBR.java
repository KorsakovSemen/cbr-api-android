package com.thetehnocafe.gurleensethi.retrofitexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CBR {
    @SerializedName("Date")
    @Expose
    private int date;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
