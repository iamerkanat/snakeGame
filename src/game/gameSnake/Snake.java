package gameSnake;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
    //bunch of rectangles
    private ArrayList<Rectangle> body;
    private int w = Game.width;
    private int h = Game.height;
    private int d = Game.dimention;

    private String move; //NOTHING, UP, DOWN, LEFT, RIGHT


    public Snake() {
        body = new ArrayList<>();

        Rectangle temp = new Rectangle(Game.dimention, Game.dimention);
        temp.setLocation(Game.width / 2 * Game.dimention, Game.height / 2 * Game.dimention);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 -1) * d, (h / 2) * d);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 -2) * d, (h / 2) * d);
        body.add(temp);

        move = "NOTHING";

    }

    //growing Snake:

    public void move() {
        //adding new rectangle for body and deleting last
        if(move != "NOTHING") {
            Rectangle first = body.get(0);
            Rectangle temp= new Rectangle(Game.dimention, Game.dimention);

            if(move == "UP"){
                temp.setLocation(first.x, first.y - Game.dimention);
            }
            else if(move == "DOWN") {
                temp.setLocation(first.x, first.y + Game.dimention);
            }
            else if(move == "LEFT") {
                temp.setLocation(first.x - Game.dimention, first.y);
            }
            else {
                temp.setLocation(first.x + Game.dimention, first.y);
            }

            body.add(0, temp);
            body.remove(body.size() - 1);
        }
    }

    public void grow(){
        if(move != "NOTHING") {
            Rectangle first = body.get(0);
            Rectangle temp= new Rectangle(Game.dimention, Game.dimention);

            if(move == "UP"){
                temp.setLocation(first.x, first.y - Game.dimention);
            }
            else if(move == "DOWN") {
                temp.setLocation(first.x, first.y + Game.dimention);
            }
            else if(move == "LEFT") {
                temp.setLocation(first.x - Game.dimention, first.y);
            }
            else {
                temp.setLocation(first.x + Game.dimention, first.y);
            }

            body.add(0, temp);

        }
    }

    public ArrayList<Rectangle> getBody() {
        return body;
    }

    public String getMove() {
        return move;
    }

    public void setBody(ArrayList<Rectangle> body) {
        this.body = body;
    }

    public int getX() {
        return body.get(0).x;
    }

    public int getY() {
        return body.get(0).y;
    }

    public void up(){
        if(move != "DOWN"){
            move = "UP";
        }
    }
    public void down() {
        if (move != "UP") {
            move = "DOWN";
        }
    }
    public void left(){
        if(move != "RIGHT") {
            move = "LEFT";
        }
    }
    public void right(){
        if(move != "LEFT"){
        move = "RIGHT";
        }
    }
}
