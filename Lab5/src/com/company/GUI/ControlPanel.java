package com.company.GUI;

import com.company.BusinnesLogic.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel
{
	private final CatalogFrame frame;

	private JButton loadBtn = new JButton("Load");
	private JButton saveBtn = new JButton("Save");
	private JButton openBtn = new JButton("Open");
	private JButton reportBtn = new JButton("Report");



	public ControlPanel(CatalogFrame frame)
	{
		this.frame = frame;
		init();
	}

	private void init()
	{
		this.add(loadBtn);
		this.add(saveBtn);
		this.add(openBtn );
		this.add(reportBtn);
		loadBtn.addActionListener(e ->Logic.getInstance().loadButton(new Dialog(true).getPath()));
		saveBtn.addActionListener(e->Logic.getInstance().saveButton(new Dialog(false).getPath()));
		openBtn.addActionListener(e->Logic.getInstance().openButton(new Dialog(true).getPath()));
		reportBtn.addActionListener(e->Logic.getInstance().report(new Dialog(false).getPath()));

	}
}
