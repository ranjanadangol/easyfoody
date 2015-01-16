package com.project.easyfoody;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegisterAcitvity extends Activity{

	EditText f_name, l_name, usr_name, pw, phone_no, address;
	DatabaseOperations register_do;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		Button register= (Button) findViewById(R.id.register);
		Button login=(Button) findViewById(R.id.bktologin);
		register_do=new DatabaseOperations(this);
		
		f_name=(EditText) findViewById(R.id.fname);
		l_name=(EditText) findViewById(R.id.lname);
		phone_no=(EditText) findViewById(R.id.phone);
		address=(EditText) findViewById(R.id.et_address);
		usr_name=(EditText) findViewById(R.id.et_username);
		pw=(EditText) findViewById(R.id.et_pword);
		
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(RegisterAcitvity.this, LoginActivity.class));
			}
		});
		
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				PostsInfo a=new PostsInfo();
					a.setFirstname(f_name.getText().toString());
					a.setLastname(l_name.getText().toString());
					a.setUser_phone_no(phone_no.getText().toString());
					a.setAddress(address.getText().toString());
					a.setUser_name(usr_name.getText().toString());
					a.setUser_pw(pw.getText().toString());
				register_do.addUserValues(a);
				
				startActivity(new Intent(RegisterAcitvity.this, RegisterAcitvity.class));
			}
		});
	}
	
}
