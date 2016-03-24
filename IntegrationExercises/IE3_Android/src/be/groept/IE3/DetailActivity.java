package be.groept.IE3;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;


public class DetailActivity extends Activity {

    TextView txtproblem, txtaddress, txtrepairinfo, txtrepairinfolabel;
    DbHelper myDb;
    Button btback;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        txtproblem = (TextView)findViewById(R.id.txtprobdescr);
        txtaddress = (TextView)findViewById(R.id.txtfulladdress);
        txtrepairinfo = (TextView)findViewById(R.id.txtrepairinfo);
        txtrepairinfolabel = (TextView)findViewById(R.id.txtrepairinfolabel);
        btback = (Button)findViewById(R.id.btback);

        myDb = DbHelperFactory.makeDbHelper(this);

        Intent i = getIntent();
        int orderid = (int)i.getExtras().get("orderid");

        Cursor res = myDb.getDetailInfo(orderid);

        if (res != null){
            String problem = res.getString(1);
            txtproblem.setText(problem);

            String address = res.getString(2);
            txtaddress.setText(address);

            String repairinfo = res.getString(3);
            if(repairinfo != null){
                txtrepairinfo.setText(repairinfo);
            }else {
                txtrepairinfo.setVisibility(View.INVISIBLE);
                txtrepairinfolabel.setVisibility(View.INVISIBLE);
            }


        }

        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}