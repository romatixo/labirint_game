package com.example.labirintgame;

import javax.swing.*;

/**
 * Created by pro on 17.01.2017.
 */
public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable(){
                    @Override
                    public void run(){
                        new Window();
                    }
                });
    }
}
