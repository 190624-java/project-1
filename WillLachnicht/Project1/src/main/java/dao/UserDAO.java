package dao;

import java.util.List;

import beans.User;

public interface UserDAO {
	public User getUser(int user_id);
	public User createUser(User u);
	public List<User> getAllUsersByType(String empType);
	public List<User> getAllUsers();
	public void updateUserInfo(User u);
	public User getUserByUsername(String username);
}
