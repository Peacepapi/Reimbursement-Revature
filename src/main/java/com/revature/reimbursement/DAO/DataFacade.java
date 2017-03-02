package com.revature.reimbursement.DAO;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursement.Model.Reimbursement;
import com.revature.reimbursement.Model.ReimbursementType;
import com.revature.reimbursement.Model.User;
import com.revature.reimbursement.Utility.ConnectionFactory;

public class DataFacade implements IDataFacade, AutoCloseable {

	private ReimbursementDAOImpl reimbDAO;
	private UserDAOImpl userDAO;
	Connection conn = null;
	
	public DataFacade(){
		try {
			 conn = ConnectionFactory.getConnection();
			 reimbDAO = new ReimbursementDAOImpl(conn);
			 userDAO = new UserDAOImpl(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User getUserByUsername(String username) {
		User user = new User();
		try {
			 user = userDAO.getUserByUsername(username);
		} catch (Exception e) {
			System.out.println("From getUserByUsername: ");
			e.printStackTrace();
		}
		return user;
	}

	public User getUserById(int userId) {
		User user = new User();
		try {
			user = userDAO.getUserById(userId);
		} catch (Exception e) {
			System.out.println("From getUserById: ");
			e.printStackTrace();
		}
		return user;
	}

	public boolean createReimbRequest(double amount, String description, Timestamp submitted, int authorId,
			int typeId) {
		boolean isSuccess = false;
		try {
			isSuccess = reimbDAO.createReimbRequest(amount, description, submitted, authorId, typeId);
		} catch (Exception e) {
			System.out.println("From createReimbRequest: ");
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean processReimb(int reimbId, int statusId, int resolverId, Timestamp resolvedDate) {
		boolean isSuccess = false;
		
		try {
			isSuccess = reimbDAO.processReimb(reimbId, statusId, resolverId, resolvedDate);
		} catch (Exception e) {
			System.out.println("From processReimb: ");
			e.printStackTrace();
		}
		return isSuccess;
	}

	public List<Reimbursement> getReimbByUser(int userId) {
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		try {
			reimbList = reimbDAO.getReimbByUser(userId);
		} catch (Exception e) {
			System.out.println("From getReimbByUser: ");
			e.printStackTrace();
		}
		return reimbList;
	}

	public List<Reimbursement> getAllReimb() {
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		try {
			reimbList = reimbDAO.getAllReimb();
		} catch (Exception e) {
			System.out.println("From getAllReimb: ");
			e.printStackTrace();
		}
		return reimbList;
	}

	public List<Reimbursement> getReimbByStatus(int statusId) {
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();

		try {
			reimbList = reimbDAO.getReimbByStatus(statusId);
		} catch (Exception e) {
			System.out.println("From getReimbByStatus: ");
			e.printStackTrace();
		}
		return reimbList;
	}

	public List<ReimbursementType> getAllReimbType(int typeId) {
		List<ReimbursementType> reimbTypeList = new ArrayList<ReimbursementType>();

		try {
			reimbTypeList = reimbDAO.getAllReimbType(typeId);
		} catch (Exception e) {
			System.out.println("From getAllReimbType: ");
			e.printStackTrace();
		}
		return reimbTypeList;
	}

	public Reimbursement getReimbById(int reimbId) {
		Reimbursement reimb = new Reimbursement();
		try {
			reimb = reimbDAO.getReimbById(reimbId);
		} catch (Exception e) {
			System.out.println("From getReimbById: ");
			e.printStackTrace();
		}
		return reimb;
	}

	public void close() throws Exception {
		if(conn != null) conn.close();		
	}

}
