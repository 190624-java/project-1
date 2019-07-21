package com.revature.project1.dao;

import java.util.List;

import com.revature.project1.beans.*;

public interface ReceiptDAO {
	
	public Receipt createReceipt(Receipt rec);
	
	public Receipt getReceipt(int rec);
	
	public List<Receipt> getReceiptList(int re);
	
	public void deleteReceipt(Receipt rec);
	
}
