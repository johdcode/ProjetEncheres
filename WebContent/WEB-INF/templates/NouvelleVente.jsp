<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<title>Nouvelle vente</title>
</head>
<body>

<header>

<!-- Début Navbar -->
	<div class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-light bg-ligh">
		
			<h1>ENI-Enchères</h1>
			
			<c:if test="${utilisateurSessionId == null }">
				<a 	class="nav-link text_light text-uppercase px-4 fa fa-text-height"
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
							<a 	class="nav-link text_light text-uppercase px-4 fa fa-text-height"
								href="${pageContext.request.contextPath}/encheres" 
								style="font-size:20px; color:#aed9e0" >
								Enchères <span class="sr-only">(current)</span>
							</a>
						</li>
						<li class="nav-item">
							<a 	class="nav-link text_light text-uppercase px-4 fa fa-text-height"
								href="${pageContext.request.contextPath}/nouvelle-vente" 
								style="font-size:20px; color:#aed9e0">
								Vendre un article 
								</a>
						</li>
						<li class="nav-item">
							<a 	class="nav-link text_light text-uppercase px-4 fa fa-text-height"
								 href="${pageContext.request.contextPath}/profil?id=${utilisateurSession.noUtilisateur}" 
								 style="font-size:20px; color:#aed9e0">
								 Mon profil
							 </a>
						<li class="nav-item">
							<a	class="nav-link text_light text-uppercase px-4 fa fa-text-height"
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
			<h2>Nouvelle vente</h2>
			<br><br>
		</div>	
	</div>
<!-- Fin Titre de la page-->

	<!-- conteneur Bootstrap -->
	
	<!-- Début corp de la page -->
	<div class="container container-corps">	

<!-- Partie en cas de non connexion -->
		<c:if test="${utilisateurSessionId == null}">
			<br><br>
			<h2>Vous devez vous connecter pour accéder au détail de la vente :</h2>
			<br><br>
			<div class="row">	
					<div class= "col-12 text-center">
			<a href="${pageContext.request.contextPath}/connexion"><button class="btn btn-dark">Connexion</button></a>
			<a href="${pageContext.request.contextPath}/encheres"><button class="btn btn-dark">Accueil</button></a>
					</div>
			</div>
			<br><br>
			
		</c:if>
	
		<!-- Fin Partie en cas de non connexion -->
		<c:if test="${utilisateurSessionId != null}">
		<br><br>
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
					<form action="${pageContext.request.contextPath}/nouvelle-vente" method="post" class="form">
	
						<div class="form-group row">
							<label class="col-form-label" for="article">Article : </label>
							 <input
								name="article" type="text" class="form-control" id="article"
								maxlength="50">
						</div>
						<div class="form-group row">
							<label class="col-form-label" for="description">Description
								: </label> <input name="description" type="text" class="form-control"
								id="description" maxlength="100">
						</div>
						<div class="form-group row">
						<label class="col-form-label" for="categorie">Catégorie </label> 
							<select name="categorie" class="custom-select">
	
								<c:forEach var="categorie" items="${categories}">
										<option value="${categorie.libelle}">${categorie.libelle}</option>
								</c:forEach>
							</select>
						</div>
						

							<input name="prix" type="number" class="form-control" id="prix" title="Veuillez saisir un nombre entier">
					</div>
					<div class="form-group row">
						<label class="col-form-label" for="debut-enchere">Début de
							l'enchère : </label> 
							<input name="debut-enchere" type="date"
							class="form-control" id="debut-enchere">
					</div>
					<div class="form-group row">
						<label class="col-form-label" for="fin-enchere">Fin de
							l'enchère : </label> <input name="fin-enchere" type="date"
							class="form-control" id="fin-enchere">
					</div>

					<fieldset style="{color:black;} class="form-group row">
                        <legend>Retrait</legend>
                            <div class="form-group row">
                                <label class="col-form-label" for="rue">Rue : </label>
                                <input name="rue" type="text" class="form-control" id="rue" maxlength="50" value="${vendeur.rue}">
                            </div>
                            <div class="form-group row">
                                <label class="col-form-label" for="cp">Code Postal : </label>
                                <input name="cp" type="text" class="form-control" id="cp" maxlength="5"value="${vendeur.codePostal}">
                            </div>
                            <div class="form-group row">
                                <label class="col-form-label" for="ville">Ville : </label>
                                <input name="ville" type="text" class="form-control" id="ville" maxlength="50"value="${vendeur.ville}">
                            </div>
                  	</fieldset>
                    <div>
                    <input class="btn btn-primary" name="enregistrer" type="submit" value="Enregistrer" >
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/encheres">Annuler</a>
                    </div>
				</form>
	
						<fieldset style="{color:black;} class="form-group row">
	                        <legend>Retrait</legend>
	                            <div class="form-group row">
	                                <label class="col-form-label" for="rue">Rue : </label>
	                                <input name="rue" type="text" class="form-control" id="rue" maxlength="50" value="${vendeur.rue}">
	                            </div>
	                            <div class="form-group row">
	                                <label class="col-form-label" for="cp">Code Postal : </label>
	                                <input name="cp" type="text" class="form-control" id="cp" maxlength="5"value="${vendeur.codePostal}">
	                            </div>
	                            <div class="form-group row">
	                                <label class="col-form-label" for="ville">Ville : </label>
	                                <input name="ville" type="text" class="form-control" id="ville" maxlength="50"value="${vendeur.ville}">
	                            </div>
	                  	</fieldset>
	                 	<div class= "col-12 text-center">
		                    <input class="btn btn-dark" name="enregistrer" type="submit" value="Enregistrer" >
		                    <a class="btn btn-dark" href="${pageContext.request.contextPath}/encheres">Annuler</a>
	                    </div>
					</form>
				<br><br>
				</div>
				<div class="col-2"></div>
			</div>
		</c:if>
	</div>
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

