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
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_tweet_list, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ArrayList<Tweet> tweet = new ArrayList<Tweet>();
		ListView lvTweet = (ListView) getActivity().findViewById(R.id.lvTweet);
		tweetAdapter = new TweetAdapter(getActivity(), tweet);
		lvTweet.setAdapter(tweetAdapter);
	}

	public TweetAdapter getTweetAdapter() {
		return tweetAdapter;
	}
}
