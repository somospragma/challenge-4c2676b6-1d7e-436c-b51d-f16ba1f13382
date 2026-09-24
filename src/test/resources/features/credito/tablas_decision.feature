Feature: Tablas de Decisión para Créditos

  Scenario: Verificar múltiples condiciones y acciones en un solo caso de prueba
    Given que el sistema está en funcionamiento
    When se ingresan los siguientes datos:
      | Monto | Plazo | Tipo de Crédito | Perfil del Solicitante |
      | 10000  | 12    | Personal        | Empleado Permanente |
    Then el sistema debe aprobar la solicitud
    And se debe enviar una notificación al solicitante

  Scenario: Verificar rechazo de solicitud con condiciones específicas
    Given que el sistema está en funcionamiento
    When se ingresan los siguientes datos:
      | Monto | Plazo | Tipo de Crédito | Perfil del Solicitante |
      | 50000  | 36    | Hipotecario     | Desempleado         |
    Then el sistema debe rechazar la solicitud
    And no se debe enviar ninguna notificación al solicitante