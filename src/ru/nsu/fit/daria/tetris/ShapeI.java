package ru.nsu.fit.daria.tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static ru.nsu.fit.daria.tetris.Controller.SIZE;
import static ru.nsu.fit.daria.tetris.Controller.XMAX;

public class ShapeI extends Shape{
    ShapeI(Rectangle a, Rectangle b, Rectangle c, Rectangle d){
        var shape = new Shape(a, b, c, d);
        shape.a.setX(XMAX / 2 - SIZE - SIZE);
        shape.b.setX(XMAX / 2 - SIZE);
        shape.c.setX(XMAX / 2);
        shape.d.setX(XMAX / 2 + SIZE);
        shape.name = "i";
        shape.color = Color.SANDYBROWN;
    }

    @Override
    public void turn(){
        int f = this.form;
        Rectangle a = this.a;
        Rectangle b = this.b;
        Rectangle c = this.c;
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
