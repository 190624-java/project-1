package com.revature.DAOs;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Request;

public interface RequestDAO {

	// CREATE
	/**
	 * Required on Employee page
	 * @param reqAmount
	 * @param description
	 * @param userID
	 * @param status
	 * @throws SQLException
	 */
	public void create(float reqAmount, String description, int userID, int status) throws SQLException;

	// READ
	
	
	/**
	 * Required on Employee page
	 * @param reqID
	 * @return
	 */
	public List<Request> getPersonalPending(int userID);
	
	/**
	 * Required on Employee page
	 * @return
	 */
	public List<Request> getPersonalResolved(int userID);


	/**
	 * Requirement of manager page
	 * Gets PENDING (i.e. not DENIED/APPROVED)
	 * 
	 * @return
	 */
	public List<Request> getPendingRequests();

	/**
	 * Requirement of manager page This is both APPROVED and DENIED types, not
	 * PENDING
	 * 
	 * @return
	 */
	public List<Request> getResolvedRequests();

	// UPDATE

	/**
	 * Required by Manager capability to approve/deny a request. Tip: use
	 * RequestStatus static class members (PENDING, APPROVED, DENIED)
	 * 
	 * @param requestID
	 * @param status
	 */
	public void resolveRequest(int requestID, int status, String resolvingManager);

	public void updateRequest(int requestID, String requestee, float requestAmount, int receiptID, int status);

	// DELETE
	public void deleteRequest(int requestID);

}
