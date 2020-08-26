<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style-john.css">
<link rel="stylesheet"href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Connexion</title>
</head>
<body>
<header>

<!-- Début Navbar -->
	<div class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-light bg-ligh">
		
			<h1>ENI-Enchères</h1>
			
			<c:if test="${utilisateurSessionId == null }">
				<a 	class="nav-link text_light font-weight-bold text-uppercase px-4 fa fa-text-height"
					href="${pageContext.request.contextPath}/connexion" 
					style="font-size:20px; color:#aed9e0" >S'incrire - Se connecter</a>
			</c:if>
			
			<c:if test="${utilisateurSessionId != null }">
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
   					<span class="navbar-toggler-icon"></span>
  				</button>
				 <div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav" >
						<li class="nav-item active">
							<a 	class="nav-link text_light font-weight-bold text-uppercase px-4 fa fa-text-height"
								href="${pageContext.request.contextPath}/encheres" 
								style="font-size:20px; color:#aed9e0" >
								Enchères <span class="sr-only">(current)</span>
							</a>
						</li>
						<li class="nav-item">
							<a 	class="nav-link text_light font-weight-bold text-uppercase px-4 fa fa-text-height"
								href="${pageContext.request.contextPath}/NouvelleVenteServlet" 
								style="font-size:20px; color:#aed9e0">
								Vendre un article 
								</a>
						</li>
						<li class="nav-item">
							<a 	class="nav-link text_light font-weight-bold text-uppercase px-4 fa fa-text-height"
								 href="${pageContext.request.contextPath}/profil?id=${utilisateurSession.noUtilisateur}" 
								 style="font-size:20px; color:#aed9e0">
								 Mon profil
							 </a>
						<li class="nav-item">
							<a	class="nav-link text_light font-weight-bold text-uppercase px-4 fa fa-text-height"
								 href="${pageContext.request.contextPath}/deconnexion" 
								 style="font-size:20px; color:#aed9e0">
								 Déconnexion
							 </a>
						</li>
						
					</ul> 
				</div>
			</c:if>
		</nav>
	</div>
</header>	
<!-- Fin Navbar -->
<!-- Début Titre de la page (en <h2> ) -->

<main>
	<div class="container container-titre">
		<div>
			<br><br>	
			<h2>Se connecter</h2>
			<br><br>
		</div>	
	</div>
<!-- Fin Titre de la page-->

<!-- Début corp de la page -->
	<div class="container container-corps">
	
		<c:if test="${utilisateurSessionId == null }">
			<div class="row p-4">
				<div class="col-md-3">&nbsp;</div>
				<div class="text-center col-md-6">
					<form class="form-signin" action="${pageContext.request.contextPath}/connexion" method="post">
				      <svg width="50" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="user" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" class="svg-inline--fa fa-user fa-w-14 fa-3x"><path fill="currentColor" d="M224 256c70.7 0 128-57.3 128-128S294.7 0 224 0 96 57.3 96 128s57.3 128 128 128zm89.6 32h-16.7c-22.2 10.2-46.9 16-72.9 16s-50.6-5.8-72.9-16h-16.7C60.2 288 0 348.2 0 422.4V464c0 26.5 21.5 48 48 48h352c26.5 0 48-21.5 48-48v-41.6c0-74.2-60.2-134.4-134.4-134.4z" class=""></path></svg>
				      <!-- <h2 class="h3 mb-3">Se connecter</h2> -->
				      <br>
				      <br>
				      <label for="identifiant" class="sr-only">Identifiant</label>
				      <input type="text" id="identifiant" name="identifiant" class="form-control mb-3" placeholder="Adresse mail ou pseudo" required="true" autofocus="">
				      <label for="motDePasse" class="sr-only">Mot de passe</label>
				      <input type="password" id="motDePasse" name="motDePasse" class="form-control mb-3" placeholder="Mot de passe" required="true">
				      <div class="checkbox mb-3">
						<label>
						  <input type="checkbox" id="seSouvenirDeMoi" name="seSouvenirDeMoi" value="seSouvenirDeMoi"> Se souvenir de moi
						</label>
					    <div><a href="/ServletMotDePasseOublie">Mot de passe oublié</a></div>
				      </div>
				      <div class="rom mt-3">
					      <button class="btn btn-lg btn-success btn-block" type="submit">Connexion</button>
						  <a href="${pageContext.request.contextPath}/inscription" class="btn btn-lg btn-primary btn-block">Créer un compte</a>
				      </div>
					  
		<%-- 			  <a href="${pageContext.request.contextPath}/inscription" class="btn btn-lg btn-success btn-block"><button type="button">Créer un compte</button></a> --%>
				      <p class="mt-5 mb-3 text-muted">© 2020-2021</p>
				    </form>
				</div>
			</div>
			
		</c:if>
		<c:if test="${utilisateurSessionId != null }">
			<div class="text-center vertical-center">
				<h2>Vous êtes déjà connecté</h2>
				<br>
				<br>
				<div class="row">
					<div class="col-6 ml-auto mr-auto">
						<a href="${pageContext.request.contextPath}/deconnexion" class="btn btn-lg btn-danger btn-block col-6 ml-auto mr-auto">Déconnexion</a>
					</div>
					<div class="col-6">
						<a href="${pageContext.request.contextPath}/encheres" class="btn btn-lg btn-primary btn-block col-6 ml-auto mr-auto">Accueil</a>
					</div>
				</div>
			</div>
		</c:if>
	</div>
	</main>
<!-- Fin du Corps -->
<!-- Début Footer -->
<br><br>
<br><br>
<footer class="page-footer font-small teal pt-4 sticky_bottom">

  <div class="container-fluid text-center ">
    <div class="row">
      <div class="col-md-6 mt-md-0 mt-3">
        <h5 class="text-uppercase font-weight-bold">Projet :  </h5>
        <p class="footer-text">ENI Enchère </p>
      </div>
      <hr class="clearfix w-100 d-md-none pb-3">
      <div class="col-md-6 mb-md-0 mb-3">
        <h5 class="text-uppercase font-weight-bold">Equipe : </h5>
        <p class="footer-text">Kim, John & Matthieu.</p>
      </div>
    </div>
  </div>
  <div class="footer-school text-center py-3 white-text"> © 2020 :
    <a href="https://www.eni-ecole.fr/" target = "_blank"> ENI</a>
  </div>
</footer>
<!-- Fin Footer -->
</body>
</body>
</html>