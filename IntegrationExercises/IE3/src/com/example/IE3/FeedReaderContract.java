package com.example.IE3;

import android.provider.BaseColumns;


public class FeedReaderContract {


    public FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
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

    }
}
