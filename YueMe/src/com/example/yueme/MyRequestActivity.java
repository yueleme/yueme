package com.example.yueme;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MyRequestActivity extends FragmentActivity{
	
	private ArrayList<Fragment> fragments;

	private ViewPager viewPager;

	private TextView tab_put;//������

	private TextView tab_get;//������

	private View tab_line;//�л�ֱ��
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_my_request);
	        initView();
	    }
	 
	
	 private void initView(){
		 tab_put = (TextView) findViewById(R.id.tab_put);
		 tab_put = (TextView) findViewById(R.id.tab_get);
		 tab_line = findViewById(R.id.tab_line);
		 
		 fragments = new ArrayList<Fragment>();
		 fragments.add(new PutRequestFragment());
		 fragments.add(new GetRequestFragment());
		 
		 tab_line.getLayoutParams().width = getWindowManager().getDefaultDisplay().getWidth()
					/ fragments.size();
		 tab_line.requestLayout();
		 
		 viewPager = (ViewPager) findViewById(R.id.viewPager);
		 viewPager.setAdapter(new FragmentStatePagerAdapter(
					getSupportFragmentManager()) {

				@Override
				public int getCount() {
					return fragments.size();
				}

				@Override
				public Fragment getItem(int arg0) {
					return fragments.get(arg0);
				}
			});
		 viewPager.setOnPageChangeListener(new OnPageChangeListener() {

				@Override
				public void onPageSelected(int arg0) {
					changeState(arg0);
				}

				@Override
				public void onPageScrolled(int arg0, float arg1, int arg2) {
//					int line_width= getWindowManager().getDefaultDisplay().getWidth()
//							/ fragments.size();
//					float tagerX = arg0 * line_width + arg2 / fragments.size();
//					ViewPropertyAnimator.animate(tab_line).translationX(tagerX)
//							.setDuration(0);
				}

				@Override
				public void onPageScrollStateChanged(int arg0) {

				}
			});
		 
		 tab_put.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					viewPager.setCurrentItem(0);
				}
			});
		 
		 tab_get.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					viewPager.setCurrentItem(1);
				}
			});
	 }
	 
	 /* ���ݴ����ֵ���ı�״̬ */
		private void changeState(int arg0) {
			if (arg0 == 0) {
				tab_put.setTextColor(getResources().getColor(R.color.blue));
				tab_get.setTextColor(getResources().getColor(R.color.black));
//				ViewPropertyAnimator.scaleX(1.2f).setDuration(200);
//				ViewPropertyAnimator.animate(tab_app).scaleY(1.2f).setDuration(200);
//				ViewPropertyAnimator.animate(tab_game).scaleX(1.0f)
//						.setDuration(200);
//				ViewPropertyAnimator.animate(tab_game).scaleY(1.0f)
//						.setDuration(200);

			} else {
				tab_get.setTextColor(getResources().getColor(R.color.blue));
				tab_put.setTextColor(getResources().getColor(R.color.black));
//				ViewPropertyAnimator.animate(tab_app).scaleX(1.0f).setDuration(200);
//				ViewPropertyAnimator.animate(tab_app).scaleY(1.0f).setDuration(200);
//				ViewPropertyAnimator.animate(tab_game).scaleX(1.2f)
//						.setDuration(200);
//				ViewPropertyAnimator.animate(tab_game).scaleY(1.2f)
//						.setDuration(200);
			}
		}

}