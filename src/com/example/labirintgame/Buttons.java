package com.example.labirintgame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pro on 17.01.2017.
 */
public class Buttons extends JButton{
    public Buttons (String s){
        super(s);
        setText(s);
        setVisible(true);
        setPreferredSize(new Dimension( 150, 50));

    }

    @Override
    public void setHorizontalAlignment(int alignment) {
        super.setHorizontalAlignment(alignment);
    }

    @Override
    public int getHorizontalAlignment() {
        return super.getHorizontalAlignment();
    }
}
