package com.vishalguptahmh.com.dagger2example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.vishalguptahmh.com.dagger2example.DaggerModules.MyApplication;

import javax.inject.Inject;

/**
 * Created by vishalguptahmh@gmail.com on 10/7/18.
 */

public class SecondActivity extends AppCompatActivity {


    String TAG=getClass().getSimpleName().toString();

    TextView textView;
    @Inject
    AppData appData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ((MyApplication) getApplication()).getNetComponent().inject(this);

        textView=(TextView) findViewById(R.id.txtView);
        textView.setText(appData.getName());
    }

}
