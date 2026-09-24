Feature: Pruebas de Transición de Estado en Créditos

  Scenario: Transición de 'Solicitud Recibida' a 'Aprobada'
    Given Una solicitud de crédito está en estado 'Solicitud Recibida'
    When Se verifican los datos de la solicitud
    Then La solicitud cambia a estado 'Aprobada'

  Scenario: Transición de 'Solicitud Recibida' a 'Rechazada'
    Given Una solicitud de crédito está en estado 'Solicitud Recibida'
    When Se verifican los datos de la solicitud y no cumplen los requisitos
    Then La solicitud cambia a estado 'Rechazada'

  Scenario: Transición de 'Aprobada' a 'Desembolsada'
    Given Una solicitud de crédito está en estado 'Aprobada'
    When Se realiza el desembolso del crédito
    Then La solicitud cambia a estado 'Desembolsada'

  Scenario: Transición de 'Rechazada' a 'Reevaluada'
    Given Una solicitud de crédito está en estado 'Rechazada'
    When El solicitante presenta nueva documentación
    Then La solicitud cambia a estado 'Reevaluada'