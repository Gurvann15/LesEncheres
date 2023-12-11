<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page d'accueil</title>
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
                            <a href="/">Enchères</a> <!-- Pas présent sur la maquette mobile-->
                        </li>
                        <li>
                            <a href="/">Vendre un article</a>
                        </li>
                        <li>
                            <a href="/">Mon profil</a>
                        </li>
                        <li>
                            <a href="/">Déconnexion</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </header>

    <div class="container">
        <h2>Liste des enchères</h2>
    </div>



    <div class="container">

        <form action="/connexion" method="post">

            <div class="child">

                <div class="underchild">
                    <label for="filtres">Filtres</label>
                    <input name="filtres" id="filtres" type="text">
                </div>

                <div class="underchild">
                    <label for="categories">Catégorie</label>
                    <select name="categorie">
                        <option>Toutes</option>
                        <option>Informatique</option>
                        <option>Ameublement</option>
                        <option>Vêtements</option>
                        <option>Sport&Loisirs</option>
                    </select>

                </div>
            </div>

            <div class="child">
                <input value="rechercher" name="rechercher" type="submit">
               
            </div>

        </form>
    </div>

    <div class="container">
        <!-- J'ai choisi underchild pour facilité le css à row mais normalement child et spécification avec une classe-->
        <div class="underchild">
            <label>
                <input type="radio" name="purchases" value="purchases"> Achats
              </label>
              <input type="openAuction" id="openAuction" name="openAuction"> enchères ouvertes
              <input type="currentAuction" id="currentAuction" name="currentAuction"> mes enchères en cours
              <input type="wonAuction" id="wonAuction" name="wonAuction"> mes enchères remportées
          
              <br>
          
              <label>
                <input type="radio" name="sales" value="sales"> Mes ventes
              </label>
              <input type="currentSales" id="currentSales" name="currentSales"> mes ventes en cours
              <input type="salesNoStarted" id="salesNoStarted" name="salesNoStarted"> ventes non débutées
              <input type="salesFinished" id="salesFinished" name="salesFinished"> ventes terminées
        </div>

        <div class="underchild"></div>
    </div>


    <div class="container">

        <div class="childList">
            <ul>

                <li>
                    <div class="left">
                        <img src="" alt="" width="" height="">
                    </div>

                    <div class="right">
                        <h3>Nom de l'objet</h3>
                        <ul>
                            <li>Prix: </li>
                            <li>Fin de l'enchère: </li>
                            <li>Vendeur: </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>

        <div class="childList">
            <ul>

                <li>
                    <div class="left">
                        <img src="" alt="" width="" height="">
                    </div>

                    <div class="right">
                        <h3>Nom de l'objet</h3>
                        <ul>
                            <li>Prix: </li>
                            <li>Fin de l'enchère: </li>
                            <li>Vendeur: </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>