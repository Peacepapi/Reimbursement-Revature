package com.revature.reimbursement.DAO;

import java.time.LocalDate;
import java.util.List;

import com.revature.reimbursement.Model.Reimbursement;
import com.revature.reimbursement.Model.ReimbursementStatus;
import com.revature.reimbursement.Model.ReimbursementType;
import com.revature.reimbursement.Model.User;

public interface ReimbursementDAO {
	
	public boolean createReimbRequest(double amount, LocalDate submitted, int authorId, int statusId, int typeId) throws Exception;
	public boolean processReimb(int reimbId, int statusId, int resolverId, LocalDate resolvedDate) throws Exception;

	public List<Reimbursement> getReimbByUser(int userId) throws Exception;
	public List<Reimbursement> getAllReimb() throws Exception;
	public List<Reimbursement> getReimbByStatus(int statusId) throws Exception;
	public List<ReimbursementType> getAllReimbType(int typeId) throws Exception;

	public Reimbursement getReimbById(int reimbId) throws Exception;
}
