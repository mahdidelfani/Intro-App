// # Copyright © 2021-2022 Mahdi82Delfani.ir
// # This Project Coded By Mahdi .
// # Url Download Project : [ https://github.com/Mahdi82Delfani/Intro-App.git ]
// # My Website For Reach Me : [ Mahdi82Delfani.ir ]
// # Our Telegram Channel For More Information : [ https://t.me/Mahdi_Memorial ]

package com.mahdi82delfani.intro;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public class ViewPagerAdapter extends PagerAdapter {
	
	private LayoutInflater layoutInflater;
	Context context;
	int[] layouts;
	
	public ViewPagerAdapter(Context context , int[] layout) {
		this.context = context;
		this.layouts = layout;
	}

	@Override
	public Object instantiateItem(ViewGroup vg, int i) {
		layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = layoutInflater.inflate(layouts[i], vg, false);
		vg.addView(view);
		return view;
	}

	@Override
	public int getCount() {
		return layouts.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object obj) {
		return view == obj;
	}


	@Override
	public void destroyItem(ViewGroup vg, int i, Object o) {
		View view = (View) o;
		vg.removeView(view);
	}
}
