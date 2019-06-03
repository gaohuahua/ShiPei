package com.example.shipei_dome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shipei_dome.utils.ConvertUtils;
import com.example.shipei_dome.utils.ScreenUtils;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = "MainActivity";

    private TextView mTvShowParams;
    private float smallestWidthDP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvShowParams = (TextView)findViewById(R.id.tv_show_params);
        mTvShowParams.setText(getScreenParams());
    }
    /**
     * 获取屏幕相关参数按钮点击事件
     * @param view
     */
    public void getScreenParams(View view) {
        mTvShowParams.setText(getScreenParams());
        dynamicSet();
    }

    /**
     * 获取屏幕相关参数
     *
     * @return
     */
    public String getScreenParams(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int HeightPixels = ScreenUtils.getScreenHeight(this);
        int widthPixels = ScreenUtils.getScreenWidth(this);
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;
        int densityDpi = dm.densityDpi;
        float density = dm.density;
        float scaledDensity = dm.scaledDensity;
        float heightDP = HeightPixels / density;
        float widthDP = widthPixels / density;
       if (widthDP<heightDP){
           smallestWidthDP = widthDP;
       }else{
           smallestWidthDP=heightDP;
       }
       String str="HeightPixels:"+HeightPixels+"px";
       str+="\nwidthPixels:"+widthPixels+"px";
        str += "\nxdpi: " + xdpi + "dpi";
        str += "\nydpi: " + ydpi + "dpi";
        str += "\ndensityDpi: " + densityDpi + "dpi";
        str += "\ndensity: " + density;
        str += "\nscaledDensity: " + scaledDensity;
        str += "\nheightDP: " + heightDP + "dp";
        str += "\nwidthDP: " + widthDP + "dp";
        str += "\nsmallestWidthDP: " + smallestWidthDP + "dp";
        return str;
    }

    /**
     * 动态设置dp或sp
     */
    private void dynamicSet() {

        /**
         * 注意：
         * getDimension()方法并不是直接拿到dimens.xml文件中的dp或sp值
         * 而是將dimens.xml文件中的dp或sp值乘以屏幕密度（density）来换算成px值
         * 所以拿到该值后还需要换算成对应的dp或sp
         */

        /*获取sp值*/
        float pxValue = getResources().getDimension(R.dimen.sp_20);//获取对应资源文件下的sp值
        int spValue = ConvertUtils.px2sp(this, pxValue);//将px值转换成sp值
        mTvShowParams.setTextSize(spValue);//设置文字大小

        /*获取dp值*/
        float pxValue2 = getResources().getDimension(R.dimen.dp_360);//获取对应资源文件下的dp值
        int dpValue = ConvertUtils.px2dp(this, pxValue2);//将px值转换成dp值

        Log.d(TAG, "pxValue= " + pxValue);
        Log.d(TAG, "spValue= " + spValue);
        Log.d(TAG, "pxValue2= " + pxValue2);
        Log.d(TAG, "dpValue= " + dpValue);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: "+outState);
        //onSaveInstanceState: Bundle[{android:viewHierarchyState=Bundle[{android:views={16908290=android.view.AbsSavedState$1@5e4ede8, 2131165190=android.support.v7.widget.Toolbar$SavedState@c662c01, 2131165192=android.view.AbsSavedState$1@5e4ede8, 2131165198=android.view.AbsSavedState$1@5e4ede8, 2131165231=android.view.AbsSavedState$1@5e4ede8, 2131165321=android.view.AbsSavedState$1@5e4ede8}}], android:fragments=android.app.FragmentManagerState@2af3aa6}]
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d(TAG, "onWindowFocusChanged: "+hasFocus);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent: "+intent);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d(TAG, "onLowMemory: ");
    }

}
