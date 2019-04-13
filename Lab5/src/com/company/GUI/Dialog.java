package com.company.GUI;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class Dialog {
	private JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	private String path=null;
	public  Dialog(boolean type){
		int returnValue =type? jfc.showOpenDialog(null):jfc.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			path =selectedFile.getAbsolutePath();
		}
	}

	public String getPath() {
		return path;
	}
}
