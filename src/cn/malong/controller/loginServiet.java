package cn.malong.controller;
//放的是Serviece，用来获取界面的内容
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.malong.domin.User;
import cn.malong.service.UserService;


@WebServlet("/loginServiet")
public class loginServiet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	//来调用业务层，因为我们不能直接来调用userdao层，因为这是我们写代码的规范
	UserService userService = new UserService();
	//用来接收前台数据
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//处理post请求的乱码，get请求tomcat8以上的版本才会自动处理
		//获取参数  ，我们还要进行输入为空的
		String username = request.getParameter("username"); //用户
		String password = request.getParameter("password"); //密码
		System.out.println("username="+username+"\npassword="+password);
		
		//2.判断账号密码输入的时候匹配，根据密码和账号，在表中查询你的数据，所以我们要创建一张表
		User user = userService.queryUserByUP(username, password);
		if(user == null){
			//没有查到，错误
			System.out.println("账号密码错误");
			//1。跳转login.jsp,并且提示用户信息
			//往前台传递数据，就是提示信息
			request.setAttribute("errMsg", "账号或密码输入错误");
			
			
			//用转发来跳转
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("user", user);
		
		//跳转 重定向 （地址栏发送变化）
		response.sendRedirect("index.jsp");
	}
	 
	

}
