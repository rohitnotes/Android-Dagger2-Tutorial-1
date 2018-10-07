# Android-Dagger2-Tutorial
Android Dagger2 Tutorial

#### Add to gradle file
```
compile 'com.google.dagger:dagger:2.11'
compile 'com.google.dagger:dagger-android:2.11'
annotationProcessor 'com.google.dagger:dagger-android-processor:2.11'
annotationProcessor 'com.google.dagger:dagger-compiler:2.11'

```
## Create Some Files

#### AppData.java
Creating a Object class
```
public class AppData {
    String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

```

#### NetModule.java
this is class where we create objects for our classes.

```
@Module
public class NetModule {

    @Singleton
    @Provides
     AppData provideAppData(){
       return new AppData();
    }
}

```

#### NetComponent.java as Interface

 In this,we are defining in which activty or fragment we need object which we have created in NetModule class

```

@Singleton
@Component(modules = {NetModule.class})
public interface NetComponent {

    void inject(MainActivity activity);
    void inject(SecondActivity secondActivity);
}


```

#### MyApplication.java

 Creating netComponent object

```
public class MyApplication extends Application {

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

```

#### Change Mainfeast File
```
 <application
        android:name=".DaggerModules.MyApplication"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        .
        .
        .
        .
 </application>

```

#### Useablilty

```
public class MainActivity extends AppCompatActivity {

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

  }
}

```

