package com.example.auctionhouse;

import java.util.*;

public class UserProfileConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserProfileService ups = new UserProfileService();
		
		ups.viewUserProfileList();
		ups.viewUserProfile("c2718a56-82b6-4ab2-a8ea-2fa50b73367b");
		
		ups.deleteUserProfile("c2718a56-82b6-4ab2-a8ea-2fa50b73367b");
		ups.viewUserProfileList();
		ups.viewUserProfile("10d9f086-92aa-4cf9-9b61-3619b0f38feb");
		ups.viewUserProfile("fee43c2b-e0fc-490e-bb87-cc84cd5c9ced");
	}

}
