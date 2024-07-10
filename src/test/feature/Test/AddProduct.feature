@tag
Feature: Ajouter produit au panier
  je veux ajouter des produits et les verifier dans le panier

  @tag1
  Scenario: Ajouter un Produit au panier
    Given lancer chrome
    And naviguer sur l URL suivant "http://automationexercise.com"
    When cliquer sur le bouton Products et defiler la page vers haut
    And choisir le premier produit "P1" et cliquer sur Add to cart
    And cliquer sur le bouton Continue Shopping et defiler la page vers haut
    And choisir le deuxieme produit "P2" et cliquer sur Add to cart
    And cliquer sur le bouton View Cart
    Then verifier que les deux produits "P1" et "P2" sont ajoutes au panier
    And verifier leurs prix "400" et "1389" et leurs quantites "5" et "2" et leurs prix totaux "2000" et "2778"
    
    
    
    
    

  
