Feature: Partición de Equivalencia en Créditos

  Scenario: Clase de equivalencia para montos bajos
    Given El solicitante es de tipo 'Tipo1'
    And El crédito es de tipo 'TipoA'
    When El monto de la solicitud es menor a 1000
    Then La solicitud es rechazada

  Scenario: Clase de equivalencia para montos altos
    Given El solicitante es de tipo 'Tipo2'
    And El crédito es de tipo 'TipoB'
    When El monto de la solicitud es mayor a 100000
    Then La solicitud es rechazada

  Scenario: Clase de equivalencia para plazos cortos
    Given El solicitante es de tipo 'Tipo3'
    And El crédito es de tipo 'TipoC'
    When El plazo de la solicitud es menor a 6 meses
    Then La solicitud es rechazada

  Scenario: Clase de equivalencia para plazos largos
    Given El solicitante es de tipo 'Tipo4'
    And El crédito es de tipo 'TipoD'
    When El plazo de la solicitud es mayor a 60 meses
    Then La solicitud es rechazada