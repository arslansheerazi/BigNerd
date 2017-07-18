package com.example.arsalanhaider.bignerd.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Arsalan Haider on 7/6/2017.
 */

public class CurvedBar extends View {

    Paint visiblePaint;
    Path path;

    public CurvedBar(Context context) {
        super(context);
        init();
    }//end of constructor

    public CurvedBar(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }//end of constructor

    public CurvedBar(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }//end of constructor

    private void init() {
        visiblePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        visiblePaint.setColor(Color.BLUE); //Set your own color
        visiblePaint.setStyle(Paint.Style.FILL);
    }//end of init

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        path = new Path();
        path.moveTo(w, 0);
        path.lineTo(w, h);
        path.lineTo(0,h);
        path.lineTo(0, 0);
        path.quadTo(w/2, h/2, w, 0); //change the 2nd param to adjust the depth of the curve
        path.close();
    }//end of on size chnage

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        super.onDraw(canvas);
        canvas.drawPath(path, visiblePaint);
    }
}
