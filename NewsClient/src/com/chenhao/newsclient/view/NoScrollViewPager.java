package com.chenhao.newsclient.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NoScrollViewPager extends LazyViewPager {

	public NoScrollViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public NoScrollViewPager(Context context) {
		super(context);
	}
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		return false;
	}
}
