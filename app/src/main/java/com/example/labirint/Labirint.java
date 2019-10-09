package com.example.labirint;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Labirint implements Drawable {

    private Paint paint;

    public Labirint() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(100,100,50,paint);
    }
}
