package be.groept.IE3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ElectroManDb";
    public static final String TABLE_NAME = "WorkOrders_Table";
    public static final String COL_ID = "ID";
    public static final String COL_CITY = "City";
    public static final String COL_DEVICE = "Device";
    public static final String COL_PROBLEM_CODE = "ProblemCode";
    public static final String COL_NAME = "Name";
    public static final String COL_PROCESSED = "Processed";
    public static final String COL_PROBLEM_DESCRIPTION = "ProblemDescription";
    public static final String COL_ADDRESS = "Address";
    public static final String COL_REPAIR_INFO = "Repair_Info";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_CITY + TEXT_TYPE + COMMA_SEP +
                    COL_DEVICE + TEXT_TYPE + COMMA_SEP +
                    COL_PROBLEM_CODE + " INTEGER, " +
                    COL_NAME + TEXT_TYPE + COMMA_SEP +
                    COL_PROCESSED + " INTEGER, " +
                    COL_PROBLEM_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    COL_ADDRESS + TEXT_TYPE + COMMA_SEP +
                    COL_REPAIR_INFO + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public boolean isDbchanged() {
        return dbchanged;
    }

    public void setDbchanged(boolean newvalue) {
        this.dbchanged = newvalue;
    }

    //variable used to determine if the data has changed and must be reloaded by an activity
    private boolean dbchanged;


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
        emptydb();
        createTestData();
        this.setDbchanged(false);
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

    public boolean insertData(String city, String device, int problemcode, String name, int processed, String problemdescription, String address, String repairinfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CITY, city);
        contentValues.put(COL_DEVICE, device);
        contentValues.put(COL_PROBLEM_CODE, problemcode);
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_PROCESSED, processed);
        contentValues.put(COL_PROBLEM_DESCRIPTION, problemdescription);
        contentValues.put(COL_ADDRESS, address);
        contentValues.put(COL_REPAIR_INFO, repairinfo);
        long result = db.insert(TABLE_NAME,null,contentValues);

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
                COL_ID,
                COL_CITY,
                COL_DEVICE,
                COL_PROBLEM_CODE,
                COL_NAME,
                COL_PROCESSED };

        Cursor res = db.query(
                TABLE_NAME,
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



    public Cursor getDetailInfo(int orderid){
        SQLiteDatabase db = this.getWritableDatabase();

        String[] projection = {
                COL_ID,
                COL_PROBLEM_DESCRIPTION,
                COL_ADDRESS,
                COL_REPAIR_INFO };

        String selection = COL_ID + " = ?";

        String[] args = {String.valueOf(orderid)};
        Cursor res = db.query(
                TABLE_NAME,
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                args,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        if (res != null) {
            res.moveToFirst();
        }

        return res;
    }



    public void updateRepair(int orderid, String repairinfo){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        if(repairinfo!=null) cv.put(COL_REPAIR_INFO,repairinfo);
        cv.put(COL_PROCESSED,1);

        String selection = COL_ID + " = ?";

        String[] args = {String.valueOf(orderid)};

        db.update(TABLE_NAME,cv,selection,args);

        setDbchanged(true);


    }

    public void createTestData(){

        SQLiteDatabase db = this.getWritableDatabase();
        insertData("Brussels","Microwave",12,"Smith",0,"Microwave dish does not rotate","Wetstraat 15, 1000 Brussels",null);
        insertData("Brussels","Dishwasher",2,"Van Eeckhout",0,"Water is not heating anymore","Koningsstraat 112, 1030 Schaerbeek",null);
        insertData("Ghent", "Cooking Stove", 10, "Lanners", 0, "One of the cooking fires is not igniting", "Korenveldstraat 5, Ghent", null);
        insertData("Amsterdam","Kroketmuur",11,"Stam",0,"Doors do not open automatically when inserting correct amount","Stationsplein 1, Amsterdam, NL",null);
        insertData("Liedekerke","Frituurketel",10,"Bruneel",0,"Heat limiter is broken, oil boils over","Kerkstraat 20, Liedekerke",null);
    }

    public void emptydb(){
        SQLiteDatabase db = this.getWritableDatabase();
        onUpgrade(db,1,1);
    }

}