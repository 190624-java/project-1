package dao;

import java.util.List;

import beans.Reimbursement;
import beans.User;

public interface ReimbursementDAO {

	public Reimbursement createReimbursement(Reimbursement reim);
	public List<Reimbursement> getAllReimbursementsByUser(User u);
	public Reimbursement getReimbursement(int reim_id);
	public List<Reimbursement> getAllUnresolvedReimbursements();
	public List<Reimbursement> getAllResolvedReimbursements();
}
