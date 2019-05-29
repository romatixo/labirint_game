package com.example.labirintgame;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by pro on 16.01.2017.
 */
public class KeyController extends JPanel implements KeyListener {

    @Override
    public void keyTyped(KeyEvent event) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (Window.startCell.y==(Window.width-2)*Main.A / Window.height&&Window.startCell.x==(Window.width-3)*Main.A / Window.height) {
                    Main.up = false;
                }
                else Main.up = true;
                break;
            case KeyEvent.VK_DOWN:
                Main.down = true;
                break;
            case KeyEvent.VK_LEFT:
                Main.left = true;
                break;
            case KeyEvent.VK_RIGHT:
                Main.right = true;
                break;
        }
        PossibleMoves.move();
    }

    @Override
    public void keyReleased(KeyEvent event) {
        Main.up=false;
        switch (event.getKeyCode()) {
            case KeyEvent.VK_UP:
                Main.up = false;
                break;
            case KeyEvent.VK_DOWN:
                Main.down = false;
                break;
            case KeyEvent.VK_LEFT:
                Main.left = false;
                break;
            case KeyEvent.VK_RIGHT:
                Main.right = false;
                break;
        }

        repaint();

    }
}
