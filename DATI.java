package Tiw2021.Tesina00;

package tiw2021.puffo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.api.utils.SystemProperty;
import com.google.appengine.repackaged.com.google.datastore.v1.CompositeFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

@WebServlet(name = "dati", value = {"/helloTesina02"}) 
public class DATI extends HttpServlet{
	int i=1; // ho messo un contatore unico perchè se la i si replica poi i file sul server vengono sovrascritti
  private UserService us;
  private DatastoreService ds;
  
  public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws IOException {
	  //importazione del file dalla form di inserimento
	  try{
		  us=UserServiceFactory.getUserService();
		  ds=DatastoreServiceFactory.getDatastoreService();
		  
		  BufferedReader br = new BufferedReader(new FileReader(request.getParameter("picker")));
		  String line;
		  //br.readLine(); //salta un RIGA nel file
		 System.out.println("BELLA LIIIII2222");
		 i++;
		  
		  while((line=br.readLine())!=null){
			  String[] e=line.split(";");
			  String AS=e[0].trim();
			  String Scuola=e[1].trim().replace("\"","");
			  String Comune=e[2].trim();
			  String Indirizzo=e[3].trim();
			  String Grado=e[4].trim();
			  String Titolo_Progetto=e[5].trim();
			  String Periodo=e[6]+"a"+e[7].trim();
			  String Formatore=e[8].trim();
			  String numero_ore=e[9].trim();
			  String numero_studenti_coinvolti=e[10].trim();
			  String età_partecipanti=e[11]+"a"+e[12].trim();
			  String Parola_chiave=e[13].trim();
	     	   
			   Entity x=new Entity("eventi",i);
			   x.setProperty("AS",AS);
			   x.setProperty("Scuola",Scuola);
			   x.setProperty("Comune",Comune);
			   x.setProperty("Grado",Grado);
			   x.setProperty("Inidirizzo",Indirizzo);
			   x.setProperty("Titolo_Progetto",Titolo_Progetto);
			   x.setProperty("Periodo",Periodo);
			   x.setProperty("Formatore",Formatore);
			   x.setProperty("numero_ore",numero_ore);
			   x.setProperty("numero_studenti_coinvolti",numero_studenti_coinvolti);
			   x.setProperty("età_partecipanti",età_partecipanti);
			   x.setProperty("Parola_chiave",Parola_chiave);
			   x.setProperty("CODE",i);
			   i++;
			   ds.put(x);			   
	   
   }
		  
   br.close();
   
 }catch(Exception e){
	 e.printStackTrace();
 }
	  
	  
  }
  
  public void load(){
	  try{
		  us=UserServiceFactory.getUserService();
		  ds=DatastoreServiceFactory.getDatastoreService();
		  ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		  InputStream is = classloader.getResourceAsStream("PROVA2.txt");
		  BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		  String line;
		  //br.readLine(); //salta un RIGA nel file
		 
		  
		  while((line=br.readLine())!=null){
			  String[] e=line.split(";");
			  String AS=e[0].trim();
			  String Scuola=e[1].trim().replace("\"","");
			  String Comune=e[2].trim();
			  String Indirizzo=e[3].trim();
			  String Grado=e[4].trim();
			  String Titolo_Progetto=e[5].trim();
			  String Periodo=e[6]+"a"+e[7].trim();
			  String Formatore=e[8].trim();
			  String numero_ore=e[9].trim();
			  String numero_studenti_coinvolti=e[10].trim();
			  String età_partecipanti=e[11]+"a"+e[12].trim();
			  String Parola_chiave=e[13].trim();
	     	   
			   Entity x=new Entity("eventi",i);
			   x.setProperty("AS",AS);
			   x.setProperty("Scuola",Scuola);
			   x.setProperty("Comune",Comune);
			   x.setProperty("Grado",Grado);
			   x.setProperty("Inidirizzo",Indirizzo);
			   x.setProperty("Titolo_Progetto",Titolo_Progetto);
			   x.setProperty("Periodo",Periodo);
			   x.setProperty("Formatore",Formatore);
			   x.setProperty("numero_ore",numero_ore);
			   x.setProperty("numero_studenti_coinvolti",numero_studenti_coinvolti);
			   x.setProperty("età_partecipanti",età_partecipanti);
			   x.setProperty("Parola_chiave",Parola_chiave);
			   x.setProperty("CODE",i);
			   i++;
			   ds.put(x);			   
	   
   }
		  
   br.close();
   
 }catch(Exception e){
	 e.printStackTrace();
 }
 }

  //queries per prendere i dati dal datastore
  
  //STUDENTI per anno
  public Integer getStudenti(String AS){
		 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		 Query q = new Query("eventi");
		 List<Filter> filters = new ArrayList<Filter>();
		 q.setFilter(new FilterPredicate("AS",FilterOperator.EQUAL,AS));
		 PreparedQuery pq = ds.prepare(q);
		 List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
		 Integer studenti_totali = 0;
		 for(Entity e : list) {
			 String studenti = (String)e.getProperty("numero_studenti_coinvolti");
			 if(!studenti.equals("")) {
				 studenti_totali += Integer.valueOf(studenti);
			 }
		 }
		 return studenti_totali;
	}
  
  //ORE (per anno)
 public Integer getOre(String AS){
	 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	 Query q = new Query("eventi");
	 List<Filter> filters = new ArrayList<Filter>();
	 q.setFilter(new FilterPredicate("AS",FilterOperator.EQUAL,AS));
	 PreparedQuery pq = ds.prepare(q);
	 List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
	 int ore_totali = 0;
	 for(Entity e : list) {
		 String ore = (String)e.getProperty("numero_ore");
		 if(!ore.equals(""))
			 ore_totali += Integer.valueOf(ore);
	 }
	 return ore_totali;
}
 
 //EVENTI per anno
 public Integer getEventi(String AS){
	 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	 Query q = new Query("eventi");
	 List<Filter> filters = new ArrayList<Filter>();
	 q.setFilter(new FilterPredicate("AS",FilterOperator.EQUAL,AS));
	 PreparedQuery pq = ds.prepare(q);
	 List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
	 Integer eventi_totali = 0;
	 for(Entity e : list) {
		 eventi_totali++;
	 					  }
	 return eventi_totali;
 }
 
 //fare lista di filtri
 public Integer getTutto(String CampoDaCercare, String AS){
	 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	 Query q = new Query("eventi");
	 List<Filter> filters = new ArrayList<Filter>();
	 q.setFilter(new FilterPredicate(CampoDaCercare,FilterOperator.EQUAL,AS));
	 PreparedQuery pq = ds.prepare(q);
	 List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
	 Integer eventi_totali = 0;
	 for(Entity e : list) {
		 eventi_totali++;
	 }
	 return eventi_totali;
 }
 
 //PRENDERE TUTTE LE SCUOLE:
 public ArrayList getScuole(){
	 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	 String s ="";
	 Query q = new Query("scuole");
	 List<Filter> filters = new ArrayList<Filter>();
	 PreparedQuery pq = ds.prepare(q);
	 List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
	 ArrayList<String> scuole = new ArrayList<String>();
	 for(Entity e : list) {
				 scuole.add(e.getProperty("scuola").toString());
	 }
	 return scuole;
 }
 
 //PRENDERE TUTTE LE LATITUDINI:
 public ArrayList getLat(){
	 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	 String s ="";
	 Query q = new Query("scuole");
	 List<Filter> filters = new ArrayList<Filter>();
	 PreparedQuery pq = ds.prepare(q);
	 List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
	 ArrayList<String> latitudini = new ArrayList<String>();
	 for(Entity e : list) {
				 latitudini.add(e.getProperty("latitudine").toString());
	 }
	 return latitudini;
 }
 
 //PRENDERE TUTTE LE SCUOLE:
 public ArrayList getLongi(){
	 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	 String s ="";
	 Query q = new Query("scuole");
	 List<Filter> filters = new ArrayList<Filter>();
	 PreparedQuery pq = ds.prepare(q);
	 List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
	 ArrayList<String> latitudini = new ArrayList<String>();
	 for(Entity e : list) {
				 latitudini.add(e.getProperty("longitudine").toString());
	 }
	 return latitudini;
 }
 
 }
