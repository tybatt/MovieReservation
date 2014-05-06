package com.example.moviereservation;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.os.Build;

public class ReserveActivity extends ActionBarActivity {
	private RadioGroup movies;
	private RadioGroup times;
	private RadioButton radioButton;
	private RadioButton radioButton2;
	private Button button1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reserve);
		
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	public void onClick(View v) {
		 
		movies = (RadioGroup) findViewById(R.id.movies);
		times = (RadioGroup) findViewById(R.id.times);
		button1 = (Button) findViewById(R.id.button1);
		// get selected radio button from radioGroup
		int selectedId = movies.getCheckedRadioButtonId();
		int selectedId2 = times.getCheckedRadioButtonId();
		// find the radiobutton by returned id
		radioButton = (RadioButton) findViewById(selectedId);
		radioButton2 = (RadioButton) findViewById(selectedId2);
		String select = radioButton.getText().toString();
		String selectT = radioButton2.getText().toString();
		Intent k = new Intent(ReserveActivity.this, InfoActivity.class);
		Bundle extraInfo = new Bundle();
		extraInfo.putString("times", selectT);
		extraInfo.putString("movies", select);
		k.putExtras(extraInfo);
		
        startActivity(k);
	 
		}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reserve, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_reserve,
					container, false);
			return rootView;
		}
	}

}
