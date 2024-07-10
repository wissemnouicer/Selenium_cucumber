
@tag
Feature: google
  je veux acceder à l url de google puis faire ma recherche

  @tag1
  Scenario: recherche google via keys entrée
    Given ouvrir le navigateur chrome
    And saisir url de google
    When saisir le mot à rechercher
    And cliquer sur le key entrée
    Then verifier le contenu de url

  
