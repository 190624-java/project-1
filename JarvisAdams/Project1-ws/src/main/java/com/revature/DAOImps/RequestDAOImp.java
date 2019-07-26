package com.revature.DAOImps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.DAOs.RequestDAO;
import com.revature.beans.Account;
import com.revature.beans.Request;
import com.revature.utilities.ConnectionFactory;
import com.revature.utilities.RequestStatus;

public class RequestDAOImp implements RequestDAO {

	// ================================================
	// CREATE
	// ================================================
	@Override
	public void create(float reqAmount, String description, int status, int userID) throws SQLException {
		try (Connection conn = ConnectionFactory.getConnection()) {
			String sql = "INSERT INTO Requests (ReqAmount, Description, Status, UserID) VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			// number, float, string, number
			ps.setFloat(1, reqAmount);
			ps.setString(2, description);
			ps.setInt(3, status);
			ps.setInt(4, userID);
		} catch (SQLException e) {
			System.out.println("Didn't create request.");
			e.printStackTrace();
			throw e;
		}
	}

	// ================================================
	// READ
	// ================================================

	@Override
	public List<Request> getPersonalPending(int userID){
		try (Connection conn = new ConnectionFactory().getConnection()) {
			String sql = "SELECT reqID, reqAmount, description, status FROM Requests WHERE userID="
					+ userID + "AND status=" + RequestStatus.PENDING;	
			/*
			 * SELECT (reqID, reqAmount, description, status) FROM Requests 
			 * WHERE userID=1 AND status=10;	
			 */
					
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			List<Request> reqs = new LinkedList<>();
			Request req = null;
			while (rs.next()) {
				req = new Request(
						rs.getInt("reqID"), 
						rs.getFloat("reqAmount"), 
						rs.getString("description"), 
						RequestStatus.PENDING, 
						userID,
						""
						);
				reqs.add(req);
				
			}
			return reqs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Request> getPersonalResolved(int userID) {
		try (Connection conn = new ConnectionFactory().getConnection()) {
//			String sub_sql = "SELECT reqID, reqAmount, description, status, resolvingManager FROM Requests WHERE userID="
//					+ userID;
//			String sql = "SELECT reqID, reqAmount, description, status, resolvingManager FROM (" + sub_sql + ") WHERE status="
//					+ RequestStatus.ACCEPTED 
//					+ "OR status="
//					+ RequestStatus.REJECTED;
			
			String sql = "SELECT reqID, reqAmount, description, status, resolvingManager FROM Requests WHERE userID="
					+ userID
					+ "AND (status="
					+ RequestStatus.ACCEPTED 
					+ "OR status="
					+ RequestStatus.REJECTED
					+ ")";
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			List<Request> reqs = new LinkedList<>();
			Request req = null;
			while (rs.next()) {
				req = new Request(
						rs.getInt("reqID"), 
						rs.getFloat("reqAmount"), 
						rs.getString("description"), 
						rs.getInt("status"), 
						userID,
						rs.getString("resolvingManager")
						);
				reqs.add(req);
				
			}
			return reqs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

	@Override
	public List<Request> getPendingRequests() {
		try (Connection conn = new ConnectionFactory().getConnection()) {
			String sql = "SELECT (reqID, reqAmount, description, userID) " + "FROM Requests WHERE status="
					+ RequestStatus.PENDING;

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			List<Request> reqs = new LinkedList<>();
			Request req = null;
			while (rs.next()) {
				req = new Request(
						rs.getInt("reqID"), 
						rs.getFloat("reqAmount"), 
						rs.getString("description"), 
						RequestStatus.PENDING, 
						rs.getInt("userID"),
						""
						);
				reqs.add(req);
				
			}
			return reqs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public List<Request> getResolvedRequests() {
		try (Connection conn = new ConnectionFactory().getConnection()) {
			String sql = "SELECT (reqID, reqAmount, description, status, userID, resolvingManager) " 
					+ "FROM Requests WHERE status="
					+ RequestStatus.ACCEPTED 
					+ "OR status="
					+ RequestStatus.REJECTED;
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			List<Request> reqs = new LinkedList<>();
			Request req = null;
			while (rs.next()) {
				req = new Request(
						rs.getInt("reqID"), 
						rs.getFloat("reqAmount"), 
						rs.getString("description"), 
						rs.getInt("status"), 
						rs.getInt("userID"),
						rs.getString("resolvingManager")
						);
				reqs.add(req);
				
			}
			return reqs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	// ================================================
	// UPDATE
	// ================================================

	@Override
	public void resolveRequest(int requestID, int status, String resolvingManager) {
		try(Connection conn = new ConnectionFactory().getConnection()){
			String sql = "UPDATE Users SET status=?, resolvingManager=? WHERE reqID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, requestID);
			ps.setString(3, resolvingManager);
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateRequest(int requestID, String requestee, float requestAmount, int receiptID, int status) {
		// TODO Auto-generated method stub

	}

	// ================================================
	// DELETE
	// ================================================

	@Override
	public void deleteRequest(int requestID) {
		// TODO Auto-generated method stub

	}

}
