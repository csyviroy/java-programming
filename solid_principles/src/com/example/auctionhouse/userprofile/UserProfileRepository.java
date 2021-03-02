package com.example.auctionhouse.userprofile;

import java.util.*;

import com.example.auctionhouse.ioservice.FileObject;

import java.io.*;

interface userProfileImp {
	public void addUserProfile(UserProfile u);
	public void deleteUserProfile(UserProfile u);
	public void updateUserProfile(UserProfile u);
	public List<UserProfile> getUserProfile();
	public UserProfile getUserProfile(String uniqueID);
}

public class UserProfileRepository extends FileObject<UserProfile> implements userProfileImp{
	private String fileName;
	private List<UserProfile> userList;
	
	public UserProfileRepository(String fileName){
		this.fileName = fileName;
		this.userList = fileReadObject(this.fileName);
		if (this.userList == null){
			this.userList = new ArrayList<UserProfile>();
			System.out.println("Unable to find existing file, user profile start fresh.");
		}
		else {
			System.out.println("System file managed to read user profile.");
		}
	}

	@Override
	public void updateUserProfile(UserProfile u) {
		// TODO Auto-generated method stub
		Iterator i = this.userList.iterator();
		while (i.hasNext()) {
			UserProfile dbUser = (UserProfile) i.next();
			if (dbUser.getUniqueID().equals(u.getUniqueID())) {
				dbUser.setCardPaymentList(u.getCardPaymentList());
				dbUser.seteAccountPaymentList(u.geteAccountPaymentList());
			}
			break;
		}
		boolean result = fileWriteObject(this.userList, this.fileName);
		if (!result) {
			System.out.println("Updating of user profile failed");
		}
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
		boolean result = fileWriteObject(this.userList, this.fileName);
		if (!result) {
			System.out.println("Deleting of user profile failed");
		}
	}

	@Override
	public void addUserProfile(UserProfile u) {
		// TODO Auto-generated method stub
		this.userList.add(u);
		boolean result = fileWriteObject(this.userList, this.fileName);
		if (!result) {
			System.out.println("Adding of user profile failed");
		}
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
}
