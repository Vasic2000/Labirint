package com.example.labirint;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Player implements Drawable {

    private Paint paint;
    private Point point;
    private int size;

    public Player(Point start, int size) {
        this.size = size;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.MAGENTA);
        point = start;
    }

    public  void move(int diffX, int diffY) {
        point.x += diffX;
        point.y += diffY;
    }

    public int getX() {
        return point.x;
    }

    public int getY() {
        return point.y;
    }

    @Override
    public void draw(Canvas canvas, Rect rect) {
        float cellSize = (float) (rect.right - rect.left) / size;
        canvas.drawRect(
                rect.left + point.x * cellSize,
                rect.top + point.y * cellSize,
                rect.left + point.x * cellSize + cellSize,
                rect.top + point.y * cellSize + cellSize,
                paint);
    }
}
