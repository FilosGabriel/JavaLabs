package com.company.GUI;

import com.company.BusinnesLogic.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GraphForm extends JPanel
{
	private final CatalogFrame frame;
	private Logic logic;
	private JLabel titleLabel = new JLabel("Name of the graph");
	private JTextField titleTextField = new JTextField(20);

	private JLabel pathDestination = new JLabel("Path of the destionation file");
	private JTextField pathDestionationTextField = new JTextField(20);

	private JLabel pathImageLabel = new JLabel("Path of the image file");
	private JTextField pathImageTextField = new JTextField(20);

	private String[] graphType = {"simple", "directed"};
	private JLabel graphTypeLabel = new JLabel("Graph type");
	private JComboBox graphTypeComboBox = new JComboBox(graphType);

	private JLabel verticesLabel = new JLabel("Number of vertices");
	private JSpinner verticesField = new JSpinner(new SpinnerNumberModel());

	private JLabel edgesLabel = new JLabel("Number of edges");
	private JSpinner edgesField = new JSpinner(new SpinnerNumberModel());

	private JButton addButton = new JButton("Add to repository");

	public GraphForm(CatalogFrame frame)
	{
		this.frame = frame;
		init();
	}

	private void init()
	{
		logic= Logic.createInstance(this);

		this.setLayout(new GridLayout(13,1));
		this.setPreferredSize(new Dimension(800,600));
		Component[] components = {titleLabel, titleTextField, pathDestination, pathDestionationTextField, pathImageLabel, pathImageTextField,
				graphTypeLabel, graphTypeComboBox, verticesLabel, verticesField, edgesLabel, edgesField, addButton};


		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addGraph();
			}
		});
//        this.add(addButton);
		for(Component component : components)
		{
			this.add(component);
		}


	}

	private void addGraph()
	{


//    frame.list.addG
		frame.table.addGraph(titleTextField.getText(),"",pathDestionationTextField.getText(),pathImageTextField.getText());

//        frame.list.addGraph(titleTextField.getText() + ", "
//                + graphTypeComboBox.getSelectedItem().toString() + ", "
//                + " Number of vertices " + verticesField.getValue() + ", "
//                + " Number of edges= " + edgesField.getValue() + ", "
//                + " Path " + pathDestionationTextField.getText() );

	}
}