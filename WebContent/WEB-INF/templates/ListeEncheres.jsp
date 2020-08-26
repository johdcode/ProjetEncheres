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
		<header class="sticky-top">
			<nav class="navbar navbar-light bg-light">
				<span class="navbar-brand mb-0 h1">ENI-Enchère</span> <span
					class="navbar-brand mb-0 h1"> <c:if
						test="${utilisateurSessionId == null }">
						<a href="${pageContext.request.contextPath}/connexion">S'incrire
							- Se connecter</a>
					</c:if>
				</span> <span> <c:if test="${utilisateurSessionId != null }">
						<a href="${pageContext.request.contextPath}/connexion">Enchères</a>
						<a href="${pageContext.request.contextPath}/connexion">Vendre
							un article</a>
						<a
							href="${pageContext.request.contextPath}/profil?id=${utilisateurSession.noUtilisateur}">Mon
							profil</a>
						<a href="${pageContext.request.contextPath}/deconnexion">Déconnexion</a>
					</c:if>
				</span>
			</nav>
		</header>

		<h2 class="text-center">Liste des enchères</h2>
		<div class="row">
			<form action="${pageContext.request.contextPath}/encheres"
				method="GET">
				<div class="col">
					<label for="recherche">Filtres :</label> <br> <input
						type="text" name="recherche" id="recherche"
						placeholder="Le nom de l'article contient" value="${recherche}">
					<br> <br> <label for="categorie">Catégories :</label> <select
						name="categorie" id="categorie">
						<option value="">Toutes</option>
						<c:forEach var="categorieDeListe" items="${listeCategorie}">
							<option value="${categorieDeListe.libelle}"
								${categorieDeListe.libelle == categorie ? "selected" : ""}>${categorieDeListe.libelle}</option>
						</c:forEach>
					</select>

				</div>

				<c:if test="${utilisateurSessionId != null }">
					<div class="row">
						<div class="col">
							<div>
								<input type="radio" id="achat" name="type" value="achat" checked>
								<label for="achat">Achats</label>
							</div>
							<div>
								<input type="checkbox" id="encheres_ouvertes"
									name="encheres_ouvertes"> <label
									for="encheres_ouvertes">enchères ouvertes</label> <br> <input
									type="checkbox" id="mes_encheres" name="mes_encheres">
								<label for="mes_encheres">mes enchères</label> <br> <input
									type="checkbox" id="mes_encheres_remportees"
									name="mes_encheres_remportees"> <label
									for="mes_encheres_remportees">mes enchères remportées</label> <br>
							</div>
						</div>
						<div class="col">

							<div>
								<input type="radio" id="vente" name="type" value="vente">
								<label for="vente">Mes ventes</label>
							</div>
							<div>
								<input type="checkbox" id="ventes_en_cours"
									name="ventes_en_cours"> <label
									for="ventes_en_cours">ventes en cours</label> <br> <input
									type="checkbox" id="ventes_non_debutees"
									name="ventes_non_debutees"> <label
									for="ventes_non_debutees">ventes non débutées</label> <br>

								<input type="checkbox" id="ventes_terminees"
									name="ventes_terminees"> <label for="ventes_terminees">ventes
									terminées</label> <br>
							</div>
						</div>
					</div>
				</c:if>


				<button class="btn btn-primary" type="submit">Rechercher</button>
			</form>
		</div>
		<label for="listeArticle">Liste des Articles :</label>
		<c:if test="${listeArticle.size() <= 0 }">
			<div>
				<p>Aucun article disponible.</p>
			</div>
		</c:if>
		<div class="row">

			<c:forEach var="listeArticle" items="${listeArticle}">
				<div class="col-6">
					<div class="card">
						<img src="..." class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">${listeArticle.nomArticle}</h5>
							<p class="card-text">${listeArticle.description}</p>
							<p class="card-text">Prix : ${listeArticle.miseAPrix} points</p>
							<p class="card-text">Fin de l'enchère:
								${listeArticle.dateFinEnchere}</p>
							<p class="card-text">Vendeur :
								${listeArticle.utilisateur.pseudo}</p>
							<a class="btn btn-primary"
								href="${pageContext.request.contextPath}/DetailVente?idArticle=${listeArticle.noArticle}">Détail</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

</body>
</html>