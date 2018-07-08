package com.rid.morgan.inter.ibuy.database;

import android.content.Context;
import android.provider.ContactsContract;

import org.greenrobot.greendao.database.Database;


/**
 * Create by Morgan on 2018/7/8 0008
 */
public class DatabaseManager {

    private UserProfileDao mDao;
    private DaoSession mSession;

    private DatabaseManager(){

    }

    public DatabaseManager init(Context context){
        initDao(context);
        return this;
    }

    private static final class Holder{
        private static final DatabaseManager INSTANCE = new DatabaseManager();
    }

    public static DatabaseManager getInstance(){
        return Holder.INSTANCE;
    }


    private void initDao(Context context){
        ReleaseOpenHelper helper = new ReleaseOpenHelper(context,"ibuy.db");
        Database  db = helper.getWritableDb();
        mSession = new DaoMaster(db).newSession();
        mDao = mSession.getUserProfileDao();
    }

    public UserProfileDao getDao() {
        return mDao;
    }
}
