@tag
Feature: LogOut User
  Je veux connecter au compte par des donnees correctes et puis faire la deconnexion du compte

  @tag1
  Scenario: connexion par des donnees correctes et deconnexion du compte
    Given connecter sur navig
    And entree url par "https://automationexercise.com/"
    Then verifier si la page 'Home' est visible
    When taper le bouton 'Signup/Login'
    Then verifier si la page 'Login to your account' est apparente
    When faire entrer correctement l email "wissem2024-1996-@gmail.com" et le password "bonjour1996*"
    And taper le boutonn 'Login'
    Then verifier que la page 'Logged in as username' est visible
    When cliquer sur  button 'Logout'
    Then verifier que l utilisateur se dirige vers la page de connexion
