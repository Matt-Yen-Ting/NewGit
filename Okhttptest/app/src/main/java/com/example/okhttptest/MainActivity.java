package com.example.okhttptest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView testRecyclerview;
    MyRecyclerView_Adapter myRecyclerView_adapter;
    ArrayList<Post> data_List=new ArrayList<>();
    String result;
    String res;
    Gson gson;
    Type typepost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testRecyclerview=findViewById(R.id.recyclerView);
        testRecyclerview.setHasFixedSize(false);
        testRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        testRecyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
       //doGet();
        //Gradle需引入下列
        //compileOptions {
        //        sourceCompatibility JavaVersion.VERSION_1_8
        //        targetCompatibility JavaVersion.VERSION_1_8
        //    }
        //implementation 'com.squareup.retrofit2:retrofit:2.9.0'
        //  implementation 'com.google.code.gson:gson:2.8.6'
      RetrofitGet();



    }

    private void RetrofitGet() {//Retrofit
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.dropbox.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OurRetrofit ourRetrofit=retrofit.create(OurRetrofit.class);
        retrofit2.Call<ArrayList<Post>> call=ourRetrofit.getJSON();
        call.enqueue(new retrofit2.Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(retrofit2.Call<ArrayList<Post>> call, retrofit2.Response<ArrayList<Post>> response) {
                ArrayList<Post> ree=response.body();
                for(Post e:ree){//for each 將Array的項目取出
                     Post po=new Post(e.getName(),e.getTitle(),e.getPrice(),e.getPhoto());
                     data_List.add(po);
                     Log.e("Tag",""+data_List.size());
                }
                myRecyclerView_adapter=new MyRecyclerView_Adapter(data_List,MainActivity.this);
                testRecyclerview.setAdapter(myRecyclerView_adapter);
            }

            @Override
            public void onFailure(retrofit2.Call<ArrayList<Post>> call, Throwable t) {

            }
        });




    }




//    private boolean doGet(){
//       new Thread(new Runnable() {
//           @Override
//           public void run() {
//               try{
//                   enqueue();
//
//               }catch(Exception e){
//                   e.printStackTrace();
//               }
//
//           }
//       }).start();
//        return false;
//    }
//    private void enqueue(){
//        OkHttpClient client=new OkHttpClient();
//        Request request=new Request.Builder().url("https://www.dropbox.com/s/5e8ngp59pmhtwok/Dyson%20v8.json?dl=1").build();
//        Call call= client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//            }
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                res =response.body().string();
//                testRecyclerview.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        //Gson解析JSonArray
//                        Gson gson=new GsonBuilder().create();
//                        typepost=new TypeToken<ArrayList<Post>>(){}.getType();
//                        data_List=gson.fromJson(res,typepost);
//                        testRecyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                        myRecyclerView_adapter=new MyRecyclerView_Adapter(data_List,MainActivity.this);
//                        testRecyclerview.setAdapter(myRecyclerView_adapter);
//
////                runOnUiThread(new Runnable() {//更新UI
////                    @Override
////                    public void run() {
//                    }
//                });
////                        RecyclerViewDisplay();
////                    }
////                });
//
//
//
//            }
//        });
//
//    }
//    private ArrayList<Post> JsonParse(String Jsondata){
//        data_List=new ArrayList<>();
//        try{
//            JSONArray jsonArray=new JSONArray(Jsondata);
//            for(int i = 0;i<jsonArray.length();i++){
//               JSONObject jsonObject=jsonArray.getJSONObject(i);
//                 String Name=jsonObject.getString("Name");
//                 String Price=jsonObject.getString("Price");
//                 String Title=jsonObject.getString("Title");
//                 String Photo=jsonObject.getString("Photo");
//                data_List.add(new Post(Name,Title,Price,Photo));
//            }
//        }catch (JSONException e){
//            Log.e("JSON",e.getMessage());
//        }
//        return data_List;
//
//
//
//    }
//   private ArrayList<Post> ParseJson_Obj(String Jsondata){
//       ArrayList<Post> List=new ArrayList<>();
//       try{
//           JSONObject jsonObject= new JSONObject(Jsondata);
//           String name=jsonObject.getString("Name");
//           String Title=jsonObject.getString("Title");
//           String Price=jsonObject.getString("Price");
//           String Photo=jsonObject.getString("Photo");
//           List.add(new Post(name,Title,Price,Photo));
//           Log.e("Tag",""+List.size());
//           }catch (JSONException e) {
//           e.printStackTrace();
//       }
//        return List;
//   }
//   private ArrayList<Post> Object_include_ob(String objson){
//        ArrayList<Post> obList=new ArrayList<>();
//       try {
//           JSONObject jsonObject=new JSONObject(objson);
//           String obj_name=jsonObject.getString("Name");
//           String obj_title=jsonObject.getString("Title");
//           String obj_price=jsonObject.getString("Price");
//           String obj_photo=jsonObject.getString("Photo");
//           JSONObject productjson=jsonObject.getJSONObject("Product");
//           String pro_name=productjson.getString("Name");
//           String pro_title=productjson.getString("Title");
//           String pro_price=productjson.getString("Price");
//           String pro_photo=productjson.getString("Photo");
//           obList.add(new Post(obj_name,obj_title,obj_price,obj_photo));
//           obList.add(new Post(pro_name,pro_title,pro_price,pro_photo));
//       } catch (JSONException e) {
//           e.printStackTrace();
//       }
//       return obList;
//    }
//


}//Class結尾