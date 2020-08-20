<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
	<main>
		<c:if test="${connecte != true }">
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
				
				<label for="mot_de_passe">Mot de passe actuel :</label>
				<input type="password" id="mot_de_passe" name="mot_de_passe"> <br>
				
				<label for="nouveau_mot_de_passe">Nouveau mot de passe :</label>
				<input type="password" id="nouveau_mot_de_passe" name="nouveau_mot_de_passe">
				
				<label for="confirmation_nouveau_mot_de_passe">Confirmation :</label>
				<input type="password" id="confirmation_nouveau_mot_de_passe" name="confirmation_nouveau_mot_de_passe"> <br>
				
				<label for="confirmation_nouveau_mot_de_passe">Crédit :</label>
				<span>640</span> <br>
				<br>
				
				<!-- TODO : faire boutton supprimer membre -->
				<button type="submit">Enregistrer</button>
				<a href="#"><button type="button"> Supprimer mon compte</button></a> 
			</form>
		</c:if>
		<c:if test="${connecte == true }">
			<h2>Vous devez vous connecter</h2>
			<a href="${pageContext.request.contextPath}/connexion"><button>Connexion</button></a>
			<a href="${pageContext.request.contextPath}/encheres"><button>Accueil</button></a>
		</c:if>
	</main>
</body>
</html>