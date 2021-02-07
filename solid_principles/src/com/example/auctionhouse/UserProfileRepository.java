package com.example.auctionhouse;

import java.util.*;
import java.io.*;

interface addUserProfile {
	public void addUserProfile(UserProfile u);
}

interface deleteUserProfile {
	public void deleteUserProfile(UserProfile u);
}

interface updateUserProfile {
	public void updateUserProfile(UserProfile u);
}

interface viewUserProfile {
	public List<UserProfile> getUserProfile();
	public UserProfile getUserProfile(String uniqueID);
}

interface fileWriteObject{
	public void fileWriteObject();
}

interface fileReadObject{
	public void fileReadObject();
}

public class UserProfileRepository implements addUserProfile, deleteUserProfile, updateUserProfile, viewUserProfile, fileWriteObject, fileReadObject{
	private String fileName;
	private List<UserProfile> userList;
	
	UserProfileRepository(String fileName){
		this.fileName = fileName;
		fileReadObject();
	}

	@Override
	public void updateUserProfile(UserProfile u) {
		// TODO Auto-generated method stub
		Iterator i = this.userList.iterator();
		while (i.hasNext()) {
			UserProfile dbUser = (UserProfile) i.next();
			if (dbUser.getUniqueID().equals(u.getUniqueID())) {
				dbUser.setOccupation(u.getOccupation());
			}
			break;
		}
		
		fileWriteObject();
	}

	@Override
	public void deleteUserProfile(UserProfile u) {
		// TODO Auto-generated method stub
		Iterator i = this.userList.iterator();
		while (i.hasNext()) {
			UserProfile dbUser = (UserProfile) i.next();
			if (dbUser.getUniqueID().equals(u.getUniqueID())) {
				this.userList.remove(dbUser);
				break;
			}
		}
		fileWriteObject();
	}

	@Override
	public void addUserProfile(UserProfile u) {
		// TODO Auto-generated method stub
		this.userList.add(u);
		fileWriteObject();
	}

	@Override
	public List<UserProfile> getUserProfile() {
		// TODO Auto-generated method stub
		return this.userList;
	}

	@Override
	public UserProfile getUserProfile(String uniqueID) {
		// TODO Auto-generated method stub
		Iterator i = this.userList.iterator();
		while (i.hasNext()) {
			UserProfile u = (UserProfile) i.next();
			if (u.getUniqueID().equals(uniqueID)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public void fileWriteObject() {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos = null;
			ObjectOutputStream out = null;
			fos = new FileOutputStream(this.fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(this.userList);
			out.close();
		}
		catch (Exception e) {
			System.out.println("Add of user profile failed");
			e.printStackTrace();
		}
	}
	

	@Override
	public void fileReadObject() {
		// TODO Auto-generated method stub
		try {
			UserProfile up = null;
			FileInputStream fis = null;
			ObjectInputStream in = null;
			fis = new FileInputStream(this.fileName);
			in = new ObjectInputStream(fis);
			this.userList = (List<UserProfile>)in.readObject();
			in.close();
		}
		catch (FileNotFoundException e) {
			this.userList = new ArrayList<UserProfile>();
			System.out.println("Unable to find existing file, user profile start fresh.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
