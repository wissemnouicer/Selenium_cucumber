
@tag
Feature: enregistrement de user
  je veux enregistrer un nouveau utilisateur

  @tag1
  Scenario: creer un compte au site de commerce
    Given acceder au browser
    And ouvrir l url suivant "https://automationexercise.com/"
    Then verifier si la page d acceuil est visible
    When cliquer sur le bt Signup/Login
    Then verifier que New User Signup! est visible
    When saisir le nom "wissem ben wissem" et l email "wissem2024-1996-@gmail.com"
    And  cliquer sur le bt Signup
    Then verifier que ENTER ACCOUNT INFORMATION est visible
    When choisir Title "Mr." 
    And entrer le mot de passe "bonjour1996*"
    And selectionner la date de naissance sous forme "10" et "October" et "2010"
    And crocher la case Sign up for our newsletter
    And crocher la case Receive special offers from our partners!
    And remplir les champs First name "wissem" et Last name "ben wissem" et company "company wissem"
    And remplir l adresse "10 avenue Mongi slim"
    And selectionner Country "New Zealand" 
    And saisir state "ardhaniya" et city "tunis" 
    And saisir le Zipcode "1000" et le Nr mobile "55667788"
    And cliquer sur le bt Create Account
    Then verifier que le compte cree est visible
    
    

 
