package ru.nsu.fit.daria.tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static ru.nsu.fit.daria.tetris.Tetris.SIZE;
import static ru.nsu.fit.daria.tetris.Tetris.XMAX;

public class ShapeS extends Shape{
    ShapeS(Rectangle a, Rectangle b, Rectangle c, Rectangle d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.a.setX(XMAX / 2 + SIZE);
        this.b.setX(XMAX / 2);
        this.c.setX(XMAX / 2);
        this.c.setY(SIZE);
        this.d.setX(XMAX / 2 - SIZE);
        this.d.setY(SIZE);
        this.name = "s";
        this.color = Color.DARKSEAGREEN;
        a.setFill(color);
        b.setFill(color);
        c.setFill(color);
        d.setFill(color);
    }

    @Override
    public void turn(){
        int f = this.form;
        Rectangle a = this.a;
        Rectangle b = this.b;
        Rectangle c = this.c;
        Rectangle d = this.d;

        if (f == 1 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
            moveDown(this.a);
            moveLeft(this.a);
            moveLeft(this.c);
            moveUp(this.c);
            moveUp(this.d);
            moveUp(this.d);
            this.changeForm();
        }

        if (f == 2 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
            moveUp(this.a);
            moveRight(this.a);
            moveRight(this.c);
            moveDown(this.c);
            moveDown(this.d);
            moveDown(this.d);
            this.changeForm();
        }

        if (f == 3 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
            moveDown(this.a);
            moveLeft(this.a);
            moveLeft(this.c);
            moveUp(this.c);
            moveUp(this.d);
            moveUp(this.d);
            this.changeForm();
        }

        if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
            moveUp(this.a);
            moveRight(this.a);
            moveRight(this.c);
            moveDown(this.c);
            moveDown(this.d);
            moveDown(this.d);
            this.changeForm();
        }
    }
}
