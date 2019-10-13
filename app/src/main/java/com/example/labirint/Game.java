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
    private Exit exit;
    private Player player;
    private Labirint labirint;

    private Rect rect = new Rect();

    private int screenSize = 7;

    public Game() {
        create(screenSize);
    }

    private void create(int screenSize) {
        drawables.clear();
        labirint = new Labirint(screenSize);
        player = new Player(labirint.getStart(), screenSize);
        exit = new Exit(labirint.getEnd(), screenSize);

        drawables.add(labirint);
        drawables.add(player);
        drawables.add(exit);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int difX = 0, difY = 0;
        difX = Math.round(e2.getX() - e1.getX());
        difY = Math.round(e2.getY() - e1.getY());

        if (Math.abs(difX) > Math.abs(difY)) {
            difX = difX > 0 ? 1 : -1;
            difY = 0;
        } else {
            difX = 0;
            difY = difY > 0 ? 1 : -1;
        }

        int stepX = player.getX();
        int stepY = player.getY();

        while(labirint.canPlayerGoTo(stepX + difX, stepY + difY)) {
            stepX += difX;
            stepY += difY;
            if (difX != 0) {
                if(labirint.canPlayerGoTo(stepX, stepY + 1)
                        || labirint.canPlayerGoTo(stepX, stepY - 1)) {
                    break;
                }
            }
            if (difY != 0) {
                if(labirint.canPlayerGoTo(stepX + 1, stepY)
                        || labirint.canPlayerGoTo(stepX - 1, stepY)) {
                    break;
                }
            }
        }
        player.goTo(stepX, stepY);

        if(exit.getPoint().equals(player.getPoint())) {
            create(labirint.getSize() + 2);
        }

        view.invalidate();
        return super.onFling(e1, e2, velocityX, velocityY);

    }

    public void draw(Canvas canvas) {
        for (Drawable item : drawables) {
            item.draw(canvas, rect);
            }
        }

        public void setView (View view){
            this.view = view;
        }

        public void setScreenSize ( int width, int height){
            screenSize = Math.min(width, height);
            rect.set(
                    (width - screenSize) / 2,
                    (height - screenSize) / 2,
                    (width + screenSize) / 2,
                    (height + screenSize) / 2
            );
        }
    }
