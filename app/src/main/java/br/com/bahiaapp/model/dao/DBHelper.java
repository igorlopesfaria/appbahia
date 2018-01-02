package br.com.bahiaapp.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Igor Faria on 02/01/18.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "appbahia-apk-db";
    private static final int DATABASE_VERSION = 1;
    static final String COLUMN_NAME_NULLABLE = "null";

    private static final String DATABASE_CREATE_FEED = "CREATE TABLE IF NOT EXISTS "
            + FeedDAO.TABLE_NAME + " ("
            + FeedDAO.COLUMN_NAME_ID + " INTEGER , "
            + FeedDAO.COLUMN_NAME_TITLE + " VARCHAR ,"
            + FeedDAO.COLUMN_NAME_SHORT_DESCRIPTION + " VARCHAR ,"
            + FeedDAO.COLUMN_NAME_TEXT_COMPLEATE + " INTEGER ,"
            + FeedDAO.COLUMN_NAME_DATE_PUBLISHED + " VARCHAR ,"
            + FeedDAO.COLUMN_NAME_IMAGE_URL + " VARCHAR ,"
            + FeedDAO.COLUMN_NAME_LINK + " VARCHAR ,"
            + FeedDAO.COLUMN_NAME_MAIN_NEW + " INTEGER );";

    private static final String DATABASE_DROP_FEED = "DROP TABLE IF EXISTS " + FeedDAO.TABLE_NAME + "; ";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        database.execSQL(DATABASE_CREATE_FEED);


    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {


        database.execSQL(DATABASE_DROP_FEED);

        this.onCreate(database);

    }


}