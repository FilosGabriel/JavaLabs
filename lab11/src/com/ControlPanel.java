package com;

import javax.swing.*;
import java.io.*;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel classNameLabel = new JLabel("Class name");
    private final JTextField classNameField = new JTextField(30);
    private final JLabel textLabel = new JLabel("Default text");
    private final JTextField textField = new JTextField(10);
    private final JButton createButton = new JButton("Add component");
    private final JButton saveButton = new JButton("Save");
    private final JButton loadButton = new JButton("Load");
    private final String filepath = new String("D:\\JavaLabs\\lab11\\DesignPanel");
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        add(classNameLabel);
        add(classNameField);
        add(textLabel);
        add(textField);
        add(createButton);
        createButton.addActionListener(e -> {
            JComponent comp = createDynamicComponent(classNameField.getText());
            setComponentText(comp, textField.getText());
            frame.designPanel.addAtRandomLocation(comp);
        });
        add(saveButton);
        saveButton.addActionListener(e-> {
            try {
                FileOutputStream file = new FileOutputStream(filepath);
                ObjectOutputStream outputStream = new ObjectOutputStream(file);
                outputStream.writeObject(frame.designPanel.designBean);
            }
            catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        add(loadButton);
        loadButton.addActionListener(e-> {
            try
            {
                FileInputStream file = new FileInputStream(filepath);
                ObjectInputStream inputStream = new ObjectInputStream(file);
                frame.designPanel.designBean = (DesignBean) inputStream.readObject();
                frame.designPanel.load();
                frame.repaint();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        });
    }
    private JComponent createDynamicComponent(String className) {
	   try {
           Class aClass = Class.forName(className);
           JComponent comp = (JComponent) aClass.newInstance();
           return comp;
       } catch (IllegalAccessException e) {
           e.printStackTrace();
           return null;
       } catch (InstantiationException e) {
           e.printStackTrace();
           return null;
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
           return null;
       }

    }
    private void setComponentText(JComponent comp, String text) {
        if (comp instanceof JButton)
            ((JButton) comp).setText(text);
        if (comp instanceof JTextField)
            ((JTextField) comp).setText(text);
        if (comp instanceof JTextArea)
            ((JTextArea)comp).setText(text);
        if (comp instanceof JLabel)
            ((JLabel) comp).setText(text);
    }
}