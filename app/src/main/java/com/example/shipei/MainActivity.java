package com.example.shipei;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    /**
     * Hello World!
     */
    private Button mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTv = (Button) findViewById(R.id.tv);
        mTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv:
                //获取屏幕最小宽度
                DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);
                //dmDisplayMetrics{density=1.5, width=720, height=1280, scaledDensity=1.5, xdpi=72.0, ydpi=72.0}
                //手机：dmDisplayMetrics{density=3.0, width=10809, height=1920, scaledDensity=3.0, xdpi=370.702, ydpi=369.454}
                Log.d(TAG, "dm"+dm.toString());

                int widthPixels = dm.widthPixels;//屏幕宽度
                int heightPixels = dm.heightPixels;//屏幕高度
                int densityDpi = dm.densityDpi;//屏幕密度pdi
                float density = dm.density;//屏幕的密度
                //屏幕宽度算法: 屏幕宽度（像素）/屏幕密度
                float widthDP = widthPixels / density;//屏幕宽度（dp）
                float heightDP = heightPixels / density;//屏幕高度(dp)
                Log.d(TAG, "widthDP: "+widthDP);
                //widthDP: 480.0
                //手机:widthDP: 360.0
                Log.d(TAG, "heightDP: "+heightDP);
                //heightDP: 853.3333
                //手机:heightDP: 640.0
                break;

        }

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
