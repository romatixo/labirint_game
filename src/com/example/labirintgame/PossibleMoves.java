package com.example.labirintgame;

/**
 * Created by pro on 16.01.2017.
 */
public class PossibleMoves {
    Main main = new Main();
    static void move(){

        if (Main.right && Window.maze2[Window.startCell.y/Main.s][Window.startCell.x/Main.s + 1] == 2) {
            Window.startCell.x+=Main.s;
        }
        if (Main.left && Window.maze2[Window.startCell.y/Main.s][Window.startCell.x/Main.s - 1] == 2) Window.startCell.x-=Main.s;
        if (Main.down && Window.maze2[Window.startCell.y/Main.s + 1][Window.startCell.x/Main.s] == 2) Window.startCell.y+=Main.s;
        if (Main.up && Window.maze2[Window.startCell.y/Main.s - 1][Window.startCell.x/Main.s] == 2) Window.startCell.y-=Main.s;


    }


}
