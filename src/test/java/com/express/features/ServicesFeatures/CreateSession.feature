@NoBrowser @Services
Feature: Create Sessions
  
  Scenario Outline: Validate Create Session services 
    Given I consult <resource> used for Express
    When perform a get request
    Then el servicio responde <code>

    Examples: 
      | dni        | resource                  | cuil        | mail                      | tipoOferta      | code |
      | "28269338" | "/session" | 20500000008 | "favio.veron@globant.com" | "voucherMaster" |  200 |



  Scenario Outline: Validate Create Session serrvices #https://user-session-nova-lb.qa.cloud.express.com:8087
    Given consulto a <resource> usado para Onboarding
    When realizo el post request con el cuil <cuil>, mail <mail> y tipo de oferta <tipoOferta>
    Then el servicio responde <code>

    Examples: 
      | dni        | resource                  | cuil        | mail                      | tipoOferta      | code |
      | "28269338" | "/session" | 20500000008 | "favio.veron@globant.com" | "voucherMaster" |  200 |
