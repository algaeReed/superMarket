package cn.malong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.malong.domin.User;
import cn.malong.service.UserService;
//通过点击用户管理就会跳转，这个用户管理的界面控制管理器

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userService = new  UserService();
	
	//获取删除点击的id
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//处理post请求的乱码，get请求tomcat8以上的版本才会自动处理
		String cmd = request.getParameter("cmd");
		String id = request.getParameter("id");
		if("delete".equals(cmd)){
		//删除
			userService.deleteUserById(Integer.valueOf(id));
		}else if("add".equals(cmd)){
		//新增
			String userId = request.getParameter("userId");
			String userName = request.getParameter("userName");
			String userpassword = request.getParameter("userpassword");
			String sex = request.getParameter("sex");
			String data = request.getParameter("data");
			String userphone = request.getParameter("userphone");
			String userAddress = request.getParameter("userAddress");
			String userlei = request.getParameter("userlei");
			
			if("woman".equals(sex)){
				sex = "女";
			}else{
				sex = "男";
			}
			
			User user = new User(userId, userName, userpassword, sex, data, userphone, userAddress, userlei);
			//保存操作
			userService.addUser(user);
			
		}else if("edit".equals(cmd)){
			//编辑，根据id铲鲟信息，返回userUodata页面
			User user = userService.queryUserById(Integer.valueOf(id));
			request.setAttribute("user", user); //重后台往前台传递数据
			request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
			return;
		}else if("update".equals(cmd)){
			String userName = request.getParameter("userName");
			String sex = request.getParameter("sex");
			String data = request.getParameter("data");
			String userphone = request.getParameter("userphone");
			String userAddress = request.getParameter("userAddress");
			System.out.println("id= " +id);
			System.out.println("userphone"+userphone);
			if("woman".equals(sex)){
				sex = "女";
			}else{
				sex = "男";
			}
			//更新
			User user = new User(Integer.valueOf(id), userName, sex, data, userphone, userAddress);
			userService.updateUser(user);
			
		}
		
		//1.查询所有的用户信息
		List<User> userList = userService.querAllUserInfo();
		System.out.println("userList = "+userList);
		//2.把数据返回页面
		request.setAttribute("userList", userList);
		//3.跳转页面
		request.getRequestDispatcher("userList.jsp").forward(request, response);
		
	}

}
