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
    <title>Modification</title>
</head>
<body>
    <header>
        <h1>ENI-Encheres</h1>
        <nav>
            <a href="<%=request.getContextPath()%>/accueil">Accueil</a>
            <a href="">Qui sommes nous ?</a>
        </nav>
    </header>
    <main>
   		<h2>Pseudo : </h2>
        <form action="<%=request.getContextPath()%>/modification" method ="post">
            
            <div class = "blocForm">
                
                <label for="nom">Nom (*) : </label><input type="text" id="nom" name="nom"/>
                <label for="prenom">Prénom (*) :</label><input type="text" id="prenom" name="prenom">
                <label for="email">Email (*) :</label><input type="text" id="email" name="email">
                <label for="telephone">Téléphone : </label><input type="text" id="telephone" name="telephone">
                <label for="rue">Rue (*) :</label><input type="text" id="rue" name="rue">
                <label for="codePostal">Code Postal (*) :</label><input type="text" id="codePostal" name="codePostal">
                <label for="ville">Ville (*) :</label><input type="text" id="ville" name="ville">
               
   
          </div>
          <% if (request.getAttribute("erreur") != null) { %>
            <div class="error-message"><%= request.getAttribute("erreur") %></div>
        <% } %>
          <button type="submit" >Créer</button>
          
        </form>
        <button><a href="<%=request.getContextPath()%>/connexion">Annuler</button>
    </main>
</body>
</html>