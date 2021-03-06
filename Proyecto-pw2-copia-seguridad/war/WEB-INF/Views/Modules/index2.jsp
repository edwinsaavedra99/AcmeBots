<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%> 
<%@ page import="model.entity.*"%> 
<%@ page import="com.google.appengine.api.users.UserService"%> 
<%@ page import ="com.google.appengine.api.users.UserServiceFactory"%>
<!DOCTYPE html>
<html class="no-js"> 
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>AB | Modulos de Robotica</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="shortcut icon" href="LOGO.png">
		<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="css/animate.css">
		<link rel="stylesheet" href="css/icomoon.css">
		<link rel="stylesheet" href="css/owl.carousel.min.css">
		<link rel="stylesheet" href="css/owl.theme.default.min.css">
		<link rel="stylesheet" href="css/magnific-popup.css">
		<link rel="stylesheet" href="css/style3.css">
		<script src="js/modernizr-2.6.2.min.js"></script>
	</head>
	<body>		
		<header id="fh5co-header" role="banner" style="position: fixed;">
			<nav class="navbar navbar-default" role="navigation" >
				<div class="container-fluid">
					<div class="navbar-header"> 
					<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle" data-toggle="collapse" data-target="#fh5co-navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
					<a class="navbar-brand" href="index.html">ACME BOTS</a>
					</div>
					
				<div id="fh5co-navbar" class="navbar-collapse collapse" >
					<ul class="nav navbar-nav navbar-right">
						<li ><a href="/index.html"><span>Home<span class="border"></span></span></a></li>
						<li><a href="/courses-page"><span>Cursos de Rob�tica<span class="border"></span></span></a></li>
						<li class="active"><a href="/modules-page"><span>M�dulos de Rob�tica<span class="border"></span></span></a></li>
						<li><a href="/advisory"><span>Desarrollo de Proyectos<span class="border"></span></span></a></li>
						<li><a href="/login"><span>Login<span class="border"></span></span></a></li>
					</ul>
				</div>
				
				</div>
			</nav>
		</header>
		<aside class="fh5co-page-heading">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1 class="fh5co-page-heading-lead">
							Modulos de Robotica
							<span class="fh5co-border"></span>
						</h1>
						
					</div>
				</div>
			</div>
		</aside>	
		<div id="fh5co-main">		
			<div class="container">
				<div class="row">
				<% List<Module> modules = (List<Module>)request.getAttribute("modules"); %>
					<% if (modules.size() > 0) { %>
						<% for (int i = 0;i< modules.size();i++) { %>
							<% Module m = (Module) modules.get(i); %>
							<div class="col-md-8 col-md-push-4" id="<%=m.getName()%>">
								<h2><%=m.getName()%></h2>
								<p><%=m.getDescription()%></p>
								<div class="row">
									<div >
										<p>Precio: $ <%=m.getPrecio()%><a href="<%=m.getBanner()%>" class="image-popup"><img src="<%=m.getBanner()%>" alt="<%=m.getName()%>" class="img-responsive img-rounded"></a></p>
									</div>
								</div>
								<div class="fh5co-spacer fh5co-spacer-xxs"></div>
								<div align="right">
									<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top" >
										<input type="hidden" name="cmd" value="_s-xclick">
										<input type="hidden" name="hosted_button_id" value="S65YREEFGPJ34">
										<input type="image" src="https://www.paypalobjects.com/es_XC/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
										<img alt="compra" border="0" src="https://www.paypalobjects.com/es_XC/i/scr/pixel.gif" width="1" height="1">
									</form>
								</div>
							</div>
						<%} %>   	 
					<%} %>  
					<div class="col-md-4 col-md-pull-8">
						<div class="fh5co-sidebox">
							<h3 class="fh5co-sidebox-lead">Lista de Modulos</h3>	
							<ul class="fh5co-post">
								<% if (modules.size() > 0) { %>
									<% for (int i = 0;i< modules.size();i++) { %>
										<% Module m = (Module) modules.get(i); %>
										<li >
											<a href="#<%=m.getName()%>" >
												<div class="fh5co-post-media"><img src="<%=m.getBanner()%>" alt="<%=m.getName()%>"></div>
												<div class="fh5co-post-blurb">
													<%=m.getName()%>
													<span class="fh5co-post-meta"><%=m.getFecha()%></span>
												</div>
											</a>
										</li>
									<%} %>   	 
								<%} %>  
							</ul>						
					</div>
					<div class="fh5co-sidebox">
						<h3 class="fh5co-sidebox-lead">Necesitas Material? </h3>	
						<ul class="fh5co-post">
							<li >
								<div >
									Puedes probar nuestro<a href="">Asesor de Ventas Tecnologicas</a> 								
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="fh5co-spacer fh5co-spacer-lg"></div>
		<footer id="fh5co-footer">		
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-sm-6">
						<div class="fh5co-footer-widget">
							<h2 class="fh5co-footer-logo">ACME BOTS</h2>
							<p>Siguenos en nuestras redes sociles a traves de estos enlaces y conocenos un poco mas GOOO ACME BOTS.</p>
						</div>
						<div class="fh5co-footer-widget">
							<ul class="fh5co-social">
								<li><a href="https://www.facebook.com/Acmebots-Arequipa-360732660766133/"><i class="icon-facebook"></i></a></li>
								<li><a href="#"><i class="icon-twitter"></i></a></li>
								<li><a href="#"><i class="icon-instagram"></i></a></li>
								<li><a href="#"><i class="icon-linkedin"></i></a></li>
								<li><a href="#"><i class="icon-youtube"></i></a></li>
							</ul>
						</div>
						<div class="fh5co-footer-widget">
							<br><br>
							<p>Puedes contactarte con un trabajador de la empresa  al 973693139.</p>
						</div>
					</div>
					<div class="col-md-2 col-sm-6">
						<div class="fh5co-footer-widget top-level">
							<h4 class="fh5co-footer-lead "></h4>
							<ul>
								
							</ul>
						</div>
					</div>				
					<div class="visible-sm-block clearfix"></div>
					<div class="col-md-2 col-sm-6">
						<div class="fh5co-footer-widget top-level">
							<h4 class="fh5co-footer-lead">Funcionalidades</h4>
							<ul class="fh5co-list-check">
								<li><a href="#">Primera funcionalidad.</a></li>
								<li><a href="#">Segunda  funcionalidad.</a></li>
								<li><a href="#">Tercera funcionalidad.</a></li>
								<li><a href="#">Cuarta funcionalidad.</a></li>
								<li><a href="#">Quinta funcionalidad.</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-2 col-sm-6">
						<div class="fh5co-footer-widget top-level">
							<h4 class="fh5co-footer-lead ">Suport</h4>
							<ul class="fh5co-list-check">
								<li><a href="/users/login">Admin.</a></li><li><a href="#">GitHub.</a></li>
								<li><a href="#">Contacto.</a></li>
								
							</ul>
						</div>
					</div>
				</div>
				<div class="row fh5co-row-padded fh5co-copyright">
					<div class="col-md-5">
						<p><small>&copy; ACME BOTS .Todos los derechos reservados. <br>Desarrolladores: by<a target="_blank"> Edwin Saavedra</a> |  by <a target="_blank">Jose Luis Monroy</a>  | by <a target="_blank"> Andrea Huayna </a></small></p>
					</div>
				</div>
			</div>
		</footer>
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Owl carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<!-- Main JS -->
	<script src="js/main.js"></script>	
	</body>
</html>