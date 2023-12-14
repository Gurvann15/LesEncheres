<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/ressources/css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Amatic+SC&family=Philosopher&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Amatic+SC&family=Fjalla+One&family=Philosopher&display=swap"
	rel="stylesheet">
<title>Profil</title>
</head>
<body>
	<header class="main-header">
		<h1>ENI-Encheres</h1>
		<nav class="main-nav">
			<a href="<%=request.getContextPath()%>/quisommesnous"
				class="nav-link">Qui sommes nous ?</a>

			<c:if test="${empty sessionScope.utilisateurConnecte}">
				<a href="<%=request.getContextPath()%>/connexion" class="nav-link">Connexion</a>
			</c:if>

			<c:if test="${not empty sessionScope.utilisateurConnecte}">
				<a href="<%=request.getContextPath()%>/accueil" class="nav-link">Accueil</a>
                <a href="<%=request.getContextPath()%>/info" class="nav-link">Mes informations</a>
                <a href="<%=request.getContextPath()%>/deconnexion" class="nav-link">Déconnexion</a>
			</c:if>
		</nav>
	</header>
	<div class ="profilBloc">
	<li class="item-price">Pseudo : ${utilisateurConnecte.pseudo}</li>
	<li class="item-price">Nom : ${utilisateurConnecte.nom}</li>
	<li class="item-price">Prénom : ${utilisateurConnecte.prenom}</li>
	<li class="item-price">Email : ${utilisateurConnecte.email}</li>
	<li class="item-price">Téléphone : ${utilisateurConnecte.telephone}</li>
	<li class="item-price">Rue : ${utilisateurConnecte.rue}</li>
	<li class="item-price">Ville : ${utilisateurConnecte.ville}</li>
	<li class="item-price">Code postal : ${utilisateurConnecte.codePostal}</li>
	</div>
</body>
</html>