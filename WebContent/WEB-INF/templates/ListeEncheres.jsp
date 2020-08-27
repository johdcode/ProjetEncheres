<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
<title>Liste des enchères</title>


</head>
<body>
<header>

<!-- Début Navbar -->
	<div class="container-fluid">
			
			<nav class="navbar navbar-expand-lg navbar-light bg-ligh">
 			 <a class="navbar-brand" href="${pageContext.request.contextPath}/encheres" style="font-size:24px; color:#dee2e6"><b>ENI-Enchères</b></a>
			
			<c:if test="${utilisateurSessionId == null }">
				<a 	class="nav-link text_light text-uppercase px-4 fa fa-text-height"
					href="${pageContext.request.contextPath}/connexion" 
					style="font-size:20px; color:#aed9e0" >S'incrire - Se connecter</a>
			</c:if>
			
			<c:if test="${utilisateurSessionId != null }">
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
   					<span class="navbar-toggler-icon"></span>
  				</button>
				 <div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav" >
						
						<li class="nav-item">
							<a 	class="nav-link text_light text-uppercase px-4 fa fa-text-height"
								href="${pageContext.request.contextPath}/nouvelle-vente" 
								style="font-size:20px; color:#aed9e0">
								Vendre un article 
								</a>
						</li>
						<li class="nav-item">
							<a 	class="nav-link text_light text-uppercase px-4 fa fa-text-height"
								 href="${pageContext.request.contextPath}/profil?id=${utilisateurSession.noUtilisateur}" 
								 style="font-size:20px; color:#aed9e0">
								 Mon profil
							 </a>
						<li class="nav-item">
							<a	class="nav-link text_light text-uppercase px-4 fa fa-text-height"
								 href="${pageContext.request.contextPath}/deconnexion" 
								 style="font-size:20px; color:#aed9e0">
								 Déconnexion
							 </a>
						</li>
						
					</ul> 
				</div>
			</c:if>
		</nav>
	</div>
</header>	
<!-- Fin Navbar -->

<!-- Début Titre -->
	<main>
		<div class="container container-titre">
			<div>
				<br><br>	
				<h2>Liste des Enchères</h2>
				<br><br>
			</div>	
		</div>

<!-- Fin Titre -->

<!-- Début Corps -->
	<div class="container container-corps">
		<div class="row ml-auto mr-auto">
			<br>
			<form action="${pageContext.request.contextPath}/encheres"
				method="GET"
				class="p-5 m-auto w-50">
				<div class="col">
					<c:if test="${listeErreur.size() > 0}">
						<div class="alert alert-warning" role="alert">
							<c:forEach var="message" items="${listeErreur}">
									<p>
										• ${message}
									</p>
							</c:forEach>
						</div>
					</c:if>
					<label for="recherche">Filtres :</label> <br> 
					<input type="text" name="recherche" id="recherche"
						placeholder="Le nom de l'article contient..." value="${recherche}" class='form-control'>
					<br>
					<label for="categorie">Catégories :</label> <select
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
							<div class="achat-trigger">
								<input type="radio" id="achat" name="type" value="achat" ${param.type == 'achat' ? 'checked' : ''}>
								<label for="achat">Achats</label>
							</div>
							<div class="achat">
								<input type="checkbox" id="encheres_ouvertes" name="encheres_ouvertes" ${param.encheres_ouvertes == 'on' ? 'checked' : ''}> 
								<label for="encheres_ouvertes">enchères ouvertes</label> <br> 
								<input type="checkbox" id="mes_encheres" name="mes_encheres" ${param.mes_encheres == 'on' ? 'checked' : ''}>
								<label for="mes_encheres">mes enchères</label> <br> 
								<input type="checkbox" id="mes_encheres_remportees" name="mes_encheres_remportees" ${param.mes_encheres_remportees == 'on' ? 'checked' : ''}> 
								<label for="mes_encheres_remportees">mes enchères remportées</label> <br>
							</div>
						</div>
						<div class="col">
							<div class="vente-trigger">
								<input type="radio" id="vente" name="type" value="vente" ${param.type == 'vente' ? 'checked' : ''}>
								<label for="vente">Mes ventes</label>
							</div>
							<div class="vente">
								<input type="checkbox" id="ventes_en_cours" name="ventes_en_cours" ${param.ventes_en_cours == 'on' ? 'checked' : ''}> 
								<label for="ventes_en_cours">ventes en cours</label> <br>
								<input type="checkbox" id="ventes_non_debutees" name="ventes_non_debutees" ${param.ventes_non_debutees == 'on' ? 'checked' : ''}>
								<label for="ventes_non_debutees">ventes non débutées</label> <br>
								<input type="checkbox" id="ventes_terminees" name="ventes_terminees" ${param.ventes_terminees == 'on' ? 'checked' : ''}> 
								<label for="ventes_terminees">ventes terminées</label> <br>
							</div>
						</div>
					</div>
				</c:if>


				<button class="btn btn-secondary" type="submit">Rechercher</button>
			</form>
		</div>
		<h4 for="listeArticle">Liste des Articles</h4>
		<br>
		<c:if test="${listeArticle.size() <= 0 }">
			<div class="text-center">
				<p>Aucun article disponible.</p>
			</div>
		</c:if>
		<div class="row">

			<c:forEach var="listeArticle" items="${listeArticle}">
				<div class="col-6">
					<div class="card mb-3">
						<img src="${pageContext.request.contextPath}/image/image.jpg" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">${listeArticle.nomArticle}</h5>
							<p class="card-text">${listeArticle.description}</p>
							<p class="card-text">Prix : ${listeArticle.miseAPrix} points</p>
							<p class="card-text">Fin de l'enchère: ${listeArticle.dateFinEnchere}</p>
							<p class="card-text">
							<a href="${pageContext.request.contextPath}/profil?id=${listeArticle.noUtilisateurArticle}"> Voir le vendeur</a>
							</p>
								<%-- ${listeArticle.noUtilisateurArticle --%>
							<a class="btn btn-dark"
								href="${pageContext.request.contextPath}/DetailVente?idArticle=${listeArticle.noArticle}">Détail</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<br>
		<br>
	</div>
	</main>
<!-- Fin du Corps -->

<!-- Début Footer -->
<br><br>
<br><br>
<footer class="page-footer font-small teal pt-4 sticky_bottom">

  <div class="container-fluid text-center ">
    <div class="row">
      <div class="col-md-6 mt-md-0 mt-3">
        <h5 class="text-uppercase font-weight-bold">Projet :  </h5>
        <p class="footer-text">ENI Enchère </p>
      </div>
      <hr class="clearfix w-100 d-md-none pb-3">
      <div class="col-md-6 mb-md-0 mb-3">
        <h5 class="text-uppercase font-weight-bold">Equipe : </h5>
        <p class="footer-text">Kim, John & Matthieu.</p>
      </div>
    </div>
  </div>
  <div class="footer-school text-center py-3 white-text"> © 2020 :
    <a href="https://www.eni-ecole.fr/" target = "_blank"> ENI</a>
  </div>
</footer>
<!-- Fin Footer -->
</body>

<!-- Début Footer -->
<script type="text/javascript">
document.body.onload = ()=>{
	if(document.querySelector('.achat-trigger input').checked){
		setAchatActive();
	}else{
		document.querySelector('.vente-trigger input').checked = true; 	
		setVenteActive();
	}
	
	document.querySelector('.achat-trigger input').onchange = ()=>{
		setAchatActive();
	}
	document.querySelector('.vente-trigger input').onchange = ()=>{
		setVenteActive();
	}
}
function setAchatActive(){	
	document.querySelectorAll('.achat input').forEach((e)=>{
	    e.disabled = false;
	});
	document.querySelectorAll('.achat label').forEach((e)=>{
	    e.style.color = "inherit";
	});
	document.querySelectorAll('.vente input').forEach((e)=>{
	    e.disabled = true;
	});
	document.querySelectorAll('.vente label').forEach((e)=>{
	    e.style.color = "grey";
	});
}
function setVenteActive(){	
	document.querySelectorAll('.vente input').forEach((e)=>{
	    e.disabled = false;
	});
	document.querySelectorAll('.vente label').forEach((e)=>{
	    e.style.color = "inherit";
	});
	document.querySelectorAll('.achat input').forEach((e)=>{
	    e.disabled = true;
	});
	document.querySelectorAll('.achat label').forEach((e)=>{
	    e.style.color = "grey";
	});
}

</script>
	
</body>
</html>