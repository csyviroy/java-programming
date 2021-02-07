package com.example.auctionhouse.userprofile;

import java.util.*;

interface UserProfileInteraction{
	public void createUserProfile(String name, Date dob, String occupation);
	public void deleteUserProfile(String uniqueID);
	public void updateUserProfile(String uniqueID, String newOccupation);
	public void viewUserProfile(String uniqueID);
	public void viewUserProfileList();
}

public class UserProfileService implements UserProfileInteraction{

	private UserProfileRepository upr = new UserProfileRepository("userFile.ser");
	
	@Override
	public void createUserProfile(String name, Date dob, String occupation) {
		// TODO Auto-generated method stub
		UserProfile u = new UserProfile(name, dob, occupation);
		upr.addUserProfile(u);
	}

	@Override
	public void deleteUserProfile(String uniqueID) {
		// TODO Auto-generated method stub
		UserProfile u = upr.getUserProfile(uniqueID);
		if (u != null)
			upr.deleteUserProfile(u);
		else
			System.out.println("System failed to delete user profile.");
	}

	@Override
	public void updateUserProfile(String uniqueID, String newOccupation) {
		// TODO Auto-generated method stub
		UserProfile u = upr.getUserProfile(uniqueID);
		if (u != null) {
			u.setOccupation(newOccupation);
			upr.updateUserProfile(u);
		}
		else
			System.out.println("System failed to update user profile.");
	}

	@Override
	public void viewUserProfileList() {
		// TODO Auto-generated method stub
		List<UserProfile> upList = upr.getUserProfile();
		upList.forEach((u) -> {
			System.out.printf("ID: %s - Name: %s\n", u.getUniqueID(), u.getName());
		});
	}

	@Override
	public void viewUserProfile(String uniqueID) {
		// TODO Auto-generated method stub
		UserProfile u = upr.getUserProfile(uniqueID);
		if (u != null)
			System.out.printf("Name: %s - DOB: %s (%s).\n", u.getName(), u.getDob(), u.getOccupation());
		else
			System.out.println("No matching user profile found");
	}
	
}
