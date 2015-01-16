package com.project.easyfoody;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DatabaseOperations {

	/*Database fields*/
	private SQLiteDatabase database;
	private MySqliteOpenHelper dbHelper;
	  
	public DatabaseOperations(Context context) {
	    dbHelper = new MySqliteOpenHelper(context);
	}
	
	public void open() throws SQLException {
	    database = dbHelper.getWritableDatabase();
	}
	
	public void close() {
	    dbHelper.close();
	}
	
	/* CRUD Operations */
	public void addValues() {
		open();
		database.execSQL(SqlQuery.INSERT_RESTAURANTS);
		database.close();
	}
	
	public int updateValues(PostsInfo a) {
		open();
		//return database.update(TableAttributes.USER_TABLE, GetContentValues(a) , TableAttributes.KEY_USER_ID + " = ?", new String[] {String.valueOf(a.get_id()) });
		return 0;
	}
	
	public void addUserValues(PostsInfo a) {
		open();
		ContentValues values= new ContentValues();
			values.put(TableAttributes.KEY_FIRST_NAME, a.getFirstname());
			values.put(TableAttributes.KEY_LAST_NAME, a.getLastname());
			values.put(TableAttributes.KEY_USER_NAME, a.getUser_name());
			values.put(TableAttributes.KEY_USER_PW, a.getUser_pw());
			values.put(TableAttributes.KEY_ADDRESS, a.getAddress());
			values.put(TableAttributes.KEY_PHONE_NO, a.getUser_phone_no());
		database.insert(TableAttributes.USER_TABLE, null, values);
		database.close();
	}

	// Getting All values
    public List<PostsInfo> getAllValuesRestaurant() {
    	open();
    	Log.e("GetAllValues", "I m in GetAllValues");
        List<PostsInfo> act_list = new ArrayList<PostsInfo>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TableAttributes.RESTAURANT_TABLE;
        Log.e("Select Query", selectQuery.toString());
 
        Cursor cursor = database.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	PostsInfo act = new PostsInfo();
                act.set_r_id(Integer.parseInt(cursor.getString(0)));
                act.set_res_name(cursor.getString(1));
                act.set_location(cursor.getString(2));
                act.setRes_phone_no(cursor.getString(3));
                               
                act_list.add(act);
            } while (cursor.moveToNext());
        }
 
        cursor.close();
        return act_list;
    }
    
 // Getting All values
    public List<PostsInfo> getAllValuesUsers() {
    	open();
    	Log.e("GetAllValues", "I m in GetAllValues");
        List<PostsInfo> act_list = new ArrayList<PostsInfo>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TableAttributes.USER_TABLE;
        Log.e("Select Query", selectQuery.toString());
 
        Cursor cursor = database.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	PostsInfo act = new PostsInfo();
                act.setUser_name(cursor.getString(1));
                act.setUser_pw(cursor.getString(2));
                act_list.add(act);
            } while (cursor.moveToNext());
        }
 
        Log.e("Select List", act_list +"");
        cursor.close();
        return act_list;
    }
    
    // Getting All values
    public List<PostsInfo> getAllValuesMenu() {
    	Log.e("GetAllValues", "I m in GetAllValues");
        List<PostsInfo> act_list = new ArrayList<PostsInfo>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TableAttributes.MENU_TABLE;
        Log.e("Select Query", selectQuery.toString());
 
        Cursor cursor = database.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	PostsInfo act = new PostsInfo();
                act.setMenu_id(Integer.parseInt(cursor.getString(0)));
                act.setResm_id(cursor.getString(1));
                act.setCategory(cursor.getString(2));
                act.setFood_name(cursor.getString(3));
                act.setPrice(cursor.getString(4));
                
                act_list.add(act);
            } while (cursor.moveToNext());
        }
 
        cursor.close();
        return act_list;
    }
}