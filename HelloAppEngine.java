package Tiw2021.Tesina00;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.api.utils.SystemProperty;

@WebServlet(name = "HelloAppEngine", value = {"/helloTesina00"}) 
public class HelloAppEngine extends HttpServlet {
	
	String userGiusta="demo"; 
	String passGiusta="demo";

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
	  DATI o = new DATI();
	  o.load();
	  
    Properties properties = System.getProperties();

    response.setContentType("text/plain");
    response.getWriter().println("Hello App Engine - Standard using"
        + SystemProperty.version.get() + " Java " + properties.get("java.specification.version"));
  }
  
  public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws IOException { 
	  	
	  DATI o = new DATI();
	    o.load();
	  
		boolean adminDB = false;
		String userDB = null;
		String passDB = null;
		
		//ricevere i parametri: ho fatto una servlet 
		String usernInserita = request.getParameter("username"); 
		String passwInserita = request.getParameter("password"); 
		  
		login log00 = new login();
		log00.add();
	    
	  //recupero la sessione corrente
	    HttpSession oldSession = request.getSession(false);
	    if(oldSession!=null) {
	    	oldSession.invalidate(); //invalida la sessione se esiste
		}
	    HttpSession currentSession = request.getSession(); //creo nuova sessione ( di defalut fa true)
			
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("utenti"); // voglio la query su utenti
		Filter f = new FilterPredicate("username",FilterOperator.EQUAL, usernInserita); // voglio l'username
		
		q.setFilter(f);
		PreparedQuery pq = ds.prepare(q);
		List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
		
		//se nel db ho che l'uente è un admin metto admin DB == true
		
		//inserisco dentro alle stringhe i dati che ho estratto dal database
		for (Entity result : pq.asIterable()) {
			  passDB = (String) result.getProperty("password");
			  userDB = (String) result.getProperty("username");
			  adminDB=(boolean) result.getProperty("admin");
			}

		currentSession.setAttribute("usDB", userDB);
		currentSession.setAttribute("admDB", adminDB);
		currentSession.setMaxInactiveInterval(5*60); //max 5 min di inattività
	    
		  if(userDB.equals(usernInserita) && passDB.equals(passwInserita)) {
			  // autenticazione è andata a buon fine
			  response.sendRedirect("master.jsp");
			  //response.sendRedirect("login1.jsp");
		  }else {
			  //se l'autenticazione fallisce
			  response.sendRedirect("loginErrato.jsp");
		  }
		 
  }
  
  private UserService us;
  private DatastoreService ds;

  public static String getInfo() {
    return "Version: " + System.getProperty("java.version")
          + " OS: " + System.getProperty("os.name")
          + " User: " + System.getProperty("user.name");
  }
 

  }
