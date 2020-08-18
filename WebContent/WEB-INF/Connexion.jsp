<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<body>
<h1>ENI-Enchères</h1>

<form method="post">
<label for="identifiant">Identifiant :</label>
<input required type="text" id="identifiant" name="identifiant">
<label for="motDePasse">Mot de passe :</label>
<input type="text" id="motDePasse" name="motDePasse">
<input required type="submit" id="connexion" name="connexion" value="Connexion">
<label for="seSouvenirDeMoi">Se souvenir de moi</label>
<input type="checkbox" id="seSouvenirDeMoi" name="seSouvenirDeMoi" value="seSouvenirDeMoi">
<a href="/ServletMotDePasseOublie">Mot de passe oublié</a>

</form>
<p><c:if test="${authentification = false}">Le mot de passe ou l'identifiant est incorrect</c:if></p>
<a href="/WEB-INF/Inscription.jsp">Créer un compte</a>
</body>
</html>