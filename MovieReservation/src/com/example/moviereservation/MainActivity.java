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
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	private EditText editText1;
	private String username;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	public void loginAction(View v) {
		editText1 = (EditText)findViewById(R.id.editText1);
		username = editText1.getText().toString();
		String text = "text";
		Toast.makeText(getApplicationContext(), 
                username, Toast.LENGTH_LONG).show();
        if(username.equals(text))
        {
        	
        		Intent k = new Intent(MainActivity.this, ReserveActivity.class);
                startActivity(k);
        }
        else
        {
        	Toast.makeText(getApplicationContext(), 
                    "didn't work", Toast.LENGTH_LONG).show();
        }
        		
        	
        
    }
	
	public void signUpAction(View v) {
        try
        {
            Intent k = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(k);
        }catch(Exception e){

        }
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
