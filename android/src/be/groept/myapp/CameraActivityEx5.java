package be.groept.myapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import be.groept.android.ex5.RestClientService;

import java.io.File;
import java.io.IOException;

/**
 * Created by java on 03.02.16.
 */
public class CameraActivityEx5 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cameraviewex5);

    }

    File file;

    public void execute(View view){
        try{
            file = getCacheDir().createTempFile("pic",".dat");
            file.setWritable(true,false);
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));

            //start capture of image Intent
            startActivityForResult(intent, 1);
            Log.d("na startActivity","method startActivityForResult passed");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d("inside actresult","inside method onActivityResult");
        Intent rest = new Intent(this, RestClientService.class);
        EditText editText = (EditText)findViewById(R.id.restserviceURL);
        rest.putExtra("host",editText.getText().toString());
        rest.putExtra("image",file.getAbsolutePath());
        startService(rest);

        super.onActivityResult(requestCode, resultCode, data);
    }






}