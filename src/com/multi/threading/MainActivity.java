package com.multi.threading;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
public class MainActivity extends Activity {

	TextView tv;
	int ct=100;
	int[] colors={Color.GRAY,Color.RED};
	boolean is_green=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Handler h=new Handler();
        
        
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView1);
        Runnable run=new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(ct!=-1)
				{
					tv.setText(String.valueOf(ct));
					ct=ct-1;
					h.postDelayed(this,1000);
				}
			}
        	
        };
        Runnable colorChanger= new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(is_green){
				tv.setTextColor(Color.RED);
				tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,48);
				is_green=false;
				}else{
					tv.setTextColor(Color.GRAY);
					tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,48);
					is_green=true;
				}
			}
        	
        };
        h.post(run);
        h.post(colorChanger);
}
}