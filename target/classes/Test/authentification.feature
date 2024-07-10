
@AuthentificationOrangeHRM
Feature: Orange HRM
  je veux s authentifier au site Orange HRM

  @tag1
  Scenario: Authentification au site Orange HRM
    Given Accéder au navigateur Chrome
    And saisir url de Orange HRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When saisir user name "Admin" et le password "admin123"
    And cliquer sur le bouton Login
    Then verifier le contenu du dashboard "dsvwrgfr mkmk"
    
 
