package com.revature.reimbursement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.revature.reimbursement.DAO.DataFacade;
import com.revature.reimbursement.Model.Reimbursement;
import com.revature.reimbursement.Utility.ConnectionFactory;

public class ConnectionTest {

	@Test
	public void testConn() {
		try {
			assertNotNull(ConnectionFactory.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void getAllReimb() {
		DataFacade df = new DataFacade();
		List<Reimbursement> list = df.getAllReimb();
		System.out.println(list);	
	}
	
	@Test
	public void addUser() {
		String hashed = BCrypt.hashpw("123456789", BCrypt.gensalt());
		System.out.println(hashed);
		if (BCrypt.checkpw("password", hashed))
			System.out.println("It matches");
		else
			System.out.println("It does not match");
	}
}

