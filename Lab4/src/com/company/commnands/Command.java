package com.company.commnands;

import com.company.MyException.FolderNotExists;
import com.company.MyException.InvalidPath;
import com.company.com.catalog.Catalog;

public abstract class Command {
	protected static Catalog catalog;

	static {
		try {
			catalog = new Catalog("C:\\Dev_file\\facultate\\java\\Lab4\\src\\com\\company\\graphs\\");
		} catch (InvalidPath invalidPath) {
			invalidPath.printStackTrace();
		} catch (FolderNotExists folderNotExists) {
			folderNotExists.printStackTrace();
		}
	}

	public static Catalog getCatalog() {
		return catalog;
	}

	public static void setCatalog(Catalog catalog) {
		Command.catalog = catalog;
	}
}
