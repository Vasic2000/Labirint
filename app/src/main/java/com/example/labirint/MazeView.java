package com.example.labirint;


import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class MazeView extends View {
    private Game gameManager;

    public MazeView(Context context, Game gameManager) {
        super(context);
        this.gameManager = gameManager;
        gameManager.setView(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        gameManager.draw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        gameManager.setScreenSize(w, h);
    }
}
