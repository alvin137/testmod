package alvin137.testmod.modchecker;

import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class ModListWriter {
	/*
	 * public void write(String filename) throws FileNotFoundException,
	 * IOException { String input = filename; FileWriter fw = new
	 * FileWriter(".\\tmp.txt"); fw.write(input); fw.write("\n"); fw.
	 * fw.close(); System.out.println("읽혔다!" + filename); }
	 */
	/*
	 * private static String writeBiz(List<String> listBiz) { File sfile = new
	 * File(); if(!sfile.isDirectory()) sfile.mkdirs(); StringBuffer sb = new
	 * StringBuffer(); for(String biz : listBiz){ sb.append( biz + "\n" ); }
	 * savefile(fileName, sb.toString() ); return fileName; }
	 */public static void savefile(String text) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(".\\tmp.txt", true));
			out.write(text);
			out.newLine();
			out.flush();
			out.close();
		} catch (IOException e) {
		}
	}
}
