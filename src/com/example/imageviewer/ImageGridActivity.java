package com.example.imageviewer;

import android.app.Activity;
import android.os.Bundle;
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
	}
}
