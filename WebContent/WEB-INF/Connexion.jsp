<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<body>
<h1>ENI-Ench�res</h1>
<form method="post">
<label for="identifiant">Identifiant :</label>
<input type="text" id="identifiant" name="identifiant">
<label for="motDePasse">Mot de passe :</label>
<input type="text" id="motDePasse" name="motDePasse">
<input type="submit" id="connexion" name="connexion" value="Connexion">
<label for="seSouvenirDeMoi">Se souvenir de moi</label>
<input type="checkbox" id="seSouvenirDeMoi" name="seSouvenirDeMoi" value="seSouvenirDeMoi">
<a href="/ServletMotDePasseOublie">Mot de passe oubli�</a>

</form>

<a href="/WEB-INF/Inscription.jsp">Cr�er un compte</a>
</body>
</html>