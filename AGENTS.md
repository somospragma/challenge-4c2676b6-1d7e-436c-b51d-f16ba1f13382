# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Diseño de Casos de Prueba para Sistema de Gestión de Créditos**.

| | |
|---|---|
| Tema | Técnicas de Generación de Casos de Pruebas - Caja Negra |
| Nivel | advanced-l2 |
| Chapter | Calidad de Software |
| Especialidad | Automatizador |
| Stack | Java / Serenity BDD 4.1.24 |
| Patron arquitectonico | Page Object Model con Screenplay para pruebas de API y UI |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz con el runner y el plugin de reportes`
- `src/test/resources/features con los .feature en Gherkin`
- `src/test/java/.../runners con el runner`
- `src/test/java/.../pages o /tasks con Page Objects o Screenplay`
- `src/test/java/.../steps con los step definitions`
- `serenity.conf o config del entorno`

Trampas conocidas:

- Sin parent POM que gestione versiones, TODA dependencia lleva su `<version>` completa de tres segmentos.
- El groupId de Serenity es `net.serenity-bdd`, NO `org.serenity-bdd`. Con el groupId equivocado el artefacto no existe y el build muere resolviendo dependencias.
- Coordenadas exactas de lo mas usado: Selenium `org.seleniumhq.selenium:selenium-java`, Rest Assured `io.rest-assured:rest-assured`, Karate `com.intuit.karate:karate-junit5`, Cucumber `io.cucumber:cucumber-java`.
- JUnit 5 se declara con `junit-jupiter` (agregador) y necesita `maven-surefire-plugin` reciente para ejecutarse.
- Serenity y Cucumber tienen que ser de lineas compatibles entre si; mezclarlas rompe el runner.

Dependencias:

- net.serenity-bdd:serenity-core 4.1.24
- net.serenity-bdd:serenity-cucumber 4.1.24
- io.cucumber:cucumber-java 7.15.0
- io.cucumber:cucumber-junit-platform-engine 7.15.0
- org.junit.platform:junit-platform-suite 1.10.2
- org.junit.jupiter:junit-jupiter 5.10.2
- org.apache.maven.plugins:maven-surefire-plugin 3.2.5
- org.apache.maven.plugins:maven-failsafe-plugin 3.2.5
- com.googlecode.lambdaj:lambdaj 2.3.3
- com.fasterxml.jackson.core:jackson-databind 2.17.0

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean test-compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean test-compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Partición de Equivalencia**: Documento con clases de equivalencia definidas y casos de prueba correspondientes.
- **Fase 2 — Análisis de Valores Límite**: Documento con valores límite definidos y casos de prueba correspondientes.
- **Fase 3 — Pruebas de Transición de Estado**: Documento con estados y transiciones definidos y casos de prueba correspondientes.
- **Fase 4 — Tablas de Decisión**: Documento con tabla de decisión definida y casos de prueba correspondientes.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Referencias colgando (8)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/test/java/com/pragma/creditos/steps/ValoresLimiteSteps.java` — `SolicitarCredito.ejecutar`
      Se invoca `ejecutar` sobre `SolicitarCredito`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/creditos/steps/TransicionEstadoSteps.java` — `SolicitarCredito.cambiarEstado`
      Se invoca `cambiarEstado` sobre `SolicitarCredito`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/creditos/steps/TransicionEstadoSteps.java` — `SolicitarCredito.obtenerEstado`
      Se invoca `obtenerEstado` sobre `SolicitarCredito`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/creditos/steps/TablasDecisionSteps.java` — `SolicitarCredito.ejecutar`
      Se invoca `ejecutar` sobre `SolicitarCredito`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/creditos/steps/TablasDecisionSteps.java` — `SolicitarCredito.obtenerResultado`
      Se invoca `obtenerResultado` sobre `SolicitarCredito`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `pom.xml` — `net.serenity-bdd:serenity-cucumber@4.1.24`
      net.serenity-bdd:serenity-cucumber declara la version 4.1.24, pero Maven Central respondio que esa version no existe. Es una version inventada: reemplazala por una version publicada real, o si no se conoce con certeza, usa el mecanismo centralizado del ecosistema (BOM/parent/platform/version catalog) y no declares una version individual.
- [ ] `pom.xml` — `net.serenity-bdd:serenity-core@4.1.24`
      net.serenity-bdd:serenity-core declara la version 4.1.24, pero Maven Central respondio que esa version no existe. Es una version inventada: reemplazala por una version publicada real, o si no se conoce con certeza, usa el mecanismo centralizado del ecosistema (BOM/parent/platform/version catalog) y no declares una version individual.
- [ ] `pom.xml` — `org.junit.platform:junit-platform-suite@5.10.2`
      org.junit.platform:junit-platform-suite declara la version 5.10.2, pero Maven Central respondio que esa version no existe. Es una version inventada: reemplazala por una version publicada real, o si no se conoce con certeza, usa el mecanismo centralizado del ecosistema (BOM/parent/platform/version catalog) y no declares una version individual.

### Presentes (16)

- `pom.xml`
- `src/test/java/com/pragma/creditos/models/CreditoData.java`
- `src/test/resources/features/credito/particion_equivalencia.feature`
- `src/test/resources/features/credito/valores_limite.feature`
- `src/test/resources/features/credito/transicion_estado.feature`
- `src/test/resources/features/credito/tablas_decision.feature`
- `src/test/java/com/pragma/creditos/runners/RunCucumberTest.java`
- `src/test/java/com/pragma/creditos/steps/ParticionEquivalenciaSteps.java`
- `src/test/java/com/pragma/creditos/steps/ValoresLimiteSteps.java`
- `src/test/java/com/pragma/creditos/steps/TransicionEstadoSteps.java`
- `src/test/java/com/pragma/creditos/steps/TablasDecisionSteps.java`
- `src/test/java/com/pragma/creditos/tasks/SolicitarCredito.java`
- `src/test/java/com/pragma/creditos/questions/EstadoSolicitud.java`
- `src/test/resources/data/credito_data.json`
- `src/test/resources/config/serenity.conf`
- `src/test/java/com/pragma/creditos/steps/CommonSteps.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/test/java/com/pragma/creditos`
- `src/test/java/com/pragma/creditos/tasks`
- `src/test/java/com/pragma/creditos/questions`
- `src/test/java/com/pragma/creditos/interactions`
- `src/test/java/com/pragma/creditos/models`
- `src/test/java/com/pragma/creditos/steps`
- `src/test/java/com/pragma/creditos/runners`
- `src/test/resources/features`
- `src/test/resources/data`
- `src/test/resources/config`

## Verificacion

```bash
mvn clean test-compile
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **Page Object Model con Screenplay para pruebas de API y UI**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Calidad de Software, Especialidad Automatizador, Tecnología QA, Advanced
- Brecha que el reto ataca: Implementa al menos una (1) técnica de caja negra como: Partición de Equivalencia, Análisis de Valores Límite, Pruebas de Transición de Estado y Tablas de Decisión o de caja blanca incluyendo: Cobertura de Sentencia, de Rama, de Condición y de Camino para aumentar la cobertura de ejecución de escenarios y casos de prueba.
- Mision: Candidato con experiencia en automatización de pruebas, enfocado en mejorar técnicas de diseño de test cases.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
