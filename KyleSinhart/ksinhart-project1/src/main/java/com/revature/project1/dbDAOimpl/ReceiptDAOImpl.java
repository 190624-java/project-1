package com.revature.project1.dbDAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project1.beans.Receipt;
import com.revature.project1.dao.ReceiptDAO;
import com.revature.project1.service.ConnectionFactory;

public class ReceiptDAOImpl implements ReceiptDAO{

	@Override
	public Receipt createReceipt(Receipt rec) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "INSERT INTO receipt records (re_id,amount,v_name) VALUES (?,?,?)";
			String[] primaryKeyValues = {"rec_id"};
			
			PreparedStatement prep=conn.prepareStatement(sql, primaryKeyValues);
			prep.setInt(1, rec.getRe_id());
			prep.setDouble(2, rec.getAmount());
			prep.setString(3, rec.getVendor_name());
			
			prep.executeUpdate();
			
			ResultSet rset = prep.getGeneratedKeys();
			
			while(rset.next()) {
				int rec_id = rset.getInt("rec_id");
				rec.setRec_id(rec_id);
			}
			return rec;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Receipt getReceipt(int rec) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT rec_id,re_id,amount,v_name FROM receipt_records WHERE rec_id = ?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, rec);
			
			ResultSet rset = prep.executeQuery();
			
			Receipt recObj = null;
			while(rset.next()) {
				int rec_id = rset.getInt("rec_id");
				int re_id = rset.getInt("re_id");
				double amount = rset.getDouble("amount");
				String v_name = rset.getString("v_name");
				
				recObj = new Receipt(rec_id, re_id,amount,v_name);
			}
			return recObj;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Receipt> getReceiptList(int re) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT rec_id,re_id,amount,v_name FROM receipt_records WHERE re_id = ?";
			
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, re);
			
			ResultSet rset = prep.executeQuery();
			
			ArrayList<Receipt> recList = new ArrayList<Receipt>();
			while(rset.next()) {
				int rec_id = rset.getInt("rec_id");
				int re_id = rset.getInt("re_id");
				double amount = rset.getDouble("amount");
				String v_name = rset.getString("v_name");
				
				recList.add(new Receipt(rec_id, re_id,amount,v_name));
			}
			return recList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteReceipt(Receipt rec) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "DELETE FROM receipt_records WHERE rec_id = ?";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
