package com.example.labirintgame;

import com.sun.javafx.scene.control.skin.ButtonSkin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by pro on 17.01.2017.
 */
public class StartWindow extends JPanel{

    private static Image background;


    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        try {
            onRepaint(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();

    }

    private static void onRepaint(Graphics g) throws IOException {
        background = ImageIO.read(Window.class.getResourceAsStream("background.jpg"));
        g.drawImage(background,-100,0,null);
    }

}

