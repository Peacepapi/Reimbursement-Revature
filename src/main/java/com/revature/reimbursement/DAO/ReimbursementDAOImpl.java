package com.revature.reimbursement.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursement.Model.Reimbursement;
import com.revature.reimbursement.Model.ReimbursementStatus;
import com.revature.reimbursement.Model.ReimbursementType;
import com.revature.reimbursement.Model.User;
import com.revature.reimbursement.Model.UserRole;
import com.revature.reimbursement.Utility.ConnectionFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	public boolean createReimbRequest(double amount, LocalDate submitted, int authorId, int statusId, int typeId) throws Exception{
		return false;
	}

	public boolean processReimb(int reimbId, int statusId, int resolverId, LocalDate resolvedDate) throws Exception{
		return false;
	}
	
	public List<ReimbursementType> getAllReimbType(int typeId) throws Exception {
		Connection conn = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		List<ReimbursementType> reimbTypeList = new ArrayList<ReimbursementType>();
		while (rs.next()) {
			ReimbursementType type = new ReimbursementType(rs.getInt("type_id"), rs.getString("type"));
			reimbTypeList.add(type);
		}
		return reimbTypeList;
	}
	
	public List<Reimbursement> getReimbByUser(int userId) throws Exception{
		Connection conn = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM V_All_Reimb where reimb_author = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, userId);
		ResultSet rs = stmt.executeQuery();

		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		while (rs.next()) {
			UserRole authorRole = new UserRole(rs.getInt("authorRole_id"), rs.getString("authorRole"));
			User author = new User(rs.getInt("author_id"), rs.getString("author_name"), rs.getString("author_fName"),
					rs.getString("author_lName"), rs.getString("author_email"), authorRole);
			UserRole resolvsrRole = new UserRole(rs.getInt("resolvsrRole_id"), rs.getString("resolvsrRole"));
			User resolvsr = new User(rs.getInt("resolvsr_id"), rs.getString("resolvsr_name"),
					rs.getString("resolvsr_fName"), rs.getString("resolvsr_lName"), rs.getString("resolvsr_email"),
					resolvsrRole);
			ReimbursementType type = new ReimbursementType(rs.getInt("type_id"), rs.getString("type"));
			ReimbursementStatus status = new ReimbursementStatus(rs.getInt("status_id"), rs.getString("status"));

			Reimbursement reimb = new Reimbursement(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"),
					rs.getDate("reimb_submitted").toLocalDate(), rs.getDate("reimb_resolved").toLocalDate(),
					rs.getString("reimb_description"), rs.getBlob("reimb_receipt"), status, type, author, resolvsr);
			
			reimbList.add(reimb);
		}
		return reimbList;
	}

	public List<Reimbursement> getAllReimb() throws Exception{
		Connection conn = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM V_All_Reimb";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		while (rs.next()) {
			UserRole authorRole = new UserRole(rs.getInt("authorRole_id"), rs.getString("authorRole"));
			User author = new User(rs.getInt("author_id"), rs.getString("author_name"), rs.getString("author_fName"),
					rs.getString("author_lName"), rs.getString("author_email"), authorRole);
			UserRole resolvsrRole = new UserRole(rs.getInt("resolvsrRole_id"), rs.getString("resolvsrRole"));
			User resolvsr = new User(rs.getInt("resolvsr_id"), rs.getString("resolvsr_name"),
					rs.getString("resolvsr_fName"), rs.getString("resolvsr_lName"), rs.getString("resolvsr_email"),
					resolvsrRole);
			ReimbursementType type = new ReimbursementType(rs.getInt("type_id"), rs.getString("type"));
			ReimbursementStatus status = new ReimbursementStatus(rs.getInt("status_id"), rs.getString("status"));

			Reimbursement reimb = new Reimbursement(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"),
					rs.getDate("reimb_submitted").toLocalDate(), rs.getDate("reimb_resolved").toLocalDate(),
					rs.getString("reimb_description"), rs.getBlob("reimb_receipt"), status, type, author, resolvsr);
			
			reimbList.add(reimb);
		}
		return reimbList;
	}

	public List<Reimbursement> getReimbByStatus(int statusId) throws Exception{
		Connection conn = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM V_All_Reimb WHERE reimb_status_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, statusId);
		ResultSet rs = stmt.executeQuery();

		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		while (rs.next()) {
			UserRole authorRole = new UserRole(rs.getInt("authorRole_id"), rs.getString("authorRole"));
			User author = new User(rs.getInt("author_id"), rs.getString("author_name"), rs.getString("author_fName"),
					rs.getString("author_lName"), rs.getString("author_email"), authorRole);
			UserRole resolvsrRole = new UserRole(rs.getInt("resolvsrRole_id"), rs.getString("resolvsrRole"));
			User resolvsr = new User(rs.getInt("resolvsr_id"), rs.getString("resolvsr_name"),
					rs.getString("resolvsr_fName"), rs.getString("resolvsr_lName"), rs.getString("resolvsr_email"),
					resolvsrRole);
			ReimbursementType type = new ReimbursementType(rs.getInt("type_id"), rs.getString("type"));
			ReimbursementStatus status = new ReimbursementStatus(rs.getInt("status_id"), rs.getString("status"));

			Reimbursement reimb = new Reimbursement(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"),
					rs.getDate("reimb_submitted").toLocalDate(), rs.getDate("reimb_resolved").toLocalDate(),
					rs.getString("reimb_description"), rs.getBlob("reimb_receipt"), status, type, author, resolvsr);
			
			reimbList.add(reimb);
		}
		return reimbList;
	}
	
	public Reimbursement getReimbById(int reimbId) throws Exception {
		Connection conn = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM V_All_Reimb WHERE reimb_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, reimbId);
		ResultSet rs = stmt.executeQuery();

		Reimbursement reimb = null;
		while (rs.next()) {
			UserRole authorRole = new UserRole(rs.getInt("authorRole_id"), rs.getString("authorRole"));
			User author = new User(rs.getInt("author_id"), rs.getString("author_name"), rs.getString("author_fName"),
					rs.getString("author_lName"), rs.getString("author_email"), authorRole);
			UserRole resolvsrRole = new UserRole(rs.getInt("resolvsrRole_id"), rs.getString("resolvsrRole"));
			User resolvsr = new User(rs.getInt("resolvsr_id"), rs.getString("resolvsr_name"),
					rs.getString("resolvsr_fName"), rs.getString("resolvsr_lName"), rs.getString("resolvsr_email"),
					resolvsrRole);
			ReimbursementType type = new ReimbursementType(rs.getInt("type_id"), rs.getString("type"));
			ReimbursementStatus status = new ReimbursementStatus(rs.getInt("status_id"), rs.getString("status"));

			reimb = new Reimbursement(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"),
					rs.getDate("reimb_submitted").toLocalDate(), rs.getDate("reimb_resolved").toLocalDate(),
					rs.getString("reimb_description"), rs.getBlob("reimb_receipt"), status, type, author, resolvsr);
		}
		return reimb;
	}
}
