package ru.nsu.fit.daria.tetris;

import java.util.Random;
import static ru.nsu.fit.daria.tetris.Tetris.*;

public class Controller {
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
        System.out.println(block);

        return switch (block) {
            case 0 -> new ShapeJ();
            case 1 -> new ShapeL();
            case 2 -> new ShapeO();
            case 3 -> new ShapeS();
            case 4 -> new ShapeT();
            case 5 -> new ShapeZ();
            default -> new ShapeI();
        };
    }

}

