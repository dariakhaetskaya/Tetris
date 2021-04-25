package ru.nsu.fit.daria.tetris;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class Tetris extends Application{
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static final int XMAX = SIZE * 12;
    public static final int YMAX = SIZE * 24;
    protected static int [][] MESH = new int [XMAX/SIZE][YMAX/SIZE];
    private final Pane group = new Pane();
    private Shape object;
    private final Scene scene = new Scene(group, XMAX + 150, YMAX);
    private static int score = 0;
    private static int top = 0;
    private static boolean game  = true;
    private static int linesNo = 0;
    private Shape nextObj = Controller.makeRect();

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        for (int[] a: MESH){
            Arrays.fill(a,0);
        }
        Line line = new Line(XMAX, 0, XMAX, YMAX);
        Text scoreText = new Text("Score: ");
        scoreText.setStyle("-fx-font: 20 arials;");
        scoreText.setX(XMAX + 5);
        scoreText.setY(100);
        scoreText.setFill(Color.WHITE);
        scene.setFill(Color.THISTLE);
        Text level = new Text("Level: ");
        level.setStyle("-fx-font: 20 arials;");
        level.setX(XMAX + 5);
        level.setY(50);
        level.setFill(Color.WHITE);

        group.getChildren().addAll(scoreText, line, level);

        Shape firstBlock = nextObj;
        group.getChildren().addAll(firstBlock.a, firstBlock.b, firstBlock.c, firstBlock.d);
        moveOnKeyPress(firstBlock);
        object = firstBlock;
        nextObj = Controller.makeRect();
        stage.setScene(scene);
        stage.setTitle("TETRIS");
        stage.show();

        Timer fall = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (object.a.getY() == 0 || object.b.getY() == 0 || object.c.getY() == 0 || object.d.getY() == 0){
                        top++;
                    } else {
                        top = 0;
                    }

                    if (top == 2){
                        Text over = new Text("GAME OVER");
                        over.setFill(Color.RED);
                        over.setStyle("-fx-font: 70 arial");
                        over.setX(10);
                        over.setY(300);
                        group.getChildren().add(over);
                        game = false;
                    }

                    if (top == 15){
                        System.exit(0);
                    }

                    if (game){
                        moveDown(object);
                        scoreText.setText("Score: " + score);
                        level.setText("Lines: " + linesNo);
                    }
                });
            }
        };

        fall.schedule(task, 0 , 300);
    }

    private void moveOnKeyPress(Shape form){
        scene.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case RIGHT -> Controller.moveRight(form);
                case DOWN -> {
                    moveDown(form);
                    score++;
                }
                case LEFT -> Controller.MoveLeft(form);
                case UP -> form.turn();
            }
        });
    }


    private void removeRows(Pane pane){
        ArrayList<Node> rectangles = new ArrayList<>();
        ArrayList<Integer> lines = new ArrayList<>();
        ArrayList<Node> newRectangles = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < MESH[0].length; i++){
            for (int[] mesh : MESH) {
                if (mesh[i] == 1) {
                    count++;
                }
            }
            if (count == MESH.length){
                lines.add(i);
            }
            count = 0;
        }

        while (lines.size() > 0){
            for (Node node : pane.getChildren()){
                if (node instanceof Rectangle){
                    rectangles.add(node);
                }
            }
            for (Node node: rectangles){
                Rectangle a = (Rectangle) node;
                if (a.getY() == lines.get(0) * SIZE){
                    MESH[((int) a.getX() / SIZE)][((int) a.getY() / SIZE)] = 0;
                    pane.getChildren().remove(node);
                } else {
                    newRectangles.add(node);
                }
            }

            for (Node node : newRectangles){
                Rectangle a = (Rectangle) node;
                if (a.getY() < lines.get(0)*SIZE){
                    MESH[((int) a.getX() / SIZE)][((int) a.getY()) / SIZE] = 0;
                    a.setY(a.getY() + SIZE);
                }
            }

            score+=50;
            linesNo++;
            lines.remove(0);
            rectangles.clear();

            for (Node node : pane.getChildren()){
                if (node instanceof Rectangle){
                    rectangles.add(node);
                }
            }

            for (Node node : rectangles){
                Rectangle a = (Rectangle) node;
                MESH[((int) a.getX())/SIZE][((int)a.getY())/SIZE] = 1;
            }
            rectangles.clear();
        }
    }

    private void moveDown(Shape form) {
        if (form.a.getY() == YMAX - SIZE || form.b.getY() == YMAX - SIZE || form.c.getY() == YMAX - SIZE
                || form.d.getY() == YMAX - SIZE || moveA(form) || moveB(form) || moveC(form) || moveD(form)) {
            MESH[(int) form.a.getX() / SIZE][(int) form.a.getY() / SIZE] = 1;
            MESH[(int) form.b.getX() / SIZE][(int) form.b.getY() / SIZE] = 1;
            MESH[(int) form.c.getX() / SIZE][(int) form.c.getY() / SIZE] = 1;
            MESH[(int) form.d.getX() / SIZE][(int) form.d.getY() / SIZE] = 1;
            removeRows(group);

            Shape currentObj = nextObj;
            nextObj = Controller.makeRect();
            object = currentObj;
            group.getChildren().addAll(currentObj.a, currentObj.b, currentObj.c, currentObj.d);
            moveOnKeyPress(currentObj);
        }

        if (form.a.getY() + MOVE < YMAX && form.b.getY() + MOVE < YMAX && form.c.getY() + MOVE < YMAX
                && form.d.getY() + MOVE < YMAX) {
            int movea = MESH[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1];
            int moveb = MESH[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1];
            int movec = MESH[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1];
            int moved = MESH[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setY(form.a.getY() + MOVE);
                form.b.setY(form.b.getY() + MOVE);
                form.c.setY(form.c.getY() + MOVE);
                form.d.setY(form.d.getY() + MOVE);
            }
        }
    }

    private boolean moveA(Shape form) {
        return (MESH[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1] == 1);
    }

    private boolean moveB(Shape form) {
        return (MESH[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1] == 1);
    }

    private boolean moveC(Shape form) {
        return (MESH[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1] == 1);
    }

    private boolean moveD(Shape form) {
        return (MESH[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1] == 1);
    }
}











