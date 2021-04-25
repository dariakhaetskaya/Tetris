package ru.nsu.fit.daria.tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static ru.nsu.fit.daria.tetris.Tetris.SIZE;
import static ru.nsu.fit.daria.tetris.Tetris.XMAX;

public class ShapeZ extends Shape{
     ShapeZ(){
        this.a = new Rectangle(SIZE - 1, SIZE - 1);
        this.b = new Rectangle(SIZE - 1, SIZE - 1);
        this.c = new Rectangle(SIZE - 1, SIZE - 1);
        this.d = new Rectangle(SIZE - 1, SIZE - 1);
        this.a.setX(XMAX / 2.0 + SIZE);
        this.b.setX(XMAX / 2.0);
        this.c.setX(XMAX / 2.0 + SIZE);
        this.c.setY(SIZE);
        this.d.setX(XMAX / 2.0 + SIZE + SIZE);
        this.d.setY(SIZE);
        this.name = "z";
        this.color = Color.PURPLE;
        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);
    }

    @Override
    public void turn(){
        int f = this.form;
        Rectangle b = this.b;
        Rectangle c = this.c;
        Rectangle d = this.d;

        if (f == 1 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
            moveUp(this.b);
            moveRight(this.b);
            moveLeft(this.c);
            moveUp(this.c);
            moveLeft(this.d);
            moveLeft(this.d);
            this.changeForm();
        }

        if (f == 2 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
            moveDown(this.b);
            moveLeft(this.b);
            moveRight(this.c);
            moveDown(this.c);
            moveRight(this.d);
            moveRight(this.d);
            this.changeForm();
        }

        if (f == 3 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
            moveUp(this.b);
            moveRight(this.b);
            moveLeft(this.c);
            moveUp(this.c);
            moveLeft(this.d);
            moveLeft(this.d);
            this.changeForm();
        }

        if (f == 4 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
            moveDown(this.b);
            moveLeft(this.b);
            moveRight(this.c);
            moveDown(this.c);
            moveRight(this.d);
            moveRight(this.d);
            this.changeForm();
        }
    }
}
