package com;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;
    public MainFrame() {
        super("Swing Designer");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        //create and add to the frame the controlPanel and designPanel objects
        controlPanel = new ControlPanel(this);
        controlPanel.setVisible(true);
        add(controlPanel);
        designPanel = new DesignPanel(this);
        designPanel.setVisible(true);
        add(designPanel);
        pack();
        setVisible(true);
    }

    //create the main method

}