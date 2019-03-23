package com.company.gui;

import javax.swing.*;
import java.awt.*;

public class CatalogFrame extends JFrame {
	GraphForm form;
	CatalogList list;
	ControlPanel control;
	public CatalogFrame(){
		super("Visual Graph manager");
		init();
	}
	private void init(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel emptyLabel = new JLabel("Name of the graph");
		emptyLabel.setPreferredSize(new Dimension(175, 100));
		list =new CatalogList();
		list.addGraph("dasda");
		this.getContentPane().add(emptyLabel, BorderLayout.CENTER);
		this.setSize(700,600);
//		this.pack();
//		this.pack();
		this.add(list, 1);
		this.add(new ControlPanel(this),2);
//		this.pack();
//		list=new CatalogList();
		this.setVisible(true);

	}
}
