package ru.nsu.fit.daria.tetris;

import javafx.scene.shape.*;

import java.util.Random;

public class Controller {
    private static final int MOVE = Tetris.getMOVE();
    private static final int SIZE = Tetris.getSIZE();
    private static final int XMAX = Tetris.getXMAX();
    private static final int YMAX = Tetris.getYMAX();
    private static int [][] MESH = Tetris.getMESH();

    public static void MoveRight(Form form){
        form.makeMove(XMAX, SIZE, MOVE, "right", MESH);
    }

    public static void MoveLeft(Form form){
        form.makeMove(XMAX, SIZE, MOVE, "left", MESH);
    }

    public static Form makeRect(){
        Random random = new Random();
        int min = 0;
        int max = 6;
        int block = random.nextInt(max + 1 - min ) + min;
        System.out.println(block);
        String name;
        Rectangle a = new Rectangle(SIZE - 1, SIZE - 1),
                b = new Rectangle(SIZE - 1, SIZE - 1),
                c = new Rectangle(SIZE - 1, SIZE - 1),
                d = new Rectangle(SIZE - 1, SIZE - 1);

        switch (block){
            case 0:
                a.setX(XMAX / 2 - SIZE);
                b.setX(XMAX / 2 - SIZE);
                b.setY(SIZE);
                c.setX(XMAX / 2);
                c.setY(SIZE);
                d.setX(XMAX / 2 + SIZE);
                d.setY(SIZE);
                name = "j";
                break;

            case 1:
                a.setX(XMAX / 2 + SIZE);
                b.setX(XMAX / 2 - SIZE);
                b.setY(SIZE);
                c.setX(XMAX / 2);
                c.setY(SIZE);
                d.setX(XMAX / 2 + SIZE);
                d.setY(SIZE);
                name = "l";
                break;

            case 2:
                a.setX(XMAX / 2 - SIZE);
                b.setX(XMAX / 2);
                c.setX(XMAX / 2 - SIZE);
                c.setY(SIZE);
                d.setX(XMAX / 2);
                d.setY(SIZE);
                name = "o";
                break;

            case 3:
                a.setX(XMAX / 2 + SIZE);
                b.setX(XMAX / 2);
                c.setX(XMAX / 2);
                c.setY(SIZE);
                d.setX(XMAX / 2 - SIZE);
                d.setY(SIZE);
                name = "s";
                break;

            case 4:
                a.setX(XMAX / 2 - SIZE);
                b.setX(XMAX / 2);
                c.setX(XMAX / 2);
                c.setY(SIZE);
                d.setX(XMAX / 2 + SIZE);
                name = "t";
                break;

            case 5:
                a.setX(XMAX / 2 + SIZE);
                b.setX(XMAX / 2);
                c.setX(XMAX / 2 + SIZE);
                c.setY(SIZE);
                d.setX(XMAX / 2 + SIZE + SIZE);
                d.setY(SIZE);
                name = "z";
                break;

            default:
                a.setX(XMAX / 2 - SIZE - SIZE);
                b.setX(XMAX / 2 - SIZE);
                c.setX(XMAX / 2);
                d.setX(XMAX / 2 + SIZE);
                name = "i";
                break;
        }

        return new Form(a, b, c, d, name);
    }

}

