package com.revature.DAOs;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.exceptions.NonexistantUser;

public interface AccountDAO {

	// ===============================
	// CREATE
	// ===============================
	public void create(String userName, String password, int type, String name, String email) throws SQLException;

	// ===============================
	// READ
	// ===============================

	/**
	 * Req on Manager Page
	 * @return
	 */
	public List<Account> getAllEmployees();

	/**
	 * Required on Employee Page, but is one of 2 methods.<br>
	 * 
	 * @param userID
	 * @return
	 */
	public Account getAccount(int userID);

	/**
	 * Required on Employee Page, but is one of 2 methods.<br>
	 * 
	 * @param userName
	 * @return
	 * @throws NonexistantUser
	 */
	public Account getAccount(String userName) throws NonexistantUser;

	/**
	 * Not Required
	 * @return
	 */
	public List<Account> getAllAccounts();

	public boolean isAccount(String userID);

	// ===============================
	// UPDATE
	// ===============================

	public void updateAccount(String userName, String name, String password, String email);

	// ===============================
	// DELETE
	// ===============================
	public void deleteAccount(String userName);

}
