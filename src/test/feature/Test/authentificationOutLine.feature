@tag
Feature: Authetification

  @tag2
  Scenario Outline: Authetification valide et non valide
    Given ouvrir le navig
    And saisir l url suivant "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When ecrire username "<user>" et le mt de passe "<mdp>"
    And presser sur le bt login
    Then verifier le resultat affichee "<resultat>"

    Examples: 
      | user   | mdp      | resultat            |
      | Admin  | admin123 | Demo A User         |
      | admine | admin    | Invalid credentials |
      | adminn | admin123 | Invalid credentials |
