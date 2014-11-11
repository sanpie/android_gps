package com.example.checkconnection;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	 Boolean isInternetPresent = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void checkC(View v)
	{
		ConnectivityManager cm =(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		 if(activeNetwork != null && activeNetwork.isConnectedOrConnecting())
		 {
				Toast.makeText(this, "you are connected to internet", 1).show();
				 boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
				 if(isWiFi)
				 {
					 Toast.makeText(this, "you are dependent on wifi for internet ", 1).show();
				 }

		 }
		
	}
	
	public void gpscheck(View v)
	{
		LocationManager locationManager = (LocationManager)getSystemService(LOCATION_SERVICE); 
		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
		{
			Toast.makeText(this, "GPS is Enabled in your devide", Toast.LENGTH_SHORT).show(); 
			}
		else
		{
			Toast.makeText(this, "GPS is DISabled in your devide", Toast.LENGTH_SHORT).show(); 
		}
		}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
