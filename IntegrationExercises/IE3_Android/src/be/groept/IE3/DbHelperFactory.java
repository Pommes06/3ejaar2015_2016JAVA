package be.groept.IE3;


import android.content.Context;

public class DbHelperFactory {

    private static DbHelper instance;

    private DbHelperFactory(){};

    public static DbHelper makeDbHelper(Context context){
        if (instance == null){
            instance = new DbHelper(context);
        }
        return instance;
    }

}

