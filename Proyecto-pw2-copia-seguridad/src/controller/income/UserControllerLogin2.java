package controller.income;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


@SuppressWarnings("serial")
public class UserControllerLogin2 extends HttpServlet {	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		UserService us = UserServiceFactory.getUserService();
		com.google.appengine.api.users.User user = us.getCurrentUser();
		if(user == null){
			resp.sendRedirect(us.createLoginURL("/login"));
		}else {
			resp.sendRedirect(us.createLoginURL("/index.html"));
		}
	}
}
