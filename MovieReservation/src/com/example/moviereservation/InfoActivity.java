package com.example.moviereservation;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class InfoActivity extends ActionBarActivity {
	private String movie;
	private String time;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		Bundle extras = getIntent().getExtras();
		
		if(extras != null) 
		{
			movie = extras.getString("movies");
			time= extras.getString("times");
		}
		TextView timeInfo = (TextView)findViewById(R.id.timeInfo);
		timeInfo.setText("Movie: " + movie);
		TextView textView1 = (TextView)findViewById(R.id.textView1);
		textView1.setText("Time: " + time);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	public void reciept(View v)
	{
		try
        {
            Intent k = new Intent(InfoActivity.this, RecieptActivity.class);
            startActivity(k);
        }catch(Exception e){

        }
	}
	
	public void backAction(View v)
	{
		try
        {
            Intent k = new Intent(InfoActivity.this, ReserveActivity.class);
            startActivity(k);
        }catch(Exception e){

        }
	}
	
	public void onClick(View v)
	{
		try
        {
			TextView textView1 = (TextView)findViewById(R.id.textView1);
			TextView timeInfo = (TextView)findViewById(R.id.timeInfo);
			timeInfo.setText("<DELETED>");
			textView1.setText("<DELETED>");
			
        }catch(Exception e){

        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info, menu);
		return true;
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
	
	
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_info, container,
					false);
			return rootView;
		}
	}

}
