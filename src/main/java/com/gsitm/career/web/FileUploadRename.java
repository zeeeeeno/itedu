package com.gsitm.career.web;

import com.oreilly.servlet.multipart.FileRenamePolicy;
import java.io.*;

public class FileUploadRename implements FileRenamePolicy {

	private String save_file_name;

	public FileUploadRename() {
	}

	public FileUploadRename(String save_file_name) {
		this.save_file_name = save_file_name;
	}

	public File rename(File f) {
		String parentDir = f.getParent();
		String fname = f.getName();

		// Get the extension if the file has one
		String fileExt = "";
		int i = -1;
		if ((i = fname.lastIndexOf(".")) != -1) {

			fileExt = fname.substring(i);
			fname = fname.substring(0, i);
		}

		// add the timestamp
		fname = save_file_name;

		// piece together the filename
		fname = parentDir + System.getProperty("file.separator") + fname + fileExt;

		File file = new File(fname);
		return file;
	}
}