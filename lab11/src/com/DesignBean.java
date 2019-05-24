package com;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DesignBean implements Serializable {
    private List<JComponent> componentList;

    public DesignBean()
    {
        componentList = new ArrayList<JComponent>();
    }

    public void addComponent(JComponent component)
    {
        componentList.add(component);
    }

    public List<JComponent> getComponentList()
    {
        return this.componentList;
    }
}
