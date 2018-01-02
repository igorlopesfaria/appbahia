package br.com.bahiaapp.model.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by Igor Faria on 27/12/17.
 */
public class BaseDAO {
	
	private Context context;
	protected SQLiteDatabase database;
	protected DBHelper dbHelper;

	protected BaseDAO(Context context) {
		this.context = context;
	}

	protected BaseDAO openWritable() throws SQLException {
		dbHelper = new DBHelper(context);
		database = dbHelper.getWritableDatabase();
		return this;
	}

	protected BaseDAO openReadable() throws SQLException {
		dbHelper = new DBHelper(context);
		database = dbHelper.getReadableDatabase();
		return this;
	}

	protected void close() {
		dbHelper.close();
	}
}
