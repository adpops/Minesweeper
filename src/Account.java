
public class Account 
{
	private String username;
	private String password;
	private int [] highscore = new int [3];
	
	public Account(String username, String password)
	{
		this.username = username;
		this.password = password;
		
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public int getHighscore(int difficulty)
	{
		return highscore[difficulty];
	}
	
	public void setUsername(String newName)
	{
		username = newName;
	}
	
	public void setPassword(String newPassword)
	{
		password = newPassword;
	}
	
	public void setHighscore(int difficulty, int score)
	{
		highscore[difficulty] = score;
	}
}
