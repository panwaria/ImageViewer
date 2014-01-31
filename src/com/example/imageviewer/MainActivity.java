package com.example.imageviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Check if opening Gallery App is allowed.
		boolean allowToOpenGallery = PreferenceManager.getDefaultSharedPreferences(this)
				.getBoolean("allow_open_gallery", true);

		// If it is not allowed, then hide the 'Open Gallery' button
		if (!allowToOpenGallery)
		{
			Button openGalleryButton = (Button) findViewById(R.id.button_gallery);
			openGalleryButton.setVisibility(View.GONE);
		}
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
			Intent galleryIntent = new Intent(Intent.ACTION_PICK, 
					                   android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(galleryIntent, 0);		
			 
			break;
			
		case R.id.button_settings:
			
			// Launch Settings Activity.
			Intent intent = new Intent(this, SettingsActivity.class);
			startActivity(intent);
			break;
			
		default:
		}
	}

}
