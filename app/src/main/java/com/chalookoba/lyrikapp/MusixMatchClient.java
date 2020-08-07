package com.chalookoba.lyrikapp;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.chalookoba.lyrikapp.Constants.MUSIXMATCH_API_KEY;
import static com.chalookoba.lyrikapp.Constants.MUSIXMATCH_BASE_URL;

public class MusixMatchClient { //use Retrofit.Builder class to create the instances as well as set some general options for all requests (base URL and the converter)
    private static Retrofit retrofit = null;
    private static MusixMatchApi getClient() {
        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest = chain.request().newBuilder()
                                    .addHeader("Authorization", MUSIXMATCH_API_KEY)
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    }).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(MUSIXMATCH_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(MusixMatchApi.class);
    }
}
