<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
<h1>ENI-Enchères</h1>

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
	
	<c:if test="${authentification == false}">
		<p>
			Le mot de passe ou l'identifiant est incorrect
		</p>
	</c:if>
	
	<button><a href="#">Créer un compte</a></button>

</body>
</html>