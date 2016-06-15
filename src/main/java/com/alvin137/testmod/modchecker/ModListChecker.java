package com.alvin137.testmod.modchecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.List;

import com.alvin137.testmod.Testmod;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;

public class ModListChecker {
	public static void subDirList(String source){
		File dir = new File(source); 
		ModListWriter writer = new ModListWriter();
		File[] fileList = dir.listFiles();
		String filename = ".\\tmp.txt";
		File f = new File(filename);
		if(f.delete())
			System.out.println("Deleted file! Rewritting...");
		else
			System.out.println("Deleting file failed! Passing this progress.");
		try{
			for(int i = 0 ; i < fileList.length ; i++){
				File file = fileList[i]; 
				if(file.isFile()){
					Testmod.logger.info("\t File name = " + file.getName());
					//writer.write(file.getName());
					writer.savefile(file.getName());
				}else if(file.isDirectory()){
					System.out.println("디렉토리 이름 = " + file.getName());
					subDirList(file.getCanonicalPath().toString()); 
				}
			}
		}catch(IOException e){}
	}
}
