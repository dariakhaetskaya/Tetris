package ru.nsu.fit.daria.tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static ru.nsu.fit.daria.tetris.Tetris.SIZE;
import static ru.nsu.fit.daria.tetris.Tetris.XMAX;

public class ShapeI extends Shape{
    ShapeI(){
        this.a = new Rectangle(Tetris.SIZE - 1, Tetris.SIZE - 1);
        this.b = new Rectangle(Tetris.SIZE - 1, Tetris.SIZE - 1);
        this.c = new Rectangle(Tetris.SIZE - 1, Tetris.SIZE - 1);
        this.d = new Rectangle(Tetris.SIZE - 1, Tetris.SIZE - 1);
        this.a.setX(XMAX / 2.0 - SIZE - SIZE);
        this.b.setX(XMAX / 2.0 - SIZE);
        this.c.setX(XMAX / 2.0);
        this.d.setX(XMAX / 2.0 + SIZE);
        this.name = "i";
        this.color = Color.SANDYBROWN;
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
        Rectangle d = this.d;

        if (f == 1 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
            moveUp(this.a);
            moveUp(this.a);
            moveRight(this.a);
            moveRight(this.a);
            moveUp(this.b);
            moveRight(this.b);
            moveDown(this.d);
            moveLeft(this.d);
            this.changeForm();
        }

        if (f == 2 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
            moveDown(this.a);
            moveDown(this.a);
            moveLeft(this.a);
            moveLeft(this.a);
            moveDown(this.b);
            moveLeft(this.b);
            moveUp(this.d);
            moveRight(this.d);
            this.changeForm();
        }

        if (f == 3 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
            moveUp(this.a);
            moveUp(this.a);
            moveRight(this.a);
            moveRight(this.a);
            moveUp(this.b);
            moveRight(this.b);
            moveDown(this.d);
            moveLeft(this.d);
            this.changeForm();
        }

        if (f == 4 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
            moveDown(this.a);
            moveDown(this.a);
            moveLeft(this.a);
            moveLeft(this.a);
            moveDown(this.b);
            moveLeft(this.b);
            moveUp(this.d);
            moveRight(this.d);
            this.changeForm();
        }
    }
}
