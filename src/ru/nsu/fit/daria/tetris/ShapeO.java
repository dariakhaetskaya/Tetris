package ru.nsu.fit.daria.tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static ru.nsu.fit.daria.tetris.Tetris.SIZE;
import static ru.nsu.fit.daria.tetris.Tetris.XMAX;

public class ShapeO extends Shape{
    ShapeO(){
        this.a = new Rectangle(SIZE - 1, SIZE - 1);
        this.b = new Rectangle(SIZE - 1, SIZE - 1);
        this.c = new Rectangle(SIZE - 1, SIZE - 1);
        this.d = new Rectangle(SIZE - 1, SIZE - 1);
        this.a.setX(XMAX / 2.0 - SIZE);
        this.b.setX(XMAX / 2.0);
        this.c.setX(XMAX / 2.0 - SIZE);
        this.c.setY(SIZE);
        this.d.setX(XMAX / 2.0);
        this.d.setY(SIZE);
        this.name = "o";
        this.color = Color.INDIANRED;
        a.setFill(color);
        b.setFill(color);
        c.setFill(color);
        d.setFill(color);
    }
    @Override
    public void turn(){
    }
}
