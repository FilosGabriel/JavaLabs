package com.company.gui;

import javax.swing.*;

public class ControlPanel extends JPanel {
	private  final CatalogFrame frame;
	JButton loadBtn=new JButton("load");
	JButton saveBtn=new JButton("Save");
	public  ControlPanel(CatalogFrame frame){
		this.frame=frame;
		init();
	}
	private void init(){
		add(loadBtn, -1);
	}
}
