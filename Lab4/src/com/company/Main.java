package com.company;

import com.company.MyException.FolderNotExists;
import com.company.MyException.IllegalArgument;

import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;
import java.nio.file.NotDirectoryException;

public class Main {

    public static void main(String[] args)
    {
        try {

            Catalog catalog=new Catalog("C:\\Dev_file\\facultate\\java\\  Lab4\\src\\com\\company\\graphs\\");
            catalog.add (new Graph("K2", "complete\\k2.tgf", "complete\\view\\k2.png"));
            catalog.add (new Graph("Petersen", "special/petersen.tgf", "d:/ag/agr1.pdf"));
            catalog.open("K2",false);
//            catalog.save("catalog.dat");
//            //...
//            catalog.load("catalog.dat");
//
//            catalog.list();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }





    }
}
