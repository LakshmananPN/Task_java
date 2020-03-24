package com.example.task.Apiclient;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient {
    public static  final  String baseurl = "https://jsonplaceholder.typicode.com/";
    public  static Retrofit retrofit = null;


    public  static  Retrofit getApiclient(){
        if(retrofit==null){

            retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }
    public static Retrofit getOkHttpClient_localAPI() {
        if(retrofit==null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder client = new OkHttpClient.Builder();
            client.connectTimeout(5, TimeUnit.MINUTES);
            client.readTimeout(5, TimeUnit.MINUTES);
            client.writeTimeout(5, TimeUnit.MINUTES);
            client.addInterceptor(interceptor);


            retrofit = new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client.build())
                    .build();
        }
        return retrofit;
    }
}
