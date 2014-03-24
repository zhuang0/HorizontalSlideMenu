package com.slide.menu;

import java.util.ArrayList;

import com.slide.util.SlideMenuUtil;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * ���������˵���������
 * @Description: ���������˵���������

 * @FileName: SlideMenuLayout.java 

 * @Package com.slide.menu 

 * @Author Hanyonglu

 * @Date 2012-4-20 ����11:17:31 

 * @Version V1.0
 */
public class SlideMenuLayout {
	// �����˵���ArrayList
	private ArrayList<TextView> menuList = null;
	
	private Activity activity;
	private TextView textView = null;
	private SlideMenuUtil menuUtil = null;
	
	public SlideMenuLayout(Activity activity){
		this.activity = activity;
		menuList = new ArrayList<TextView>();
		menuUtil = new SlideMenuUtil();
	}
	
	/**
	 * ���������˵�����
	 * @param menuTextViews
	 * @param layoutWidth
	 */
	public View getSlideMenuLinerLayout(String[] menuTextViews,int layoutWidth){
		// ����TextView��LinearLayout
		LinearLayout menuLinerLayout = new LinearLayout(activity);
		menuLinerLayout.setOrientation(LinearLayout.HORIZONTAL);
		
		// ��������
		LinearLayout.LayoutParams menuLinerLayoutParames = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT, 
				LinearLayout.LayoutParams.WRAP_CONTENT,
				1);
		menuLinerLayoutParames.gravity = Gravity.CENTER_HORIZONTAL;
		
		// ���TextView�ؼ�
		for(int i = 0;i < menuTextViews.length; i++){
			TextView tvMenu = new TextView(activity);
			// ���ñ�ʶֵ
			tvMenu.setTag(menuTextViews[i]);
			tvMenu.setLayoutParams(new LayoutParams(layoutWidth / 4,30)); 
			tvMenu.setPadding(30, 14, 30, 10);
			tvMenu.setText(menuTextViews[i]);
			tvMenu.setTextColor(Color.WHITE);
			tvMenu.setGravity(Gravity.CENTER_HORIZONTAL);
			tvMenu.setOnClickListener(SlideMenuOnClickListener);
			
			// �˵������
			menuUtil.count ++;

			// ���õ�һ���˵����
			if(menuUtil.count == 1){
				tvMenu.setBackgroundResource(R.drawable.menu_bg);
			}
			
			menuLinerLayout.addView(tvMenu,menuLinerLayoutParames);
			menuList.add(tvMenu);
		}

		return menuLinerLayout;
	}
	
	// �����˵��¼�
	OnClickListener SlideMenuOnClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String menuTag = v.getTag().toString();
			
			if(v.isClickable()){
				textView = (TextView)v;
				Log.i("SlideMenu", 
						"width��" + textView.getWidth() + 
						"height��" + textView.getHeight());

				textView.setBackgroundResource(R.drawable.menu_bg);
				
				for(int i = 0;i < menuList.size();i++){
					if(!menuTag.equals(menuList.get(i).getText())){
						menuList.get(i).setBackgroundDrawable(null);
					}
				}
				
		        // ����˵�ʱ�ı�����
				slideMenuOnChange(menuTag);
			}
		}
	};
	
	// ���ʱ������
	private void slideMenuOnChange(String menuTag){
		LayoutInflater inflater = activity.getLayoutInflater();
		ViewGroup llc = (ViewGroup)activity.findViewById(R.id.linearLayoutContent);
		llc.removeAllViews();

		if(menuTag.equals(SlideMenuUtil.ITEM_MOBILE)){
			llc.addView(inflater.inflate(R.layout.item_mobile, null));
		}else if(menuTag.equals(SlideMenuUtil.ITEM_WEB)){
			llc.addView(inflater.inflate(R.layout.item_web, null));
		}else if(menuTag.equals(SlideMenuUtil.ITEM_CLOUD)){
			llc.addView(inflater.inflate(R.layout.item_cloud, null));
		}else if(menuTag.equals(SlideMenuUtil.ITEM_DATABASE)){
			llc.addView(inflater.inflate(R.layout.item_database, null));
		}else if(menuTag.equals(SlideMenuUtil.ITEM_EMBED)){
			llc.addView(inflater.inflate(R.layout.item_embed, null));
		}else if(menuTag.equals(SlideMenuUtil.ITEM_SERVER)){
			llc.addView(inflater.inflate(R.layout.item_server, null));
		}else if(menuTag.equals(SlideMenuUtil.ITEM_DOTNET)){
			llc.addView(inflater.inflate(R.layout.item_dotnet, null));
		}else if(menuTag.equals(SlideMenuUtil.ITEM_JAVA)){
			llc.addView(inflater.inflate(R.layout.item_java, null));
		}else if(menuTag.equals(SlideMenuUtil.ITEM_SAFE)){
			llc.addView(inflater.inflate(R.layout.item_safe, null));
		}else if(menuTag.equals(SlideMenuUtil.ITEM_DOMAIN)){
			llc.addView(inflater.inflate(R.layout.item_domain, null));
		}else if(menuTag.equals(SlideMenuUtil.ITEM_RESEASRCH)){
			llc.addView(inflater.inflate(R.layout.item_research, null));
		}else if(menuTag.equals(SlideMenuUtil.ITEM_MANAGE)){
			llc.addView(inflater.inflate(R.layout.item_manage, null));
		}
	}
}