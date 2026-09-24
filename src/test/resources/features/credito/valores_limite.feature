Feature: Análisis de Valores Límite en Créditos

  Scenario: Valor límite inferior para monto
    Given El solicitante es de tipo 'Tipo5'
    And El crédito es de tipo 'TipoE'
    When El monto de la solicitud es exactamente 1000
    Then La solicitud es aprobada

  Scenario: Valor límite superior para monto
    Given El solicitante es de tipo 'Tipo6'
    And El crédito es de tipo 'TipoF'
    When El monto de la solicitud es exactamente 100000
    Then La solicitud es aprobada

  Scenario: Valor límite inferior para plazo
    Given El solicitante es de tipo 'Tipo7'
    And El crédito es de tipo 'TipoG'
    When El plazo de la solicitud es exactamente 6 meses
    Then La solicitud es aprobada

  Scenario: Valor límite superior para plazo
    Given El solicitante es de tipo 'Tipo8'
    And El crédito es de tipo 'TipoH'
    When El plazo de la solicitud es exactamente 60 meses
    Then La solicitud es aprobada