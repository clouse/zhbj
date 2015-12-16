package com.chenhao.newsclient.activity;

import com.chenhao.newsclient.R;
import com.chenhao.newsclient.utils.CacheUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class SplashUI extends Activity implements OnClickListener {
	@ViewInject(R.id.vp_splash)
	ViewPager vpSplash;

	private int[] imgRes = { R.drawable.guide_1, R.drawable.guide_2,
			R.drawable.guide_3 };
	private SplashAdapter splashAdapter;
	@ViewInject(R.id.ll_splash_point_container)
	private LinearLayout llPointContainer;
	@ViewInject(R.id.view_point_selected)
	private View mPointSelected;
	private int mPointSpace;
	@ViewInject(R.id.btn_splash_explore)
	private Button btnExplore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		ViewUtils.inject(this);
		initData();
	}

	private void initData() {
		mPointSelected.getViewTreeObserver().addOnGlobalLayoutListener(
				new OnGlobalLayoutListener() {
					@Override
					public void onGlobalLayout() {
						mPointSpace = llPointContainer.getChildAt(1).getLeft()
								- llPointContainer.getChildAt(0).getLeft();
						mPointSelected.getViewTreeObserver()
								.removeGlobalOnLayoutListener(this);
					}
				});
		splashAdapter = new SplashAdapter();
		vpSplash.setAdapter(splashAdapter);
		vpSplash.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				btnExplore
						.setVisibility(position == imgRes.length - 1 ? View.VISIBLE
								: View.INVISIBLE);
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				int left =(int) ((position+positionOffset) * mPointSpace + 0.5f);
				RelativeLayout.LayoutParams params = (LayoutParams) mPointSelected.getLayoutParams();
				params.leftMargin = left;
				mPointSelected.setLayoutParams(params);
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
		btnExplore.setOnClickListener(this);
	}

	class SplashAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			if (imgRes != null) {
				return imgRes.length;
			}
			return 0;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView iv = (ImageView) View.inflate(SplashUI.this,
					R.layout.item_vp_splash, null);
			iv.setBackgroundResource(imgRes[position]);
			container.addView(iv);
			return iv;
		}
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.btn_splash_explore){
			CacheUtils.putBoolean(SplashUI.this, WelcomeUI.IS_FIRST_OPEN, false);
			Intent intent = new Intent(SplashUI.this, MainUI.class);
			startActivity(intent);
			finish();
		}
	}
}
