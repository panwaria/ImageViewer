package com.example.imageviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class ImageGridActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imagegrid);
		
		// Get GridView from xml
		GridView gridView = (GridView) findViewById(R.id.grid_view);
		
		// Set Adapter for GridView
		gridView.setAdapter(new ImageAdapter(this));
		
		/**
		* On Click event for Single GridView Item
		**/
		gridView.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id)
			{
				// Create new intent
				Intent i = new Intent(ImageGridActivity.this, ImageDetailActivity.class);
				
				// Send Image ID to ImageActivity
				i.putExtra("id", position);
				startActivity(i);
			}
		});
	}
}
