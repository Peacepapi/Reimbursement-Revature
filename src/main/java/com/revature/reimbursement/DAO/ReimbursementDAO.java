package com.revature.reimbursement.DAO;

import java.time.LocalDate;
import java.util.List;

import com.revature.reimbursement.Model.Reimbursement;
import com.revature.reimbursement.Model.ReimbursementStatus;
import com.revature.reimbursement.Model.ReimbursementType;
import com.revature.reimbursement.Model.User;

public interface ReimbursementDAO {
	
	public boolean createReimbRequest(double amount, LocalDate submitted, User author, ReimbursementStatus status, ReimbursementType type);
	public boolean processReimb(int reimbId, int statusId, int resolverId, LocalDate resolvedDate);

	public List<Reimbursement> getReimbByUser(int userId);
	public List<Reimbursement> getAllReimb();
	public List<Reimbursement> getReimbByStatus(int StatusId);
	public List<ReimbursementType> getAllReimbType();

	public Reimbursement getReimbById(int reimbId);
}
