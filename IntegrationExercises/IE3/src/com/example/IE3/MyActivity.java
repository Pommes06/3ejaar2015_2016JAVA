package com.example.IE3;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TableLayout;
import com.example.myapp.R;

public class MyActivity extends Activity {

    TableLayout table_layout;

    DbHelper myDb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        table_layout = (TableLayout) findViewById(R.id.tableLayout1);

        this.myDb = new DbHelper(this);

        //initlaunchdb();

        //laadData();

        //BuildTable();
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void laadData(){
        Cursor res = myDb.getMainScreenData();
        if(res.getCount() == 0){
            showMessage("Geen werk orders","Er zijn geen werk orders beschikbaar");
        } else {
            showMessage("Werk orders gevonden","Er zijn wel werk orders");
        }
    }

    public void BuildTable(){

    }

    public void initlaunchdb(){

        myDb.createTestData();
    }

}
