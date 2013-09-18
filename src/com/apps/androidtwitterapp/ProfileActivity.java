package com.apps.androidtwitterapp;

import org.json.JSONArray;
import org.json.JSONObject;

import com.apps.androidtwitterapp.models.User;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		//loadUserProfile();
		
		Intent intent = getIntent();
		  if(intent.getExtras() !=null)
		  {
		     String screenName = intent.getStringExtra("screen_name");
		     loadClickedOnUserProfile(screenName);
		  }
		  else
		  {
			  loadLoggedInUserProfile();
		  }
	}

	public void loadClickedOnUserProfile(String screenName) {
		RequestParams params =new RequestParams();
		params.put("screen_name", screenName);
		TwitterClientApp.getRestClient().getSpecificUserProfile(params,new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONObject userProfile) {
				User user = User.fromJson(userProfile);
				getActionBar().setTitle("@" + user.getScreenName());
				populateHeaderInfo(user);
			}
		});
	}

	public void loadLoggedInUserProfile() {
		TwitterClientApp.getRestClient().getUserProfile(new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONObject userProfile) {
				User user = User.fromJson(userProfile);
				getActionBar().setTitle("@" + user.getScreenName());
				populateHeaderInfo(user);
			}
		});
		
	}

	public void populateHeaderInfo(User user) {
		TextView tvTagline = (TextView)findViewById(R.id.tvTagline);
		TextView tvUsername = (TextView)findViewById(R.id.tvUsername);
		TextView tvfollowers = (TextView)findViewById(R.id.tvFollowers);
		TextView tvfollowing = (TextView)findViewById(R.id.tvFollowing);
		ImageView userImage = (ImageView) findViewById(R.id.ivUserImage);
		
		tvUsername.setText(user.getName());
		tvfollowers.setText(user.getFollowersCount() + " Followers");
		tvfollowing.setText(user.getFriendsCount() + " Following");
		tvTagline.setText(user.getTagline());
		ImageLoader.getInstance().displayImage(user.getProfileImageUrl(), userImage);
		
		

		


		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

}
