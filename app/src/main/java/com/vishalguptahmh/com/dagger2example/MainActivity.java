package com.vishalguptahmh.com.dagger2example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vishalguptahmh.com.dagger2example.DaggerModules.MyApplication;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    String TAG=getClass().getSimpleName().toString();

    EditText editText;
    Button button;

    //This is injection of object
    @Inject
    AppData appData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Here we telling module to get object
        ((MyApplication) getApplication()).getNetComponent().inject(this);

        // here we are access our object.
        appData.setName("vishalGupta");





        editText=(EditText)findViewById(R.id.edtText);
        button=(Button)findViewById(R.id.btnClick);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText()!=null && editText.getText().toString().length()>0){

                    //setting data from edit text
                    appData.setName(editText.getText().toString());

                    // Redirect to Second activity.
                    Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);


                }
                else{
                    Toast.makeText(MainActivity.this,"Enter some text",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

}
