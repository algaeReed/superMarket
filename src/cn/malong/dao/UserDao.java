package cn.malong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.malong.domin.User;
import cn.malong.jdbc.JDBCUtil;

//连接数据库的类
public class UserDao {
	
	//1注册驱动
	JDBCUtil jdbc = new JDBCUtil();
	
	public User queryUserByUP(String username , String password){
		String sql = "select * from xy_user where userName = '"+username+"' and userpassword = '"+password+"'";
		Connection conn =  null;
		Statement st =  null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = jdbc.getConn();//获取连接
			st = conn.createStatement();//创建SQL执行对象
			//执行sql命令
		    rs = st.executeQuery(sql);
		  
		    
		    while(rs.next()){
		    	int id = rs.getInt("id");
		    	String userId = rs.getString("userId");
		    	String userName = rs.getString("userName");
		    	String userpassword = rs.getString("userpassword");
		    	String sex = rs.getString("sex");
		    	String userData = rs.getString("userData");
		        String userphone = rs.getString("userphone");
		    	String userAddress= rs.getString("userAddress");
		    	String userlei= rs.getString("userlei");
		        user = new  User(id,  userId,userName,  userpassword,  sex,  userData,userphone,  userAddress, userlei);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbc.close(rs, st, conn);
		}
		return user;
	}
	
	//这个是查询数据库中的所有数据，
	public  List<User>  querAllUserInfo(){
		String sql = "select * from xy_user";
		Connection conn = null;
		Statement st =  null;
		ResultSet rs = null;
		List<User> list = new  ArrayList<>();
		
		try {
			 conn = jdbc.getConn();
			 st = conn.createStatement();
			 rs = st.executeQuery(sql);
			 while(rs.next()){
			    	int id = rs.getInt("id");
			    	String userId = rs.getString("userId");
			    	String userName = rs.getString("userName");
			    	String userpassword = rs.getString("userpassword");
			    	String sex = rs.getString("sex");
			    	String userData = rs.getString("userData");
			        String userphone = rs.getString("userphone");
			    	String userAddress= rs.getString("userAddress");
			    	String userlei= rs.getString("userlei");
			        User user = new  User(id,  userId,userName,  userpassword,  sex,  userData,userphone,  userAddress, userlei);
			        list.add(user);//向集合添加数据
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbc.close(rs, st, conn);
		}
		return list;
	}
	/*
	 * 根据id删除用户
	 * */
	
	public void deleteUserById(int id){
		String sql = "delete from xy_user where id = ?";
		Connection conn = null;
		PreparedStatement pst =  null;
		try {
			conn = jdbc.getConn();
		    pst = conn.prepareStatement(sql);  //创建的时候来执行sql命令
		    pst.setInt(1, id);  //给问好设置数值
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbc.close(null, pst, conn);
		}
	}
	
	
	//保存数据
	public void addUser(User user){
		Connection conn = null;
		PreparedStatement pst =  null;
		String sql = "insert into xy_user(userId,userName,userpassword,sex,userData,userphone,userAddress,userlei) values(?,?,?,?,?,?,?,?)";

		try {
			 conn = jdbc.getConn();
			 pst = conn.prepareStatement(sql);
			 pst = conn.prepareStatement(sql);
			 pst.setString(1, user.getUserId());
			 pst.setString(2, user.getUserName());
			 pst.setString(3, user.getUserpassword());
			 pst.setString(4, user.getSex());
			 pst.setString(5, user.getUserData());
			 pst.setString(6, user.getUserphone());
			 pst.setString(7, user.getUserAddress());
			 pst.setString(8, user.getUserlei());
			 pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//根据id查询信息
	public User queryUserById(int id){
		String sql = "select * from xy_user where id =?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs =  null;
		User user = null;
		try {
			 conn = jdbc.getConn();
			 pst = conn.prepareStatement(sql);
			 pst.setInt(1,id); //设置问号的值
			 rs = pst.executeQuery();
			
			while(rs.next()){
		    	//int id = rs.getInt("id");
		    	String userId = rs.getString("userId");
		    	String userName = rs.getString("userName");
		    	String userpassword = rs.getString("userpassword");
		    	String sex = rs.getString("sex");
		    	String userData = rs.getString("userData");
		        String userphone = rs.getString("userphone");
		    	String userAddress= rs.getString("userAddress");
		    	String userlei= rs.getString("userlei");
		        user = new  User(id,  userId,userName,  userpassword,  sex,  userData,userphone,  userAddress, userlei);
		        
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbc.close(null, pst, conn);
		}
		return user;
	}
	
	public void updateUser(User user){
		String sql = "update xy_user set userName = ?,sex = ?,userData = ?,userphone = ?,userAddress = ? where id = ?";
		Connection conn =  null;
		PreparedStatement pst =  null;
		try {
			 conn = jdbc.getConn();
			 pst = conn.prepareStatement(sql);
			 pst.setString(1, user.getUserName());
			 pst.setString(2, user.getSex());
			 pst.setString(3, user.getUserData());
			 pst.setString(4, user.getUserphone());
			 pst.setString(5, user.getUserAddress());
			 pst.setInt(6, user.getId());
			 pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbc.close(null,pst, conn);
		}
	}
}
