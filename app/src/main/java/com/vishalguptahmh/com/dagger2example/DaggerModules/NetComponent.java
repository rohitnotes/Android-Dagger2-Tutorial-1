package com.vishalguptahmh.com.dagger2example.DaggerModules;

import com.vishalguptahmh.com.dagger2example.MainActivity;
import com.vishalguptahmh.com.dagger2example.SecondActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by vishalguptahmh@gmail.com on 10/7/18.
 */

@Singleton
@Component(modules = {NetModule.class})
public interface NetComponent {

    //here we are defining in which activty or fragment we need object which we have created in NetModule class
    void inject(MainActivity activity);
    void inject(SecondActivity secondActivity);
}
