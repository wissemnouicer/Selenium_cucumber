@tag
Feature: Login user
  je veux verifier le compte cree par des donnees valides du password et email
  et par la suite par des donnees incorretes

  @tag1
  Scenario: connecter au compte par des donnees valides du password et email
    Given naviguer au browser
    And ecrire url suivant "https://automationexercise.com/"
    When cliquer sur le bouton Signup/Login
    Then verifier si le texte Login to your account est visible
    When entrer l email "wissem2024-1996-@gmail.com" et le password "bonjour1996*"
    And cliquer le bouton login
    Then verifier que le texte Logged in as username est visible

  @authentificationNonvalide
  Scenario Outline: connecter au compte par des donnees invalides du password et email
    Given ouvrir le navigator
    And taper l url suivant "https://automationexercise.com/"
    When taper sur le bt Signup/Login
    And ecrire l eamil "<email>" et le mt de passe "<password>"
    And presser le bouton login
    Then verifier le resultat "<resultat>"

    Examples: 
      | email                         | password     | resultat                             |
      | wissem2024-1996//@gmail.com   | bonjour6000  | Your email or password is incorrect! |
      | wissembenwissem1996@gmail.com | bonjour1996* | Your email or password is incorrect! |
      | wissemwissem1996@gmail.com    | reseau2000   | Your email or password is incorrect! |

  