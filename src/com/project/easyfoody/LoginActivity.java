package com.project.easyfoody;

import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity{
	
	EditText username, password;
	TextView register;
	DatabaseOperations login_do;
	Button login_btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		username= (EditText) findViewById(R.id.et_username);
		password= (EditText) findViewById(R.id.et_password);
		login_btn=(Button) findViewById(R.id.btn_login);
		register= (TextView) findViewById(R.id.register);
		
		login_do=new DatabaseOperations(this);
		
		login_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				List<PostsInfo> l_pinfo= login_do.getAllValuesUsers();
				String un_value=username.getText().toString();
				String pw_value=password.getText().toString();
				
				for( PostsInfo pvalue : l_pinfo){
					if (un_value.equals(pvalue.getUser_name()) && pw_value.equals(pvalue.getUser_pw())){
						startActivity(new Intent(LoginActivity.this, MenuActivity.class));
						break;
					}
					Toast.makeText(LoginActivity.this, "Wrong username and password", Toast.LENGTH_LONG).show();
				}
				
			}
		});
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginActivity.this, RegisterAcitvity.class));
			}
		});
		
	}
}
