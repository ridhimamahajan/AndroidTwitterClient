package com.apps.androidtwitterapp;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.apps.androidtwitterapp.models.Tweet;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class ComposeActivity extends Activity {

	EditText etTweet; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compose);
		etTweet = (EditText) findViewById(R.id.etTweet);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.compose, menu);
		return true;
	}
	
	public void onTweet(View view) {
		String tweetText= etTweet.getText().toString();
		RequestParams params = new RequestParams();
		params.put("status", tweetText );
		TwitterClientApp.getRestClient().postTweet(params, new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONObject jsonTweet){
				
				
				if (getParent() == null) {
				    setResult(Activity.RESULT_OK);
				} else {
				    getParent().setResult(Activity.RESULT_OK);
				}
				finish();

			}
			

		});
		
		
	}
	

}
