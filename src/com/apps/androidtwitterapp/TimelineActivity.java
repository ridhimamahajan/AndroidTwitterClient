package com.apps.androidtwitterapp;

import org.json.JSONArray;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;

import com.apps.androidtwitterapp.fragments.HomeTimeLineFragment;
import com.apps.androidtwitterapp.fragments.MentionsFragment;
import com.apps.androidtwitterapp.fragments.TimelineFragment;
import com.apps.androidtwitterapp.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

public class TimelineActivity extends FragmentActivity implements TabListener {
	TimelineFragment timelineFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timeline);
		setNavigationTabs();		
		//updateAndDisplayTimeline();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.timeline, menu);
		return true;
	}
	
	public void onComposeClick(MenuItem m){
		Intent i = new Intent(getApplicationContext(), ComposeActivity.class);
		startActivityForResult(i,1);
		
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		if(resultCode == RESULT_OK && requestCode == 1 ){
			// updateAndDisplayTimeline();
			FragmentManager fragmentManager = getSupportFragmentManager();
			android.support.v4.app.FragmentTransaction fts = fragmentManager.beginTransaction();
			fts.replace(R.id.frame_container, new HomeTimeLineFragment());
			fts.commit();

		}
	}
	
	public void setNavigationTabs(){
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(true);
		Tab tabHome= actionBar.newTab().setText("Home")
				.setTag("HomeTimeLineFragment")
				.setIcon(R.drawable.ic_home)
				.setTabListener(this);
		Tab tabMentions= actionBar.newTab().setText("Mentions")
				.setTag("MentionsFragment")
				.setIcon(R.drawable.ic_at)
				.setTabListener(this);
		actionBar.addTab(tabHome);
		actionBar.addTab(tabMentions);
		actionBar.selectTab(tabHome);

	}

	public void onProfileClick(MenuItem item) {
		Intent i = new Intent(this, ProfileActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);                     
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
		startActivity(i);
	}
	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction fts = fragmentManager.beginTransaction();
		if (tab.getTag() == ("HomeTimeLineFragment")){
			fts.replace(R.id.frame_container, new HomeTimeLineFragment());
		}
		else{
			fts.replace(R.id.frame_container, new MentionsFragment());
		}
		fts.commit();
			
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	

}
