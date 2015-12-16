package com.chenhao.newsclient.fragment;

import java.util.ArrayList;
import java.util.List;

import com.chenhao.newsclient.R;
import com.chenhao.newsclient.controller.TabController;
import com.chenhao.newsclient.controller.tab.GovController;
import com.chenhao.newsclient.controller.tab.HomeController;
import com.chenhao.newsclient.controller.tab.NewsCenterController;
import com.chenhao.newsclient.controller.tab.SettingController;
import com.chenhao.newsclient.controller.tab.SmartServiceController;
import com.chenhao.newsclient.view.LazyViewPager;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainFragment extends BaseFragment implements OnCheckedChangeListener {
	@ViewInject(R.id.rg_main_content)
	private RadioGroup rgMainUI;
	@ViewInject(R.id.vp_main_content)
	private LazyViewPager vpContent;
	private ContentPagerAdapter contentPagerAdapter;
	private List<TabController> controllers = new ArrayList<TabController>();

	@Override
	protected View initView() {
		View mRootView = View.inflate(mActivity, R.layout.content_main, null);
		ViewUtils.inject(this, mRootView);
		return mRootView;
	}

	@Override
	protected void initData() {
		super.initData();
		controllers.add(new HomeController(mActivity));
		controllers.add(new NewsCenterController(mActivity));
		controllers.add(new SmartServiceController(mActivity));
		controllers.add(new GovController(mActivity));
		controllers.add(new SettingController(mActivity));
		rgMainUI.check(R.id.rbtn_home);
		rgMainUI.setOnCheckedChangeListener(this);
		contentPagerAdapter = new ContentPagerAdapter();
		vpContent.setAdapter(contentPagerAdapter);
	}

	class ContentPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			if (controllers != null) {
				return controllers.size();
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
			TabController tabController = controllers.get(position);
			View controllerRootView = tabController.initView();
			tabController.initData();
			container.addView(controllerRootView);
			return controllerRootView;
		}

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		int currentItemViewpager = -1;
		switch (checkedId) {
		case R.id.rbtn_home:
			currentItemViewpager = 0;
			break;
		case R.id.rbtn_newscenter:
			currentItemViewpager = 1;
			break;
		case R.id.rbtn_service:
			currentItemViewpager = 2;
			break;
		case R.id.rbtn_gov:
			currentItemViewpager = 3;
			break;
		case R.id.rbtn_setting:
			currentItemViewpager = 4;
			break;

		default:
			break;
		}
		vpContent.setCurrentItem(currentItemViewpager);
	}
}
