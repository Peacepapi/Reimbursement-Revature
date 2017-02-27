package com.revature.reimbursement;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
public class ConnectionTest {
//	@Test
//	public void test(){
//		try {
//			assertNotNull(ConnectionFactory.getConnection());
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}
//	
//	@Test
//	public void getRoles(){
//		TestingDb dao = new TestingDb();
//		try {
//			List<String> listStr = dao.getRoles();
//			System.out.println(listStr);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}
//	
	@Test
	public void checkPassword(){
		// Hash a password for the first time
		String hashed = BCrypt.hashpw("Cambodia", BCrypt.gensalt());
		// Check that an unencrypted password matches one that has
		// previously been hashed
		System.out.println(hashed);
		if (BCrypt.checkpw("Camboda", hashed))
			System.out.println("It matches");
		else
			System.out.println("It does not match");
	}
}
