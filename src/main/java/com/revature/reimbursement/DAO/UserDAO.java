package com.revature.reimbursement.DAO;
import com.revature.reimbursement.Model.ERS_Users;

public interface UserDAO {

	public ERS_Users getUserByUsername(String username);
	public boolean authenticateUser();
	public boolean login();
	public boolean signOut();
}
