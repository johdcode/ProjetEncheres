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
<title>Liste des enchères</title>
</head>
<body>
	<div class="container-fluid">
		<header>	
		<nav class="navbar navbar-light bg-light">
			<span class="navbar-brand mb-0 h1">ENI-Enchère</span> 
			<span
				class="navbar-brand mb-0 h1">
				<c:if test="${utilisateurSessionId == null }">
				<a href="${pageContext.request.contextPath}/connexion">S'incrire - Se connecter</a>
			</c:if>
				</span>
				<span>
				<c:if test="${utilisateurSessionId != null }">
				<a href="${pageContext.request.contextPath}/connexion">Enchères</a>
				<a href="${pageContext.request.contextPath}/connexion">Vendre un article</a>
				<a href="${pageContext.request.contextPath}/profil?id=${utilisateurSession.noUtilisateur}" >Mon profil</a>
				<a href="${pageContext.request.contextPath}/deconnexion">Déconnexion</a>
			</c:if>
				</span>
		</nav>		
		</header>
		
		<h2>Liste des enchères</h2>
		<form action="${pageContext.request.contextPath}/encheres" method="POST">
		 <div class="form-group">
			<label for="recherche">Filtres :</label> <br>
			<input class="form-control" type="text" name ="recherche" id="recherche" placeholder="Le nom de l'article contient"> <br>
			</div>
			<div class="form-group">
			<label for="categorie">Catégories :</label>
			<select class="form-control" name="categorie" id="categorie">
			   		 <option value="toutes">Toutes</option>
			   <c:forEach var = "categorie" items = "${listeCategorie}">
			   		 <option value="${categorie.libelle}">${categorie.libelle}</option>
			   
			   </c:forEach>
			</select>
			</div>
			<c:if test="${requestScope.connecte == true }">
				<div>
				  <input type="radio" id="achat" name="type" value="achat" checked>
				  <label for="achat">Achats</label>
				</div>
				<div>
				  <input type="checkbox" id="encheres_ouvertes" name="encheres_ouvertes" checked>
				  <label for="encheres_ouvertes">enchères ouvertes</label> <br>
				  
				  <input type="checkbox" id="mes_encheres" name="mes_encheres">
				  <label for="mes_encheres">mes enchères</label> <br>
				  
				  <input type="checkbox" id="mes_encheres_remportees" name="mes_encheres_remportees">
				  <label for="mes_encheres_remportees">mes enchères remportées</label> <br>
				</div>
				
				<br>
				<div>
				  <input type="radio" id="vente" name="type" value="vente">
				  <label for="vente">Mes ventes</label>
				</div>
				<div>
				  <input type="checkbox" id="ventes_en_cours" name="ventes_en_cours" checked>
				  <label for="ventes_en_cours">ventes en cours</label> <br>
				  
				  <input type="checkbox" id="ventes_non_debutees" name="ventes_non_debutees">
				  <label for="ventes_non_debutees">ventes non débutées</label> <br>
				  
				  <input type="checkbox" id="ventes_terminees" name="ventes_terminees">
				  <label for="ventes_terminees">ventes terminées</label> <br>
				</div>
			</c:if>
			
			<button class="btn btn-primary" type="submit">Recherche</button>
		</form>
		<br>
		<br>
		
		<div>
			<div>IMAGE ENCHERE</div>
			<span>PC Gamer pour travailler</span>
			<span>Prix : 210 points</span> <br>
			<span>Fin de l'enchère : 10/08/2018</span> <br>
			<br>
			<span>Vendeur : jojo44</span>
		</div>
		<br>
			<label for="listeArticle">Liste des Articles :</label>
			
		
			   <c:forEach var = "listeArticle" items = "${listeArticle}">
			   		
			   		<fieldset>
			   		<br>
			   		IMAGE ARTICLE
			   		<br><br>
			   		<a href="${pageContext.request.contextPath}/DetailVente?idArticle=${listeArticle.noArticle}"><c:out value = "${listeArticle.nomArticle}"/></a>
			   		<br>
			   		<c:out value = "${listeArticle.description}"/>
			   		<br><br>
			   		<c:out value = "Date de fin des enchères : ${listeArticle.dateFinEnchere}"/>
			   		<br>
			   		Prix : <c:out value = "${listeArticle.miseAPrix}"/>
			   		<br>
			   		Vendeur : <c:out value = "${listeArticle.noUtilisateurArticle}"/>
			   		<br><br>
			   		</fieldset>
			   		
			   </c:forEach>
			   
			   
			<br>
		
	</div>
</body >
</html>