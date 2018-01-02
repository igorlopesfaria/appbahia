package br.com.bahiaapp.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import br.com.bahiaapp.model.Feed;

/**
 * Created by Igor Faria on 27/12/17.
 */
public class FeedDAO extends BaseDAO {

    private static String TAG = "BaseDAO";
    final static String TABLE_NAME = "tbl_feed";
    final static String COLUMN_NAME_ID = "id";
    final static String COLUMN_NAME_TITLE = "title";
    final static String COLUMN_NAME_SHORT_DESCRIPTION = "shortDescription";
    final static String COLUMN_NAME_TEXT_COMPLEATE = "textCompleate";
    final static String COLUMN_NAME_DATE_PUBLISHED = "datePublished";
    final static String COLUMN_NAME_IMAGE_URL = "imageUrl";
    final static String COLUMN_NAME_MAIN_NEW = "mainNew";
    final static String COLUMN_NAME_LINK = "link";



    public FeedDAO(Context context) {
        super(context);
    }
    public void removeAll() {
        this.openWritable();

        database.delete(TABLE_NAME, null,null );
        this.close();
    }


    public List<Feed> findAll() {
        this.openReadable();

        List<Feed> returnFeeds = new ArrayList();
        String[] projection = {
                COLUMN_NAME_ID,
                COLUMN_NAME_TITLE,
                COLUMN_NAME_SHORT_DESCRIPTION,
                COLUMN_NAME_TEXT_COMPLEATE,
                COLUMN_NAME_DATE_PUBLISHED,
                COLUMN_NAME_IMAGE_URL,
                COLUMN_NAME_MAIN_NEW,
                COLUMN_NAME_LINK
        };


        try {
            Cursor cursor = database.query(TABLE_NAME, // The table to query
                    projection, // The columns to return
                    null,
                    null, // The values for the WHERE clause
                    null, // don't group the rows
                    null, // don't filter by row groups
                    null // The sort order
            );

            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                returnFeeds = new ArrayList();
                do {
                    returnFeeds.add(this.bindSQLite(cursor));
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (SQLException e) {
            Log.e(TAG, e.getMessage());
        } finally {
            this.close();
        }

        return returnFeeds;

    }


   
    public void insert(List<Feed> lFeed) {
        this.openWritable();
        try {
            database.beginTransaction();

            for (Feed feed : lFeed) {
                // Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                values.put(COLUMN_NAME_ID, feed.getId());
                values.put(COLUMN_NAME_TITLE, feed.getTitle());
                values.put(COLUMN_NAME_SHORT_DESCRIPTION, feed.getShortDescription());
                values.put(COLUMN_NAME_TEXT_COMPLEATE, feed.getTextCompleate());
                values.put(COLUMN_NAME_DATE_PUBLISHED, feed.getDatePublished());
                values.put(COLUMN_NAME_IMAGE_URL, feed.getImageUrl());
                values.put(COLUMN_NAME_MAIN_NEW, feed.isMainNew()?1:0);
                values.put(COLUMN_NAME_LINK, feed.getLink());


                // Insert the new row, returning the primary key value of the
                // new row
                long rowId = 0;

                String selection = COLUMN_NAME_ID + " == ?";
                String[] selectionArgs = { String.valueOf(feed.getId()) };

                rowId = database.update(TABLE_NAME, values, selection,
                        selectionArgs);

                if (rowId == 0) {
                    database.insert(TABLE_NAME,
                            DBHelper.COLUMN_NAME_NULLABLE, values);

                }
            }

            database.setTransactionSuccessful();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } finally {
            database.endTransaction();
            close();
        }
    }

    private Feed bindSQLite(Cursor cursor) {
        Feed feed = new Feed();
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            if (COLUMN_NAME_ID.equals(cursor.getColumnName(i)))
                feed.setId(cursor.getLong(i));
            else if (COLUMN_NAME_TITLE.equals(cursor.getColumnName(i)))
                feed.setTitle(cursor.getString(i));
            else if (COLUMN_NAME_SHORT_DESCRIPTION.equals(cursor.getColumnName(i)))
                feed.setShortDescription(cursor.getString(i));
            else if (COLUMN_NAME_TEXT_COMPLEATE.equals(cursor.getColumnName(i)))
                feed.setTextCompleate(cursor.getString(i));
            else if (COLUMN_NAME_DATE_PUBLISHED.equals(cursor.getColumnName(i)))
                feed.setDatePublished(cursor.getString(i));
            else if (COLUMN_NAME_IMAGE_URL.equals(cursor.getColumnName(i)))
                feed.setImageUrl(cursor.getString(i));
            else if (COLUMN_NAME_MAIN_NEW.equals(cursor.getColumnName(i)))
                feed.setMainNew(cursor.getInt(i)==1?true:false);
            else if (COLUMN_NAME_LINK.equals(cursor.getColumnName(i)))
                feed.setLink(cursor.getString(i));

        }
        return feed;
    }

}
