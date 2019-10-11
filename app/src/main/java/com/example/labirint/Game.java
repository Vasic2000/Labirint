package com.example.labirint;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Game extends GestureDetector.SimpleOnGestureListener {
    private List<Drawable> drawables = new ArrayList<>();
    private View view;
    private Player player;
    private Labirint labirint;

    private Rect rect = new Rect();
    private int size = 15;

    public Game() {
        labirint = new Labirint(size);
        player = new Player(labirint.getStart(), size);

        drawables.add(player);
        drawables.add(labirint);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int difX = 0, difY = 0;
        difX = Math.round(e2.getX() - e1.getX());
        difY = Math.round(e2.getY() - e1.getY());

        if(Math.abs(difX) > Math.abs(difY)) {
            difX  = difX > 0 ? 1 : -1;
            difY =0;
        } else {
            difX  = 0;
            difY = difY > 0 ? 1 : -1;;
        }

        if (labirint.canPlayerGoTo(
                player.getX() + difX,
                player.getY() + difY
        )) {
             player.move(difX, difY);
            view.invalidate();
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    public void draw(Canvas canvas) {
        for(Drawable item : drawables) {
            item.draw(canvas, rect);
        }

    }

    public void setView(View view) {
        this.view = view;
    }

    public void setScreenSize(int width, int height) {
        size = Math.min(width, height);
        rect.set(
                (width - size)/ 2,
                (height - size)/ 2,
                (width + size)/ 2,
                (height + size)/ 2
        );
    }
}
