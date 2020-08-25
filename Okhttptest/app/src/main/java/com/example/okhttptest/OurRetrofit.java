package com.example.okhttptest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OurRetrofit {//JSON Array
@GET("s/5e8ngp59pmhtwok/Dyson%20v8.json?dl=1")
    Call<ArrayList<Post>>getJSON();//自定義取得的方法
}
