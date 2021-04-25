package ru.nsu.fit.daria.tetris;

import javafx.scene.shape.*;

import java.util.Random;

public class Controller {
    public static final int MOVE = Tetris.getMOVE();
    public static final int SIZE = Tetris.getSIZE();
    public static final int XMAX = Tetris.getXMAX();
    public static final int YMAX = Tetris.getYMAX();
    private static int [][] MESH = Tetris.getMESH();

    public static void moveRight(Shape form){
        form.makeMove(XMAX, SIZE, MOVE, "right", MESH);
    }

    public static void MoveLeft(Shape form){
        form.makeMove(XMAX, SIZE, MOVE, "left", MESH);
    }

    public static Shape makeRect(){
        Random random = new Random();
        int min = 0;
        int max = 6;
        int block = random.nextInt(max + 1 - min ) + min;
//        int block = 5;
        System.out.println(block);

        String name;
        Rectangle a = new Rectangle(SIZE - 1, SIZE - 1),
                b = new Rectangle(SIZE - 1, SIZE - 1),
                c = new Rectangle(SIZE - 1, SIZE - 1),
                d = new Rectangle(SIZE - 1, SIZE - 1);

        return switch (block) {
            case 0 -> new ShapeJ(a, b, c, d);
            case 1 -> new ShapeL(a, b, c, d);
            case 2 -> new ShapeO(a, b, c, d);
            case 3 -> new ShapeS(a, b, c, d);
            case 4 -> new ShapeT(a, b, c, d);
            case 5 -> new ShapeZ(a, b, c, d);
            default -> new ShapeI(a, b, c, d);
        };
    }

}

