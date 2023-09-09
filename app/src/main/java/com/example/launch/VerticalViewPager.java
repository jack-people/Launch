package com.example.launch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class VerticalViewPager extends ViewPager {
    private float initialX;
    private float initialY;
    private boolean isHorizontalScrollEnabled = true;
    private final int minScrollX = 200; // 最小滑动范围
    private final int maxScrollX = 620; // 最大滑动范围

    public VerticalViewPager(Context context) {
        super(context);
        init();
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        // 设置页面切换动画为水平方向
        setPageTransformer(true, new HorizontalPageTransformer());
        // 设置滑动方向为水平方向
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isHorizontalScrollEnabled) {
            return super.onTouchEvent(event);
        }

        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialX = x;
                initialY = y;
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                float deltaX = x - initialX;
                float deltaY = y - initialY;
                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    // 水平滑动
                    if (getCurrentItem() == 0 && deltaX > 0) {
                        // 第一页，向左滑动
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else if (getCurrentItem() == getAdapter().getCount() - 1 && deltaX < 0) {
                        // 最后一页，向右滑动
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        // 在滑动范围内，水平滑动
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                } else {
                    // 竖直滑动
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
        }

        return super.onTouchEvent(event);
    }

    public void setHorizontalScrollEnabled(boolean horizontalScrollEnabled) {
        isHorizontalScrollEnabled = horizontalScrollEnabled;
    }

    private class HorizontalPageTransformer implements ViewPager.PageTransformer {
        @Override
        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) {
                view.setAlpha(0);
            } else if (position <= 1) {
                view.setAlpha(1);

                // 设置页面的水平偏移量
                view.setTranslationX(pageWidth * -position);

                // 设置页面的缩放比例
                float scaleFactor = Math.max(0.85f, 1 - Math.abs(position) / 4);
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);
            } else {
                view.setAlpha(0);
            }
        }
    }
}