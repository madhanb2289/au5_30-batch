Feature: Launchng mobile app

  #Scenario: launch the mobile
  #Given launch the mobile
  #Then validate the header
  Scenario: test datatable
    Given launch URL
    When enters datas
      | fname | lname | id |
      |     1 |     2 |  3 |
      |     3 |     4 |  5 |
    Then validate header
