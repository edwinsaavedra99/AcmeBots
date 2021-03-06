package controller.users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import controller.PMF;
import model.entity.*;
@SuppressWarnings("serial")
public class UserControllerIndex extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		PrintWriter out = resp.getWriter();  
		UserService us = UserServiceFactory.getUserService();
		com.google.appengine.api.users.User user = us.getCurrentUser();
		
		String query3 = "select from " + User.class.getName(); 
		PersistenceManager pm2 = PMF.get().getPersistenceManager();
		List<User> use = (List<User>) pm.newQuery(query3).execute();
		
		if(use.size()>0) {
			for(int i=0;i<use.size();i++) {
				System.out.println("correos"+ use.get(i).getEmail()+", status"+use.get(i).isStatus());
			}
		}
		else {
			
			//fecha de Creacion
			Calendar fecha = new GregorianCalendar();
	        int a�o = fecha.get(Calendar.YEAR);
	        int mes = fecha.get(Calendar.MONTH);
	        int dia = fecha.get(Calendar.DAY_OF_MONTH);
	        int hora = fecha.get(Calendar.HOUR_OF_DAY);
	        int minuto = fecha.get(Calendar.MINUTE);
	        int segundo = fecha.get(Calendar.SECOND);
	        String fechaactual=(dia-1) + "/" + (mes+1) + "/" + a�o +" - "+ hora+":"+minuto+":"+segundo;
	        
	        Role rolecreate2 = new Role("Usuario",fechaactual,true,"Usuario comun"); pm2.makePersistent(rolecreate2);
			Role rolecreate = new Role("Administrador",fechaactual,true,"Primer Admnistrador"); pm2.makePersistent(rolecreate);
			User usercreate = new User(rolecreate.getId(),"Admin","Admin","edwinsaavedra99@gmail.com","936144471","Cayma-1roJunio",true);
			pm2.makePersistent(usercreate);
			//permiso al admin de ver las paginas de acmebots
			
			//permiso al Primer Admin acceso crear,ver,editar y borrar cursos
			Resource re = new Resource("courses",fechaactual,"/courses","Resource courses",true); pm2.makePersistent(re);
			Access ac = new Access(rolecreate.getId(),re.getId(),fechaactual,true); pm2.makePersistent(ac);
			Resource re1 = new Resource("courses Add",fechaactual,"/courses/add","Resource courses Add",true); pm2.makePersistent(re1);
			Access ac1 = new Access(rolecreate.getId(),re1.getId(),fechaactual,true); pm2.makePersistent(ac1);
			Resource re2 = new Resource("courses View",fechaactual,"/courses/view","Resource courses View",true); pm2.makePersistent(re2);
			Access ac2 = new Access(rolecreate.getId(),re2.getId(),fechaactual,true); pm2.makePersistent(ac2);
			Resource re3 = new Resource("courses Edit",fechaactual,"/courses/edit","Resource courses Edit",true); pm2.makePersistent(re3);
			Access ac3 = new Access(rolecreate.getId(),re3.getId(),fechaactual,true); pm2.makePersistent(ac3);
			Resource re4 = new Resource("courses Delete",fechaactual,"/courses/delete","Resource courses Delete",true); pm2.makePersistent(re4);
			Access ac4 = new Access(rolecreate.getId(),re4.getId(),fechaactual,true); pm2.makePersistent(ac4);
			Resource re5 = new Resource("courses page",fechaactual,"/courses-page","Resource courses page",true); pm2.makePersistent(re5);
			Access ac5 = new Access(rolecreate.getId(),re5.getId(),fechaactual,true); pm2.makePersistent(ac5);
			Access a = new Access(rolecreate2.getId(),re5.getId(),fechaactual,true); pm2.makePersistent(a);
			
			//permiso al Primer Admin acceso crear,ver,editar y borrar modules
			Resource rea = new Resource("modules",fechaactual,"/modules","Resource modules",true); pm2.makePersistent(rea);
			Access aca = new Access(rolecreate.getId(),re.getId(),fechaactual,true); pm2.makePersistent(aca);
			Resource re11 = new Resource("modules Add",fechaactual,"/modules/add","Resource modulesAdd",true); pm2.makePersistent(re11);
			Access ac11 = new Access(rolecreate.getId(),re1.getId(),fechaactual,true); pm2.makePersistent(ac11);
			Resource re22 = new Resource("modules View",fechaactual,"/modules/view","Resource modules View",true); pm2.makePersistent(re22);
			Access ac22 = new Access(rolecreate.getId(),re2.getId(),fechaactual,true); pm2.makePersistent(ac22);
			Resource re33 = new Resource("modules Edit",fechaactual,"/modules/edit","Resource modules Edit",true); pm2.makePersistent(re33);
			Access ac33 = new Access(rolecreate.getId(),re3.getId(),fechaactual,true); pm2.makePersistent(ac33);
			Resource re44 = new Resource("modules Delete",fechaactual,"/modules/delete","Resource modules Delete",true); pm2.makePersistent(re44);
			Access ac44 = new Access(rolecreate.getId(),re4.getId(),fechaactual,true); pm2.makePersistent(ac44);
			Resource re55 = new Resource("modules page",fechaactual,"/modules-page","Resource modules page",true); pm2.makePersistent(re55);
			Access ac55 = new Access(rolecreate.getId(),re4.getId(),fechaactual,true); pm2.makePersistent(ac55);
			
			
			
			
			//permiso al Primer Admin acceso crear,ver,editar y borrar usuarios
			Resource resourcea = new Resource("User",fechaactual,"/users","Resource User",true); pm2.makePersistent(resourcea);
			Access accessa = new Access(rolecreate.getId(),resourcea.getId(),fechaactual,true); pm2.makePersistent(accessa);
			Resource resource1 = new Resource("User Add",fechaactual,"/users/add","Resource User Add",true); pm2.makePersistent(resource1);
			Access access1 = new Access(rolecreate.getId(),resource1.getId(),fechaactual,true); pm2.makePersistent(access1);
			Resource resource2 = new Resource("User View",fechaactual,"/users/view","Resource User View",true); pm2.makePersistent(resource2);
			Access access2 = new Access(rolecreate.getId(),resource2.getId(),fechaactual,true); pm2.makePersistent(access2);
			Resource resource3 = new Resource("User Edit",fechaactual,"/users/edit","Resource User Edit",true); pm2.makePersistent(resource3);
			Access access3 = new Access(rolecreate.getId(),resource3.getId(),fechaactual,true); pm2.makePersistent(access3);
			Resource resource4 = new Resource("User Delete",fechaactual,"/users/delete","Resource User Delete",true); pm2.makePersistent(resource4);
			Access access4 = new Access(rolecreate.getId(),resource4.getId(),fechaactual,true); pm2.makePersistent(access4);
			System.out.print("lol si entra");
			//permiso al Primer Admin a acceder,crear,ver,editar y borrar role
			Resource resourceaa = new Resource("Role",fechaactual,"/roles","Resource Role",true); pm2.makePersistent(resourceaa);
			Access accessaa = new Access(rolecreate.getId(),resourceaa.getId(),fechaactual,true); pm2.makePersistent(accessaa);
			Resource resource11 = new Resource("Role Add",fechaactual,"/roles/add","Resource Role  Add",true); pm2.makePersistent(resource11);
			Access access11 = new Access(rolecreate.getId(),resource11.getId(),fechaactual,true); pm2.makePersistent(access11);
			Resource resource22 = new Resource("Role  View",fechaactual,"/roles/view","Resource Role View",true); pm2.makePersistent(resource22);
			Access access22 = new Access(rolecreate.getId(),resource22.getId(),fechaactual,true); pm2.makePersistent(access22);
			Resource resource33 = new Resource("Role  Edit",fechaactual,"/roles/edit","Resource Role  Edit",true); pm2.makePersistent(resource33);
			Access access33 = new Access(rolecreate.getId(),resource33.getId(),fechaactual,true); pm2.makePersistent(access33);
			Resource resource44 = new Resource("Role  Delete",fechaactual,"/roles/delete","Resource Role  Delete",true); pm2.makePersistent(resource44);
			Access access44 = new Access(rolecreate.getId(),resource44.getId(),fechaactual,true); pm2.makePersistent(access44);
			
			//permiso al Primer Admin a acceder,crear,ver,editar y borrar resource
			Resource resourceaaa = new Resource("Resource",fechaactual,"/resources","Resource Resource",true); pm2.makePersistent(resourceaaa);
			Access accessaaa = new Access(rolecreate.getId(),resourceaaa.getId(),fechaactual,true); pm2.makePersistent(accessaaa);
			Resource resource111 = new Resource("Resource Add",fechaactual,"/resources/add","Resource Resource Add",true); pm2.makePersistent(resource111);
			Access access111 = new Access(rolecreate.getId(),resource111.getId(),fechaactual,true); pm2.makePersistent(access111);
			Resource resource222 = new Resource("Resource  View",fechaactual,"/resources/view","Resource Resource View",true); pm2.makePersistent(resource222);
			Access access222 = new Access(rolecreate.getId(),resource222.getId(),fechaactual,true); pm2.makePersistent(access222);
			Resource resource333 = new Resource("Resource  Edit",fechaactual,"/resources/edit","Resource Resource Edit",true); pm2.makePersistent(resource333);
			Access access333 = new Access(rolecreate.getId(),resource333.getId(),fechaactual,true); pm2.makePersistent(access333);
			Resource resource444 = new Resource("Resource  Delete",fechaactual,"/resources/delete","Resource Resource Delete",true); pm2.makePersistent(resource444);
			Access access444 = new Access(rolecreate.getId(),resource444.getId(),fechaactual,true); pm2.makePersistent(access444);
			
			//permiso al Primer Admin a acceder,crear,ver,editar y borrar access 
			Resource resourceaaaa = new Resource("Access",fechaactual,"/access","Resource Access",true);  pm2.makePersistent(resourceaaaa);
			Access accessaaaa = new Access(rolecreate.getId(),resourceaaaa.getId(),fechaactual,true); pm2.makePersistent(accessaaaa);
			Resource resource1111 = new Resource("Access Add",fechaactual,"/access/add","Resource Access Add",true); pm2.makePersistent(resource1111);
			Access access1111 = new Access(rolecreate.getId(),resource1111.getId(),fechaactual,true); pm2.makePersistent(access1111);
			Resource resource2222 = new Resource("Access  View",fechaactual,"/access/view","Resource Access View",true); pm2.makePersistent(resource2222);
			Access access2222 = new Access(rolecreate.getId(),resource2222.getId(),fechaactual,true); pm2.makePersistent(access2222);
			Resource resource3333 = new Resource("Access Edit",fechaactual,"/access/edit","Resource Access Edit",true); pm2.makePersistent(resource3333);
			Access access3333 = new Access(rolecreate.getId(),resource3333.getId(),fechaactual,true); pm2.makePersistent(access3333);
			Resource resource4444 = new Resource("Access  Delete",fechaactual,"/access/delete","Resource Access Delete",true); pm2.makePersistent(resource4444);
			Access access4444 = new Access(rolecreate.getId(),resource4444.getId(),fechaactual,true); pm2.makePersistent(access4444);
		}
		
		
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
		    		String query5 = "select from " + Access.class.getName()+ 
		    				" where idRole =="+ userSearch.get(0).getIdRole()+
		    				" && idResource =="+rSearch.get(0).getId()+
		    				" && status==true"; 
		  			List<Access> aSearch = (List<Access>) pm.newQuery(query5).execute();
			    	if(aSearch.isEmpty()) {
			    		req.getRequestDispatcher("/WEB-INF/Views/Errores/error4.jsp").forward(req, resp); 
			    	}else {	
						//-------------------------------------------------------container
						String query = "select from " + User.class.getName(); 
						List<User> users = (List<User>) pm.newQuery(query).execute();
						req.setAttribute("users", users);		  
						try{
							resp.setContentType("text/html"); resp.setCharacterEncoding("UTF-8");
							req.getRequestDispatcher("/WEB-INF/Views/Users/index.jsp").forward(req, resp);          
						}catch(Exception ex){
							out.println(ex.getMessage()); 
						}
						//-------------------------------------------------------
			    	}
		    	}
			}
		}
	}
}
