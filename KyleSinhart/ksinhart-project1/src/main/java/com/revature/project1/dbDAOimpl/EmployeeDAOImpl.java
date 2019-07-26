package com.revature.project1.dbDAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project1.beans.Employee;
import com.revature.project1.dao.EmployeeDAO;
import com.revature.project1.service.ConnectionFactory;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public Employee createEmployee(Employee e) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "INSERT INTO employee (fname,lname,pass,emp_email,is_admin, hometown, phone) VALUES (?,?,?,?,?,?,?)";
			String[] primaryKeyValues = {"emp_id"};
			
			PreparedStatement prep=conn.prepareStatement(sql, primaryKeyValues);
			prep.setString(1, e.getFname());
			prep.setString(2, e.getLname());
			prep.setString(3, e.getPass());
			prep.setString(4, e.getEmail());
			prep.setInt(5, e.getIsAdminNum());
			prep.setString(6, e.getHometown());
			prep.setInt(7, e.getPhone());
			
			prep.executeUpdate();
			
			ResultSet rset = prep.getGeneratedKeys();
			
			while(rset.next()) {
				e.setEmp_id(rset.getInt(1));
			}
			return e;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployee(String email) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT emp_id,fname,lname,pass,emp_email,is_admin, hometown, phone FROM employee WHERE emp_email = ?";
			
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setString(1, email);
			
			ResultSet rset = prep.executeQuery();
			
			Employee e = null;
			while(rset.next()) {
				int emp_id = rset.getInt("emp_id");
				String fname = rset.getString("fname");
				String lname= rset.getString("lname");
				String pass= rset.getString("pass");
				String emailQ= rset.getString("emp_email");
				int isAdminNum= rset.getInt("is_admin");
				String hometown= rset.getString("hometown");
				int phone= rset.getInt("phone");
				
				e=new Employee(emp_id,fname,lname,pass,emailQ,isAdminNum,hometown,phone);
				//System.out.println(e.toString());
			}
			if(e==null) {
				return new Employee(false);
			}
			else {
				return e;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return new Employee(false);
		}
	}
	
	@Override
	public Employee getEmployee(int id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM employee WHERE emp_id = ?";
			
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, id);
			
			ResultSet rset = prep.executeQuery();
			
			Employee e = null;
			
			while(rset.next()) {
				int emp_id = rset.getInt("emp_id");
				String fname = rset.getString("fname");
				String lname= rset.getString("lname");
				String pass= rset.getString("pass");
				String emailQ= rset.getString("emp_email");
				int isAdminNum= rset.getInt("is_admin");
				String hometown= rset.getString("hometown");
				int phone= rset.getInt("phone");
				
				e=new Employee(emp_id,fname,lname,pass,emailQ,isAdminNum,hometown,phone);
			}
			
			return e;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	
	@Override
	public Employee updateEmployee(String hometown, int phone, Employee e) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "UPDATE employee SET hometown=?, phone=? WHERE emp_id=?";
			
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setString(1, hometown);
			prep.setInt(2, phone);
			prep.setInt(3, e.getEmp_id());
			
			prep.executeUpdate();
			
			e.setHometown(hometown);
			e.setPhone(phone);
			
			return e;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<Employee> getEmployeeList() {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM employee";
			
			PreparedStatement prep = conn.prepareStatement(sql);
			
			ResultSet rset = prep.executeQuery();
			
			ArrayList<Employee> eList = new ArrayList<Employee>();
			while(rset.next()) {
				int emp_id = rset.getInt("emp_id");
				String fname = rset.getString("fname");
				String lname= rset.getString("lname");
				String pass= rset.getString("pass");
				String emailQ= rset.getString("emp_email");
				int isAdminNum= rset.getInt("is_admin");
				String hometown= rset.getString("hometown");
				int phone= rset.getInt("phone");
				
				eList.add(new Employee(emp_id,fname,lname,pass,emailQ,isAdminNum,hometown,phone));
			}
			return eList;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteEmployee(Employee e) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "DELETE FROM employee WHERE";
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
