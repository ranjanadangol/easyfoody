package com.project.easyfoody;

public class SqlQuery {

	//Table Creation for ACTIVITY_NAME	
	public static final String EF_RESTAURANT= "CREATE TABLE IF NOT EXISTS "
			+ TableAttributes.RESTAURANT_TABLE 
			+ "(" + TableAttributes.KEY_RES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			  	+ TableAttributes.KEY_RES_NAME + " VARCHAR(50), " 
				+ TableAttributes.KEY_LOC + " TEXT, "
				+ TableAttributes.KEY_PHONE + " LONG )";
		
	public static final String EF_USER_DETAILS= "CREATE TABLE IF NOT EXISTS "
			+ TableAttributes.USER_TABLE 
			+ "(" + TableAttributes.KEY_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
				+ TableAttributes.KEY_FIRST_NAME + " VARCHAR(50), " 
				+ TableAttributes.KEY_LAST_NAME + " VARCHAR(50), "
			  	+ TableAttributes.KEY_USER_NAME + " VARCHAR(50), " 
				+ TableAttributes.KEY_USER_PW + " VARCHAR(50), "
				+ TableAttributes.KEY_ADDRESS + " VARCHAR(50), " 
				+ TableAttributes.KEY_PHONE_NO + " TEXT, "
				+ TableAttributes.KEY_FOOD_ORDER + " TEXT, "
				+ TableAttributes.KEY_TOTAL_PRICE + " LONG )";
	
	public static final String EF_MENU= "CREATE TABLE IF NOT EXISTS "
				+ TableAttributes.MENU_TABLE 
				+ "("
					+ TableAttributes.KEY_MENU_ID
						+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ TableAttributes.KEY_RESM_ID
						+ " INTEGER FOREIGN KEY REFERENCES " 
						+TableAttributes.RESTAURANT_TABLE
						+" ("+ TableAttributes.KEY_RES_ID +") " 
					+ TableAttributes.KEY_CATEGORY
						+ " TEXT,"
					+ TableAttributes.KEY_FOOD_NAME
						+ " TEXT,"
					+ TableAttributes.KEY_PRICE
						+ " TEXT )";
	
	public static final String INSERT_RESTAURANTS= "INSERT INTO "
			+ TableAttributes.RESTAURANT_TABLE 
			+ " VALUES "
			+ "("
			+ "NULL, "
			+ "'GHANGHRI SUMAI', "
			+ "'TEKU, KATHMANDU', "
			+ "9812345758"
			+ "), "
			+ "("
			+ "NULL, "
			+ "'THE BAKERY CAFE', "
			+ "'TEKU, KATHMANDU', "
			+ "9812345758"
			+ "), "
			+ "("
			+ "NULL, "
			+ "'JESSY PENNY', "
			+ "'TEKU, KATHMANDU', "
			+ "9812345758"
			+ "), "
			+ "("
			+ "NULL, "
			+ "'HOT BREADS', "
			+ "'TEKU, KATHMANDU', "
			+ "9812345758"
			+ ")";
	
	public static final String INSERT_MENU= "INSERT INTO "
			+ TableAttributes.MENU_TABLE 
			+ " VALUES "
			+ "("
			+ "NULL, "
			+ "1, "
			+ "'FAST FOOD', "
			+ "'PIZZA', "
			+ "Rs.120"
			+ "), "
			+ "("
			+ "NULL, "
			+ "1, "
			+ "'FAST FOOD', "
			+ "'MO:MO"
			+ "Rs.75"
			+ "), "
			+ "("
			+ "NULL, "
			+ "1, "
			+ "'FAST FOOD', "
			+ "'CHIPS CHILLI"
			+ "Rs.70"
			+ "), "
			+ "("
			+ "NULL, "
			+ "1, "
			+ "'FAST FOOD', "
			+ "'BURGER"
			+ "Rs.85"
			+ "), "

			/*Restaurant 2*/

			+ "("
			+ "NULL, "
			+ "2, "
			+ "'FAST FOOD', "
			+ "'PIZZA', "
			+ "Rs.120"
			+ "), "
			+ "("
			+ "NULL, "
			+ "2, "
			+ "'FAST FOOD', "
			+ "'MO:MO"
			+ "Rs.75"
			+ "), "
			+ "("
			+ "NULL, "
			+ "2, "
			+ "'FAST FOOD', "
			+ "'CHIPS CHILLI"
			+ "Rs.70"
			+ "), "
			+ "("
			+ "NULL, "
			+ "2, "
			+ "'FAST FOOD', "
			+ "'BURGER"
			+ "Rs.85"
			+ ")"
			
			/*REstaurant 1 category 2*/
			+ "("
			+ "NULL, "
			+ "1, "
			+ "'COMBO', "
			+ "'Pizza+Coke+Fries', "
			+ "Rs.120"
			+ "), "
			+ "("
			+ "NULL, "
			+ "1, "
			+ "'COMBO', "
			+ "'MO:MO"
			+ "Rs.75"
			+ "), "
			+ "("
			+ "NULL, "
			+ "2, "
			+ "'COMBO', "
			+ "'CHIPS CHILLI"
			+ "Rs.70"
			+ "), "
			+ "("
			+ "NULL, "
			+ "2, "
			+ "'COMBO', "
			+ "'BURGER"
			+ "Rs.85"
			+ ")"
			;

}
