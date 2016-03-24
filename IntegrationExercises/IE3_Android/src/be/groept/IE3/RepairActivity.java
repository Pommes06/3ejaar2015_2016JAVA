package be.groept.IE3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RepairActivity extends Activity {

    Button btback, btdone;
    EditText edittxt;
    DbHelper myDb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repair);

        myDb = DbHelperFactory.makeDbHelper(this);

        Intent i = getIntent();
        int orderid = (int)i.getExtras().get("orderid");

        edittxt = (EditText)findViewById(R.id.editText);

        btback = (Button)findViewById(R.id.btback);
        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btdone = (Button)findViewById(R.id.btdone);
        btdone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDb.updateRepair(orderid,edittxt.getText().toString());

                finish();

                //Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                //startActivity(intent);
            }
        });

    }
}