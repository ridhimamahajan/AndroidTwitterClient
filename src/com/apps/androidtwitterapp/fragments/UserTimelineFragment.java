package com.apps.androidtwitterapp.fragments;

import org.json.JSONArray;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.apps.androidtwitterapp.TwitterClientApp;
import com.apps.androidtwitterapp.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class UserTimelineFragment extends TimelineFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//updateAndDisplayTimeline();
		
		  Intent intent = getActivity().getIntent();
		  /* Obtain String from Intent  */
		  if(intent.getExtras() !=null)
		  {
		     String screenName = intent.getStringExtra("screen_name");
		     updateAndDisplayTimeline(screenName);
		  }
		  else
		  {
		    updateAndDisplayTimeline();
		  }
	}

	public void updateAndDisplayTimeline() {
		TwitterClientApp.getRestClient().getUserTimeline(new JsonHttpResponseHandler(){
		
			@Override
			public void onSuccess(JSONArray jsonTweets){
				Log.d("DEBUG", jsonTweets.toString());
				getTweetAdapter().clear();
				getTweetAdapter().addAll(Tweet.fromJson(jsonTweets));
			}

			
		});
	}
	
	public void updateAndDisplayTimeline(String screenName) {
		
		RequestParams params = new RequestParams();
		params.put("screen_name", screenName );
		TwitterClientApp.getRestClient().getUserTimeline(params, new JsonHttpResponseHandler(){
		
			@Override
			public void onSuccess(JSONArray jsonTweets){
				Log.d("DEBUG", jsonTweets.toString());
				getTweetAdapter().clear();
				getTweetAdapter().addAll(Tweet.fromJson(jsonTweets));
			}

			
		});
	}
}
