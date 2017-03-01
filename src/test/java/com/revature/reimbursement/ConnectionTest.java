package com.revature.reimbursement;
import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.reimbursement.DAO.ReimbursementDAO;
import com.revature.reimbursement.DAO.ReimbursementDAOImpl;
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
		ReimbursementDAOImpl dao = new ReimbursementDAOImpl();
		try {
			System.out.println(dao.getReimbById(1).getrAuthor().getUserEmail());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
