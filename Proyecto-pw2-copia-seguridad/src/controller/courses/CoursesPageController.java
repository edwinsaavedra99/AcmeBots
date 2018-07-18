package controller.courses;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import controller.PMF;
import model.entity.*;
@SuppressWarnings("serial")
public class CoursesPageController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		resp.setContentType("text/html"); resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		  try{
	    	  PersistenceManager pm = PMF.get().getPersistenceManager();
	    	  UserService us = UserServiceFactory.getUserService();
	  		  com.google.appengine.api.users.User user = us.getCurrentUser();
	  		  if(user == null) {
	  			  System.out.println("no login");
	  			req.getRequestDispatcher("/WEB-INF/Views/Errores/login.jsp").forward(req, resp);
	  		  }else {
	  			String query1 = "select from " + User.class.getName() + " where email == '"+user.getEmail()+"'"+"&& status==true"; 
				List<User> userSearch = (List<User>) pm.newQuery(query1).execute();
	  			if(userSearch.isEmpty()) {
	  				System.out.println("no registrado");
	  				req.getRequestDispatcher("/WEB-INF/Views/Errores/login.jsp").forward(req, resp);
	  			}else{
	  				String query2 = "select from " + Resource.class.getName()+ " where url == '"+req.getServletPath()+"'"+"&& status == true"; 
		  			List<Resource> rSearch = (List<Resource>) pm.newQuery(query2).execute();
		  			if(rSearch.isEmpty()) {
		  				req.getRequestDispatcher("/WEB-INF/Views/Errores/error6.jsp").forward(req, resp);
			    	}else {
			    		String query3 = "select from " + Access.class.getName()+ 
			    				" where idRole =="+ userSearch.get(0).getIdRole()+
			    				" && idResource =="+rSearch.get(0).getId()+
			    				" && status==true"; 
			    		List<Access> aSearch = (List<Access>) pm.newQuery(query3).execute();
				    	if(aSearch.isEmpty()) {
				    		req.getRequestDispatcher("/WEB-INF/Views/Errores/error6.jsp").forward(req, resp);
				    	}else {	
				    		//-------------------------------------------------------container
							String query = "select from " + Courses.class.getName(); 
							List<Courses> courses = (List<Courses>) pm.newQuery(query).execute();
							req.setAttribute("courses", courses);		  
							try{
								resp.setContentType("text/html"); resp.setCharacterEncoding("UTF-8");
								req.getRequestDispatcher("/WEB-INF/Views/Courses/index2.jsp").forward(req, resp);          
							}catch(Exception ex){
								out.println(ex.getMessage()); 
							}
							//-------------------------------------------------------
				    	}
			    	} 
	  			}
		}
	}catch(Exception ex){
		out.println(ex.getMessage()); 
	}	  
	}
}
