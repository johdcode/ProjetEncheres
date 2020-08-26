<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style-john.css">
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	<main class="container">
		<h1>ENI-Enchères</h1>
		<br>
		<c:if test="${utilisateurSessionId == null }">
			<!-- <form method="post">
				<div class="form-group row">
					<label for="identifiant">Identifiant :</label>
					<input required type="text" id="identifiant" name="identifiant"> <br>
				</div>
				
				<div class="form-group row">
					<label for="motDePasse">Mot de passe :</label>
					<input type="text" id="motDePasse" name="motDePasse"> <br>
				</div>
				
				<input required type="submit" id="connexion" name="connexion" value="Connexion">
				
				<input type="checkbox" id="seSouvenirDeMoi" name="seSouvenirDeMoi" value="seSouvenirDeMoi">
				<label for="seSouvenirDeMoi">Se souvenir de moi</label><br>
				
				<a href="/ServletMotDePasseOublie">Mot de passe oublié</a>
			
			</form> -->
			<div class="row">
				<div class="col-md-3">&nbsp;</div>
				<div class="text-center col-md-6">
					<form class="form-signin" action="${pageContext.request.contextPath}/connexion" method="post">
				      <svg width="50" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="user" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" class="svg-inline--fa fa-user fa-w-14 fa-3x"><path fill="currentColor" d="M224 256c70.7 0 128-57.3 128-128S294.7 0 224 0 96 57.3 96 128s57.3 128 128 128zm89.6 32h-16.7c-22.2 10.2-46.9 16-72.9 16s-50.6-5.8-72.9-16h-16.7C60.2 288 0 348.2 0 422.4V464c0 26.5 21.5 48 48 48h352c26.5 0 48-21.5 48-48v-41.6c0-74.2-60.2-134.4-134.4-134.4z" class=""></path></svg>
				      <h2 class="h3 mb-3">Se connecter</h2>
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
	</main>
</body>
</html>