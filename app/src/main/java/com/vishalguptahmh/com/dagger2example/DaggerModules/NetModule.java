package com.vishalguptahmh.com.dagger2example.DaggerModules;

import com.vishalguptahmh.com.dagger2example.AppData;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vishalguptahmh@gmail.com on 10/7/18.
 */
@Module
public class NetModule {

    @Singleton
    @Provides
     AppData provideAppData(){
       return new AppData();
    }
}
