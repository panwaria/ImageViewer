package com.example.imageviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/**
	 * Callback method for clicks on the buttons in Main Screen.
	 * @param v		View clicked
	 */
	public void onButtonClick(View v)
	{
		switch(v.getId())
		{
		case R.id.button_uwimages:
			
			// Create new intent
			Intent i = new Intent(MainActivity.this, ImageGridActivity.class);
			
			startActivity(i);
			break;
			
		case R.id.button_gallery:
			
			// Open pre-installed Gallery Application
			Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(galleryIntent, 0);		
			 
			break;
			
		case R.id.button_settings:
			
			// Lets just show toast for now.
			Toast.makeText(this, "Will add Preferences later!", Toast.LENGTH_LONG).show();
			break;
			
		default:
		}
	}

}
