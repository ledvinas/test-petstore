  @PetStore

  Feature: Test pet store

  Scenario: Negative Pet store
    Given actor has a pet inserted
    When actor retrieves pet
    #Then actor can see that pet was not created

  Scenario: Positive Pet store test
    Given actor has a pet inserted
    When actor retrieves pet
    Then actor can see that pet was placed in pet store

  Scenario: Security Pet store test

