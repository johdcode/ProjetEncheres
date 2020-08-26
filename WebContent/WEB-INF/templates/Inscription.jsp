<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style-john.css">
<title>Inscription</title>
</head>
<body>
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
	<main>
		<div class="container">
			
			<c:if test="${utilisateurSessionId == null}">
				<br>
				<br>
				<div class="row">	
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<h2>Inscription</h2>
						<br>
						<form action="${pageContext.request.contextPath}/inscription" method="POST">
							<div class="row">
								<div class="col-md-6">
									<label for="pseudo">Pseudo :</label> <br>	
									<input required type="text" id="pseudo" name="pseudo" class="form-control mb-3">
								</div>
								<div class="col-md-6">
									<label for="nom">Nom :</label> <br>
									<input type="text" id="nom" name="nom" class="form-control mb-3">
								</div>
							</div>
							<div class="row">					
								<div class="col-md-6">
									<label for="prenom">Prénom :</label> <br>
									<input type="text" id="prenom" name="prenom" class="form-control mb-3">
								</div>
								<div class="col-md-6">
									<label for="email">Email :</label> <br>
									<input type="text" id="email" name="email" class="form-control mb-3">
								</div>
							</div>
							<div class="row">					
								<div class="col-md-6">
									<label for="telephone">Téléphone :</label> <br>
									<input type="text" id="telephone" name="telephone" class="form-control mb-3">
								</div>
								<div class="col-md-6">
									<label for="rue">Rue :</label> <br>
									<input type="text" id="rue" name="rue" class="form-control mb-3">
								</div>
							</div>
							<div class="row">					
								<div class="col-md-6">
									<label for="code_postal">Code postale :</label> <br>
									<input type="text" id="code_postal" name="code_postal" class="form-control mb-3">
								</div>
								<div class="col-md-6">
									<label for="ville">Ville :</label> <br>
									<input type="text" id="ville" name="ville" class="form-control mb-3"> 
								</div>
							</div>
							<div class="row">					
								<div class="col-md-6">
									<label for="mot_de_passe">Mot de passe :</label> <br>
									<input type="password" id="mot_de_passe" name="mot_de_passe" class="form-control mb-3">
								</div>
								<div class="col-md-6">
									<label for="confirmation_mot_de_passe">Confirmation :</label> <br>
									<input type="password" id="confirmation_mot_de_passe" name="confirmation_mot_de_passe" class="form-control mb-3"> <br> 
								</div>
							</div>
							<div class="row mt-3">					
								<div class="col-md-12">
									<button type="submit" class="btn btn-lg btn-success btn-block">Créer</button>
								</div>
							</div>
							<div class="row mt-3">					
								<div class="col-md">
									<%-- <a href="${pageContext.request.contextPath}/connexion"><button type="button"> Annuler</button></a> --%>
									<a href="${pageContext.request.contextPath}/connexion" class="btn btn-lg btn-danger btn-block">Annuler</a>
								</div>
							</div>
							<!-- <label for="nom">Nom :</label>
							<input type="text" id="nom" name="nom"> <br> -->
							
							<!-- <label for="prenom">Prénom :</label>
							<input type="text" id="prenom" name="prenom">
							
							<label for="email">Email :</label>
							<input type="text" id="email" name="email"> <br> -->
							
							<!-- <label for="telephone">Téléphone :</label>
							<input type="text" id="telephone" name="telephone">
							
							<label for="rue">Rue :</label>
							<input type="text" id="rue" name="rue"> <br> -->
							
							<!-- <label for="code_postal">Code postale :</label>
							<input type="text" id="code_postal" name="code_postal">
							
							<label for="ville">Ville :</label>
							<input type="text" id="ville" name="ville"> <br>
							
							<label for="mot_de_passe">Mot de passe :</label>
							<input type="password" id="mot_de_passe" name="mot_de_passe">
							
							<label for="confirmation_mot_de_passe">Confirmation :</label>
							<input type="password" id="confirmation_mot_de_passe" name="confirmation_mot_de_passe"> <br> -->
							<%-- <br>
							<button type="submit">Creer</button>
							<a href="${pageContext.request.contextPath}/connexion"><button type="button"> Annuler</button></a>  --%>
						</form>
					</div>
				</div>
			</c:if>
			<c:if test="${utilisateurSessionId != null}">
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
<!-- Fin corp de la page -->		

	
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