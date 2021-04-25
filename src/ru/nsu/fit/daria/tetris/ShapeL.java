package ru.nsu.fit.daria.tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static ru.nsu.fit.daria.tetris.Tetris.SIZE;
import static ru.nsu.fit.daria.tetris.Tetris.XMAX;

public class ShapeL extends Shape{
    ShapeL(){
        this.a = new Rectangle(SIZE - 1, SIZE - 1);
        this.b = new Rectangle(SIZE - 1, SIZE - 1);
        this.c = new Rectangle(SIZE - 1, SIZE - 1);
        this.d = new Rectangle(SIZE - 1, SIZE - 1);
        this.a.setX(XMAX / 2.0 + SIZE);
        this.b.setX(XMAX / 2.0 - SIZE);
        this.b.setY(SIZE);
        this.c.setX(XMAX / 2.0);
        this.c.setY(SIZE);
        this.d.setX(XMAX / 2.0 + SIZE);
        this.d.setY(SIZE);
        this.name = "l";
        this.color = Color.DARKGOLDENROD;
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

        if (f == 1 && cB(a, 1, -1) && cB(c, 1, 1) && cB(b, 2, 2)) {
            moveRight(this.a);
            moveDown(this.a);
            moveUp(this.c);
            moveRight(this.c);
            moveUp(this.b);
            moveUp(this.b);
            moveRight(this.b);
            moveRight(this.b);
            this.changeForm();
        }

        if (f == 2 && cB(a, -1, -1) && cB(b, 2, -2) && cB(c, 1, -1)) {
            moveDown(this.a);
            moveLeft(this.a);
            moveRight(this.b);
            moveRight(this.b);
            moveDown(this.b);
            moveDown(this.b);
            moveRight(this.c);
            moveDown(this.c);
            this.changeForm();
        }

        if (f == 3 && cB(a, -1, 1) && cB(c, -1, -1) && cB(b, -2, -2)) {
            moveLeft(this.a);
            moveUp(this.a);
            moveDown(this.c);
            moveLeft(this.c);
            moveDown(this.b);
            moveDown(this.b);
            moveLeft(this.b);
            moveLeft(this.b);
            this.changeForm();
        }

        if (f == 4 && cB(a, 1, 1) && cB(b, -2, 2) && cB(c, -1, 1)) {
            moveUp(this.a);
            moveRight(this.a);
            moveLeft(this.b);
            moveLeft(this.b);
            moveUp(this.b);
            moveUp(this.b);
            moveLeft(this.c);
            moveUp(this.c);
            this.changeForm();
        }
    }
}
