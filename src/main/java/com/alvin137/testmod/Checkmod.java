package com.alvin137.testmod;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;

public class Checkmod {
	public static void subDirList(String source){
		File dir = new File(source); 
		File[] fileList = dir.listFiles(); 
		try{
			for(int i = 0 ; i < fileList.length ; i++){
				File file = fileList[i]; 
				if(file.isFile()){
    // ������ �ִٸ� ���� �̸� ���
					System.out.println("\t ���� �̸� = " + file.getName());
				}else if(file.isDirectory()){
					System.out.println("���丮 �̸� = " + file.getName());
    // ������丮�� �����ϸ� ����� ������� �ٽ� Ž��
					subDirList(file.getCanonicalPath().toString()); 
				}
			}
		}catch(IOException e){
		}
	}
}
