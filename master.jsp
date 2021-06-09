<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Tiw2021.Tesina00.HelloAppEngine" %>
<%@ page import ="java.util.*" %>
<%@ page import= "com.google.appengine.api.users.*"%>
<%@ page import= "com.google.appengine.api.datastore.Entity" %>
<%@ page import="Tiw2021.Tesina00.*" %>
<%@ page import="Tiw2021.Tesina00.login" %>
<%@ page import="Tiw2021.Tesina00.DATI" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

	
<head>
<title>Prefettura e adolescenza</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200;400&display=swap" rel="stylesheet">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"
   integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A=="
   crossorigin=""/>
<script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"
   integrity="sha512-XQoYMqMTK8LvdxXYG3nZ448hOEQiglfqkJs1NOQV44cWnUrBc8PkAOcXy20w0vlaXaVUearIOBhiXZ5V3ynxwA=="
   crossorigin=""></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script>google.charts.load('current', {packages: ['corechart']});</script>
<%DATI d=new DATI(); %>

<!-- #log modifica la barra di login
.navbar modifica la barra di navigazione (in alto)
.body modifica tutto quello che c'è sotto alla barra di navigazione -->
	
<style>

.navbar-brand {
	cursor: pointer;
}

.navbar {
	position: fixed;
	top: 0;
	z-index: 999;
	width:100%;
  	padding-top: 15px;
  	padding-bottom: 15px;
 	border: 0;
 	border-radius: 0;
 	margin-bottom: 0;
 	font: Montserrat;
 	font-size: 16px;
 	letter-spacing: 5px;
	background-color: #00326E;
 	color: white;
  }

.container-fluid, container{
padding-top: 80px;
padding-bottom: 50px;
font-size:16px;
}

body{
padding:90px solid;
margin-top:50px;
background-color:MistyRose;
font: Montserrat;
color:#00326E;
}

.tbn{
border-right:1px solid !important;
}

input{
    color: -internal-light-dark(black, white);
    appeareance:none;
}

option{
backgorund-color:white;
color:black;
appearance: none;
}

.counter_wrapper,
.counter_wrapper_below {
  display: -webkit-box;
  display: -ms-flexbox;
  display: -webkit-flex;
  display: flex;
  flex-direction: row;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  -webkit-justify-content: center;
  justify-content: center;
  -webkit-box-align: center;
  -ms-flex-align: center;
  -webkit-align-items: center;
  align-items: center;
  width: 100%;
  margin: auto;
}

.counter_wrapper_below {
  width: 680px;
  height: 190px;
  margin-top: 10px;
  margin-bottom: 10px;
}

.col_1,
.col_2,
.col_3,
.col_4,
.col_5_top,
.col_6_top,
.col_7_top {
  width: 14%;
  text-align: center;
  background-color:MistyRose;
  vertical-align: top;
}

.col_5,
.col_6,
.col_7 {
  width: 33%;
  text-align: center;
  background-color: #f7f6f2;
  vertical-align: top;
}

.filetto_verticale_top {
  border-right: 1px solid rgba(31, 34, 38, 0.5);
}

.filetto_verticale_top_dotted {
  border-right: 1px dotted rgba(31, 34, 38, 0.5);
}

hr.filetto_verticale {
  border-top: 1px solid rgba(31, 34, 38, 0.5);
  height: 100px;
}

#num_1,
#variazione_1,
#total_1 {
  color: #FF3366;
  font-size: 20px;
}

#num_3,
#variazione_3,
#total_3 {
  color: #19b290;
font-size: 20px;
}

#num_4,
#variazione_4,
#total_4 {
  color: #ef4e63;
  font-size: 25px;
}

#num_5_top,
#variazione_5_top,
#total_5_top {
  color: #f38384;
}

#num_6_top,
#variazione_6_top,
#total_6_top {
  color: black;
  font-size: 25px;
}

#num_7_top,
#variazione_7_top,
#total_7_top {
  color: #f38384;
}

#num_5_top,
#num_6_top,
#num_7_top {
  font-weight: 800;
}

#num_5,
#variazione_5,
#total_5 {
  color: #ef4e63;
}

#num_6,
#variazione_6,
#total_6 {
  color: #aa0438;
}

#num_7,
#variazione_7,
#total_7 {
  color: #f38384;
}

.timer {
  font-family: "SoleSans", Arial, Helvetica, sans-serif;
  font-weight: 800;
  font-style: normal;
  line-height: 0.8;
  letter-spacing: normal;
  color: rgba(15, 15, 15, 0.8);
  margin: 15px 0;
  font-size: 25px;
}

.timer_below {
  font-family: "SoleSans", Arial, Helvetica, sans-serif;
  font-weight: 800;
  font-style: normal;
  line-height: 0.8;
  letter-spacing: normal;
  color: rgba(15, 15, 15, 0.8);
  margin: 15px 0;
  font-size: 50px;
}

.count-text {
  font-family: "SoleSans", Arial, Helvetica, sans-serif;
  font-weight: 400;
  font-stretch: normal;
  font-style: normal;
  letter-spacing: normal;
  color: rgba(15, 15, 15, 0.8);
  margin: 0px;
  font-size: 14px;
}

.count-text_var {
  font-family: "SoleSans", Arial, Helvetica, sans-serif;
  font-weight: 400;
  font-stretch: normal;
  font-style: normal;
  line-height: 1.1;
  letter-spacing: normal;
  color: rgba(15, 15, 15, 0.8);
  margin: 0px;
  font-size: 16px;
  margin-bottom: 15px;
}

.count-text_total {
  font-family: "SoleSans", Arial, Helvetica, sans-serif;
  font-weight: 600;
  font-stretch: normal;
  font-style: normal;
  line-height: 1.1;
  letter-spacing: normal;
  color: rgba(15, 15, 15, 0.8);
  margin: 0px;
  font-size: 16px;
}

#picker, #file-upload-button{
magrin-left:200px;
margin-right:200px;
}

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

input[type=number] {
  -moz-appearance: textfield;
}

form{
font-size: 16px;

}

</style>

<%
//Prendo il numero di studenti per anno
Integer stud18= d.getStudenti("2018/2019");  
Integer stud19= d.getStudenti("2019/2020");
Integer stud20= d.getStudenti("2020/2021");
//prendo il numero di eventi per anno
Integer ev18= d.getEventi("2018/2019");  
Integer ev19= d.getEventi("2019/2020");
Integer ev20= d.getEventi("2020/2021");
//prendo il numero di ore per anno
Integer ore18= Integer.valueOf(d.getOre("2018/2019"));  
Integer ore19= Integer.valueOf(d.getOre("2019/2020"));
Integer ore20= Integer.valueOf(d.getOre("2020/2021"));

String word =request.getParameter("key");
%>
<script type="text/javascript">

//GRAFICI
google.charts.setOnLoadCallback(drawVisualization);
function drawVisualization() {
 //Grafico 1
     var data = new google.visualization.DataTable();
        data.addColumn('string','Anni');
        data.addColumn('number', 'Numero studenti');
		
        data.addRow(["2018/2019", <%=stud18%>])
        data.addRow(["2019/2020", <%=stud19%>])
        data.addRow(["2020/2021", <%=stud20%>])
			
        var options = {
          title : 'Numero Studenti',
          pieHole: 0.5,
          vAxis: {title: 'Numero Studenti'},
          hAxis: {title: 'Year'},
          seriesType: 'bars',
          series: {5: {type: 'line'}},
          chartArea:{left:40,right:20,top:50,width:'100%',height:'100%'},
        }
        
        var chart1 = new google.visualization.PieChart(document.getElementById('chart1_div'));
        chart1.draw(data, options);
	
   //Grafico 2
     var data2 = new google.visualization.DataTable();
        data2.addColumn('string','Anni');
		data2.addColumn('number', 'Ore Svolte');
		
		data2.addRow(["2018/2019", <%=ore18%>])
        data2.addRow(["2019/2020", <%=ore19%>])
        data2.addRow(["2020/2021", <%=ore20%>])
		
		//for(let anno=0; anno < anni.length; anno++) {
			//data2.addRow([anni[anno], ore[anno]])
			//}	
			// 2018/2019, 21
			// 2019/2020, 22
			
        var options2 = {
          title : 'Ore svolte',
          vAxis: {title: 'Ore'},
          hAxis: {title: 'Year'},
          seriesType: 'bars',
          series: {5: {type: 'line'}},
          chartArea:{left:40,right:20,top:50,bottom:50,width:'100%',height:'100%'},
        }
        //oppure line chart
        var chart2 = new google.visualization.ColumnChart(document.getElementById('chart2_div'));
        chart2.draw(data2, options2);
    
    //Grafico 3
     var data3 = new google.visualization.DataTable();
        data3.addColumn('string','Anni');
		data3.addColumn('number', 'Eventi totali');
		
		data3.addRow(["2018/2019", <%=ev18%>])
        data3.addRow(["2019/2020", <%=ev19%>])
        data3.addRow(["2020/2021", <%=ev20%>])
		
		//for(let anno=0; anno < anni.length; anno++) {
			//data3.addRow([anni[anno], eventiTot[anno]])
			//}	
			// 2018/2019, 1
			// 2019/2020, 4
			
        var options3 = {
          title : 'Eventi svolti',
          is3D: true,
          vAxis: {title: 'Eventi'},
          hAxis: {title: 'Year'},
          seriesType: 'bars',
          series: {5: {type: 'line'}},
          chartArea:{left:40,right:20,top:50,bottom:50,width:'100%',height:'100%'}
        }
        
        var chart3 = new google.visualization.PieChart(document.getElementById('chart3_div'));
        chart3.draw(data3, options3);
}

</script>
</head>
<body>

	<%
	String user=(String)session.getAttribute("username");
	String usDB=(String)session.getAttribute("usDB");
	String pwDB=(String)session.getAttribute("pwDB");
	boolean adminDB=(boolean)session.getAttribute("admDB");%>
	
	<div id="main">
		<nav class="navbar navbar-inverse navbar-default">
	  	<div class="container">
	   	 <div class="navbar-header">
	   	 </div>
	   	 <ul class="nav navbar-nav navbar-left text-gray">
	   	   <li><a href="">Home</a></li>
	 	 </ul>
	    	 <ul class="nav navbar-nav navbar-right text-gray">
	      		<li><a href="#Dati">DATI</a></li>
	      		<li><a href="#Grafici">GRAFICI</a></li>
	    		<li><a href="#Eventi">EVENTI</a></li>
	      		<li><a href="#Map">MAPPA</a></li>
	      		<li><a href="#Scuole">SCUOLE</a></li>
	    	</ul>
	    </div>
	    </nav>
  	</div>
	
	
	<div class="container-fluid text-center" style="background-color:White;">
		<p><font size="10"><font face="Arial">Sei nel sito Prefettura e Adolescenza!</font></FONT></p>
		<p><font size="6"><font face="Arial">Su questo sito puoi consultare gli eventi delle scuole della provincia di Reggio Emilia su temi critici quali droghe, alcol e bullismo.</font> </FONT> </p>
		<img src="stemmareggio.jpeg"   height="300">
		<%if(adminDB==true){ %>
		<p><FONT size="6">Per aggiungere un utente, una scuola o degli eventi vai in fondo alla pagina</FONT></p>
		<%}%>
		<font size="4">Per consultare il sito del comune di Reggio Emilia clicca <a href="https://www.comune.re.it/">qui</a></font><p>
		<font size="4">Per consultare il sito della prefettura di Reggio Emilia clicca <a href="http://www.prefettura.it/reggioemilia/multidip/index.htm">qui</a></font>
		
		<h6>Stringa che esce dalla query: name:<%=usDB%> pw:<%=pwDB%> admin:<%=adminDB%></h6>
	</div>

	<!-- DATI / CONTATORI -->
	<article id="Dati">
		<div class="container-fluid text-center" >
			<p><font size="6"> <FONT COLOR=" #000080"> <font face="Arial"><span class="glyphicon glyphicon-file"></span><br>
			<b>DATI RACCOLTI</b></font></font></font></p>
			<!-- CONTATORE -->
				<div class="counter_wrapper">
					<div class="counter col_4 filetto_verticale_top">
						<p class="count-text" id="count_text_4">EVENTI<br>SVOLTI</p>
						<h2 class="timer count-number" id="num_4"><span id="contatore_eventi"><%=d.getEventitot()%></span></h2>
					</div>
					<div class="counter col_2 filetto_verticale_top">
						<p class="count-text" id="count_text_2">STUDENTI<br>PARTECIPANTI<br></p>
						<h2 class="timer count-number" id="num_2"><span id="numero_studenti"><%=d.getStudentiTot() %></span></h2>
					</div>
					<div class="counter col_3 filetto_verticale_top">
						<p class="count-text" id="count_text_3">SCUOLA<br>VIRTUOSA<br></p>
						<h2 class="timer count-number" id="num_3"><span id="scuola" ><%=d.getScuolaVirtuosa() %></span></h2>
					</div>
					<div class="counter col_1 filetto_verticale_top">
						<p class="count-text" id="count_text_1">TEMA<br>PRINCIPALE</p>
						<h2 class="timer count-number" id="num_1"><span id="tema_trattato"><%=d.getTema()%></span></h2>
					</div>
					<div class="counter col_6_top filetto_verticale_top">
						<p class="count-text" id="count_text_6_top">ORE<br>SVOLTE</p>
						<h2 class="timer count-number" id="num_6_top"><span id="ore" ><%=d.getOreTot() %></span></h2>
					</div>
				</div>
				<!-- FINE CONTATORE -->
			<br>
		</div>
		<br>
	</article>
	
	
	<article id="Grafici">
		<div class="container-fluid text-center" style="background-color:White;">
			<p><font size="6"> <FONT COLOR=" #000080"> <font face="Arial"><span class="glyphicon glyphicon-stats"></span><br><b>CHARTS</b></font></font></font></p>
			<div class="row">
				<div id="tbn" class="col-sm-4 text-center">	 	
					<div id="chart1_div" style="width: 100%; height: 60%; "></div>
				</div>
				<div id="tbn" class="col-sm-4 text-center">	 	
					<div id="chart2_div" style="width: 100%; height: 60%; "></div>
				</div>
				<div id="tbn" class="col-sm-4 text-center">	 	
					<div id="chart3_div" style="width: 100%; height: 60%; "></div>
				</div>
			</div>
		</div>
	</article>
	
	<!-- VISUALIZZA TUTTI GLI EVENTI -->
	<article id="Eventi">
		<div class="container-fluid text-center">
			<p><font size="6"> <FONT COLOR=" #000080"> <font face="Arial"><span class="glyphicon glyphicon-folder-open"></span><br>
			<b>EVENTI</b></font></font></font></p>
			<table>
			
			<tr><td>Evento 1 </td><td> Scuola </td><td> tema</td></tr>
			<tr><td>Evento 2 </td><td> Scuola </td><td> </td></tr>
			<tr><td>Evento 3 </td><td> </td><td> </td></tr>
			</table>
		</div>
	</article>
	
	<!-- MAPPA  -->
	<article id="Map">
		<div class="container-fluid text-center" style="background-color:White;">
		<p><font size="6"> <FONT COLOR=" #000080"> <font face="Arial"><span class="glyphicon glyphicon-map-marker"></span><br>
		<b>MAPPA</b></font></font></font></p>
			<div id="mapId" style="position: relative; top: 0; left: 70; right:70; width: 90%; height: 70%;"></div>
			
			<script>
				//MAPPA
				var lat = 44.7007;
				var longi= 10.6337;
				//String s = "Istituto SCaruffiLeviTricolore";
		
				var map = new L.map("mapId").setView([44.7007, 10.6337], 12);
	
				L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
			   	 	attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
			    	maxZoom: 17,
				}).addTo(map);
				
				<%
				ArrayList<String> scuole = new ArrayList<String>();
				scuole = d.getScuole();
				ArrayList<String> latitudini = new ArrayList<String>();
				latitudini = d.getLat();
				ArrayList<String> longitudini = new ArrayList<String>();
				longitudini = d.getLongi();
				
				for(int i = 0; i < scuole.size() ; i++){
					String s = scuole.get(i).toString();
					Double lat = Double.parseDouble(latitudini.get(i));
					Double longi = Double.parseDouble(longitudini.get(i));
					%>

					L.marker([<%=lat%>, <%=longi%>]).addTo(map).bindPopup('<b><%=s%></b>');

				<%}%>			
				
			</script>
			
		</div>
		
	</article>
	
	<!-- VISUALIZZA TUTTE LE SCUOLE -->
	<article id="Scuole">
		<div class="container-fluid text-center">
		<p><font size="6"> <FONT COLOR=" #000080"> <font face="Arial"><span class="glyphicon glyphicon-book"></span><br>
		<b>Scuole</b></font></font></font></p>
		<table>
			<tr><td><%=d.getTutteScuole() %></td></tr>
		</table>
		</div>
	</article>
	
	<!-- CERCA EVENTO -->	
	<article id="CercaEvento">
		<div class="container-fluid text-center" style="background-color:#e0ebeb;">
			<p><FONT COLOR="#000080"><font size="4"><font face="Arial"><span class="glyphicon glyphicon-filter"></span><br><b>Cerca per parole chiave</b></font></font></FONT></p>
			
			<form method="post" id="search" action="#CercaEvento">
						<table>
							<tr>
								<td><label for="scuola" style="width:250px" >Seleziona la parola chiave:</label></td>
								<td><input type="text" style="width:400px" placeholder="parola chiave" id="key" name="key" required></td>
							</tr>
							<tr><td><button type="submit" class="btn btn-success">Cerca!</button></td></tr>
	  					</table>
					</form>		
				<table>
					<%for(int j=0; j<d.Search(word).size(); j++){%>
						<tr><td><%=d.Search(word).get(j)%></td></tr>
					<%} %>
				</table>
		</div>
	</article>
	
	<!-- VISIBILE SOLO AGLI AMMINISTRATORI -->
	<%if(adminDB==true){ %>
	
	<!-- AGGIUNGI SCUOLE -->
	<article id="Aggiungi scuole">
		<div class="container-fluid text-center" style="background-color:#e0ebeb;">
			<p><font size="4"> <FONT COLOR=" #000080"><font face="Arial"><span class="glyphicon glyphicon-plus"></span><br>
			<b>Aggiungi scuola</b></font></font></font></p>
			Inserisci la scuola che vuoi aggiunere
			<!-- lo mando alla servlet login.java -->
			<form method="post" id="newScuola" action="/helloTesina01">
				<table>
					<tr>
						<td><label for="scuola" style="width:100px"><b>Scuola</b></label></td>
						<td><input type="text" style="width:250px" id="Scuola" placeholder="Inserire il nome della scuola" name="scuola" required><br/></td>
					</tr>
					<tr>
						<td><label for="lat" style="width:100px"><b>Latitudine  </b></label></td>
						<td><input type="number" style="width:250px" id="lat" step="0.0000000000001" min="0" max="100" placeholder="Inserisci la latitudine" name="lat" required><br/></td>
					</tr>
					<tr>
						<td><label for="longi" style="width:100px"><b>Longitudine  </b></label></td>
						<td><input type="number" style="width:250px" id="longi" step="0.0000000000001" min="0" max="100" placeholder="Inserisci la longitudine" name="longi" required><br/></td>
					</tr>
					<tr><td></td><td><button type="submit" name="addScuola" value="addScuola">Aggiungi</button></td></tr>
				</table>
			</form>
		</div>
	</article>
	
	
	<!-- AGGIUNGI EVENTI (FILE) -->
	<article>
		<div class="container-fluid text-center" style="background-color:#e0ebeb;">
			<p><font size="4"><FONT COLOR=" #000080"> <font face="Arial"><span class="glyphicon glyphicon-open-file"></span><br>
			<b>Aggiungi eventi</b></font></font></font></p>
			<!-- COLLEGARE MENU DROPDOWN CON SCUOLE  -->
			Aggiungi un file .csv con degli eventi
					<form method="post" id="addFile" action="/helloTesina02" enctype="multipart/form-data">
						<table>
							<tr><td><label for="scuola" style="width:300px" placeholder="Scuola">Seleziona la scuola:</label></td>
							<td><input list="scuole" style="width:400px">
								<datalist id="scuole">
									<!-- qui ci va la lista delle scuole -->
									<%for(int i = 0; i < d.getScuole().size() ; i++){
										String s = d.getScuole().get(i).toString();%>
										<option value="<%=s%>">
									<%} %>
								</datalist></td></tr>
								<br>
							 <tr><td><span><label for="file">Select a file:</label></td>
							 <td><input id="picker" type="file" style="width:400px" name="picker"></span><td><tr>
							 <tr><td><button type="submit" class="btn btn-primary" style="position: absolute; left: 25%; margin-top: 5px;">Aggiungi</button></td><td></td></tr>
	  					</table>
	  						 
							<!-- lasciamo questo script? 
							<script src="LETTURA_CODICE.js"></script>-->
						
					</form>										
									
		</div>
	</article>
	
	<!-- AGGIUNGI UTENTE -->
	<article id="Aggiungi utente">
		<div class="container-fluid text-center" style="background-color:#e0ebeb;">
			<p><font size="4"> <FONT COLOR=" #000080"><font face="Arial"><span class="glyphicon glyphicon-user"></span><br>
			<b>Aggiungi utente</b></font></font></font></p>
			Inserisci i dati dell'utente che vuoi aggiunere <br>
			<!-- lo mando alla servlet login.java -->
			<form method="post" id="newUser" action="/helloTesina01">
				<label for="username" style="width:80px"><b>Username</b></label>
				<input type="text" id="User" placeholder="Enter Username" name="username" required><br/>
				<label for="psw" style="width:80px;"><b> Password </b></label>
				<input type="password" id="Password" placeholder="Enter Password" name="password" required><br/>
				<button type="submit" name="addUser" value="addUser">Aggiungi</button>
			</form>
		</div>
	</article>
	
<%}%>
</body>
</html>
