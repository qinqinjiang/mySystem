package struts2.com.wode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

/**
 * struts2连接数据库
 * @author 蒋芹芹
 *
 * 2018年2月8日
 */
public class ConnectDataBase extends ActionSupport{
	private int userId;
	private String userName;
	private String password;
	
	@Override
	public String execute() throws Exception {
		String res = ERROR;
		Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost/test";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root","root");
			String sql ="select * from users where userName = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				userName = rs.getString("userName");
				System.out.println(userName);
				res = SUCCESS;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res = ERROR;
		}finally{
			if (conn != null) {
				conn.close();
			}
		}
		return res;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
