package com.example.labirint;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Labirint implements Drawable {

    private Paint paint;
    private boolean [][] arrayMaze;
    private final int size;
    private final Point end = new Point(1,1);

    public Labirint(int size) {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        this.size = size;
        arrayMaze = new boolean[size][size];
    }

    private void generateMaze() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                arrayMaze[i][j] = i%2 != 0 && j%2 != 0
                        && i < size-1 && j < size-1;
            }
        }
        Random random = new Random();
        Stack<Point> stack = new Stack<>();
        stack.push(end);

        while(stack.size() > 0) {
            Point current = stack.peek();
            List<Point> unusedNeighbors = new LinkedList<>();
            //left
            if (current.x > 2) {
                if (!isUsedCall(current.x - 2, current.y)) {
                    unusedNeighbors.add(new Point(current.x - 2, current.y));
                }
            }

            //top
            if (current.y > 2) {
                if (!isUsedCall(current.x, current.y - 2)) {
                    unusedNeighbors.add(new Point(current.x, current.y - 2));
                }
            }

            //right
            if (current.x < size - 2) {
                if (!isUsedCall(current.x + 2, current.y)) {
                    unusedNeighbors.add(new Point(current.x + 2, current.y));
                }
            }

            //bottom
            if (current.y  < size - 2) {
                if (!isUsedCall(current.x, current.y + 2)) {
                    unusedNeighbors.add(new Point(current.x, current.y + 2));
                }
            }
            if(unusedNeighbors.size() > 0) {
                int rnd = random.nextInt(unusedNeighbors.size());
                Point direction = unusedNeighbors.get(rnd);
                int diffX = (direction.x - current.x) / 2;
                int diffY = (direction.y - current.y) / 2;
                arrayMaze[current.y + diffY][current.x + diffX] = true;
            }
            else
        }


    }

    private boolean isUsedCall(int x, int y) {
        if (x < 0 || y < 0 || y >= size -1 || y >= size-1) {
            return true;
        }
        return  arrayMaze[y-1][x] //left
        || arrayMaze[y][x-1] //top
        || arrayMaze[y+1][x] //right
        || arrayMaze[y][x+1]; //bottom
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(100,100,50,paint);
    }
}
