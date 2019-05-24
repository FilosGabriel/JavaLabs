package com;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class DesignPanel extends JPanel {
    public static final transient int W = 800, H = 600;
    private final MainFrame frame;
    public transient DesignBean designBean;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(W, H));
        setLayout(null);
        designBean = new DesignBean();
    }

    public void addAtRandomLocation(JComponent comp) {
        int x = new Random().nextInt(W-1);//create a random integer between 0 and W-1
        int y = new Random().nextInt(H-1);//create a random integer between 0 and H-1
        int w = comp.getPreferredSize().width;
        int h = comp.getPreferredSize().height;
        comp.setBounds(x, y, w, h);
        comp.setToolTipText(comp.getClass().getName());
        this.add(comp);
        frame.repaint();
        designBean.addComponent(comp);
//        comp.addComponentListener(  );
    }

    public void load()
    {
        this.removeAll();
        List<JComponent> components = designBean.getComponentList();
        for (JComponent component : components)
        {
            this.add(component);
            frame.repaint();
        }
    }
}