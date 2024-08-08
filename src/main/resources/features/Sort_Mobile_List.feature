Feature: User should be abel to sort mobile list based on " NAME "

  # Test scenario 1
Scenario: Verify item in Mobile List Page Can Be sorted by "Name"
  Given User open Browser
  Given user navigate to Home page
  Given verify the title of the page
  Given user navigate to Mobile List Page


  When user Select sort by List with name


  Then verify all the products are sorted by their names
  Then  quit the browser