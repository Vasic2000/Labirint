package com.example.labirint;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Dot implements Drawable {
    protected Paint paint;

    public Point getPoint() {
        return point;
    }

    protected Point point;
    private int size;

    public Dot(Point point, Paint paint, int size) {
        this.size = size;
        this.point = point;
        this.paint = paint;
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
