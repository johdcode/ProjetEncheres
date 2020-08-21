<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des enchères</title>
</head>
<body>
	<main>
		<header>			
			<h1>ENI-Echères</h1>
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
		
		<h2>Liste des enchères</h2>
		<form action="${pageContext.request.contextPath}/encheres" method="POST">
			<label for="recherche">Filtres :</label> <br>
			<input type="text" name ="recherche" id="recherche" placeholder="Le nom de l'article contient"> <br>
			<br>
			<label for="categorie">Catégories :</label>
			<select name="categorie" id="categorie">
			    <option value="toute">Toutes</option>
			    <option value="cat">Cat</option>
			    <option value="hamster">Hamster</option>
			    <option value="parrot">Parrot</option>
			    <option value="spider">Spider</option>
			    <option value="goldfish">Goldfish</option>
			</select> <br>
			
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
			
			<button type="submit">Recherche</button>
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
		<div>
			<div>IMAGE ENCHERE</div>
			<span>Rocket stove pour riz et pâtes</span>
			<span>Prix : 185 points</span> <br>
			<span>Fin de l'enchère : 09/10/2018</span> <br>
			<br>
			<span>Vendeur : jiji56</span>
		</div>
	</main>
</body >
</html>