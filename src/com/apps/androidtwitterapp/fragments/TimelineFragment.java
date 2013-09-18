package com.apps.androidtwitterapp.fragments;

import java.util.ArrayList;

import com.apps.androidtwitterapp.R;
import com.apps.androidtwitterapp.TweetAdapter;
import com.apps.androidtwitterapp.models.Tweet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TimelineFragment extends Fragment {
	TweetAdapter tweetAdapter;
	ListView lvTweets;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_tweet_list, container, false);
		lvTweets = (ListView) v.findViewById(R.id.lvTweet);
		lvTweets.setAdapter(tweetAdapter);
		return v;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ArrayList<Tweet> tweet = new ArrayList<Tweet>();
		tweetAdapter = new TweetAdapter(getActivity(), tweet);
	}

	public TweetAdapter getTweetAdapter() {
		return tweetAdapter;
	}
}
