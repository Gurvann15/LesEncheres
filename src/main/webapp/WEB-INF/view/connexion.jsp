<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <header>
        <div class="container">
            <div class="child">
                <h1>ENI-Encheres</h1>
            </div>
            <div class="child">
                <nav>
                    <ul>
                        <li>
                            <a href="/">S'inscrire</a>
                        </li>
                        <li>
                            <a href="/">Se connecter</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </header>

    <div class="container">
        <form action="<%=request.getContextPath()%>/connexion" method="post">


            <div class="child">
                <label for="identifiant">Identifiant: </label>
                    <input name="identifiant" id="identifiant" type="text">
            </div>

            <div class="child">
                <label for="password">Mot de passe: </label>
                    <input name="password" id="password" type="password">
            </div>

            <div class="child">
                <div class="underchild">
                    <input value="Connexion" name="connexion" type="submit">
                </div>
                <div class="underchild">
                    <div class="top">
                        <input type="radio" name="rememberMe" id="rememberMe" valeur="rememberMe">
                        <label for="rememberMe">Se souvenir de moi</label>
                    </div>

                    <div class="bottom">
                        <a href="">Mot de passe oublié</a>
                    </div>
                </div>
            </div>
            
            <div class="child">
                <input value="Créer un compte" name="newAccount" type="submit">
            </div>

        </form>
    
</body>
</html>