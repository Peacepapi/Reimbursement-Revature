package com.revature.reimbursement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursement.Utility.ConnectionFactory;

public class TestingDb {
	
	public List<String> getRoles() throws Exception{
		String sql = "SELECT USER_ROLE FROM ERS_USER_ROLES";
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<String> str = new ArrayList<String>();
		while(rs.next()){
			str.add(rs.getString("USER_ROLE"));
		}
		return str;
	}
	public List<String> showTables() throws Exception{
		String sql = "select user from dual";
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<String> str = new ArrayList<String>();
		while(rs.next()){
			str.add(rs.getString("USER"));
		}
		return str;
	}
}
