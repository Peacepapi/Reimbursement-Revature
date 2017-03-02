package com.revature.reimbursement;

import org.mindrot.jbcrypt.BCrypt;

import com.revature.reimbursement.DAO.DataFacade;
import com.revature.reimbursement.Model.User;

public class TestingDb {
	
	public static void main(String[] args){
		DataFacade df = new DataFacade();
		User user = df.getUserByUsername("YungGoose");
		String hashed = user.getPassword();
		String password = "Cambodia";
		
		System.out.println(hashed);
		if (BCrypt.checkpw(password, hashed))
			System.out.println("It matches");
		else
			System.out.println("It does not match");
	}
}

