package com.example.auctionhouse.ioservice;

import java.util.*;

import com.example.auctionhouse.userprofile.UserProfile;

import java.io.*;

interface fileWriteObject<T>{
	public <T> boolean fileWriteObject(List<T> listObject, String fileName);
}

interface fileReadObject<T>{
	public <T> List<T> fileReadObject(String fileName);
}


public class FileObject<T> implements fileWriteObject<T>, fileReadObject<T>{

	@Override
	public <T> boolean fileWriteObject(List<T> listObject, String fileName) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos = null;
			ObjectOutputStream out = null;
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(listObject);
			out.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public <T> List<T> fileReadObject(String fileName) {
		List<T> objectList = null;
		// TODO Auto-generated method stub
		try {
			UserProfile up = null;
			FileInputStream fis = null;
			ObjectInputStream in = null;
			System.out.println("Working Directory = " + System.getProperty("user.dir"));
			fis = new FileInputStream(fileName);
			in = new ObjectInputStream(fis);
			objectList = (List<T>)in.readObject();
			in.close();
			return objectList;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

}


