package com.example.pashko00710.rssmvpreader;import android.app.Application;import android.content.Context;import com.example.pashko00710.rssmvpreader.injection.components.ApplicationComponent;import com.example.pashko00710.rssmvpreader.injection.components.DaggerApplicationComponent;import com.example.pashko00710.rssmvpreader.injection.modules.ApplicationModule;public class NewsApplication extends Application {    private ApplicationComponent appComponent;    public static NewsApplication get(Context context) {        return (NewsApplication) context.getApplicationContext();    }    @Override    public void onCreate() {        super.onCreate();        buildGraphAndInject();    }    public ApplicationComponent getAppComponent() {        return appComponent;    }    public void buildGraphAndInject() {        appComponent = DaggerApplicationComponent.builder()                .applicationModule(new ApplicationModule(this))                .build();        appComponent.inject(this);    }}