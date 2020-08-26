<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
			<h2>Connexion</h2>
			<br><br>
		</div>	
	</div>
<!-- Fin Titre de la page-->

<!-- Début corp de la page -->
	<div class="container container-corps">
	
		<c:if test="${utilisateurSessionId == null }">
			<form method="post">
				<label for="identifiant">Identifiant :</label>
				<input required type="text" id="identifiant" name="identifiant"> <br>
				
				<label for="motDePasse">Mot de passe :</label>
				<input type="text" id="motDePasse" name="motDePasse"> <br>
				
				<input required type="submit" id="connexion" name="connexion" value="Connexion">
				
				<input type="checkbox" id="seSouvenirDeMoi" name="seSouvenirDeMoi" value="seSouvenirDeMoi">
				<label for="seSouvenirDeMoi">Se souvenir de moi</label><br>
				
				<a href="/ServletMotDePasseOublie">Mot de passe oublié</a>
			
			</form>
			
			<a href="${pageContext.request.contextPath}/inscription"><button>Créer un compte</button></a>
		</c:if>
		<c:if test="${utilisateurSessionId != null }">
			<h2>Vous êtes déjà connecté</h2>
			<a href="${pageContext.request.contextPath}/deconnexion"><button>Déconnexion</button></a>
			<a href="${pageContext.request.contextPath}/encheres"><button>Accueil</button></a>
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