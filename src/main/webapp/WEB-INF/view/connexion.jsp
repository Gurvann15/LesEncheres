<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
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
    <title>Connexion</title>
</head>

<body>
    <header>
        <h1>ENI-Encheres</h1>
        <nav>	
        
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
    <main>
    <form action="<%=request.getContextPath()%>/connexion"method ="post">
        <label for="identifiant">Identifiant : </label>
      <input type="text" id="identifiant" name="identifiant"/>
      <label for="password">Mot de passe : </label>
      <input type="password" id="password" name="password"/>
      <% if (request.getAttribute("erreur") != null) { %>
            <div class="error-message"><%= request.getAttribute("erreur") %></div>
        <% } %>
      <div class ="Souvenir"><input type="checkbox" cols="1"><libellé class ="libelle">Se souvenir de moi</libellé></input></div>
      <button type="submit" >Se connecter</button>
    </form>
    
    <button><a href="<%=request.getContextPath()%>/inscription">Créer un compte</button>
    <div class="password-forgot"><a href="">Mot de passe oublié</a></div>
</main>
</body>
</html>
