package com.dwetherbee.crossrexapp;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.dwetherbee.crossrexapp.data.DemoData;
import com.dwetherbee.crossrexapp.database.DaoMaster;
import com.dwetherbee.crossrexapp.database.DaoSession;

/**
 * Created with IntelliJ IDEA.
 * User: Flavadave
 * Date: 8/18/13
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class CrossRexApplication extends Application {
    private static CrossRexApplication sInstance;
    public CrossRexApplication() {
        sInstance = this;

    }
    public static Context getContext(){
        return sInstance;
    }
    private static SQLiteDatabase sDatabase;
    private static DaoMaster sDaoMaster;
    private static DaoSession sDaoSession;

    private void initializeDatabase(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "crossrex-db", null);
        sDatabase = helper.getWritableDatabase();
        sDaoMaster = new DaoMaster(sDatabase);
        sDaoSession = sDaoMaster.newSession();
    }

    public static DaoSession getDaoSession(){
        return sDaoSession;
    }



    @Override
    public void onCreate() {
        super.onCreate();    //To change body of overridden methods use File | Settings | File Templates.
        initializeDatabase();
        DemoData.create();



    }
}
