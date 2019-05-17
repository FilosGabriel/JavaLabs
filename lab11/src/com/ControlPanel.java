package com;

import javax.swing.*;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel classNameLabel = new JLabel("Class name");
    private final JTextField classNameField = new JTextField(30);
    private final JLabel textLabel = new JLabel("Default text");
    private final JTextField textField = new JTextField(10);
    private final JButton createButton = new JButton("Add component");
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