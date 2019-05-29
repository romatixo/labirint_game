package com.example.labirintgame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by pro on 17.01.2017.
 */
public class GameField extends JPanel {

    private  Image winscreen;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            onRepaint(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();
    }


     void onRepaint(Graphics g) throws IOException{
        Graphics2D gr2d = (Graphics2D) g;
        int a = 0;
        int b = 0;
        winscreen = ImageIO.read(Window.class.getResourceAsStream("winscreen.jpg"));

        for (int i = 0; i < Window.height; i++) {
            for (int j = 0; j < Window.width; j++) {
                if (Window.maze2[i][j] == 0 || Window.maze2[i][j] == 4) {

                    gr2d.setPaint(Color.BLACK);
                    g.fillRect(a, b, Main.s, Main.s);
                    a = a + Main.s;
                } else if (Window.maze2[i][j] == 2) {
                    gr2d.setPaint(Color.WHITE);
                    g.fillRect(a, b, Main.s, Main.s);
                    a = a + Main.s;
                } else {
                    gr2d.setPaint(Color.RED);
                    g.fillRect(a, b, Main.s, Main.s);
                    a = a + Main.s;
                }
            }
            a = 0; // a - ширина
            b = b + Main.s;
        }
        gr2d.setPaint(Color.GREEN);
        g.fillRect(Window.startCell.x, Window.startCell.y, Main.s, Main.s);
        if (Window.startCell.y==(Window.width-2)*Main.A / Window.height&&Window.startCell.x==(Window.width-3)* Main.A / Window.height){
            Window.bway.hide();
            g.drawImage(winscreen, 0, 0, null);
        }


    }
}
