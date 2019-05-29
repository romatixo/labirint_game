package com.example.labirintgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;

/**
 * Created by pro on 12.01.2017.
 */

public class Window extends JFrame  {
    static int height = 30;
    static int width = 30;
    private Buttons b1,b2,b3;
    static VerticalButton bway;

    static int[][] maze2 = new int[Window.height][Window.width];
    static LabirintGame.cell startCell = new LabirintGame.cell(Main.s, Main.s);


    public Window(){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - Main.A) / 2;
        int locationY = (screenSize.height - Main.A) / 2;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(locationX, locationY, Main.A, Main.A);
        setSize(Main.A + 50, Main.B + 25);
        setResizable(false);
        setVisible(true);
        final StartWindow startWindow = new StartWindow();
        final GameField game_field = new GameField();
        add(startWindow);
        b1= new Buttons("30 х 30");
        b2 = new Buttons("50 х 50");
        b3 = new Buttons("100 х 100");
        startWindow.setLayout(new GridBagLayout());
        game_field.setBackground(Color.BLACK);
        final KeyController listener = new KeyController();
        setFocusable(true);

        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(startWindow);
                height = 30;
                width = 30;
                Main.s = Main.A / width;
                startCell.x = Main.A / width;
                startCell.y = Main.A / width;
                maze2 = LabirintGame.returnmaze(Main.maze);
                addKeyListener(listener);
                add(game_field);
                remove(b1);
                revalidate();
                repaint();
            }
        });
        b2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(startWindow);
                height = 50;
                width = 50;
                Main.s = Main.A / width;
                startCell.x = Main.A / width;
                startCell.y = Main.A / width;
                maze2 = LabirintGame.returnmaze(Main.maze);
                addKeyListener(listener);
                add(game_field);
                remove(b2);
                revalidate();
                repaint();
            }
        });
        b3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(startWindow);
                height = 100;
                width = 100;
                Main.s = Main.A / width;
                startCell.x = Main.A / width;
                startCell.y = Main.A / width;
                maze2 = LabirintGame.returnmaze(Main.maze);

                addKeyListener(listener);
                add(game_field);
                remove(b3);
                revalidate();
                repaint();
            }
        });

        startWindow.add(b1);
        startWindow.add(b2);
        startWindow.add(b3);
        bway = new VerticalButton("Показать путь",false);
        bway.setPreferredSize(new Dimension(50, 0));
        game_field.add(bway);
        game_field.setLayout(new BorderLayout());
        game_field.add(bway, BorderLayout.EAST);
        bway.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exit.finalMaze(maze2);
            }
        });



    }



}
