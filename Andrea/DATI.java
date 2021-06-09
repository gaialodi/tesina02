package tiw2021.puffo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

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

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JLabel;
import javax.swing.JTextArea;



@WebServlet(name = "dati", value = {"/helloTesina02"}) 
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class DATI extends HttpServlet{
	int i=1; // ho messo un contatore unico perchè se la i si replica poi i file sul server vengono sovrascritti
  private UserService us;
  private DatastoreService ds;
  
  public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws IOException {
	  
	  //importazione del file dalla form di inserimento
	  System.out.println("BELLA LIIIII2222");
	  DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		 Query q = new Query("eventi");
		 PreparedQuery pq = ds.prepare(q);
		 List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
		 i=list.size()+1;
	  //leggere file
	 try{
		  us=UserServiceFactory.getUserService();
		  ds=DatastoreServiceFactory.getDatastoreService();

		  InputStream filecontent = null;
		  
		  Part filePart = request.getPart("picker");
		    filecontent = filePart.getInputStream();
		    response.getWriter().print("The file uploaded sucessfully.");
		    BufferedReader br = new BufferedReader(new InputStreamReader(filecontent, "UTF-8"));
  
		  String line;
		 // br.readLine(); //salta un RIGA nel file		 

		  while((line=br.readLine())!=null){
			  String[] e=line.split(";");
			  String AS=e[0].trim();
			  String Scuola=e[1].trim().replace("\"","");
			  String Comune=e[2].trim();
			  String Indirizzo=e[3].trim();
			  String Grado=e[4].trim();
			  String Titolo_Progetto=e[5].trim();
			  String Periodo=e[6]+" a "+e[7].trim();
			  String Formatore=e[8].trim();
			  String numero_ore=e[9].trim();
			  String numero_studenti_coinvolti=e[10].trim();
			  String età_partecipanti=e[11]+" a "+e[12].trim();
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
			   System.out.println("BELLA LIIIII "+i);

   }

   br.close();
   response.sendRedirect("master.jsp");
   
 }catch(Exception e){
	 e.printStackTrace();
 } 
	  
  }//fine POST
  
  //carica sul datastore il file che ho già
  
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
  public String Search(String word)
  {  
	 StringBuffer sb = new StringBuffer();
	 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	 Query q = new Query("eventi");
	 List<Filter> filters = new ArrayList<Filter>();
	 q.setFilter(new FilterPredicate("Parola_chiave",FilterOperator.EQUAL,word));
	 PreparedQuery pq = ds.prepare(q);
	 List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
	 if(list.size()!=0)
	 {
		 int indice=1;
		 String ret;
	
	 for(Entity e : list) {
		  ret=(" [ "+indice+" "+e.getProperty("Scuola").toString()+" "+e.getProperty("Titolo_Progetto").toString()+" "+e.getProperty("AS").toString()+"]"+"  ");
		 sb.append(ret);
		 
		 indice++;
	 }
	 return sb.toString();
	 }
	return null;
  }
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
 
 public Integer getEventitot(){
	 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	 Query q = new Query("eventi");
	 PreparedQuery pq = ds.prepare(q);
	 List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
	 Integer eventi_totali = 0;
	 for (int j = 0; j < list.size(); j++) {
		eventi_totali++;
	}
	 return eventi_totali;
 }
 
 public Integer getStudentiTot(){
	 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	 Query q = new Query("eventi");
	 PreparedQuery pq = ds.prepare(q);
	 List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
	 Integer studenti_totali = 0;
	 for (Entity e: list) {
		 if(!e.getProperty("numero_studenti_coinvolti").equals(""))
		studenti_totali+=Integer.valueOf(e.getProperty("numero_studenti_coinvolti").toString());
	}
	 return studenti_totali;
 }
 
 public Integer getOreTot(){
	 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	 Query q = new Query("eventi");
	 PreparedQuery pq = ds.prepare(q);
	 List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
	 Integer ore_totali = 0;
	 for (Entity e: list) {
		 if(!e.getProperty("numero_studenti_coinvolti").equals(""))
		ore_totali+=Integer.valueOf(e.getProperty("numero_ore").toString());
	}
	 return ore_totali;
 }
 
 public String getScuolaVirtuosa(){
	 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	 Query q = new Query("eventi");
	 PreparedQuery pq = ds.prepare(q);
	 List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
	 List<Entity> list2 = pq.asList(FetchOptions.Builder.withLimit(100));
	 int scuola= 0;
		int cont=0;
		String chiave="";
		for(Entity e:list)
			{
			cont=0;
				for(Entity f:list2)
				{
					if(e.getProperty("Scuola").equals(f.getProperty("Scuola")))
					{
					cont+=1;
					}
				
				}
				if(cont>scuola)  //questo if controlla se il tema corrente è stato trattato più volte del tema piu trattato dall'iterazione precedente
				{
					scuola=cont;
					chiave=e.getProperty("Scuola").toString();
				}
			
			}
		return chiave;
	}
 
 public String getTema(){
	 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	 Query q = new Query("eventi");
	 PreparedQuery pq = ds.prepare(q);
	 List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
	 List<Entity> list2 = pq.asList(FetchOptions.Builder.withLimit(100));
		int cont=0;
		String chiave="";
		int tema=0;
		for(Entity e:list)
			{
			cont=0;
				for(Entity f:list2)
				{
					if(e.getProperty("Parola_chiave").equals(f.getProperty("Parola_chiave")))
					{
					cont+=1;
					}
				
				}
				if(cont>tema)  //questo if controlla se il tema corrente è stato trattato più volte del tema piu trattato dall'iterazione precedente
				{
					tema=cont;
					chiave=e.getProperty("Parola_chiave").toString();
					
				}
				
			
			}
		return chiave;
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
 public String getTutteScuole(){
	 StringBuffer sb = new StringBuffer();
	 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	 String s = null;
	 Query q = new Query("scuole");
	 PreparedQuery pq = ds.prepare(q);
	 List<Entity> list = pq.asList(FetchOptions.Builder.withLimit(100));
	 for(Entity e : list) {
				 s=(" [ "+e.getProperty("scuola").toString()+" ] ");
				 sb.append(s);
	 }
	 return sb.toString();
 }
 
 
 
 }