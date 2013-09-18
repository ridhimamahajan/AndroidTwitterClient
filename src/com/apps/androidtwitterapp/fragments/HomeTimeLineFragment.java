package com.apps.androidtwitterapp.fragments;

import org.json.JSONArray;

import com.apps.androidtwitterapp.R;
import com.apps.androidtwitterapp.TwitterClientApp;
import com.apps.androidtwitterapp.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.os.Bundle;
import android.util.Log;

public class HomeTimeLineFragment extends TimelineFragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		updateAndDisplayTimeline();
	}

	public void updateAndDisplayTimeline() {
		TwitterClientApp.getRestClient().getHomeTimeline(new JsonHttpResponseHandler(){
		
			@Override
			public void onSuccess(JSONArray jsonTweets){
				Log.d("DEBUG", jsonTweets.toString());
				getTweetAdapter().clear();
				getTweetAdapter().addAll(Tweet.fromJson(jsonTweets));
			}

			
		});
	}
	
	
}
