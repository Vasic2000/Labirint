package com.example.labirint;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Player implements Drawable {

    private Paint paint;

    private Point point;

    public Player() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.MAGENTA);
        point = new Point(0,0);
    }

    public  void move(int diffX, int diffY) {
        point.x += diffX;
        point.y += diffY;
    }

    @Override
    public void draw(Canvas canvas, Rect rect) {
        canvas.drawRect(point.x, point.y,point.x + 50,point.y + 50, paint);
    }
}
