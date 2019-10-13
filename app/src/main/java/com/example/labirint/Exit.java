package com.example.labirint;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

public class Exit extends Dot {
    public Exit(Point point, int size) {
        super(point, getPaint(), size);
    }

    private static Paint getPaint() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GREEN);
        return paint;
    }
}
