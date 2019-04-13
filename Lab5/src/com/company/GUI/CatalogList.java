package com.company.GUI;

import javax.swing.*;
import java.awt.*;

public class CatalogList extends JList
{
	private DefaultListModel model = new DefaultListModel<>();



	public CatalogList()
	{
		String title = "<html><i><font color='blue'>" +
				"Catalog Graphs" + "</font></i></hmtl>";

		this.setVisible(true);

	}

	public void addGraph(String item)
	{
		model.addElement(item);
	}
}