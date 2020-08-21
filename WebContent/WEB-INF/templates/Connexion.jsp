<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	<main>
		<h1>ENI-Enchères</h1>
		<c:if test="${utilisateurId == null }">
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
			
			<a href="${pageContext.request.contextPath}/inscription"><button>Créer un compte</button></a>
		</c:if>
		<c:if test="${utilisateurId != null }">
			<h2>Vous êtes déjà connecté</h2>
			<a href="${pageContext.request.contextPath}/deconnexion"><button>Déconnexion</button></a>
			<a href="${pageContext.request.contextPath}/encheres"><button>Accueil</button></a>
		</c:if>
	</main>
</body>
</html>