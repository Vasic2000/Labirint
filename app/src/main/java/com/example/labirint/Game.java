package com.example.labirint;

import android.graphics.Canvas;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Game extends GestureDetector.SimpleOnGestureListener {
    private List<Drawable> drawables = new ArrayList<>();
    private View view;
    private Player player;

    public Game() {
        player = new Player();
        drawables.add(player);
        drawables.add(new Labirint());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int difX = 0, difY = 0;
        difX = Math.round(e2.getX() - e1.getX());
        difY = Math.round(e2.getY() - e1.getY());
        player.move(difX, difY);
        view.invalidate();
//        Log.i("GM", String.format("DiffX = %f\n DiffY = %f", difX, difY));
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    public void draw(Canvas canvas) {
        for(Drawable item : drawables) {
            item.draw(canvas);
        }

    }

    public void setView(View view) {
        this.view = view;
    }
}