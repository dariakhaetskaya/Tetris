package ru.nsu.fit.daria.tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static ru.nsu.fit.daria.tetris.Tetris.*;

public class Shape {
    protected Rectangle a;
    protected Rectangle b;
    protected Rectangle c;
    protected Rectangle d;

    Color color;
    String name;

    public int form = 1;

    public Shape() {
         a = new Rectangle(SIZE - 1, SIZE - 1);
         b = new Rectangle(SIZE - 1, SIZE - 1);
         c = new Rectangle(SIZE - 1, SIZE - 1);
         d = new Rectangle(SIZE - 1, SIZE - 1);
    }

    private void move(int MOVE) {
        a.setX(a.getX() + MOVE);
        b.setX(b.getX() + MOVE);
        c.setX(c.getX() + MOVE);
        d.setX(d.getX() + MOVE);
    }

    public void changeForm(){
        if (form != 4) {
            form++;
        } else {
            form = 1;
        }
    }

    void moveDown(Rectangle rectangle) {
        if (rectangle.getY() + MOVE < YMAX)
            rectangle.setY(rectangle.getY() + MOVE);
    }

    void moveRight(Rectangle rectangle) {
        if (rectangle.getX() + MOVE <= XMAX - SIZE)
            rectangle.setX(rectangle.getX() + MOVE);
    }

    void moveLeft(Rectangle rectangle) {
        if (rectangle.getX() - MOVE >= 0)
            rectangle.setX(rectangle.getX() - MOVE);
    }

    void moveUp(Rectangle rectangle) {
        if (rectangle.getY() - MOVE > 0)
            rectangle.setY(rectangle.getY() - MOVE);
    }

    public boolean cB(Rectangle rect, int x, int y) {
        boolean xb = false;
        boolean yb = false;
        if (x >= 0)
            xb = rect.getX() + x * MOVE <= XMAX - SIZE;
        if (x < 0)
            xb = rect.getX() + x * MOVE >= 0;
        if (y >= 0)
            yb = rect.getY() - y * MOVE > 0;
        if (y < 0)
            yb = rect.getY() + y * MOVE < YMAX;
        return xb && yb && MESH[((int) rect.getX() / SIZE) + x][((int) rect.getY() / SIZE) - y] == 0;
    }

    public void makeMove(int XMAX, int SIZE, int MOVE, String direction, int[][] MESH) {
        switch (direction) {
            case "right":
                if (this.a.getX() + MOVE <= XMAX - SIZE && this.b.getX() + MOVE <= XMAX - SIZE &&
                        this.c.getX() + MOVE <= XMAX - SIZE && this.d.getX() + MOVE <= XMAX - SIZE) {
                    int canMoveA = MESH[((int) a.getX() / SIZE) + 1][((int) a.getY() / SIZE)];
                    int canMoveB = MESH[((int) b.getX() / SIZE) + 1][((int) b.getY() / SIZE)];
                    int canMoveC = MESH[((int) c.getX() / SIZE) + 1][((int) c.getY() / SIZE)];
                    int canMoveD = MESH[((int) d.getX() / SIZE) + 1][((int) d.getY() / SIZE)];
                    if (canMoveA == 0 && canMoveB == 0 && canMoveC == 0 && canMoveD == 0) {
                        move(MOVE);
                    }
                    break;
                }
                break;

            case "left":
                if (this.a.getX() - MOVE >= 0 && this.b.getX() - MOVE >= 0 &&
                        this.c.getX() - MOVE >= 0 && this.d.getX() - MOVE >= 0) {
                    int canMoveA = MESH[((int) a.getX() / SIZE) - 1][((int) a.getY() / SIZE)];
                    int canMoveB = MESH[((int) b.getX() / SIZE) - 1][((int) b.getY() / SIZE)];
                    int canMoveC = MESH[((int) c.getX() / SIZE) - 1][((int) c.getY() / SIZE)];
                    int canMoveD = MESH[((int) d.getX() / SIZE) - 1][((int) d.getY() / SIZE)];
                    if (canMoveA == 0 && canMoveB == 0 && canMoveC == 0 && canMoveD == 0) {
                        move((-1) * MOVE);
                    }
                    break;
                }
                break;

            default:
                throw new IllegalArgumentException("direction can be either left of right");
        }
    }

    public void turn() {
    }
}
