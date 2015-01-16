package com.project.easyfoody;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;


/*New MySqliteHelper for version 3*/
public class MySqliteOpenHelper extends SQLiteOpenHelper{
	/* Database Version */
	public static final int DATABASE_VERSION=2;
	
	/*Initialize*/
	public MySqliteOpenHelper(Context context) {
		/*Save sqlite database in the path specified*/
		super(context, "easyfood", null, DATABASE_VERSION);
		Log.e("MySqliteHelper", Environment.getExternalStorageDirectory()+"/EF/");
	}

	/* Create Table*/
	@Override
	public void onCreate(SQLiteDatabase database) {
		Log.e("Table Creation", "started");
		database.execSQL(SqlQuery.EF_RESTAURANT);
		database.execSQL(SqlQuery.EF_MENU);
		database.execSQL(SqlQuery.EF_USER_DETAILS);
		Log.e("Table Creation", "Ended");
	}
	
	/*Upgrade Database*/
	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		
		/* Drop Table IF Existed */
		db.execSQL("DROP TABLE IF EXISTS" + TableAttributes.RESTAURANT_TABLE);
		db.execSQL("DROP TABLE IF EXISTS" + TableAttributes.MENU_TABLE);
		db.execSQL("DROP TABLE IF EXISTS" + TableAttributes.USER_TABLE);
		/* create Table again */
		onCreate(db);
	}
	
}
