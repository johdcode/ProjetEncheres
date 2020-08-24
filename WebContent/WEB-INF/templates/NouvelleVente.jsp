<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<title>Nouvelle vente</title>
</head>
<body>

	<!-- conteneur Bootstrap -->
	<div class="container-fluid">
		<!-- Navbarre -->
		<nav class="navbar navbar-light bg-light">
			<span class="navbar-brand mb-0 h1">ENI-Enchère</span> <span
				class="navbar-brand mb-0 h1">Nouvelle vente</span>
		</nav>

		<div class="row">
			<div class="col-4">
			<!-- 	<div class="card" style="width: 18rem;">
					<img src="..." class="card-img-top" alt="...">
					<div class="card-body">
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
					</div>
				</div> -->
			</div>
			<div class="col">
				<form action="${pageContext.request.contextPath}/NouvelleVenteServlet" method="post"class="form">
					<div class="form-group row">
						<label class="col-form-label" for="article">Article : </label> 
						<input name="article" type="text"class="form-control" id="article" maxlength="50">
					</div>
					<div class="form-group row">
						<label class="col-form-label" for="description">Description : </label> 
						<input name="description" type="text" class="form-control" id="description"maxlength="100">
					</div>
					<div class="form-group row">
					<label class="col-form-label" for="categorie">Catégorie </label> 
						<select name="categorie" class="custom-select">
							<option value="toutes">Toutes</option>
							<c:forEach var="categorie" items="${categories}">
								<option value="${categorie.libelle}">${categorie.libelle}</option>
							</c:forEach>
						</select>
					</div>
					<!-- <div class="form-group row">
						<label class="col-form-label" for="photo">Photo de l'article </label> 
						<input name="photo" type="file"class="form-control" id="photo">
					</div> -->
					<div class="form-group row">
						<label class="col-form-label" for="prix">Mise à prix : </label> 
						<input name="prix"type="number"class="form-control" id="prix">
					</div>
					<div class="form-group row">
						<label class="col-form-label" for="debut-enchere">Début de l'enchère : </label> 
						<input name="debut-enchere" type="date" class="form-control" id="debut-enchere">
					</div>
					<div class="form-group row">
						<label class="col-form-label" for="fin-enchere">Fin de l'enchère : </label> 
						<input name="fin-enchere" type="date" class="form-control" id="fin-enchere">
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
			</div>
		</div>
	</div>
</body>
</html>