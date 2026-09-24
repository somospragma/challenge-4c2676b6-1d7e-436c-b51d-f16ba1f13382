# Diseño de Casos de Prueba para Sistema de Gestión de Créditos

El sistema de gestión de créditos requiere mejoras en la cobertura de pruebas. Debes implementar al menos una técnica de caja negra para aumentar la efectividad de los casos de prueba. El sistema gestiona solicitudes de crédito con atributos como monto, plazo, tipo de crédito y perfil del solicitante. Los casos de prueba deben cubrir escenarios comunes y bordes del dominio.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Técnicas de Generación de Casos de Pruebas - Caja Negra |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Partición de Equivalencia

**Objetivo:** Aplicar la técnica de Partición de Equivalencia para identificar clases de equivalencia en los datos de entrada del sistema.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identifica los atributos de entrada del sistema (monto, plazo, tipo de crédito, perfil del solicitante).
- Define clases de equivalencia para cada atributo.
- Crea casos de prueba que representen cada clase de equivalencia.

**Entregable:** Documento con clases de equivalencia definidas y casos de prueba correspondientes.

<details>
<summary>Pistas de conocimiento</summary>

- Piensa en cómo los valores de entrada se pueden agrupar en clases que se comportan de manera similar.
- Considera los límites y valores extremos para cada clase de equivalencia.

</details>

### Fase 2: Análisis de Valores Límite

**Objetivo:** Aplicar la técnica de Análisis de Valores Límite para identificar y probar los valores extremos de los atributos de entrada.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identifica los valores límite para cada atributo de entrada (monto mínimo y máximo, plazo mínimo y máximo, etc.).
- Crea casos de prueba que prueben estos valores límite.
- Verifica que el sistema se comporte correctamente en estos escenarios extremos.

**Entregable:** Documento con valores límite definidos y casos de prueba correspondientes.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda que los valores límite son aquellos que están en el borde de las clases de equivalencia.
- Prueba tanto por encima como por debajo de cada límite.

</details>

### Fase 3: Pruebas de Transición de Estado

**Objetivo:** Aplicar la técnica de Pruebas de Transición de Estado para verificar que el sistema maneja correctamente las transiciones entre estados.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identifica los estados posibles del sistema (p. ej., solicitud recibida, solicitud aprobada, solicitud rechazada).
- Define las transiciones entre estos estados.
- Crea casos de prueba que cubran todas las transiciones posibles.

**Entregable:** Documento con estados y transiciones definidos y casos de prueba correspondientes.

<details>
<summary>Pistas de conocimiento</summary>

- Piensa en cómo el sistema cambia de estado en respuesta a diferentes acciones.
- Asegúrate de cubrir todas las transiciones posibles, incluyendo aquellas que son menos comunes.

</details>

### Fase 4: Tablas de Decisión

**Objetivo:** Aplicar la técnica de Tablas de Decisión para cubrir múltiples condiciones y acciones en un solo caso de prueba.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identifica las condiciones y acciones relevantes para el sistema (p. ej., si el monto es mayor a X, aprobar la solicitud).
- Crea una tabla de decisión que cubra todas las combinaciones posibles de condiciones y acciones.
- Crea casos de prueba basados en la tabla de decisión.

**Entregable:** Documento con tabla de decisión definida y casos de prueba correspondientes.

<details>
<summary>Pistas de conocimiento</summary>

- Piensa en cómo puedes combinar diferentes condiciones para crear casos de prueba más complejos.
- Asegúrate de cubrir todas las combinaciones posibles en la tabla de decisión.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es la Partición de Equivalencia y cómo se aplica en el diseño de casos de prueba?
- **paraQueSirve**: ¿Para qué sirve el Análisis de Valores Límite en el contexto de las pruebas de software?
- **comoSeUsa**: ¿Cómo se usan las Pruebas de Transición de Estado para verificar el comportamiento del sistema?
- **erroresComunes**: ¿Cuáles son los errores comunes al aplicar la técnica de Tablas de Decisión?
- **queDecisionesImplica**: ¿Qué decisiones implica la elección de una técnica de caja negra sobre otra en un proyecto real?

## Criterios de Evaluacion

- Implementación correcta de la Partición de Equivalencia.
- Creación de casos de prueba para valores límite.
- Verificación de transiciones de estado.
- Uso de tablas de decisión para cubrir múltiples condiciones.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean test-compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
