package Tiw2021.Tesina00;

import java.io.FileReader;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@WebServlet(name = "login", value = {"/helloTesina01"}) 

public class login extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws IOException {
		//per vedere cosa c'è nel DB: http://localhost:8080/_ah/admin/datastore?
		
		if(request.getParameter("addUser") != null) {
			//aggiungo url con questo metodo, ma io voglio aggiungere gli USERS
			String usern = request.getParameter("username"); //metto nome del campo che cerco di intercettare
			String psw = request.getParameter("password");
			Entity e = new Entity("utenti", usern); //la tabella si chiama utenti e la chiave è l'username
			e.setProperty("username", usern);
			e.setProperty("password", psw); // aggiungo la proprietà (colonna?)
			e.setProperty("admin", false); //user NON è un admin
			ds.put(e);
			response.sendRedirect("master.jsp");
		}
		 
		if(request.getParameter("addScuola") != null) {
		//aggiungo scuola con latitudine e longitudine
				String scuola = request.getParameter("scuola"); //metto nome del campo che cerco di intercettare
				double lat = Double.parseDouble(request.getParameter("lat"));
				double longi = Double.parseDouble(request.getParameter("longi")); //metto nome del campo che cerco di intercettare
				Entity s = new Entity("scuole");
				s.setProperty("scuola", scuola);
				s.setProperty("latitudine", lat);
				s.setProperty("longitudine", longi);
				ds.put(s);
				response.sendRedirect("master.jsp");
		}
		
	}
	
	private UserService us;
	private DatastoreService ds;
	
	//ora devo mettere il metodo doPost che riceve i dati del form nel master in cui admin aggiunge gli utenti
	
	public login() {
	us = UserServiceFactory.getUserService();
	ds = DatastoreServiceFactory.getDatastoreService();
	}
	
	public void add() {
		//inserisco admin
		String username = "gaia";
		String psw = "password";
		Entity e = new Entity("utenti", username); //la tabella si chiama utenti e la chiave è l'username
		e.setProperty("username", username);
		e.setProperty("password", psw); // aggiungo la proprietà (colonna?)
		e.setProperty("admin", true); //Gaia è admin
		ds.put(e);
		
		String scuola = "I.T. Scaruffi Levi  Tricolore"; //metto nome del campo che cerco di intercettare
		double lat = 44.7007475271964;
		double longi = 10.633781921287271; //metto nome del campo che cerco di intercettare
		Entity s = new Entity("scuole", 1);
		s.setProperty("scuola", scuola);
		s.setProperty("latitudine", lat);
		s.setProperty("longitudine", longi);
		ds.put(s);
		
	}

		
}
