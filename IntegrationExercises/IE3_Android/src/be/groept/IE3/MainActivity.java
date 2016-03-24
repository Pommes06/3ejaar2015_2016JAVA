package be.groept.IE3;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {

    TableLayout table_layout;
    DbHelper myDb;
    int tabletxtsize = 10;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        table_layout = (TableLayout) findViewById(R.id.tableLayout1);

        this.myDb = DbHelperFactory.makeDbHelper(this);
        Cursor res = myDb.getMainScreenData();

        buildtable(res);

    }

    public void buildtable(Cursor res){
        while(!res.isAfterLast()){
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            int orderid = Integer.valueOf(res.getString(0));

            String city = res.getString(1);
            TextView txtcity = new TextView(this);
            txtcity.setTextSize(tabletxtsize);
            txtcity.setText(city);
            tr.addView(txtcity);

            String device = res.getString(2);
            TextView txtdevice = new TextView(this);
            txtdevice.setTextSize(tabletxtsize);
            txtdevice.setText(device);
            tr.addView(txtdevice);

            String probcode = res.getString(3);
            TextView txtprobcode = new TextView(this);
            txtprobcode.setTextSize(tabletxtsize);
            txtprobcode.setText(probcode);
            tr.addView(txtprobcode);

            String name = res.getString(4);
            TextView txtname = new TextView(this);
            txtname.setTextSize(tabletxtsize);
            txtname.setText(name);
            tr.addView(txtname);

            int processed = Integer.valueOf(res.getString(5));

            if(processed == 0){

                //Knop aanmaken indien het work order nog niet is behandeld
                Button b = new Button(this);
                b.setText("NO");
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),RepairActivity.class);
                        intent.putExtra("orderid",orderid);
                        startActivity(intent);
                                            }
                });
                tr.addView(b);


                // De rij wordt in dit geval ook aanklikbaar gemaakt
                tr.setClickable(true);
                tr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                        intent.putExtra("orderid",orderid);
                        startActivity(intent);
                    }
                });

            }
            else {
                // work order is reeds behandeld, geen knop maar wel tekst
                TextView txtproc = new TextView(this);
                txtproc.setTextSize(tabletxtsize);
                txtproc.setText("done");
                tr.addView(txtproc);

                //rij is niet meer klikbaar
                tr.setClickable(false);
            }



            res.moveToNext();
            table_layout.addView(tr);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        if (myDb.isDbchanged()){

            this.recreate();

            //Cursor res = myDb.getMainScreenData();
            //buildtable(res);
            //myDb.setDbchanged(false);
        }


    }

}
