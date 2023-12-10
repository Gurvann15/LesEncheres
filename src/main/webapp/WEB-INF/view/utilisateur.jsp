<%@ page import="fr.eni.lesencheres.bo.Utilisateur" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.eni.lesencheres.bll.UtilisateurManager" %>
<%@ page import="fr.eni.lesencheres.dal.DAOFactory" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Liste des utilisateurs</title>
</head>
<body>
    <h1>Liste des utilisateurs</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Numéro Utilisateur</th>
                <th>Pseudo</th>
                <!-- Ajoutez d'autres colonnes selon les attributs de votre classe Utilisateur -->
            </tr>
        </thead>
        <tbody>
            <c:forEach var="utilisateur" items="${utilisateurs}">
                <tr>
                    <td>${utilisateur.numUtilisateur}</td>
                    <td>${utilisateur.pseudo}</td>
                    <!-- Ajoutez d'autres colonnes selon les attributs de votre classe Utilisateur -->
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
