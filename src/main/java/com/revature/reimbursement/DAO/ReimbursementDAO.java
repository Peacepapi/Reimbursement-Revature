package com.revature.reimbursement.DAO;

import java.sql.Timestamp;
import java.util.List;

import com.revature.reimbursement.Model.Reimbursement;
import com.revature.reimbursement.Model.ReimbursementType;

public interface ReimbursementDAO {
	
	public boolean createReimbRequest(double amount, String description, Timestamp submitted, int authorId, int typeId) throws Exception;
	public boolean processReimb(int reimbId, int statusId, int resolverId, Timestamp resolvedDate) throws Exception;

	public List<Reimbursement> getReimbByUser(int userId) throws Exception;
	public List<Reimbursement> getAllReimb() throws Exception;
	public List<Reimbursement> getReimbByStatus(int statusId) throws Exception;
	
	public List<ReimbursementType> getAllReimbType(int typeId) throws Exception;

	public Reimbursement getReimbById(int reimbId) throws Exception;
}
