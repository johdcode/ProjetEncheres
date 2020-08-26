<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style-john.css">
<title>Inscription</title>
</head>
<body>
	<main>
		<div class="container">
			<c:if test="${utilisateurSessionId == null}">
				<h1>ENI-Enchères</h1>
				<br>
				<br>
				<div class="row">	
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<h2>Inscription</h2>
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
</body>
</html>