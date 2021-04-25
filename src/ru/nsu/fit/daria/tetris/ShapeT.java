package ru.nsu.fit.daria.tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static ru.nsu.fit.daria.tetris.Tetris.SIZE;
import static ru.nsu.fit.daria.tetris.Tetris.XMAX;

public class ShapeT extends Shape{
    ShapeT(Rectangle a, Rectangle b, Rectangle c, Rectangle d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.a.setX(XMAX / 2 - SIZE);
        this.b.setX(XMAX / 2);
        this.c.setX(XMAX / 2);
        this.c.setY(SIZE);
        this.d.setX(XMAX / 2 + SIZE);
        this.name = "t";
        this.color = Color.CADETBLUE;
        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);
    }

    @Override
    public void turn(){
        int f = this.form;
        Rectangle a = this.a;
        Rectangle b = this.b;
        Rectangle c = this.c;
        Rectangle d = this.d;

        if (f == 1 && cB(a, 1, 1) && cB(d, -1, -1) && cB(c, -1, 1)) {
            moveUp(this.a);
            moveRight(this.a);
            moveDown(this.d);
            moveLeft(this.d);
            moveLeft(this.c);
            moveUp(this.c);
            this.changeForm();
        }

        if (f == 2 && cB(a, 1, -1) && cB(d, -1, 1) && cB(c, 1, 1)) {
            moveRight(this.a);
            moveDown(this.a);
            moveLeft(this.d);
            moveUp(this.d);
            moveUp(this.c);
            moveRight(this.c);
            this.changeForm();
        }

        if (f == 3 && cB(a, -1, -1) && cB(d, 1, 1) && cB(c, 1, -1)) {
            moveDown(this.a);
            moveLeft(this.a);
            moveUp(this.d);
            moveRight(this.d);
            moveRight(this.c);
            moveDown(this.c);
            this.changeForm();
        }

        if (f == 4 && cB(a, -1, 1) && cB(d, 1, -1) && cB(c, -1, -1)) {
            moveLeft(this.a);
            moveUp(this.a);
            moveRight(this.d);
            moveDown(this.d);
            moveDown(this.c);
            moveLeft(this.c);
            this.changeForm();
        }
    }
}
