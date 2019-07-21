package dbDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import beans.Reimbursement;
import beans.User;
import dao.ReimbursementDAO;
import rev.project1.ConnectionFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO{
	public Reimbursement createReimbursement(Reimbursement re)
	{
		try(Connection conn = ConnectionFactory.getConnection())
		{
			String sql = "INSERT INTO reimbursements(user_id, resolved, time_stamps) " + "VALUES(?, ?, TO_DATE(?))";
			String[] primaryKeyValues = {"req_id"};
			PreparedStatement stmt = conn.prepareStatement(sql, primaryKeyValues);
			stmt.setInt(1, re.getUID());
			stmt.setInt(2, re.getResolved());
			stmt.setString(3, re.getTimeStamp());
			
			int rowsAffected = stmt.executeUpdate();
			ResultSet keys = stmt.getGeneratedKeys();
			while(keys.next())
			{
				int reim_id = keys.getInt("req_id");
				re.setRID(reim_id);
			}
			return re;
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public Reimbursement getReimbursement(int reim_id)
	{
		try(Connection conn = ConnectionFactory.getConnection())
		{
			String sql = "SELECT * FROM reimbursements WHERE reim_id = ?";
			String[] primaryKeyValues = {"req_id"};
			PreparedStatement stmt = conn.prepareStatement(sql, primaryKeyValues);
			stmt.setInt(1, reim_id);
			
			ResultSet results = stmt.executeQuery();
			Reimbursement r = null;
			while(results.next())
			{
				int re_id = results.getInt("req_id");
				int u_id = results.getInt("user_id");
				int res = results.getInt("resolved");
				r = new Reimbursement(re_id, u_id, res, null);
			}
			return r;
		}catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public List<Reimbursement> getAllReimbursementsByUser(User u)
	{
		try(Connection conn = ConnectionFactory.getConnection())
		{
			String sql = "SELECT * FROM reimbursements " + "WHERE user_id = ? ";
			String[] primaryKeyValues = {"req_id"};
			PreparedStatement stmt = conn.prepareStatement(sql, primaryKeyValues);
			stmt.setInt(1, u.getUID());
			ResultSet results = stmt.executeQuery();
			List<Reimbursement> reimList = new ArrayList<Reimbursement>();
			while(results.next())
			{
				int reim_id = results.getInt("req_id");
				int u_id = results.getInt("user_id");
				int res = results.getInt("resolved");
				reimList.add(new Reimbursement(reim_id, u_id, res, null));
			}
			return reimList;
		}catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public List<Reimbursement> getAllUnresolvedReimbursements()
	{
		try(Connection conn = ConnectionFactory.getConnection())
		{
			String sql = "SELECT * FROM reimbursements " + "WHERE resolved = 0";
			String[] primaryKeyValues = {"req_id"};
			PreparedStatement stmt = conn.prepareStatement(sql, primaryKeyValues);
			ResultSet results = stmt.executeQuery();
			List<Reimbursement> unresolvedReimbursementList = new LinkedList<Reimbursement>();
			while(results.next())
			{
				int reim_id = results.getInt("req_id");
				int u_id = results.getInt("user_id");
				int res = results.getInt("resolved");
				unresolvedReimbursementList.add(new Reimbursement(reim_id, u_id, res, null));
			}
			return unresolvedReimbursementList;
		}catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public List<Reimbursement> getAllResolvedReimbursements()
	{
		try(Connection conn = ConnectionFactory.getConnection())
		{
			String sql = "SELECT * FROM reimbursements WHERE resolved = 1 " + "ORDER BY time_stamps";
			String[] primaryKeyValues = {"req_id"};
			PreparedStatement stmt = conn.prepareStatement(sql, primaryKeyValues);
			ResultSet results = stmt.executeQuery();
			List<Reimbursement> resolvedReimbursements = new LinkedList<Reimbursement>();
			while(results.next())
			{
				int reim_id = results.getInt("req_id");
				int u_id = results.getInt("user_id");
				int res = results.getInt("resolved");
				resolvedReimbursements.add(new Reimbursement(reim_id, u_id, res, null));
			}
			return resolvedReimbursements;
		}catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public Reimbursement resolveReimbursement(Reimbursement r)
	{
		try(Connection conn = ConnectionFactory.getConnection())
		{
			String sql = "UPDATE reimbursements " + "SET resolved = 1 " + "WHERE req_id = ?";
			String[] primaryKeyValues = {"req_id"};
			PreparedStatement stmt = conn.prepareStatement(sql, primaryKeyValues);
			stmt.setInt(1, r.getRID());
			int rowsAffected = stmt.executeUpdate();
			return r;
		}catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
