package com.revature.reimbursement.DAO;

import com.revature.reimbursement.Model.User;

public interface UserDAO {
	
	public User getUserByUsername(String username) throws Exception;
	public User getUserById(int userId) throws Exception;
}
