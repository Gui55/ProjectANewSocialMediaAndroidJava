package com.example.anewsocialmedia.dagger;

import com.example.anewsocialmedia.services.webservices.Requisition;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetroModule {

    @Provides
    public Requisition provideRequisition(){

        return new Retrofit.Builder().baseUrl("https://api-v3.igdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Requisition.class);

    }

}
