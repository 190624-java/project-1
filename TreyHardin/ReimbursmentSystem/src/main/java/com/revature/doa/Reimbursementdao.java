package com.revature.doa;

import java.sql.Connection;
import java.util.List;

//import com.revature.beans.Receipt;
import com.revature.beans.Reimbursement;

public interface Reimbursementdao {
	
	
	Reimbursement createReimbursement(double amount, int userId, Connection con);
	Reimbursement getReimbursement(int id, Connection con);
	List<Reimbursement> getReimbursement(boolean status, Connection con);
	Reimbursement updateReimbursement(Reimbursement reim, Connection con);
	
	//Receipt createReciept(int reimId, String blob, Connection con);
	//List<Receipt> getReceipts> (int reimId, Connection con);

}
