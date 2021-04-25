package ru.nsu.fit.daria.tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static ru.nsu.fit.daria.tetris.Tetris.SIZE;
import static ru.nsu.fit.daria.tetris.Tetris.XMAX;

public class ShapeO extends Shape{
    ShapeO(Rectangle a, Rectangle b, Rectangle c, Rectangle d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.a.setX(XMAX / 2 - SIZE);
        this.b.setX(XMAX / 2);
        this.c.setX(XMAX / 2 - SIZE);
        this.c.setY(SIZE);
        this.d.setX(XMAX / 2);
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
