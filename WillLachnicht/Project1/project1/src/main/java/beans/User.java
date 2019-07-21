package beans;

public class User {

	private int user_id;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String gender;
	private String address;
	private String empType;
	
	User(){}
	
	public User(int UID, String uN, String p, String fn, String ln, String g, String add, String empType)
	{
		super();
		this.user_id = UID;
		this.username = uN;
		this.password = p;
		this.first_name = fn;
		this.last_name = ln;
		this.gender = g;
		this.address = add;
		this.empType = empType;
	}
	
	public int getUID()
	{
		return this.user_id;
	}
	
	public void setUID(int UID)
	{
		this.user_id = UID;
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public void setUsername(String name)
	{
		this.username = name;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setPassword(String pass)
	{
		this.password = pass;
	}
	
	public String getFirstName()
	{
		return this.first_name;
	}
	
	public void setFirstName(String fn)
	{
		this.first_name = fn;
	}
	
	public String getLastName()
	{
		return this.last_name;
	}
	
	public void setLastName(String ln)
	{
		this.last_name = ln;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public void setAddress(String add)
	{
		this.address = add;
	}
	
	public String getGender()
	{
		return this.gender;
	}
	
	public void setGender(String g)
	{
		this.gender = g;
	}
	
	public String getEmpType()
	{
		return this.empType;
	}
	
	public void setEmpType(String emp)
	{
		this.empType = emp;
	}
}
