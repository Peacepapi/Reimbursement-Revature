package com.revature.reimbursement.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.reimbursement.Model.User;
import com.revature.reimbursement.Model.UserRole;
import com.revature.reimbursement.Utility.ConnectionFactory;

public class UserDAOImpl implements UserDAO {
	Connection conn;

	public UserDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public User getUserByUsername(String username) throws Exception {
		conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM ERS_USERS " + "INNER JOIN ERS_USER_ROLES "
				+ "ON ERS_USERS.USER_ROLE_ID = ERS_USER_ROLES.ERS_USER_ROLE_ID " + "WHERE ERS_USERNAME = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);

		ResultSet rs = stmt.executeQuery();

		UserRole userRole = new UserRole();
		User user = new User();
		while (rs.next()) {
			userRole.setUserRoleId(rs.getInt("ERS_USER_ROLE_ID"));
			userRole.setUserRole(rs.getString("USER_ROLE"));

			user.setUserId(rs.getInt("ERS_USERS_ID"));
			user.setUsername(rs.getString("ERS_USERNAME"));
			user.setPassword(rs.getString("ERS_PASSWORD"));
			user.setUserFName(rs.getString("USER_FIRST_NAME"));
			user.setUserLName(rs.getString("USER_LAST_NAME"));
			user.setUserEmail(rs.getString("USER_EMAIL"));
			user.setUserRole(userRole);
		}
		return user;
	}

	public User getUserById(int userId) throws Exception {
		conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM ERS_USERS " + "INNER JOIN ERS_USER_ROLES "
				+ "ON ERS_USERS.USER_ROLE_ID = ERS_USER_ROLES.ERS_USER_ROLE_ID " + "WHERE ERS_USERS_ID = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, userId);

		ResultSet rs = stmt.executeQuery();

		UserRole userRole = new UserRole();
		User user = new User();
		while (rs.next()) {
			userRole.setUserRoleId(rs.getInt("ERS_USER_ROLE_ID"));
			userRole.setUserRole(rs.getString("USER_ROLE"));

			user.setUserId(rs.getInt("ERS_USERS_ID"));
			user.setUsername(rs.getString("ERS_USERNAME"));
			user.setPassword(rs.getString("ERS_PASSWORD"));
			user.setUserFName(rs.getString("USER_FIRST_NAME"));
			user.setUserLName(rs.getString("USER_LAST_NAME"));
			user.setUserEmail(rs.getString("USER_EMAIL"));
			user.setUserRole(userRole);
		}
		return user;
	}
}
