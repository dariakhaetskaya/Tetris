package ru.nsu.fit.daria.tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Form {
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;

    Color color;
    private String name;
    public int form = 1;

    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name = name;
        switch (name) {
            case "j":
                color = Color.SLATEGREY;
                break;
            case "l":
                color = Color.DARKGOLDENROD;
                break;
            case "o":
                color = Color.INDIANRED;
                break;
            case "s":
                color = Color.DARKSEAGREEN;
                break;
            case "t":
                color = Color.CADETBLUE;
                break;
            case "z":
                color = Color.PURPLE;
                break;
            case "i":
                color = Color.SANDYBROWN;
                break;
        }

        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);
    }

    public String getName(){
        return name;
    }

    public void changeForm(){
        if (form != 4) {
            form++;
        } else {
            form = 1;
        }
    }

    private void move(int MOVE){
        a.setX(a.getX() + MOVE);
        b.setX(b.getX() + MOVE);
        c.setX(c.getX() + MOVE);
        d.setX(d.getX() + MOVE);
    }

    public void makeMove(int XMAX, int SIZE, int MOVE, String direction, int [][]MESH){
        switch (direction){
            case "right":
                if (this.a.getX() + MOVE <= XMAX - SIZE &&  this.b.getX() + MOVE <= XMAX - SIZE &&
                        this.c.getX() + MOVE <= XMAX - SIZE &&  this.d.getX() + MOVE <= XMAX - SIZE)
                {
                    int canMoveA = MESH[((int)a.getX() / SIZE) + 1][((int)a.getY() / SIZE)];
                    int canMoveB = MESH[((int)b.getX() / SIZE) + 1][((int)b.getY() / SIZE)];
                    int canMoveC = MESH[((int)c.getX() / SIZE) + 1][((int)c.getY() / SIZE)];
                    int canMoveD = MESH[((int)d.getX() / SIZE) + 1][((int)d.getY() / SIZE)];
                    if (canMoveA == 0 && canMoveB == 0 && canMoveC == 0 && canMoveD == 0){
                        move(MOVE);
                    }
                    break;
                }
            case "left":
                if (this.a.getX() - MOVE >= 0 && this.b.getX() - MOVE >=0 &&
                        this.c.getX() - MOVE >= 0 && this.d.getX() - MOVE >=0)
                {
                    int canMoveA = MESH[((int)a.getX() / SIZE) - 1][((int)a.getY() / SIZE)];
                    int canMoveB = MESH[((int)b.getX() / SIZE) - 1][((int)b.getY() / SIZE)];
                    int canMoveC = MESH[((int)c.getX() / SIZE) - 1][((int)c.getY() / SIZE)];
                    int canMoveD = MESH[((int)d.getX() / SIZE) - 1][((int)d.getY() / SIZE)];
                    if (canMoveA == 0 && canMoveB == 0 && canMoveC == 0 && canMoveD == 0){
                        move((-1)*MOVE);
                    }
                    break;
                }
        }
    }

}

