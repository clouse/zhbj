package com.chenhao.newsclient.activity;

import com.chenhao.newsclient.R;
import com.chenhao.newsclient.R.layout;
import com.chenhao.newsclient.utils.CacheUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

public class WelcomeUI extends Activity {
	@ViewInject(R.id.rl_welcome_rootview)
	private RelativeLayout mRootView;
	private static final long ANIMATION_DURATION = 3000;
	public static final String IS_FIRST_OPEN = "first_open_app";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		ViewUtils.inject(this);
		initData();
	}

	private void initData() {
		RotateAnimation ra = new RotateAnimation(0, 360,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		ScaleAnimation sa = new ScaleAnimation(0f, 1.0f, 0f, 1.0f,
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
		AlphaAnimation aa = new AlphaAnimation(0, 1.0f);
		AnimationSet set = new AnimationSet(true);
		set.setDuration(ANIMATION_DURATION);
		set.setFillAfter(true);
		set.addAnimation(ra);
		set.addAnimation(sa);
		set.addAnimation(aa);
		set.setInterpolator(new BounceInterpolator());
		mRootView.startAnimation(set);
		set.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation animation) {
				Intent intent = new Intent(WelcomeUI.this,
						CacheUtils.getBoolean(WelcomeUI.this, IS_FIRST_OPEN,
								true) ? SplashUI.class : MainUI.class);
				startActivity(intent);
				finish();
			}

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});

	}
}
