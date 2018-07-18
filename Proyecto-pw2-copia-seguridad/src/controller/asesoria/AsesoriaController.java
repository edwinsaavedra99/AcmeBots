package controller.asesoria;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage; 
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.util.Properties;
import controller.PMF;
import model.entity.*;

@SuppressWarnings("serial")
public class AsesoriaController extends HttpServlet {	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
	      try{
	    	  PersistenceManager pm = PMF.get().getPersistenceManager();
	    	  	  resp.setContentType("text/html"); resp.setCharacterEncoding("UTF-8");
				    	  req.getRequestDispatcher("/WEB-INF/Views/Asesoria/index.jsp").forward(req, resp); 
				    	 
				    	
	  		  		
	      }catch(Exception ex){
	    	  out.println(ex.getMessage()); 
	      }	      
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html"); resp.setCharacterEncoding("UTF-8");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		//Para enviar un mensaje de correo electr�nico, una aplicaci�n prepara un objeto msg,
				//a continuaci�n, lo env�a con el m�todo en texto�en el�transporte�de clase.�
		        //El mensaje se crea utilizando un objeto JavaMail Sesi�n.�
				//transporte con el servicio App Engine correo sin ninguna
		System.out.println("tmre1");
		String name = req.getParameter("name");		
		String correo = req.getParameter("email");
		String mensaje = req.getParameter("mensaje");
		String city = req.getParameter("region");
		
		Properties props=new Properties();
		Session session=Session.getDefaultInstance(props,null);
		String msgBodyEmail=name + "\n" + mensaje + "\n" + correo + "\n" + city;
		
		try{		
			Message msg	= new MimeMessage(session);
			//Direcciones de correo electr�nico del remitente y el 
			//destinatario est�n representados en JavaMail utilizando instancias de la clase InternetAddres
            //Para establecer la direcci�n del remitente, la aplicaci�n llama al�setFrom ()�m�todo en el objeto Mmsge.
			//�La direcci�n del remitente debe ser uno de los siguientes tipos:
			
			msg.setFrom(new InternetAddress(correo,name));
			//Varios m�todos en el Mege objeto establecer los destinatarios.�
			//El�addRecipient ()�m�todo toma un tipo de receptor y una direcci�n, y lo a�ade a la lista 
			//de destinatarios para el tipo.
            //El tipo de destinatario puede
			//ser cualquiera deMessage.RecipientType.TO�,�Message.RecipientType.CC�o�Message.RecipientType.BCC�.
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress("acmebots123@gmail.com","THE READER"));
			msg.setSubject("Desarrollo de Proyectos");
			msg.setText(msgBodyEmail);
			Transport.send(msg); 
			System.out.println("email enviado correctamente");
			req.getRequestDispatcher("/WEB-INF/Views/Errores/error7.jsp").forward(req, resp);
			
			}catch(Exception e){
				resp.setContentType("text/plain");
				System.out.println("tmre");
				resp.getWriter().print("HUBO FALLO.");
				throw new RuntimeException(e);
			}
			
	}
}