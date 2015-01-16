package com.project.easyfoody;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        Thread logoTimer= new Thread(){
         public void run(){
        	 try {
        		sleep(5000);
        		Intent menuIntent = new Intent(SplashScreen.this,LoginActivity.class);
        		startActivity(menuIntent);
        	 } catch (InterruptedException e) {
				e.printStackTrace();
			}
        	 
        	 finally{
        		 finish();
        	 }
         }
        };
        
        logoTimer.start();
        
        
			
    }
 
 


}
