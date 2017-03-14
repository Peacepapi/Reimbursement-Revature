package com.revature.reimbursement.DAO;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursement.Model.Reimbursement;
import com.revature.reimbursement.Model.ReimbursementStatus;
import com.revature.reimbursement.Model.ReimbursementType;
import com.revature.reimbursement.Model.User;
import com.revature.reimbursement.Model.UserRole;
import com.revature.reimbursement.Utility.ConnectionFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	Connection conn;
	
	public ReimbursementDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	public boolean createReimbRequest(double amount, String description, Timestamp submitted, int authorId, int typeId, InputStream receipt) throws Exception{
		conn = ConnectionFactory.getConnection();
		
		
		String sql = "INSERT INTO ERS_REIMBURSEMENT"
				+ "(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_SUBMITTED, REIMB_AUTHOR, REIMB_TYPE_ID, REIMB_RECEIPT) "
				+ "VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setDouble(1, amount);
		stmt.setString(2, description);
		stmt.setTimestamp(3, submitted);
		stmt.setInt(4, authorId);
		stmt.setInt(5, typeId);
		stmt.setBlob(6, receipt);
		
		int isSuccess = stmt.executeUpdate();
		
		return isSuccess > 0;
	}

	public boolean processReimb(int reimbId, int statusId, int resolverId, Timestamp resolvedDate) throws Exception{
		conn = ConnectionFactory.getConnection();
		String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = ?, REIMB_RESOLVER = ?, REIMB_RESOLVED = ? WHERE REIMB_ID = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, statusId);
		stmt.setInt(2, resolverId);
		stmt.setTimestamp(3, resolvedDate);
		stmt.setInt(4, reimbId);
		
		int isSuccess = stmt.executeUpdate();
		
		return isSuccess > 0;
	}
	
	public List<ReimbursementType> getAllReimbType() throws Exception {
		conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		List<ReimbursementType> reimbTypeList = new ArrayList<ReimbursementType>();
		while (rs.next()) {
			ReimbursementType type = new ReimbursementType(rs.getInt("REIMB_TYPE_ID"), rs.getString("REIMB_TYPE"));
			reimbTypeList.add(type);
		}
		return reimbTypeList;
	}
	
	public List<Reimbursement> getReimbByUser(int userId) throws Exception{
		conn = ConnectionFactory.getConnection();

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
					rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
					rs.getString("reimb_description"), rs.getBlob("reimb_receipt"), status, type, author, resolvsr);
			
			reimbList.add(reimb);
		}
		return reimbList;
	}

	public List<Reimbursement> getAllReimb() throws Exception{
		conn = ConnectionFactory.getConnection();

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
					rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
					rs.getString("reimb_description"), rs.getBlob("reimb_receipt"), status, type, author, resolvsr);
			
			reimbList.add(reimb);
		}		
		return reimbList;
	}

	public List<Reimbursement> getReimbByStatus(int statusId) throws Exception{
		conn = ConnectionFactory.getConnection();

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
					rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
					rs.getString("reimb_description"), rs.getBlob("reimb_receipt"), status, type, author, resolvsr);

			reimbList.add(reimb);
		}
		return reimbList;
	}
	
	public Reimbursement getReimbById(int reimbId) throws Exception {
		conn = ConnectionFactory.getConnection();

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
					rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
					rs.getString("reimb_description"), rs.getBlob("reimb_receipt"), status, type, author, resolvsr);
		}
		return reimb;
	}

	@Override
	public Blob getImageById(int id) throws Exception {
		conn = ConnectionFactory.getConnection();

		String sql = "SELECT REIMB_RECEIPT FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		
		Blob blob = null;
		
		while(rs.next()){
			blob = rs.getBlob("REIMB_RECEIPT");
		}
		return blob;
	}
}
