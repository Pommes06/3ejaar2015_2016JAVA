package be.groept.myapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Date;

/**
 * Created by java on 27.01.16.
 */
public class TestActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.testactivitylayout);


        try {
            Intent i = getIntent();
            Uri data = i.getData();

            Log.d("intent url",data.toString() );
        } catch (Exception e) {
            Log.d("error uri","error printing the uri to log");
            e.printStackTrace();
        }




        Button buttontomain = (Button)findViewById(R.id.button3);
        buttontomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MyActivity.class);
                startActivity(intent);
                Log.d("exit ex4","exiting ex4 just before finish()");
                finish();
            }
        });


    }



}

