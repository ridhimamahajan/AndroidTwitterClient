package com.apps.androidtwitterapp.models;
import org.json.JSONException;
import org.json.JSONObject;

	public class BaseModel {
	    protected JSONObject jsonObject;

	    public String getJSONString() {
	        return jsonObject.toString();
	    }

	    public String getString(String name) {
	        try {
	            return jsonObject.getString(name);
	        } catch (JSONException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    public long getLong(String name) {
	        try {
	            return jsonObject.getLong(name);
	        } catch (JSONException e) {
	            e.printStackTrace();
	            return 0;
	        }
	    }

	    public int getInt(String name) {
	        try {
	            return jsonObject.getInt(name);
	        } catch (JSONException e) {
	            e.printStackTrace();
	            return 0;
	        }
	    }

	    public double getDouble(String name) {
	        try {
	            return jsonObject.getDouble(name);
	        } catch (JSONException e) {
	            e.printStackTrace();
	            return 0;
	        }
	    }

	    public boolean getBoolean(String name) {
	        try {
	            return jsonObject.getBoolean(name);
	        } catch (JSONException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	}


