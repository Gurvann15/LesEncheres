<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ressources/css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Amatic+SC&family=Philosopher&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Amatic+SC&family=Fjalla+One&family=Philosopher&display=swap" rel="stylesheet">
    <title>Mes informations</title>
</head>
<body>
   <header>
		<h1>ENI-Encheres</h1>
		<nav>		
           

            <c:if test="${not empty sessionScope.utilisateurConnecte}">
				<a href="<%=request.getContextPath()%>/accueil" class="nav-link">Accueil</a>
                <a href="<%=request.getContextPath()%>/info" class="nav-link">Mes informations</a>
                <a href="<%=request.getContextPath()%>/quisommesnous">Qui sommes nous ?</a>
                <a href="<%=request.getContextPath()%>/deconnexion" class="nav-link">Déconnexion</a>
			</c:if>
		</nav>
	</header>
    <div class ="profilBloc">
	<li class="item-price">Pseudo : ${pseudoEnCours.pseudo}</li>
	<li class="item-price">Nom : ${pseudoEnCours.nom}</li>
	<li class="item-price">Prénom : ${pseudoEnCours.prenom}</li>
	<li class="item-price">Email : ${pseudoEnCours.email}</li>
	<li class="item-price">Téléphone : ${pseudoEnCours.telephone}</li>
	<li class="item-price">Rue : ${pseudoEnCours.rue}</li>
	<li class="item-price">Ville : ${pseudoEnCours.ville}</li>
	<li class="item-price">Code postal : ${pseudoEnCours.codePostal}</li>
	</div>
	<button><a href="<%=request.getContextPath()%>/modification">Modifier mes informations</button>
</body>
</html>