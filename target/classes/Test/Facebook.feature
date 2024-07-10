
@tag
Feature: creation compte facebook
  je veux creer un nouveau compte facebook

  @tag1
  Scenario: creer un compte facebook
    Given ouvrir chrome
    And ouvrir url Facebook "https://www.facebook.com/?locale=fr_FR"
    When cliquer sur le bouton Creer nouveau compte
    And remplir les champs Prenom "wissem" et nom de la famille "nouicer"
    And remplir les champs Nr mobile "88779966" et mot de passe "wissem2024*"
    And selectionner la date de naissance "10 oct 2009" et le genre
    Then cliquer sur le bouton s inscrire

 
