package com.chenhao.newsclient.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class CacheUtils {
	
	private static final String SHAREDPREFERENCES_NAME = "NewsClientSharedPreference";
	public static boolean getBoolean(Context context,String key){
		SharedPreferences sp = context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
		return sp.getBoolean(key, false);
	}
	public static boolean getBoolean(Context context,String key,boolean defValue){
		SharedPreferences sp = context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
		return sp.getBoolean(key, defValue);
	}
	public static void putBoolean(Context context,String key,boolean value){
		SharedPreferences sp = context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}
}
