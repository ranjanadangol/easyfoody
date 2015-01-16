package com.project.easyfoody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class RestaurantActivity extends Activity{
	ListView listView;
	DatabaseOperations d_o;
	ArrayList<HashMap<String, String>> array_list = new ArrayList<HashMap<String, String>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);
		
		d_o=new DatabaseOperations(this);
		
		if (!isFirstTime()) {
			d_o.addValues();
		}
		List<PostsInfo> l_pinfo= d_o.getAllValuesRestaurant();
		for( PostsInfo pvalue : l_pinfo){
			HashMap<String, String> map = new HashMap<String, String>();
	
			//Add child node to HashMap key & value
			map.put("res_id", Integer.toString(pvalue.get_r_id()));
			map.put("res_name", pvalue.get_res_name());
			map.put("res_loc", pvalue.get_location());
			map.put("res_phone", pvalue.getRes_phone_no());
	
			array_list.add(map);
		}

		listView=(ListView) findViewById(R.id.list);
		Log.e("array_list values", array_list + "");
	
		/*Create Adapter*/
		ListAdapter adapter= new SimpleAdapter(this, array_list, R.layout.list_item, new String[]{"res_name", "res_loc"}, new int[] { R.id.res_name, R.id.res_address});
	
		if(adapter!= null){
			Log.e("Adapter check", adapter + "");
			/*set the Adapter to listview*/
			listView.setAdapter(adapter);
			listView.setOnItemClickListener(new OnItemClickListener() {
	
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					
					String val = ((TextView) view.findViewById(R.id.res_name)).getText().toString();
					//Toast.makeText(getApplicationContext(), val, Toast.LENGTH_LONG).show();	
					Intent i;
					/*i.putExtra("resm_id", array_list.get(position).get("res_id"));
					b=i.getExtras();
					*/
				}
			});
		}
	}
	
	/*Check If the User is first time user*/
	public boolean isFirstTime() { 
		SharedPreferences preferences = getSharedPreferences("Test", MODE_PRIVATE);
		boolean ranBefore = preferences.getBoolean("RanBefore", false);
		if (!ranBefore) {
			// first time 
			SharedPreferences.Editor editor = preferences.edit();
			editor.putBoolean("RanBefore", true);
			editor.commit();
		} 
		return ranBefore;
	} 
	
}
