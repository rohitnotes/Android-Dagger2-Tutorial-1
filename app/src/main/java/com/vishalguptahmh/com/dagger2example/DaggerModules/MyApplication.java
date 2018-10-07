package com.vishalguptahmh.com.dagger2example.DaggerModules;

import android.app.Application;
import android.content.Context;
import android.provider.SyncStateContract;

/**
 * Created by vishalguptahmh@gmail.com on 10/7/18.
 */

public class MyApplication extends Application {


    //Creating netComponent object
    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        netComponent = DaggerNetComponent.builder()
                .netModule(new NetModule())
                .build();
    }
    public NetComponent getNetComponent(){return  netComponent;}

}
