package com.company.GUI;

import com.company.GUI.ControlPanel;

import javax.swing.*;
import java.awt.*;


public class CatalogFrame extends JFrame
{
	private GraphForm form = new GraphForm(this);
	public CatalogList list = new CatalogList();
	private ControlPanel control = new ControlPanel(this);
	public GUI.CatalogTable table=new GUI.CatalogTable();
	JTable j;
	public CatalogFrame()
	{
		super("Visual Graph Manager");
		init();
	}

	private void init()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		table=new GUI.CatalogTable();
		this.getContentPane().add(form, BorderLayout.NORTH);
		this.getContentPane().add(table.getTabel());
		this.getContentPane().add(control, BorderLayout.SOUTH);
		this.pack();
	}
}