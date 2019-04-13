package com.company;

import com.company.com.catalog.Catalog;
import com.company.graph.Graph;

public class Main {

	/**
	 * @param args Arguments for program
	 */
	public static void main(String[] args)
	{
		try {

			Catalog catalog=new Catalog("C:\\Dev_file\\facultate\\java\\Lab4\\src\\com\\company\\graphs\\");
			catalog.add(new Graph("K3", "complete\\k3.tgf", "complete\\view\\K3png"));
//            catalog.add (new Graph("K2", "complete\\k2.tgf", "complete\\view\\K2.png"));
			catalog.add (new Graph("Petersen", "special/petersen.tgf", "d:/ag/agr1.pdf"));
////            catalog.open("K2");
////            catalog.open("Petersen",false);
//			catalog.save("catalog.dat");
////            //...
//			catalog.load("catalog.dat");
////
////			catalog.list();
			catalog.writeToHtml();
			catalog.writePdf();
			catalog.writeExcel();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
