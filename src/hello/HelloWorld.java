package hello;

import deskBall.BallGame;

import java.util.List;

public class HelloWorld {
    public static void main(String[] args){
        ballGame();
    }

    public static void hello1(){
        String s1 = "samuel";
        System.out.println("hello world..." + s1);
    }

    public static void ballGame(){
        BallGame game = new BallGame();
        game.launchFrame();
    }
}
