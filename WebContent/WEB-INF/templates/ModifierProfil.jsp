<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
<meta charset="UTF-8">


	<title>Modifier son profil</title>

</head>
<body>
<header>
	<div class="container-fluid">
		<nav class="navbar sticky-top">
			<h1>ENI-Enchères</h1>
			<c:if test="${utilisateurSessionId == null }">
				<a href="${pageContext.request.contextPath}/connexion" style="color:#EB6424">S'incrire - Se connecter</a>
			</c:if>
			
			<c:if test="${utilisateurSessionId != null }">
				<div class="container">
						<a href="${pageContext.request.contextPath}/connexion" style="color:#EB6424" >Enchères<span class="sr-only">(current)</span></a>
					
						<a href="${pageContext.request.contextPath}/connexion" style="color:#EB6424">Vendre un article</a>
					
						<a href="${pageContext.request.contextPath}/profil?id=${utilisateurSession.noUtilisateur}" style="color:#EB6424" >Mon profil</a>
					
						<a href="${pageContext.request.contextPath}/deconnexion" style="color:#EB6424">Déconnexion</a>
				</div>	
				
				
			</c:if>
		</nav>
	</div>
</header>

<main>
	<div class="border border-white text-center">
		<br><br>	
		<h1>Mon profil</h1>
		<br><br>
	</div>	
		<c:if test="${utilisateurSessionId != null}">
			<div class="border border-white">
			<br>
			<br>
			<form action="${pageContext.request.contextPath}/modifier-profil" method="POST">
				<div class="row">
				<div class= "col-3">
				<label for="pseudo">Pseudo :</label>
				<input required type="text" id="pseudo" name="pseudo" value="${utilisateurSession.pseudo}" class="form-control">
				<label for="nom">Nom :</label>
				<input type="text" id="nom" name="nom" value="${utilisateurSession.nom}"class="form-control">
				<label for="prenom">Prénom :</label>
				<input type="text" id="prenom" name="prenom" value="${utilisateurSession.prenom}" class="form-control">
				<label for="rue">Rue :</label>
				<input type="text" id="rue" name="rue" value="${utilisateurSession.rue}" class="form-control">
				<label for="code_postal">Code postale :</label>
				<input type="text" id="code_postal" name="code_postal" value="${utilisateurSession.codePostal}" class="form-control">
				<label for="ville">Ville :</label>
				<input type="text" id="ville" name="ville" value="${utilisateurSession.ville}" class="form-control">
				
				
				</div>
				
				<div class= "col-3">
				<label for="email">Email :</label>
				<input type="text" id="email" name="email" value="${utilisateurSession.email}" class="form-control">
				<label for="telephone">Téléphone :</label>
				<input type="text" id="telephone" name="telephone" value="${utilisateurSession.telephone}" class="form-control">
				<label for="mot_de_passe">Mot de passe actuel :</label>
				<input type="password" id="mot_de_passe" name="mot_de_passe" class="form-control">
				<label for="nouveau_mot_de_passe">Nouveau mot de passe :</label>
				<input type="password" id="nouveau_mot_de_passe" name="nouveau_mot_de_passe" class="form-control">
				<label for="confirmation_nouveau_mot_de_passe">Confirmation :</label>
				<input type="password" id="confirmation_nouveau_mot_de_passe" name="confirmation_nouveau_mot_de_passe" class="form-control">	
				<br><br>
				<label for="credit">Crédit :</label>
				<span>${utilisateurSession.credit}</span> <br>
				</div>
				</div>
				 
				 <div class="row">
					<div class= "col-3">
						<button type="submit">Enregistrer</button>
					 </div>
					 <div class= "col-3">
					 <!-- TODO : faire boutton supprimer membre -->
						<a href="#"><button type="button"> Supprimer mon compte</button></a>
						<br><br>
						<br><br>
						<br><br>
					 </div>
				</div>
				 
			</form>
			</div>
		</c:if>
		<c:if test="${utilisateurSessionId == null}">
			<h2>Vous devez vous connecter</h2>
			<a href="${pageContext.request.contextPath}/connexion"><button>Connexion</button></a>
			<a href="${pageContext.request.contextPath}/encheres"><button>Accueil</button></a>
		</c:if>
		
	</main>
	

<footer class="page-footer font-small teal pt-4 sticky_bottom">

  <div class="container-fluid text-center ">
    <div class="row">
      <div class="col-md-6 mt-md-0 mt-3">
        <h5 class="text-uppercase font-weight-bold">Projet :  </h5>
        <p>ENI Enchère </p>
      </div>
      <hr class="clearfix w-100 d-md-none pb-3">
      <div class="col-md-6 mb-md-0 mb-3">
        <h5 class="text-uppercase font-weight-bold">Equipe : </h5>
        <p>Kim, John & Matthieu.</p>
      </div>
    </div>
  </div>
  <div class="footer-school text-center py-3">© 2020 :
    <a href="https://www.eni-ecole.fr/"> ENI</a>
  </div>
</footer>

</body>
</html>