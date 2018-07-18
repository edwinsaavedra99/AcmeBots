package controller.users;

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
public class UserControllerEdit extends HttpServlet {
	

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
						    	  PersistenceManager pm1 = PMF.get().getPersistenceManager();
									String query = "select from " + Role.class.getName(); 
									List<Role> roles = (List<Role>) pm1.newQuery(query).execute();   
									req.setAttribute("roles", roles);
									
									
									Key k = KeyFactory.createKey(User.class.getSimpleName(), new Long(req.getParameter("id")));  
									User u = pm.getObjectById(User.class, k);  
									req.setAttribute("user", u);
						    	  resp.setContentType("text/html"); resp.setCharacterEncoding("UTF-8");
						    	  req.getRequestDispatcher("/WEB-INF/Views/Users/edit.jsp").forward(req, resp);          
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
			Key k = KeyFactory.createKey(User.class.getSimpleName(), new Long(req.getParameter("id")));  
			User u = pm.getObjectById(User.class, k);  
			req.setAttribute("user", u);
			u.setIdRole(Long.parseLong(req.getParameter("idRole")));
			u.setPhone(req.getParameter("phone"));
			u.setAddress(req.getParameter("address"));
			u.setEmail(req.getParameter("email"));
			u.setLastName(req.getParameter("lastName"));
			u.setName(req.getParameter("name"));
			u.setStatus(Boolean.parseBoolean(req.getParameter("status")));
			resp.sendRedirect("/users");
		 } finally {        
			 pm.close();    
		 } 
	} 
	
	
	
	
	
	    
}
