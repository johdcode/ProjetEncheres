<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<title>Détail vente</title>
</head>
<body>

	<header>			
		<h1>ENI-Enchères</h1>
		<c:if test="${utilisateurSessionId == null }">
			<a href="${pageContext.request.contextPath}/connexion">S'incrire - Se connecter</a>
		</c:if>
		<c:if test="${utilisateurSessionId != null }">
			<a href="${pageContext.request.contextPath}/connexion">Enchères</a>
			<a href="${pageContext.request.contextPath}/connexion">Vendre un article</a>
			<a href="${pageContext.request.contextPath}/profil?id=${utilisateurSession.noUtilisateur}" >Mon profil</a>
			<a href="${pageContext.request.contextPath}/deconnexion">Déconnexion</a>
		</c:if>
	</header>

<c:if test="${utilisateurSessionId == null }">
<h3>Veuillez vous connecter pour accéder au detail de l'enchère.</h3>

</c:if>

<c:if test="${utilisateurSessionId != null }">
	<h2>Détail vente</h2>

<!-- nom article vendu -->
	<br><br>
	Description : ${articleAAfficher.description}
<!-- affichage description -->

	<br><br>
	Catégorie : ${categorieArticle.libelle}

<!-- affichage catégorie -->

	<br><br>
	Meilleur offre : ${enchereActuelle} 
<!-- affichage du montant de l'offre + de l'utilisateur qui a fait l'offre -->

	<br><br>
	Mise à prix : ${articleAAfficher.miseAPrix}
<!-- prix de départ article vendu -->

	<br><br>
	Fin de l'enchère : ${articleAAfficher.dateFinEnchere}
<!-- date fin de l'enchère -->

	<br><br>
	Retrait : ${retraitArticle.rue} ${retraitArticle.codePostal} ${retraitArticle.ville} 
<!-- rue + CP + Ville -->

	<br><br>
	Vendeur : ${utilisateurArticle.pseudo}
<!--  nom du vendeur qui visite cette page -->


	
	<br><br>
	<form action="${pageContext.request.contextPath}/DetailVente?idArticle=${idArticle}" method="POST">
					<label for="enchereSaisie">Votre enchère : </label>
					<input required type="text" id="enchereSaisie" name="enchereSaisie">
					
					<c:if test="${!empty erreurMontant }">
					<p style="color : red"><c:out value="${erreurMontant}" ></c:out><p>
					</c:if>
					<c:if test="${!empty erreurCredit }">
					<p style="color : red"><c:out value="${erreurCredit}" ></c:out><p>
					</c:if>
					<c:if test="${!empty erreurDate }">
					<p style="color : red"><c:out value="${erreurDate}" ></c:out><p>
					</c:if>
					<button type="submit">Proposer Enchère</button> 
				</form>
</c:if>



</body>
</html>