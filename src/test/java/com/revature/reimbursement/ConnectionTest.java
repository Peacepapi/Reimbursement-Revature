package com.revature.reimbursement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.revature.reimbursement.DAO.DataFacade;
import com.revature.reimbursement.DAO.ReimbursementDAOImpl;
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
	public void getUser() {
		DataFacade df = new DataFacade();
		List<Reimbursement> list = df.getAllReimb();
		for (Reimbursement l : list)
			System.out.println(l.getrAmount());

	}
}
