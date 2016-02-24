package be.groept.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by java on 03.02.16.
 */
public class UriShowActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button buttonexit = (Button)findViewById(R.id.buttonexit);
        buttonexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}