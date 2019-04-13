package com.company.BusinnesLogic;


import com.company.GUI.GraphForm;
import com.company.MyException.FolderNotExists;
import com.company.MyException.IllegalArgument;
import com.company.MyException.InvalidPath;
import com.company.com.catalog.Catalog;
import com.company.graph.Graph;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Map;


public class Logic {
    private static Logic instance = null;
    private Catalog catalog;
    private static int noInstance = 0;
    private GraphForm form = null;
    JTable table = null;

    private Logic(GraphForm form) {
        try {
            this.form = form;
            catalog = new Catalog("C:\\Dev_file\\facultate\\java\\Lab4\\src\\com\\company\\graphs\\");
        } catch (InvalidPath invalidPath) {
            invalidPath.printStackTrace();
        } catch (FolderNotExists folderNotExists) {
            folderNotExists.printStackTrace();
        }
    }

    public static Logic createInstance(GraphForm form) {
        if (instance == null) instance = new Logic(form);
        return instance;
    }

    public void addTable(JTable table) {
            this.table=table;
    }

    public static Logic getInstance() {
        return instance;
    }

    public void saveButton(String saveLocation) {
        for (int index = 0; index < table.getRowCount(); index++) {
            try {
                String name=table.getModel().getValueAt(index, 0).toString();
                String description=" ";
                String tgf=table.getModel().getValueAt(index, 1).toString();
                String image=table.getModel().getValueAt(index, 2).toString();
                System.out.println(name+description+tgf+image);
                    catalog.add(name,description,tgf,image);
            } catch (IllegalArgument illegalArgument) {
                illegalArgument.printStackTrace();
            }
        }
        catalog.save(saveLocation);

    }

    public void openButton(String nameFile) {
        catalog.open(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
    }

    public void loadButton(String path) {
        //catalog.load(path);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Description");
        model.addColumn("Path tgf");
        model.addColumn("Path image");
        table.setModel(model);
//        for (Map.Entry<String , Graph> en:catalog.entrySet()) {
//
//
//            System.out.println("Nume :"+entry.getValue().getName());
//            System.out.println("Definitia :"+entry.getValue().getPathDefinition());
//            System.out.println("Locatie imagine :"+entry.getValue().getPathImage());
//            if(entry.getValue().getDescription()!=null)
//            {
//                System.out.println("Descriere :"+entry.getValue().getDescription());
//            }
//            System.out.print("\n");
//        }
//        model.addRow(new Object[]{name, description, pathTgf, pathImage});
    }

    public void report(String reportName) {
        catalog.writePdf();
    }

}
