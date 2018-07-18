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
	<title>AB | Desarrollo de Proyectos</title>
	
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
						<li><a href="/index.html"><span>Home<span class="border"></span></span></a></li>
						<li><a href="/courses-page"><span>Cursos de Robotica<span class="border"></span></span></a></li>
						
						<li><a href="/modules-page"><span>Modulos de Robotica<span class="border"></span></span></a></li>
					
						<li class="active"><a href="/advisory"><span>Desarrollo de Proyectos<span class="border"></span></span></a></li>
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
						Desarrollo de Proyectos
						<span class="fh5co-border"></span>
					</h1>
					
				</div>
			</div>
		</div>
	</aside>
	
	<div id="fh5co-main">
		
		<div class="container">
			<div class="row">
				<div >
					<big><p ALIGN="justify"><strong>Tienes un proyecto</strong> y no sabes como hacerlo realidad, en AcmeBots te ayudamos brindando una asesoria a tu proyecto de calidad . <em>Ayuda intelectual </em> o algun financiamiento (ayuda economica), para hacer tu proyecto realidad en <a href="#">desarrollo de proyectos</a> ponte en contacto con nosotros siguiendo las instrucciones mas abajo.</p></big>
					
					<h2>Entra en Contacto</h2>
					<ol>
					   <li>Llena el formulario con tus datos validos (evita cometer errores).</li>
					   <li>Redacta un mensaje, detallando el tema de tu proyecto y en que necesitas ayuda </li>
					   <li>Si es necesario detallar haslo, contestamos todos los mensajes</li>
					</ol>

					<blockquote><p>Recuerda estamos para apoyarte, es un tema serio.</p></blockquote>

					

					<h2>Formulario</h2>
					<br>
					
					<div class="row">
						<font></font>
						<form method="post" action="/advisory" >
							<div class="col-md-6">
								<div class="form-group">
									<label for="name" class="sr-only"></label>
									<input placeholder="Nombre" id="name" name="name" type="text" class="form-control input-lg">
								</div>	
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="email" class="sr-only"></label>
									<input placeholder="Email" id="email" name="email" type="email" class="form-control input-lg">
								</div>	
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label for="gender" class="sr-only">Region</label>
									<select class="form-control input-lg" id="gender" name="region">
									  <option>-- Region --</option>
									  <option>Amazonas</option>
									<option>Áncash</option>
									<option>Apurímac</option>
									<option>Arequipa</option>
									<option>Cajamarca</option>
									<option>Callao</option>
									<option>Cusco</option>
									<option>Huancavelica</option>
									<option>Huánuco</option>
									<option>Ica</option>
									<option>Junin</option>
									<option>La Libertad</option>
									<option>Lambayeque</option>
									<option>Lima</option>
									<option>Loreto</option>
									<option>Madre de Dios</option>
									<option>Moquegua</option>
									<option>Pasco</option>
									<option>Piura</option>
									<option>Puno</option>
									<option>San Martin</option>
									<option>Tacna</option>
									<option>Tumbes</option>
									<option>Ucayali</option>
									</select>
								</div>	
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label for="message" class="sr-only">Mensaje</label>
									<textarea placeholder="Mensaje" id="message" class="form-control input-lg" name="mensaje" rows="3"></textarea>
								</div>	
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input type="submit" class="btn btn-primary " value="Enviar">

									<input type="reset" class="btn btn-outline  " value="Reset">
								</div>	
							</div>
						</form>	
					</div>

					<h2>Testimony (Success is only possible when you risk)</h2>
					<br>
					<p ALIGN="justify">His answer was revealing. He outlined in his face one of those smiles that appear when someone is totally confident in something, raised his eyebrows as if to prepare for the declaration of a totally obvious truth, and said: That has been the way I have made my fortune. Seated in front of me at the table of the restaurant was Homer, an American businessman of Cuban origin. Decades ago he and his family had a small business. Today they still have a family business, but in financial proportions over one billion dollars. What he told me came from his own experience. His conviction did not come from just thinking positively, but from the enjoyment of tangible results, produced by the implementation of specific strategies. What Homer told me that morning, a couple of days ago, was spinning in my head. It entered my brain as a reminder of one of the truths of life: He who does not risk does not win; misses. The popular phrase is that whoever does not risk does not win. But another part of the truth is missing. If you do not risk ... you lose the opportunity; you lose the possibility of learning; you lose the ability to change; you lose the chance to overcome your fear; You lose the strength that would allow you to take the risk next time. If you risk, you win. Not necessarily that specific for what you risked, but maybe something even more valuable: experience, learning, pride, satisfaction, inner strength, enthusiasm for life. Homer's statement came because while he was telling me about a bold and risky strategy that he is about to implement, I asked him what made him assume such a risk. The message that came to me when I heard your answer, in essence, was this: Success is only possible when you risk it. Life, to live it fully, requires that you are willing to let go of the security of what you have to go after the manifestation of what you want. If you want to increase your success and your quality of life, the question is not whether you are going to take a risk or not. There is no other way to grow that is not risking things. There is no other way forward that does not imply the possibility of losing something. The question is what are you willing to risk? The issue is how you can take an intelligent risk. Of course Homer and his family did not arrive where they are today just because they took risks. They did not assume any risk. Those who assumed did so consciously and intelligently. They took a risk for what made business sense, sense of success. They acted on the risks they had the ability to assume. Risks whose benefits, if successful, were much greater than the possible negative consequences of things not coming out as expected. Risking or not risking is not the question. For a full life, not risking yourself is not an option. Think about it. Anything that has the potential to lead you to a better life experience carries a risk. Being willing to smile is risking others to think you ridiculous. To be willing to say something is to risk being opposed by others to your ideas. Being willing to go after your dream is to risk being branded as crazy by others. Being willing to change is risking others rejecting you. Being willing to ask is to risk the other telling you no. To be willing to love is to risk being unrequited. But there is no life without the willingness to surrender to it. The biggest risk is not to try, but to stagnate. The greatest risk is not to dare, but then to repent. And perhaps, the greatest risk of all, is to live without having lived. Perhaps what at this moment separates you from something you want-be it an increase in your income, a better relationship, a better health, a fulfilled dream-is a risk you have not taken yet. Perhaps what has held you back until now is not an obstacle out there, but a challenge to overcome there within you. The challenge of daring you Take a chance To be willing to release the security of what you have for the construction of what you want. Remember: risking yourself is not optional. The options are on how to do it and when to do it. If it is not now, when? What are you waiting for? Take the risk. Not anybody or in any way. One that is worth it. One that is intelligent to assume. One that, regardless of the result, allows you to connect more intensely with the wonder of living.</p>

					<img src="http://www.inviertaparaganar.com/blog/wp-content/uploads/2016/03/Henry-Ford-Henry-Ford.jpg" >
					
					

					
					
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
						<h2 class="fh5co-footer-logo">ACME BOTS</h2><br>
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
