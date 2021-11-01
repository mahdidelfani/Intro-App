// # Copyright © 2021-2022 Mahdi82Delfani.ir
// # This Project Coded By Mahdi .
// # Url Download Project : [ https://github.com/Mahdi82Delfani/Intro-App.git ]
// # My Website For Reach Me : [ Mahdi82Delfani.ir ]
// # Our Telegram Channel For More Information : [ https://t.me/Mahdi_Memorial ]

package com.mahdi82delfani.intro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.appcompat.R;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class IntroApp extends Activity
{
	
	private ViewPager viewPager;
    private LinearLayout Layout;
    private TextView[] txtViews;
    private int[] layouts;
    private Button btnNext;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        new SystemBarTintManager(this).setStatusBarTintEnabled(false);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
		getWindow().setStatusBarColor(Color.TRANSPARENT);
        viewPager = findViewById(R.id.viewPager);
        Layout = findViewById(R.id.layoutPages);
        btnNext = findViewById(R.id.nextBtn);
        layouts = new int[]{R.layout.page_one,R.layout.page_two,R.layout.page_three,R.layout.page_four};
        navigationDot(0);
        viewPager.setAdapter(new ViewPagerAdapter(IntroApp.this,layouts));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
				@Override
				public void onPageSelected(int i) {
					navigationDot(i);
					if (i == layouts.length-1) 
						btnNext.setText(getString(R.string.go));
					else
						btnNext.setText(getString(R.string.next));
				}
				@Override
				public void onPageScrolled(int arg0, float arg1, int arg2) {
				}
				@Override
				public void onPageScrollStateChanged(int arg0) {
				}
		});
        btnNext.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View view){
					int input = getdata(+1);
					if (input < layouts.length)
						viewPager.setCurrentItem(input);
					else{
						startActivity(new Intent(IntroApp.this,MainActivity.class));
						finish();
					}
				}
			});
    }

    private void navigationDot(int currentPage) {
        txtViews = new TextView[layouts.length];
        int[] colorsActive = getResources().getIntArray(R.array.pager_Active);
        int[] colorsUnactive = getResources().getIntArray(R.array.pager_Unactive);
        Layout.removeAllViews();
        for (int i = 0; i < txtViews.length; i++) {
            txtViews[i] = new TextView(this);
            txtViews[i].setText(Html.fromHtml("&#8226;"));
            txtViews[i].setTextSize(35);
            txtViews[i].setTextColor(colorsActive[currentPage]);
            Layout.addView(txtViews[i]);
        }
        if (txtViews.length > 0)
            txtViews[currentPage].setTextColor(colorsUnactive[currentPage]);
    }

    private int getdata(int i) {
        return viewPager.getCurrentItem()+i;
    }
}
