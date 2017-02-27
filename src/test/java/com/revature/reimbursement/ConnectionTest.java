package com.revature.reimbursement;
import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.reimbursement.DAO.UserDAOImpl;
import com.revature.reimbursement.Utility.ConnectionFactory;

public class ConnectionTest {
	
	@Test
	public void testConn(){
		try {
			assertNotNull(ConnectionFactory.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void getUser(){
		UserDAOImpl dao = new UserDAOImpl();
		System.out.println(dao.getUserByUsername("SDippy").getUsername());
	}
}
