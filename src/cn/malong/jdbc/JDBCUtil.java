package cn.malong.jdbc;
/*
 * Jdbc的工具类*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * 
 * import com.mysql.jdbc.Statement;和import java.sql.Statement;有什么不一样
 * 
 * 在写程序时在源代码中导入java.sql包，在连接数据库的时候代码中要使用com.mysql.jdbc驱动，
 * 但是如果你是用Eclipse开发的话，在构建路径中要手动导入mysql的连接驱动。
 * java.sql里面封装的是类可以支持所有jdbc规范的数据库软件，如duoracle和sqlserver等。
使用java.sql不存在兼zhi容性问题dao。
com.mysql.jdbc 是专门针对mysql 优化过的
 * */


public class JDBCUtil {
	
	/*
	 * 静态块：服务启动时，执行，并且只会执行一次*/
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 获取连接
	 * 方法中的方法不要用try和catch
	 * 要向上抛*/
	public  Connection  getConn() throws SQLException{
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","8888");
		return connection;
	}
	
	/*
	 *关闭连接*/
	
	public  void  close(ResultSet rs,Statement st,Connection conn){
		try { 
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(st != null){
					st.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if(conn != null){
						conn.close();
					}	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
