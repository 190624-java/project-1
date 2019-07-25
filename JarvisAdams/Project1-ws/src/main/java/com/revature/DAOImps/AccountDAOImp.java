package com.revature.DAOImps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.DAOs.AccountDAO;
import com.revature.beans.Account;
import com.revature.exceptions.NonexistantUser;
import com.revature.utilities.ConnectionFactory;
import com.revature.utilities.UType;

public class AccountDAOImp implements AccountDAO {

	// ===============================
	// CREATE
	// ===============================

	@Override
	public void create(String userName, String password, int type, String name, String email) throws SQLException {
		try (Connection conn = ConnectionFactory.getConnection()) {
			String psString = "INSERT INTO Users VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(psString);
			ps.setString(1, password);
			ps.setInt(2, type);
			ps.setString(3, name);
			ps.setString(4, email);
			ps.setString(5, userName);
			ps.executeQuery();

		} catch (SQLException e) {
			System.out.println("There was an error creating account.");
			throw e;
		}
		;

	}

	// ===============================
	// READ
	// ===============================

	@Override
	public Account getAccount(String userName) throws NonexistantUser {
		Account acc = null;
		try (Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT userID, password, name, email, type FROM Users WHERE username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				acc = new Account();
				acc.setUserID(rs.getInt("userId"));
				acc.setUserName(userName);
				acc.setPassword(rs.getString("password"));
				acc.setName(rs.getString("name"));
				acc.setEmail(rs.getString("email"));
				acc.setType(rs.getInt("type"));

				return acc;
			} else {
				System.out.println("Warning: No Employee by that username: " + userName);
				throw new NonexistantUser();
			}
		} catch (SQLException e) {
			System.out.println("There was an error finding account.");
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Account getAccount(int userID) {

		Account acc = null;
		try (Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT username, password, name, email FROM Users WHERE userID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				acc = new Account();
				acc.setUserID(userID);
				acc.setUserName(rs.getString("username"));
				acc.setPassword(rs.getString("password"));
				acc.setName(rs.getString("name"));
				acc.setEmail(rs.getString("email"));

				return acc;
			} else {
				System.out.println("Warning: No Employee by that id: " + userID);
				return null;
			}
		} catch (SQLException e) {
			System.out.println("There was an error creating account.");
			return null;
		}
	}

	@Override
	public List<Account> getAllEmployees() {
		Account acc = null;
		try (Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM Users WHERE type=" + UType.EMPLOYEE;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			List<Account> accounts = new LinkedList<>();

			while (rs.next()) {
				acc = new Account();
				acc.setUserID(rs.getInt("userID"));
				acc.setUserName(rs.getString("username"));
				acc.setPassword(rs.getString("password"));
				acc.setName(rs.getString("name"));
				acc.setEmail(rs.getString("email"));

				accounts.add(acc);
			}
			return accounts;
		} catch (SQLException e) {
			System.out.println("There was an error creating account.");
			return null;
		}
	}

	@Override
	public List<Account> getAllAccounts() {

		Account acc = null;
		try (Connection conn = ConnectionFactory.getConnection()) {
			String sql = "SELECT * FROM Users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			List<Account> accounts = new LinkedList<>();

			while (rs.next()) {
				acc = new Account();
				acc.setUserID(rs.getInt("userID"));
				acc.setUserName(rs.getString("username"));
				acc.setPassword(rs.getString("password"));
				acc.setName(rs.getString("name"));
				acc.setEmail(rs.getString("email"));

				accounts.add(acc);
			}
			return accounts;
		} catch (SQLException e) {
			System.out.println("There was an error creating account.");
			return null;
		}
	}

	@Override
	public boolean isAccount(String userID) {
		// TODO Auto-generated method stub
		return false;
	}

	// ===============================
	// UPDATE
	// ===============================

	@Override
	public void updateAccount(String userName, String name, String password, String email) {
		// TODO Auto-generated method stub

	}

	// ===============================
	// DELETE
	// ===============================

	@Override
	public void deleteAccount(String userName) {
		// TODO Auto-generated method stub

	}

}
