package com.revature.dbDAOimpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.doa.Reimbursementdao;

public class ReimbursementImpl implements Reimbursementdao {

	@Override
	public Reimbursement createReimbursement(double amount, int userId, Connection con) {
		try {
			 //2. Create a statement.
				String sql = "INSERT INTO reimbursements(employ_id, reimbursment)"
						+"VALUES (?, ?)";
				String[] primaryKeyValues = {"reimbursment_id"};
				PreparedStatement stmt = con.prepareStatement(sql, primaryKeyValues);
				stmt.setInt(1, userId);
				stmt.setDouble(2, amount);
	        
				//3. Executing the statement
				stmt.executeUpdate();
	        
				//4. get id
				ResultSet keys = stmt.getGeneratedKeys();
				Reimbursement reim = new Reimbursement(userId, amount);
				while(keys.next()) 
				{
					int reimId = keys.getInt(1);
					reim.setReimbursmentId(reimId);
				}
				return reim;
		} 
		
		catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	    }
	}

	@Override
	public Reimbursement getReimbursement(int id, Connection con) {
		try {
			String sql = "Select * from reimbursements Where reimbursment_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet results = stmt.executeQuery();
			Reimbursement reim = null; 
			
			while(results.next()) {
				int employId = results.getInt("employ_id");
				int managerId = results.getInt("manager_id");
				double amount = results.getDouble("reimbursment");
				boolean approved = results.getInt("approved")==1;
				reim = new Reimbursement(id, employId, managerId, amount, approved);
			}
			
			return reim;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Reimbursement> getReimbursement(boolean status, Connection con) {
		
		int approve = 0;
		
		if(status) {
			approve = 1;
		}
		
		try {
			String sql = "Select * From reimbursements Where approved = " + approve;
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet results = stmt.executeQuery();
			List<Reimbursement> reim = new ArrayList<>(); 
			
			while(results.next()) {
				int id = results.getInt("reimbursement_id");
				int employId = results.getInt("employ_id");
				int managerId = results.getInt("manager_id");
				double amount = results.getDouble("reimbursment");
				boolean approved = results.getInt("approved")==1;
				reim.add(new Reimbursement(id, employId, managerId, amount, approved));
			}
			
			return reim;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement reim, Connection con) {
		
		int approved = 0;
		if(reim.isApproved()) {
			approved = 1;
		}
		
		try {
			String sql = "Updatate reimbursement Set manager_id = ?, approved = ? Where reimbursement_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, reim.getManagerId());
			stmt.setInt(2, approved);
			stmt.setInt(3, reim.getReimbursmentId());
			
			stmt.executeUpdate();
			
			return reim;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
