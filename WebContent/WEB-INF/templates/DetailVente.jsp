<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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


	<c:if test="${utilisateurSessionId != null }">
<br><br>
<form action="${pageContext.request.contextPath}/DetailVente?idArticle=${idArticle}" method="POST">
				<label for="enchereSaisie">Votre enchère : </label>
				<input required type="text" id="enchereSaisie" name="enchereSaisie">
				<button type="submit">Proposer Enchère</button> 
			</form>
	</c:if>
<!-- 
Formu
Liste déroulante de sélection du montant (de 5 en 5 ?)
Bouton de validation
 -->


</body>
</html>