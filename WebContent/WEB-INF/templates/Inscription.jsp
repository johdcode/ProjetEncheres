<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
	<h1>ENI-Enchères</h1>
	<br>
	<br>
	<h1>Mon profil</h1>
	<form action="${pageContext.request.contextPath}/inscription" method="POST">
		<label for="pseudo">Pseudo :</label>
		<input required type="text" id="pseudo" name="pseudo">
		
		<label for="nom">Nom :</label>
		<input type="text" id="nom" name="nom"> <br>
		
		<label for="prenom">Prénom :</label>
		<input type="text" id="prenom" name="prenom">
		
		<label for="email">Email :</label>
		<input type="text" id="email" name="email"> <br>
		
		<label for="telephone">Téléphone :</label>
		<input type="text" id="telephone" name="telephone">
		
		<label for="rue">Rue :</label>
		<input type="text" id="rue" name="rue"> <br>
		
		<label for="code_postal">Code postale :</label>
		<input type="text" id="code_postal" name="code_postal">
		
		<label for="ville">Ville :</label>
		<input type="text" id="ville" name="ville"> <br>
		
		<label for="mot_de_passe">Mot de passe :</label>
		<input type="password" id="mot_de_passe" name="mot_de_passe">
		
		<label for="confirmation_mot_de_passe">Confirmation :</label>
		<input type="password" id="confirmation_mot_de_passe" name="confirmation_mot_de_passe"> <br>
		<br>
		<button type="submit">Creer</button>
		<a href="#"><button type="button"> Annuler</button></a> 
	</form>
</body>
</html>