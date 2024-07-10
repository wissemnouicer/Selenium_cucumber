#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
@tag
Feature: Enregistrer l utilisateur avec un email existant
  je veux enregistrer avec un email existant afin qu un message d erreur s affiche

  @tag1
  Scenario: Enregistrement par un email existant et affichage d un message d erreur
    Given lancement du navigat
    When surfer vers l url "http://automationexercise.com"
    Then tester si la page "Home" est visible
    When taper sur bouton "Signup/Login"
    Then verifier si le texte "New User Signup!" est visible
    When saisir le nom et l email deja existé "wissem ben wissem" et "wissem2024-1996-@gmail.com"
    And taper sur boutonn "Signup"
    Then verifier l affichage du message d erreur suivant "Email Address already exist!"
