package GUI;

import com.company.BusinnesLogic.Logic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class CatalogTable {
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane sp;
    private JPopupMenu menu = null;
    final String[] strings = {"cmd", "/c", "start chrome https://www.google.com/search?q="};


    public CatalogTable() {

        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Description");
        model.addColumn("Path tgf");
        model.addColumn("Path image");

        String[] columnNames = {"Name", "Description", "Path tgf", "Path image"};
        table = new JTable(model);
        table.setBounds(30, 40, 200, 300);
        sp = new JScrollPane(table);
        sp.setVisible(true);
        Logic.getInstance().addTable(table);
//		frame.add(sp);

    }

    public JScrollPane getTabel() {
        return sp;
    }

    public void addGraph(String name, String description, String pathTgf, String pathImage) {

//		Logic.getInstance().
        model.addRow(new Object[]{name, description, pathTgf, pathImage});
        table.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        int r = table.rowAtPoint(e.getPoint());
                        if (r >= 0 && r < table.getRowCount()) {
                            table.setRowSelectionInterval(r, r);
                        } else {
                            table.clearSelection();
                        }
                        int rowindex = table.getSelectedRow();
                        if (rowindex < 0)
                            return;
                        if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
                            JPopupMenu popup = new JPopupMenu("Popup");
                            JMenuItem item = new JMenuItem("Cauta pe google");
                            String[] search = strings;
                            search[2] = search[2] + table.getModel().getValueAt(rowindex, 0);
                            System.out.println(search[2]);
                            item.addActionListener(e1->{
                                try {
                                    Runtime.getRuntime().exec(search);
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            });
                            popup.add(item);
                            popup.add(item);
                            popup.show(e.getComponent(), e.getX(), e.getY());
                        }
                    }
                }
        );
    }
}
