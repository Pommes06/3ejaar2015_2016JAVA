package be.groept.myapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    // voorbeeld van Koen proberen na te schrijven voor intent.
    /**public void execute(View view){
        Intent intent = new Intent(getApplicationContext(),TestActivity.class);
        //intent.putExtra("some data");
        startActivity(intent);
        startActivityForResult(intent, 200);
     **/



       Button thomasbutton = (Button) findViewById(R.id.button);
        thomasbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                EditText editText = (EditText) findViewById(R.id.editText);
                editText.setText("button2 via API", TextView.BufferType.NORMAL);
                Log.d("button2 via API", "button2 via api");
            }
        });



        Button buttontotestactivity = (Button)findViewById(R.id.button2);
        buttontotestactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TestActivity.class); //explicit intent declaration
                //Intent intent = new Intent(Intent.ACTION_DEFAULT, Uri.parse("TestActivity")); //implicit intent

                startActivity(intent);


            }
        });


        Button buttonEx5 = (Button)findViewById(R.id.buttonEx5);
        buttonEx5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CameraActivityEx5.class);

                startActivity(intent);

            }
        });

        new Thread(){
            @Override
            public void run() {
                while(true){
                    Log.d("broadcast","begin broadcasting in thread");
                    Intent intentTimeBC = new Intent("currenttime");
                    intentTimeBC.putExtra("date",new Date().toString());
                    Log.d("time log",intentTimeBC.getExtras());
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();


        Button bttimebc = (Button)findViewById(R.id.btbroadcast);
        bttimebc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MyActivity.class));
            }
        });


}}
