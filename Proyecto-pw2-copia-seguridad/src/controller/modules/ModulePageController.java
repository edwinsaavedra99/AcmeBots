package controller.modules;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import controller.PMF;
import model.entity.*;
@SuppressWarnings("serial")
public class ModulePageController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//No es necesario restringir acceso a alguien interesado en comprar
		resp.setContentType("text/html"); resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		//-------------------------------------------------------container
		String query = "select from " + Module.class.getName(); 
		List<Module> modules = (List<Module>) pm.newQuery(query).execute();
		req.setAttribute("modules",modules);		  
		try{
			resp.setContentType("text/html"); resp.setCharacterEncoding("UTF-8");
			req.getRequestDispatcher("/WEB-INF/Views/Modules/index2.jsp").forward(req, resp);          
		}catch(Exception ex){
			out.println(ex.getMessage()); 
		}
		//-------------------------------------------------------
	}
}
