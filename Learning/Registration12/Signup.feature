Feature: Resgister with signup option in Upskill Application

  Scenario Outline: Validate signing up done successfully
    Given I am able to navigate onto Signin page
    Given User enters "<Firstname>" and "<Lastname>"
    * User enters "<Email>" and "<Username>" and "<Pass>"
    * User provide the "<ConfirmPass>" for confirmation
    * I click on the login button
    Then I should see the username as "<User>"
    
    Examples:
    |Firstname|Lastname|Email|Username|Pass|ConfirmaPass|User|
    |Monali|Dey|Monali1dey@gmail.com|monali.dey|garden123|garden123|Monali|
    |Moina|Dey|moina@gmail.com|moina.dey|sunday@12|sunday@12|Moina|
    

  Scenario: User is having an account already
    Given User is in the home page
    And I click on the login button and click on the login_icon
    And Click on inbox and select compose message
    And select the send to id
    And Write the subject of the email
    And the message needs to be sent
    Then click on send
