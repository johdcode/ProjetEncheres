<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>Modifier son profil</title>

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
								href="${pageContext.request.contextPath}/connexion" 
								style="font-size:20px; color:#aed9e0" >
								Enchères <span class="sr-only">(current)</span>
							</a>
						</li>
						<li class="nav-item">
							<a 	class="nav-link text_light font-weight-bold text-uppercase px-4 fa fa-text-height"
								href="${pageContext.request.contextPath}/connexion" 
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
	
<!-- Fin Navbar -->
</header>

<main>

<!-- Début Titre de la page (en <h2> ) -->
	<div class="container container-titre">
		<div>
			<br><br>	
			<h2>Mon profil</h2>
			<br><br>
		</div>	
	</div>
<!-- Fin Titre de la page-->

<!-- Début corp de la page -->
	<div class="container container-corps">
		<c:if test="${utilisateurSessionId != null}">
			<div class="border border-white">
			<br>
			<br>
			<form action="${pageContext.request.contextPath}/modifier-profil" method="POST">
				<div class="row">
				<div class= "col-6">
				<label for="pseudo">Pseudo :</label>
				<input required type="text" id="pseudo" name="pseudo" value="${utilisateurSession.pseudo}" class="form-control">
				<label for="nom">Nom :</label>
				<input type="text" id="nom" name="nom" value="${utilisateurSession.nom}"class="form-control">
				<label for="prenom">Prénom :</label>
				<input type="text" id="prenom" name="prenom" value="${utilisateurSession.prenom}" class="form-control">
				<label for="rue">Rue :</label>
				<input type="text" id="rue" name="rue" value="${utilisateurSession.rue}" class="form-control">
				<label for="code_postal">Code postale :</label>
				<input type="text" id="code_postal" name="code_postal" value="${utilisateurSession.codePostal}" class="form-control">
				<label for="ville">Ville :</label>
				<input type="text" id="ville" name="ville" value="${utilisateurSession.ville}" class="form-control">
				
				
				</div>
				
				<div class= "col-6">
				<label for="email">Email :</label>
				<input type="text" id="email" name="email" value="${utilisateurSession.email}" class="form-control">
				<label for="telephone">Téléphone :</label>
				<input type="text" id="telephone" name="telephone" value="${utilisateurSession.telephone}" class="form-control">
				<label for="mot_de_passe">Mot de passe actuel :</label>
				<input type="password" id="mot_de_passe" name="mot_de_passe" class="form-control">
				<label for="nouveau_mot_de_passe">Nouveau mot de passe :</label>
				<input type="password" id="nouveau_mot_de_passe" name="nouveau_mot_de_passe" class="form-control">
				<label for="confirmation_nouveau_mot_de_passe">Confirmation :</label>
				<input type="password" id="confirmation_nouveau_mot_de_passe" name="confirmation_nouveau_mot_de_passe" class="form-control">	
				<br><br>
				</div>
				</div>
				
				<br><br>
				 <div class="row">
					<div class= "col-12 text-center">
						<button type="submit" class="btn btn-dark">Enregistrer</button>
					 </div>
					<br><br>
				 </div>
				<br><br>
				<div class="mise-en-avant">
					<label for="credit">Crédit :</label>
					<span >${utilisateurSession.credit}</span> <br>
				</div>
				<br><br>
				
				<div class="row">	
					<div class= "col-12 text-center">
					<!--  TODO : faire boutton supprimer membre -->
					<a href="#"><button type="button" class="btn btn-dark"> Supprimer mon compte</button></a>	
					 </div>
				
				
				</div> 
			</form>
			</div>
			<br><br>
			
		</c:if>
		
		<!-- Partie en cas de non connexion -->
		<c:if test="${utilisateurSessionId == null}">
			<br><br>
			<h2>Vous devez vous connecter</h2>
			<br><br>
			<div class="row">	
					<div class= "col-12 text-center">
			<a href="${pageContext.request.contextPath}/connexion"><button class="btn btn-dark">Connexion</button></a>
			<a href="${pageContext.request.contextPath}/encheres"><button class="btn btn-dark">Accueil</button></a>
					</div>
			</div>
			<br><br>
			
		</c:if>
	</div>
		<!-- Fin Partie en cas de non connexion -->
<!-- Fin corp de la page -->		
	</main>
	


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

</html>