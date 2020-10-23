package cn.malong.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.malong.domin.User;

/**
 * 这里面我写的是修改密码的界面控制
 */
@WebServlet("/PasswordServliet")
public class PasswordServliet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//处理post请求的乱码，get请求tomcat8以上的版本才会自动处理
		String oldPassword = request.getParameter("oldPassword"); //旧密码
		String newpassword = request.getParameter("newPassword"); //新密码
		String reNewPassword = request.getParameter("reNewPassword"); //确认密码
		System.out.println("原密码="+oldPassword+"新密码"+newpassword+"确认密码="+reNewPassword);
		//获取到登录界面的代码。
		User user = (User) request.getSession().getAttribute("user");
		String password = user.getUserpassword();
		int  id = user.getId();
		System.out.println("password+"+password+"id="+id);
		System.out.println("我这里看看就是");
		if(oldPassword.equals(password) && newpassword.equals(reNewPassword)){
			
		}else{
			request.setAttribute("errMsg", "旧密码和之前的不一样或者新密码确认不一致");
			//用转发来跳转
			request.getRequestDispatcher("password.jsp").forward(request, response);
			return;
		}
		
	}

}
