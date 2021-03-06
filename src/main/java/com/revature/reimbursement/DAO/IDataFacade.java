package com.revature.reimbursement.DAO;

import java.sql.Timestamp;
import java.util.List;

import com.revature.reimbursement.Model.Reimbursement;
import com.revature.reimbursement.Model.ReimbursementType;
import com.revature.reimbursement.Model.User;

public interface IDataFacade {
	
	public User getUserByUsername(String username);
	public User getUserById(int userId);
	
	public boolean createReimbRequest(double amount, String description, Timestamp submitted, int authorId, int typeId);
	public boolean processReimb(int reimbId, int statusId, int resolverId, Timestamp resolvedDate);

	public List<Reimbursement> getReimbByUser(int userId);
	public List<Reimbursement> getAllReimb() throws Exception;
	public List<Reimbursement> getReimbByStatus(int statusId);
	public List<ReimbursementType> getAllReimbType(int typeId);

	public Reimbursement getReimbById(int reimbId);
}
