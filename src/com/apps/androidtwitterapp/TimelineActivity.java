package com.apps.androidtwitterapp;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.apps.androidtwitterapp.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

public class TimelineActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timeline);
		updateAndDisplayTimeline();
	}

	public void updateAndDisplayTimeline() {
		TwitterClientApp.getRestClient().getHomeTimeline(new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONArray jsonTweets){
				ArrayList<Tweet> tweet = Tweet.fromJson(jsonTweets);
				ListView lvTweet = (ListView) findViewById(R.id.lvTweet);
				TweetAdapter tweetAdapter = new TweetAdapter(getBaseContext(), tweet);
				lvTweet.setAdapter(tweetAdapter);
				//Log.d("DEBUG", jsonTweets.toString());
			}

			
		});
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
			updateAndDisplayTimeline();
		}
	}
	
	

}
