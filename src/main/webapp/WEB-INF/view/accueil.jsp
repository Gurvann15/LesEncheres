<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="fr.eni.lesencheres.bo.Categorie"%>
<!DOCTYPE html>
<html lang="fr">

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

<title>Page d'accueil</title>
</head>

<body>
	<header class="main-header">
		<h1>ENI-Encheres</h1>
		<nav class="main-nav">
			<c:if test="${empty sessionScope.utilisateurConnecte}">
                <a href="<%=request.getContextPath()%>/accueil" class="nav-link">Accueil</a>
                <a href="<%=request.getContextPath()%>/quisommesnous">Qui sommes nous ?</a>
                <a href="<%=request.getContextPath()%>/connexion" class="nav-link">Connexion</a>
            </c:if>
           

			<c:if test="${not empty sessionScope.utilisateurConnecte}">
				<a href="<%=request.getContextPath()%>/accueil" class="nav-link">Accueil</a>
                <a href="<%=request.getContextPath()%>/info" class="nav-link">Mes informations</a>
                <a href="<%=request.getContextPath()%>/quisommesnous">Qui sommes nous ?</a>
                <a href="<%=request.getContextPath()%>/deconnexion" class="nav-link">Déconnexion</a>
			</c:if>
		</nav>
	</header>
	<main class="main-content"></main>

	<div class="container">
		<h2 class="auction-list-heading">Liste des enchères</h2>
	</div>

	<div class="container">
		<form action="<%=request.getContextPath()%>/accueil" method="post"
			class="filter-form">
			<div class="filter-group">
				<label for="filtres">Filtres</label> <input name="filtres"
					id="filtres" type="text" class="filter-input"
					placeholder="Le nom de l'article contient">
			</div>
			<div class="filter-group">
				<label for="categories">Catégorie</label> <select name="categorie"
					class="category-select">
					<c:forEach var="categorie" items="${categories}">
						<option><c:out value="${categorie.libelle}" /></option>
					</c:forEach>
				</select>

			</div>
			<div class="filter-group">
				<input value="rechercher" name="rechercher" type="submit"
					class="filter-submit">
			</div>
		</form>
	</div>

	<div class="container item-list">
		<c:forEach var="article" items="${articles}">
			<ul>
				<li class="item">
					<div class="item-left">
						<img src="" alt="" width="" height="" class="item-image">
					</div>

					<div class="item-right">
						<h3 class="item-name">${article.nomArticle}</h3>
						<ul>
							<li class="item-price">Prix: ${article.prixInitial} crédits</li>
							<li class="item-price">Meilleure enchère :
								${article.prixVente} crédits</li>
							<li class="item-end">Fin de l'enchère:
								${article.dateFinEnchere}</li>
							<li class="item-seller">Vendeur: <c:choose>
									<c:when test="${empty sessionScope.utilisateurConnecte}">
            								${article.utilisateurVendeur.pseudo}
        							</c:when>
									<c:otherwise>
										<a class="lienPseudo"
											href="<%=request.getContextPath()%>/profil?pseudo=${article.utilisateurVendeur.pseudo}">
											${article.utilisateurVendeur.pseudo} </a>
									</c:otherwise>
								</c:choose>
							</li>
						</ul>
					</div>
				</li>
			</ul>
		</c:forEach>
	</div>

</body>

</html>
