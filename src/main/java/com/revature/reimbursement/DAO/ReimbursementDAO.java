package com.revature.reimbursement.DAO;

import java.util.List;

import com.revature.reimbursement.Model.ERS_Reimbursement;
import com.revature.reimbursement.Model.ERS_Reimbursement_Type;
import com.revature.reimbursement.Model.ERS_Users;

public interface ReimbursementDAO {
	public boolean createReimburseRequest();
	public List<ERS_Reimbursement> getReimburseByUser(ERS_Users user);
	public List<ERS_Reimbursement> getAllReimburse();
	public List<ERS_Reimbursement> getReimburseByStatus(String status);
	public boolean processReimburse();
	public ERS_Reimbursement getReimburseById(int id);
	public List<ERS_Reimbursement_Type> getAllReimburseTypes();
}
