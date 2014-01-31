package com.example.imageviewer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageDetailActivity extends Activity
{
	
	Integer mCurrentImagePosition = -1;		// Currently displayed image 
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imagedetail);
		
		// Get intent data
		Intent i = getIntent();
		// Extract Image ID (position) from the passed intent
		mCurrentImagePosition = i.getExtras().getInt("id");
		
		// First, set the image user want to be displayed.
				ImageView imageView = (ImageView) findViewById(R.id.image_large);
				imageView.setImageResource(mPics[mCurrentImagePosition]);
				
		// Set UI controls
		setCaptionUIControls();
	}
	
	/** 
	 * Method to set UI related to Image caption.
	 */
	public void setCaptionUIControls()
	{
		// See if a caption has already been added for this image. 
		LinearLayout captionLinearLayout = (LinearLayout) findViewById(R.id.image_caption_linearlayout);
		TextView captionTextView = (TextView) findViewById(R.id.image_caption_textview);
		
		String caption = getImageCaption();
		if(caption!= null && !caption.equals(""))
		{
			captionTextView.setVisibility(View.VISIBLE);
			captionTextView.setText(caption);
			captionLinearLayout.setVisibility(View.GONE);
		}
		else
		{
			captionTextView.setVisibility(View.GONE);
			captionLinearLayout.setVisibility(View.VISIBLE);
		}
	}
	
	// Actual Full Size Images
	public Integer[] mPics =
	{
		R.drawable.pic0, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
		R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7,
		R.drawable.pic8, R.drawable.pic9, R.drawable.pic10, R.drawable.pic11,
		R.drawable.pic12, R.drawable.pic13, R.drawable.pic14, R.drawable.pic15,
		R.drawable.pic16, R.drawable.pic17, R.drawable.pic18, R.drawable.pic19,
		R.drawable.pic20, R.drawable.pic21, R.drawable.pic22, R.drawable.pic23,
		R.drawable.pic24, R.drawable.pic25, R.drawable.pic26, R.drawable.pic27,
		R.drawable.pic28, R.drawable.pic29, R.drawable.pic30, R.drawable.pic31,
		R.drawable.pic32, R.drawable.pic33, R.drawable.pic34, R.drawable.pic35,
		R.drawable.pic36, R.drawable.pic37, R.drawable.pic38, R.drawable.pic39
	};
	
	private static final String PREFS_NAME = "com.example.ImageViewer.caption";
	
	/**
	 * Method to get the Image Caption (if any) from Shared Preferences.
	 * 
	 * @return	Image caption text
	 */
	private String getImageCaption()
	{
		// Check if SharedPreferences has a caption associated for the requested image.
		SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		return prefs.getString(mCurrentImagePosition.toString(), null);
	}
		
	/**
	 * Method to store Image caption in SharePreferences.
	 * 
	 * @param caption 	Caption text
	 */
	private void setImageCaption(String caption)
	{
		// Get Shared Preferences Editor
		SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		
		// Edit the value for this particular key (Image position) and commit the change.
		editor.putString(mCurrentImagePosition.toString(), caption);
		editor.commit();
	}
	
	/**
	 * Click callback for 'Add' button on ImageDetail Screen.
	 * 
	 * @param v		View clicked
	 */
	public void onButtonClick(View v)
	{
		switch(v.getId())
		{
		case R.id.image_caption_button:
		
			EditText captionEditText = (EditText) findViewById(R.id.image_caption_edittext);
			String caption = captionEditText.getText().toString();
			
			if(caption != null && !caption.equals(""))
			{
				// Store the caption string in Shared Preferences against this image.
				setImageCaption(caption);
				
				// Refresh UI
				setCaptionUIControls();
			}
			break;
			
		default:
		}
	}
	
	/**
	 * Click callback for 'TextView' on ImageDetail Screen.
	 * 
	 * @param v		View clicked
	 */
	public void onTextViewClick(View v)
	{
		switch(v.getId())
		{
		case R.id.image_caption_textview:
			
			TextView captionTextView = (TextView) findViewById(R.id.image_caption_textview);
			LinearLayout captionLinearLayout = (LinearLayout) findViewById(R.id.image_caption_linearlayout);
			EditText captionEditText = (EditText) findViewById(R.id.image_caption_edittext);

			// Put the text of TextView in EditText
			String caption = captionTextView.getText().toString();
			captionEditText.setText(caption);
			
			if(captionEditText.requestFocus()) 
			    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
			
			// And, make EditText & Button visible
			captionTextView.setVisibility(View.GONE);
			captionLinearLayout.setVisibility(View.VISIBLE);
			
			break;
			
		default:
		}
	}
	
}


