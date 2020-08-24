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
<title>Profil ${utilisateur != null ? 'de ' += utilisateur.pseudo : 'inconnu'}</title>
</head>
<body>
	<% // TODO: Dans la jsp %>
	<c:if test="${utilisateur != null}">
		<h1>ENI-Enchères</h1>
		<br>
		<br>
		<label for="pseudo">Pseudo: </label>
		<span class="pseudo">${utilisateur.pseudo}</span><br>
<%-- 		
		<label for="nom">Nom: </label>
		<span class="nom">${utilisateur.nom}</span><br>
		 --%>
		<label for="prenom">Prénom: </label>
		<span class="prenom">${utilisateur.prenom}</span><br>
<%-- 		
		<label for="email">Email: </label>
		<span class="email">${utilisateur.email}</span><br>
		
		<label for="telephone">Téléphone: </label>
		<span class="telephone">${utilisateur.telephone}</span><br>
		
		<label for="rue">Rue: </label>
		<span class="rue">${utilisateur.rue}</span><br>
		 --%>
		<label for="code_postal">Code postal: </label>
		<span class="code_postal">${utilisateur.codePostal}</span><br>
		
		<label for="ville">Ville: </label>
		<span class="ville">${utilisateur.ville}</span><br>
		
		<c:if test="${(utilisateur.nom != null) && (utilisateur.nom == utilisateurSession.nom)}">
			<a href="${pageContext.request.contextPath}/modifier-profil"><button>Modifier</button></a>
		</c:if>
	</c:if>
	
	<c:if test="${utilisateur == null}">
		<h2>Utilisateur inconnu</h2>
		<p>
			L'utilisateur n'a pas été trouvé.
		</p>
	</c:if>
</body>
</html>