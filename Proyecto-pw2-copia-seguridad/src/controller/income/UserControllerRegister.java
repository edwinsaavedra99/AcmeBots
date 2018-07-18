package controller.income;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import controller.PMF;
import model.entity.*;

@SuppressWarnings("serial")
public class UserControllerRegister extends HttpServlet {	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		resp.setContentType("text/html"); resp.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/WEB-INF/Views/Errores/login.jsp").forward(req, resp); 
		req.getRequestDispatcher("/income/register").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html"); resp.setCharacterEncoding("UTF-8");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		//el rol de usuario
		String query1 = "select from " + Role.class.getName() + " where nameRole == '"+"Usuario"+"'"+"&& status==true"; 
		List<Role> roles = (List<Role>) pm.newQuery(query1).execute();
		
			User u=new User(
					roles.get(0).getId(),
					req.getParameter("name"),
					req.getParameter("lastName"),
					req.getParameter("email"),
					req.getParameter("phone"),
					req.getParameter("address"),
					true
					);
			u.setUserName(req.getParameter("userName"));
			try{		
				pm.makePersistent(u);
				resp.sendRedirect("/index.html");	
			}catch(Exception e){
				System.out.println(e);
				resp.getWriter().println("Ocurrio un error, <a href='/users'>regresar</a>");
			}finally{
				pm.close();
			}		
		
		
	}
}