package cn.malong.service;
import java.util.List;

//业务层
import cn.malong.dao.UserDao;
import cn.malong.domin.User;

public class UserService {
	
	UserDao  userDao = new UserDao();
	
	//他也是调用dao中的方法
	public User queryUserByUP (String username,String password){
		User user = userDao.queryUserByUP(username, password);
		return user;
	}
	
	//就是为了调用dao中的查询数据库中的所有数据
	public  List<User>  querAllUserInfo(){
		List<User> list = userDao.querAllUserInfo();
		return list;
	}
	
	public void deleteUserById( int   id){
		userDao.deleteUserById(id);
	}
	
	public void addUser(User user){
		userDao.addUser(user);
	}
	public User queryUserById(int id){
		return userDao.queryUserById(id);
	}
	public void updateUser(User user){
		userDao.updateUser(user);
	}
	
}
