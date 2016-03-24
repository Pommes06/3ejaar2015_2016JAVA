package com.example.IE3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.IE3.FeedReaderContract.FeedEntry;


public class DbHelper extends SQLiteOpenHelper {



    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
    "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FeedEntry.COL_CITY + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COL_DEVICE + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COL_PROBLEM_CODE + " INTEGER, " +
                    FeedEntry.COL_NAME + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COL_PROCESSED + " BOOLEAN, " +
                    FeedEntry.COL_PROBLEM_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COL_ADDRESS + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COL_REPAIR_INFO + TEXT_TYPE +
            " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

    public DbHelper(Context context) {
        super(context, FeedEntry.DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
        //createTestData();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public boolean insertData(String city, String device, int problemcode, String name, boolean processed, String problemdescription, String address, String repairinfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FeedEntry.COL_CITY, city);
        contentValues.put(FeedEntry.COL_DEVICE, device);
        contentValues.put(FeedEntry.COL_PROBLEM_CODE, problemcode);
        contentValues.put(FeedEntry.COL_NAME, name);
        contentValues.put(FeedEntry.COL_PROCESSED, processed);
        contentValues.put(FeedEntry.COL_PROBLEM_DESCRIPTION, problemdescription);
        contentValues.put(FeedEntry.COL_ADDRESS, address);
        contentValues.put(FeedEntry.COL_REPAIR_INFO, repairinfo);
        long result = db.insert(FeedEntry.TABLE_NAME,null,contentValues);

        if (result == -1) {
            Log.d("insert failed", "problem while inserting data");
            return false;
        } else
            return true;
    }

    // geeft data die in het startscherm getoond worden
    public Cursor getMainScreenData(){
        SQLiteDatabase db = this.getWritableDatabase();

        String[] projection = {
                FeedEntry.COL_ID,
                FeedEntry.COL_CITY,
                FeedEntry.COL_DEVICE,
                FeedEntry.COL_PROBLEM_CODE,
                FeedEntry.COL_NAME,
                FeedEntry.COL_PROCESSED };

        Cursor res = db.query(
                FeedEntry.TABLE_NAME,
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        if (res != null) {
            res.moveToFirst();
        }

        return res;
    }

    public void createTestData(){

        SQLiteDatabase db = this.getWritableDatabase();
        insertData("Brussels","Microwave",12,"Smith",false,"Microwave dish does not rotate","Wetstraat 15, 1000 Brussels",null);
        insertData("Brussels","Dishwasher",2,"Van Eeckhout",false,"Water is not heating anymore","Koningsstraat 112 1030 Schaerbeek",null);
        insertData("Ghent", "Cooking Stove", 10, "Lanners", false, "One of the cooking fires is not igniting", "Korenveldstraat 5, Ghent", null);
        insertData("Amsterdam","Kroketmuur",11,"Stam",false,"Doors do not open automatically when inserting correct amount","Stationsplein 1, Amsterdam, NL",null);
        insertData("Liedekerke","Frituurketel",10,"Bruneel",false,"Heat limiter is broken, oil boils over","Kerkstraat 20, Liedekerke",null);
    }
}
