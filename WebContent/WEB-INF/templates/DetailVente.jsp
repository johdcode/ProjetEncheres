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
		<c:if test="${requestScope.connecte != true }">
			<a href="${pageContext.request.contextPath}/connexion">S'incrire - Se connecter</a>
		</c:if>
		<c:if test="${requestScope.connecte == true }">
			<a href="${pageContext.request.contextPath}/connexion">Enchères</a>
			<a href="${pageContext.request.contextPath}/connexion">Vendre un article</a>
			<a href="${pageContext.request.contextPath}/profil?id=${utilisateurSession.noUtilisateur}" >Mon profil</a>
			<a href="${pageContext.request.contextPath}/deconnexion">Déconnexion</a>
		</c:if>
	</header>


	<h2>Détail vente</h2>

<!-- nom article vendu -->
	<br><br>
	<h3>  </h3>
	Description : ${articleAAfficher.description}
<!-- affichage description -->

<br><br>
	Catégorie : ${categorieArticle.libelle}

<!-- affichage catégorie -->

<br><br>
Meilleur offre
<!-- affichage du montant de l'offre + de l'utilisateur qui a fait l'offre -->

<br><br>
Mise à prix :
<!-- prix de départ article vendu -->

<br><br>
Fin de l'enchère :
<!-- date fin de l'enchère -->

<br><br>
Retrait :
<!-- rue + CP + Ville -->

<br><br>
Vendeur :
<!--  nom du vendeur qui visite cette page -->

<br><br>
Ma proposition :
<br><br>


<!-- 
Formu
Liste déroulante de sélection du montant (de 5 en 5 ?)
Bouton de validation
 -->


</body>
</html>