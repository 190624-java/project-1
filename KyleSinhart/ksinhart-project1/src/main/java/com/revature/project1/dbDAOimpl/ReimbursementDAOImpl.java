package com.revature.project1.dbDAOimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project1.beans.Employee;
import com.revature.project1.beans.Reimbursement;
import com.revature.project1.dao.ReimbursementDAO;
import com.revature.project1.service.*;

public class ReimbursementDAOImpl implements ReimbursementDAO{

	@Override
	public Reimbursement createReimbursement(Reimbursement re) {
		
		try(Connection conn=ConnectionFactory.getConnection()){
		
			String sql="INSERT INTO reimbursement (emp_id,re_status,amount,date_of,re_description) VALUES (?,?,?,?,?)";
			//get generated keys
			String[] primaryKeyValues = { "re_id" };
			
			PreparedStatement prep=conn.prepareStatement(sql,primaryKeyValues);
			
			prep.setInt(1,re.getEmp_id());
			prep.setInt(2, re.getRe_status());
			prep.setDouble(3, re.getAmount());
			prep.setString(4, re.getDate_of());
			prep.setString(5, re.getDescription());
			
			prep.execute();
			
			ResultSet rset = prep.getGeneratedKeys();
			
			while(rset.next()) {
				int id = rset.getInt(1);
				re.setRe_id(id);
				//re.setRe_id(rset.getInt("re_id"));
			}
			System.out.println(re.toString());
			return re;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement getReimbursement(int emp) {
		try(Connection conn=ConnectionFactory.getConnection()){
			String sql="SELECT * FROM reimbursement WHERE emp_id = ?";
			
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, emp);
			
			ResultSet rset = prep.executeQuery();
			
			Reimbursement reObj = null;
			while(rset.next()) {
				int re_id = rset.getInt("re_id");
				int emp_id = rset.getInt("emp_id");
				int re_status = rset.getInt("re_status");
				double amount = rset.getDouble("amount");
				String date_of  = rset.getString("date_of");
				String re_des = rset.getString("re_description");
				int manager_id = rset.getInt("manager_id");
				
				reObj = new Reimbursement(re_id,emp_id,re_status,amount,date_of,re_des,manager_id);
			}
			return reObj;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Reimbursement> getReimbursementList(int status) {
		try(Connection conn=ConnectionFactory.getConnection()){
			String sql="SELECT * FROM reimbursement WHERE re_status = ?";
			
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, status);
			
			ResultSet rset = prep.executeQuery();
			
			ArrayList<Reimbursement> reList = new ArrayList<Reimbursement>();
			while(rset.next()) {
				int re_id = rset.getInt("re_id");
				int emp_id = rset.getInt("emp_id");
				int re_status = rset.getInt("re_status");
				double amount = rset.getDouble("amount");
				String date_of  = rset.getString("date_of");
				String re_des = rset.getString("re_description");
				int manager_id = rset.getInt("manager_id");
				
				reList.add(new Reimbursement(re_id,emp_id,re_status,amount,date_of,re_des,manager_id));
			}
			return reList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	
	@Override
	public List<Reimbursement> getReimbursementList(Employee e) {
		try(Connection conn=ConnectionFactory.getConnection()){
			String sql="SELECT * FROM reimbursement WHERE emp_id = ?";
			
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, e.getEmp_id());
			
			ResultSet rset = prep.executeQuery();
			
			ArrayList<Reimbursement> reList = new ArrayList<Reimbursement>();
			while(rset.next()) {
				int re_id = rset.getInt("re_id");
				int emp_id = rset.getInt("emp_id");
				int re_status = rset.getInt("re_status");
				double amount = rset.getDouble("amount");
				String date_of  = rset.getString("date_of");
				String re_des = rset.getString("re_description");
				int manager_id = rset.getInt("manager_id");
				
				reList.add(new Reimbursement(re_id,emp_id,re_status,amount,date_of,re_des,manager_id));
			}
			return reList;
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return null;
	}
	
	@Override
	public void deleteReimbursement(Reimbursement re) {
		try(Connection conn=ConnectionFactory.getConnection()){
			String sql="DELETE FROM reimbursement WHERE re_id = ?";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Reimbursement updateReimbursement(Reimbursement re, Employee m, int status) {
		try(Connection conn=ConnectionFactory.getConnection()){
			String sql = "UPDATE reimbursement SET re_status = ?, manager_id=? WHERE re_id = ?";
			
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, status);
			prep.setInt(2, m.getEmp_id());
			prep.setInt(3, re.getRe_id());
			
			prep.executeUpdate();
			
			re.setRe_status(status);
			re.setManager_id(m.getEmp_id());
			
			return re;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursement() {
		try(Connection conn=ConnectionFactory.getConnection()){
			String sql="SELECT * FROM reimbursement";
			
			PreparedStatement prep = conn.prepareStatement(sql);
			
			ResultSet rset = prep.executeQuery();
			
			ArrayList<Reimbursement> reList = new ArrayList<Reimbursement>();
			while(rset.next()) {
				int re_id = rset.getInt("re_id");
				int emp_id = rset.getInt("emp_id");
				int re_status = rset.getInt("re_status");
				double amount = rset.getDouble("amount");
				String date_of  = rset.getString("date_of");
				String re_des = rset.getString("re_description");
				int manager_id = rset.getInt("manager_id");
				
				reList.add(new Reimbursement(re_id,emp_id,re_status,amount,date_of,re_des,manager_id));
			}
			return reList;
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement getReimbursementbyRe(int re) {
		try(Connection conn=ConnectionFactory.getConnection()){
			String sql="SELECT * FROM reimbursement WHERE re_id = ?";
			
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, re);
			
			ResultSet rset = prep.executeQuery();
			
			Reimbursement reObj = null;
			while(rset.next()) {
				int re_id = rset.getInt("re_id");
				int emp_id = rset.getInt("emp_id");
				int re_status = rset.getInt("re_status");
				double amount = rset.getDouble("amount");
				String date_of  = rset.getString("date_of");
				String re_des = rset.getString("re_description");
				int manager_id = rset.getInt("manager_id");
				
				reObj = new Reimbursement(re_id,emp_id,re_status,amount,date_of,re_des,manager_id);
			}
			return reObj;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
