package com.example.slidingmenutemplate;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends FragmentActivity {

	private SlidingMenu mSlidingMenuLeft;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		initActionBarAndSlidingMenu();
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void initActionBarAndSlidingMenu() {
		getActionBar().setHomeButtonEnabled(true);

		mSlidingMenuLeft = new SlidingMenu(this);
		mSlidingMenuLeft.setMode(SlidingMenu.LEFT_RIGHT);
		mSlidingMenuLeft.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		mSlidingMenuLeft.setShadowWidthRes(R.dimen.shadow_width);
		mSlidingMenuLeft.setShadowDrawable(R.drawable.shadow);
		mSlidingMenuLeft.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		mSlidingMenuLeft.setFadeDegree(0.35f);
		mSlidingMenuLeft.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		mSlidingMenuLeft.setMenu(R.layout.menu_frame_one);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame_one, new SampleListFragment())
				.commit();

		mSlidingMenuLeft.setSecondaryMenu(R.layout.menu_frame_two);

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame_two, new SampleListFragment())
				.commit();
		mSlidingMenuLeft.setSecondaryShadowDrawable(R.drawable.shadow);
		
		
	}

	@Override
	public void onBackPressed() {
		if (mSlidingMenuLeft.isMenuShowing()) {
			mSlidingMenuLeft.showContent();
		} else {
			super.onBackPressed();
		}
	}

}
