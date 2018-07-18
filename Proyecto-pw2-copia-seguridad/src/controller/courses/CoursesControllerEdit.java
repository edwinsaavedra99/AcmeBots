package controller.courses;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
public class CoursesControllerEdit extends HttpServlet {
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html"); resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		  try{
	    	  PersistenceManager pm = PMF.get().getPersistenceManager();
	    	  UserService us = UserServiceFactory.getUserService();
	  		  com.google.appengine.api.users.User user = us.getCurrentUser();
	  		  if(user == null) {
	  			req.getRequestDispatcher("/WEB-INF/Views/Errores/error1.jsp").forward(req, resp);
	  		  }else {
	  			String query1 = "select from " + User.class.getName() + " where email == '"+user.getEmail()+"'"+"&& status==true"; 
				List<User> userSearch = (List<User>) pm.newQuery(query1).execute();
	  			if(userSearch.isEmpty()) {
	  				req.getRequestDispatcher("/WEB-INF/Views/Errores/error2.jsp").forward(req, resp);
	  			}else{
	  				String query2 = "select from " + Resource.class.getName()+ " where url == '"+req.getServletPath()+"'"+"&& status == true"; 
		  			List<Resource> rSearch = (List<Resource>) pm.newQuery(query2).execute();
		  			if(rSearch.isEmpty()) {
		  				req.getRequestDispatcher("/WEB-INF/Views/Errores/error3.jsp").forward(req, resp);
			    	}else {
			    		String query3 = "select from " + Access.class.getName()+ 
			    				" where idRole =="+ userSearch.get(0).getIdRole()+
			    				" && idResource =="+rSearch.get(0).getId()+
			    				" && status==true"; 
			    		List<Access> aSearch = (List<Access>) pm.newQuery(query3).execute();
				    	if(aSearch.isEmpty()) {
				    		req.getRequestDispatcher("/WEB-INF/Views/Errores/error4.jsp").forward(req, resp);
				    	}else {	
						      try{
						    	 				
									
									Key k = KeyFactory.createKey(Courses.class.getSimpleName(), new Long(req.getParameter("id")));  
									Courses c = pm.getObjectById(Courses.class, k);  
									req.setAttribute("courses", c);
						    	  resp.setContentType("text/html"); resp.setCharacterEncoding("UTF-8");
						    	  req.getRequestDispatcher("/WEB-INF/Views/Courses/edit.jsp").forward(req, resp);          
						      }catch(Exception ex){
						    	  out.println(ex.getMessage()); 
						      }   
				    	}
			    	} 
	  			}
		}
	}catch(Exception ex){
		out.println(ex.getMessage()); 
	}	  
}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html"); resp.setCharacterEncoding("UTF-8");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {   
			Key k = KeyFactory.createKey(Courses.class.getSimpleName(), new Long(req.getParameter("id")));  
			Courses c = pm.getObjectById(Courses.class, k);  
			req.setAttribute("courses", c);
			c.setCourseName(req.getParameter("nameCourse"));
			c.setRugro(req.getParameter("rugro"));
			c.setBanner(req.getParameter("banner"));
			c.setDuracion(req.getParameter("duracion"));
			c.setDescription(req.getParameter("description"));
			c.setStatus(Boolean.parseBoolean(req.getParameter("status")));
			resp.sendRedirect("/courses");
		 } finally {        
			 pm.close();    
		 } 
	} 
	
	
	
	
	
	    
}
