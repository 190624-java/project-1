package com.revature.project1.dbDAOimpl;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import com.revature.project1.beans.Receipt;
import com.revature.project1.dao.ReceiptDAO;
import com.revature.project1.service.ConnectionFactory;

import oracle.sql.BLOB;

public class ReceiptDAOImpl implements ReceiptDAO{

	@Override
	public Receipt createReceipt(Receipt rec, InputStream is) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "INSERT INTO receipt_records (re_id,amount,v_name,photo) VALUES (?,?,?,?)";
			String[] primaryKeyValues = {"rec_id"};
			
			PreparedStatement prep=conn.prepareStatement(sql, primaryKeyValues);
			prep.setInt(1, rec.getRe_id());
			prep.setDouble(2, rec.getAmount());
			prep.setString(3, rec.getVendor_name());
//			
			if (is != null) {
                // fetches input stream of the upload file for the blob column
                prep.setBlob(4, is);
            }
			
			prep.executeUpdate();
			
			ResultSet rset = prep.getGeneratedKeys();
			
			while(rset.next()) {
				int rec_id = rset.getInt(1);
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
				//Blob blob =  rset.getBlob("photo");
				//byte[] bytes = blob.getBytes(1, (int) blob.length());
				
				recObj = new Receipt(rec_id, re_id,amount,v_name);
				//recObj.setBytes(bytes);
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
				//Blob blob =  rset.getBlob("photo");
				
				Receipt rec = new Receipt(rec_id, re_id,amount,v_name);
				//rec.setPhoto(blob);
				recList.add(rec);
				
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
