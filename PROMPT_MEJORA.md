# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/test/java/com/pragma/creditos/steps/ValoresLimiteSteps.java` — `SolicitarCredito.ejecutar`: Se invoca `ejecutar` sobre `SolicitarCredito`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/creditos/steps/TransicionEstadoSteps.java` — `SolicitarCredito.cambiarEstado`: Se invoca `cambiarEstado` sobre `SolicitarCredito`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/creditos/steps/TransicionEstadoSteps.java` — `SolicitarCredito.obtenerEstado`: Se invoca `obtenerEstado` sobre `SolicitarCredito`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/creditos/steps/TablasDecisionSteps.java` — `SolicitarCredito.ejecutar`: Se invoca `ejecutar` sobre `SolicitarCredito`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/creditos/steps/TablasDecisionSteps.java` — `SolicitarCredito.obtenerResultado`: Se invoca `obtenerResultado` sobre `SolicitarCredito`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `pom.xml` — `net.serenity-bdd:serenity-cucumber@4.1.24`: net.serenity-bdd:serenity-cucumber declara la version 4.1.24, pero Maven Central respondio que esa version no existe. Es una version inventada: reemplazala por una version publicada real, o si no se conoce con certeza, usa el mecanismo centralizado del ecosistema (BOM/parent/platform/version catalog) y no declares una version individual.
- `pom.xml` — `net.serenity-bdd:serenity-core@4.1.24`: net.serenity-bdd:serenity-core declara la version 4.1.24, pero Maven Central respondio que esa version no existe. Es una version inventada: reemplazala por una version publicada real, o si no se conoce con certeza, usa el mecanismo centralizado del ecosistema (BOM/parent/platform/version catalog) y no declares una version individual.
- `pom.xml` — `org.junit.platform:junit-platform-suite@5.10.2`: org.junit.platform:junit-platform-suite declara la version 5.10.2, pero Maven Central respondio que esa version no existe. Es una version inventada: reemplazala por una version publicada real, o si no se conoce con certeza, usa el mecanismo centralizado del ecosistema (BOM/parent/platform/version catalog) y no declares una version individual.

## Como saber que terminaste

```bash
mvn clean test-compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Calidad de Software, Especialidad Automatizador, Tecnología QA, Advanced

### Brecha de conocimiento
Implementa al menos una (1) técnica de caja negra como: Partición de Equivalencia, Análisis de Valores Límite, Pruebas de Transición de Estado y Tablas de Decisión o de caja blanca incluyendo: Cobertura de Sentencia, de Rama, de Condición y de Camino para aumentar la cobertura de ejecución de escenarios y casos de prueba.

### Misión / candidato
Candidato con experiencia en automatización de pruebas, enfocado en mejorar técnicas de diseño de test cases.

### Reto
- Tema: Técnicas de Generación de Casos de Pruebas - Caja Negra
- Seniority: advanced-l2
- Tipo: practical
- Título: Diseño de Casos de Prueba para Sistema de Gestión de Créditos
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Partición de Equivalencia — objetivo: Aplicar la técnica de Partición de Equivalencia para identificar clases de equivalencia en los datos de entrada del sistema. — entregable (NO resolver): Documento con clases de equivalencia definidas y casos de prueba correspondientes.
- Fase 2: Análisis de Valores Límite — objetivo: Aplicar la técnica de Análisis de Valores Límite para identificar y probar los valores extremos de los atributos de entrada. — entregable (NO resolver): Documento con valores límite definidos y casos de prueba correspondientes.
- Fase 3: Pruebas de Transición de Estado — objetivo: Aplicar la técnica de Pruebas de Transición de Estado para verificar que el sistema maneja correctamente las transiciones entre estados. — entregable (NO resolver): Documento con estados y transiciones definidos y casos de prueba correspondientes.
- Fase 4: Tablas de Decisión — objetivo: Aplicar la técnica de Tablas de Decisión para cubrir múltiples condiciones y acciones en un solo caso de prueba. — entregable (NO resolver): Documento con tabla de decisión definida y casos de prueba correspondientes.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.pragma</groupId>
    <artifactId>creditos</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <serenity.version>4.1.24</serenity.version>
        <cucumber.version>7.15.0</cucumber.version>
        <junit.version>5.10.2</junit.version>
        <jackson.version>2.17.0</jackson.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>net.serenity-bdd</groupId>
                <artifactId>serenity-core</artifactId>
                <version>${serenity.version}</version>
            </dependency>
            <dependency>
                <groupId>net.serenity-bdd</groupId>
                <artifactId>serenity-cucumber</artifactId>
                <version>${serenity.version}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <!-- Serenity BDD -->
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-core</artifactId>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-cucumber</artifactId>
        </dependency>
        
        <!-- Cucumber -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>${cucumber.version}</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit-platform-engine</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        
        <!-- JUnit -->
        <dependency>
            <groupId>org.junit.platform</groupId>
            <artifactId>junit-platform-suite</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        
        <!-- Lambdaj -->
        <dependency>
            <groupId>com.googlecode.lambdaj</groupId>
            <artifactId>lambdaj</artifactId>
            <version>2.3.3</version>
        </dependency>
        
        <!-- Jackson -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>${jackson.version}</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.2.5</version>
                <configuration>
                    <includes>
                        <include>**/*Test.java</include>
                        <include>**/*Tests.java</include>
                        <include>**/*TestSuite.java</include>
                    </includes>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-failsafe-plugin</artifactId>
                <version>3.2.5</version>
                <configuration>
                    <includes>
                        <include>**/RunCucumberTest.java</include>
                    </includes>
                    <argLine>-Xmx512m</argLine>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>integration-test</goal>
                            <goal>verify</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>net.serenity-bdd.maven.plugins</groupId>
                <artifactId>serenity-maven-plugin</artifactId>
                <version>${serenity.version}</version>
                <executions>
                    <execution>
                        <id>serenity-reports</id>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>aggregate</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/test/java/com/pragma/creditos/models/CreditoData.java ===
package com.pragma.creditos.models;

import java.util.Objects;

/**
 * Modelo de datos que representa una solicitud de crédito con sus atributos principales.
 * Utilizado para estructurar los datos de prueba en los escenarios Gherkin.
 */
public record CreditoData(
    Double monto,
    Integer plazo,
    TipoCredito tipoCredito,
    PerfilSolicitante perfilSolicitante,
    String estadoSolicitud
) {
    
    /**
     * Tipos de crédito soportados por el sistema.
     */
    public enum TipoCredito {
        PERSONAL,
        HIPOTECARIO,
        VEHICULO,
        ESTUDIOS
    }
    
    /**
     * Perfiles de solicitante que determinan condiciones de aprobación.
     */
    public enum PerfilSolicitante {
        PLATINO,
        ORO,
        PLATA,
        BRONCE
    }
    
    /**
     * Constructor que inicializa todos los campos con valores proporcionados.
     * @param monto Monto solicitado en unidades monetarias.
     * @param plazo Plazo de pago en meses.
     * @param tipoCredito Tipo de crédito solicitado.
     * @param perfilSolicitante Perfil del solicitante.
     * @param estadoSolicitud Estado inicial de la solicitud.
     */
    public CreditoData {
        Objects.requireNonNull(monto, "El monto no puede ser nulo");
        Objects.requireNonNull(plazo, "El plazo no puede ser nulo");
        Objects.requireNonNull(tipoCredito, "El tipo de crédito no puede ser nulo");
        Objects.requireNonNull(perfilSolicitante, "El perfil del solicitante no puede ser nulo");
        Objects.requireNonNull(estadoSolicitud, "El estado de la solicitud no puede ser nulo");
        
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero");
        }
        if (plazo <= 0) {
            throw new IllegalArgumentException("El plazo debe ser mayor que cero");
        }
    }
    
    /**
     * Crea una instancia de CreditoData con valores por defecto para pruebas.
     * @return Instancia de CreditoData con valores válidos.
     */
    public static CreditoData crearCreditoPorDefecto() {
        return new CreditoData(
            10000.0,
            12,
            TipoCredito.PERSONAL,
            PerfilSolicitante.ORO,
            "PENDIENTE"
        );
    }
    
    /**
     * Valida si el monto solicitado está dentro de los límites permitidos para el perfil.
     * @return true si el monto es válido para el perfil, false en caso contrario.
     */
    public boolean esMontoValidoParaPerfil() {
        return switch (perfilSolicitante) {
            case PLATINO -> monto <= 50000.0;
            case ORO -> monto <= 30000.0;
            case PLATA -> monto <= 15000.0;
            case BRONCE -> monto <= 5000.0;
        };
    }
    
    /**
     * Valida si el plazo solicitado está dentro de los límites permitidos para el tipo de crédito.
     * @return true si el plazo es válido para el tipo de crédito, false en caso contrario.
     */
    public boolean esPlazoValidoParaTipoCredito() {
        return switch (tipoCredito) {
            case PERSONAL -> plazo >= 6 && plazo <= 36;
            case HIPOTECARIO -> plazo >= 60 && plazo <= 360;
            case VEHICULO -> plazo >= 12 && plazo <= 72;
            case ESTUDIOS -> plazo >= 12 && plazo <= 60;
        };
    }
}

// === ARCHIVO: src/test/resources/features/credito/particion_equivalencia.feature ===
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

// === ARCHIVO: src/test/resources/features/credito/valores_limite.feature ===
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

// === ARCHIVO: src/test/resources/features/credito/transicion_estado.feature ===
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

// === ARCHIVO: src/test/resources/features/credito/tablas_decision.feature ===
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

// === ARCHIVO: src/test/java/com/pragma/creditos/runners/RunCucumberTest.java ===
package com.pragma.creditos.runners;

import io.cucumber.junit.platform.engine.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasspathResource("features")
@Cucumber
public class RunCucumberTest {
}

// === ARCHIVO: src/test/java/com/pragma/creditos/steps/ParticionEquivalenciaSteps.java ===
package com.pragma.creditos.steps;

import com.pragma.creditos.tasks.SolicitarCredito;
import com.pragma.creditos.questions.EstadoSolicitud;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.GivenWhenThen.then;

public class ParticionEquivalenciaSteps {

    @Step
    public void que_el_sistema_esta_en_funcionamiento() {
        // Inicialización del sistema o contexto necesario
    }

    @Step
    public void cuando_se_ingresan_los_siguientes_datos(Actor actor, String monto, String plazo, String tipoCredito, String perfilSolicitante) {
        actor.attemptsTo(
            SolicitarCredito.conDatos(monto, plazo, tipoCredito, perfilSolicitante)
        );
    }

    @Step
    public void entonces_el_sistema_debe_aprobar_la_solicitud(Actor actor) {
        then(actor).should(Ensure.that(EstadoSolicitud.es()).isEqualTo("Aprobado"));
    }

    @Step
    public void y_se_debe_enviar_una_notificacion_al_solicitante(Actor actor) {
        // Verificación de la notificación
    }

    @Step
    public void entonces_el_sistema_debe_rechazar_la_solicitud(Actor actor) {
        then(actor).should(Ensure.that(EstadoSolicitud.es()).isEqualTo("Rechazado"));
    }

    @Step
    public void y_no_se_debe_enviar_ninguna_notificacion_al_solicitante(Actor actor) {
        // Verificación de la ausencia de notificación
    }
}

// === ARCHIVO: src/test/java/com/pragma/creditos/steps/ValoresLimiteSteps.java ===
package com.pragma.creditos.steps;


import com.pragma.creditos.tasks.SolicitarCredito;
import com.pragma.creditos.models.CreditoData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class ValoresLimiteSteps {

    @Steps
    private SolicitarCredito solicitarCredito;

    @Given("un crédito con monto límite de {int}")
    public void dadoUnCreditoConMontoLimiteDe(int montoLimite) {
        CreditoData credito = CreditoData.crearCreditoPorDefecto().withMonto(montoLimite);
        solicitarCredito.conDatos(credito);
    }

    @When("se solicita el crédito")
    public void cuandoSeSolicitaElCredito() {
        solicitarCredito.ejecutar();
    }

    @Then("el sistema debe rechazar la solicitud")
    public void entoncesElSistemaDebeRechazarLaSolicitud() {
        Serenity.recordReportData().withTitle("Estado de la solicitud").andContents("Rechazada");
    }
}

// === ARCHIVO: src/test/java/com/pragma/creditos/steps/TransicionEstadoSteps.java ===
package com.pragma.creditos.steps;


import com.pragma.creditos.tasks.SolicitarCredito;
import com.pragma.creditos.models.CreditoData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.thucydides.core.annotations.Step;
import static org.assertj.core.api.Assertions.assertThat;

public class TransicionEstadoSteps {

    @Steps
    private SolicitarCredito solicitarCredito;

    @Given("un crédito en estado {string}")
    public void dadoUnCreditoEnEstado(String estado) {
        CreditoData credito = CreditoData.crearCreditoPorDefecto();
        solicitarCredito.conDatos(credito);
        Serenity.recordReportData().withTitle("Estado inicial").andContents(estado);
    }

    @When("se cambia el estado a {string}")
    public void cuandoSeCambiaElEstadoA(String nuevoEstado) {
        solicitarCredito.cambiarEstado(nuevoEstado);
    }

    @Then("el sistema debe estar en el estado {string}")
    public void entoncesElSistemaDebeEstarEnElEstado(String estadoEsperado) {
        String estadoActual = solicitarCredito.obtenerEstado();
        assertThat(estadoActual).isEqualTo(estadoEsperado);
    }
}

// === ARCHIVO: src/test/java/com/pragma/creditos/steps/TablasDecisionSteps.java ===
package com.pragma.creditos.steps;


import com.pragma.creditos.tasks.SolicitarCredito;
import com.pragma.creditos.models.CreditoData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.thucydides.core.annotations.Step;
import static org.assertj.core.api.Assertions.assertThat;

public class TablasDecisionSteps {

    @Steps
    private SolicitarCredito solicitarCredito;

    @Given("un crédito con monto {int} y plazo {int}")
    public void dadoUnCreditoConMontoYPlazo(int monto, int plazo) {
        CreditoData credito = CreditoData.crearCreditoPorDefecto().withMonto(monto).withPlazo(plazo);
        solicitarCredito.conDatos(credito);
    }

    @When("se aplica la tabla de decisión")
    public void cuandoSeAplicaLaTablaDeDecision() {
        solicitarCredito.ejecutar();
    }

    @Then("el sistema debe decidir {string}")
    public void entoncesElSistemaDebeDecidir(String decision) {
        String resultado = solicitarCredito.obtenerResultado();
        assertThat(resultado).isEqualTo(decision);
    }
}

// === ARCHIVO: src/test/java/com/pragma/creditos/tasks/SolicitarCredito.java ===
package com.pragma.creditos.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import com.pragma.creditos.models.CreditoData;

public class SolicitarCredito implements Task {

    private final CreditoData creditoData;

    public SolicitarCredito(CreditoData creditoData) {
        this.creditoData = creditoData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Post.to("/creditos").with(request -> request.body(creditoData))
        );
    }

    public static SolicitarCredito conDatos(CreditoData creditoData) {
        return new SolicitarCredito(creditoData);
    }
}

// === ARCHIVO: src/test/java/com/pragma/creditos/questions/EstadoSolicitud.java ===
package com.pragma.creditos.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class EstadoSolicitud implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LastResponse.receivedBy(actor).jsonPath().getString("estado");
    }

    public static Question<String> deLaSolicitud() {
        return new EstadoSolicitud();
    }
}

// === ARCHIVO: src/test/resources/data/credito_data.json ===
{
  "partitionEquivalence": [
    {
      "monto": 10000,
      "plazo": 12,
      "tipoCredito": "HIPOTEKARIO",
      "perfilSolicitante": "PREMIUM"
    },
    {
      "monto": 50000,
      "plazo": 24,
      "tipoCredito": "PERSONAL",
      "perfilSolicitante": "REGULAR"
    }
  ],
  "limitValues": [
    {
      "monto": 1,
      "plazo": 1,
      "tipoCredito": "PERSONAL",
      "perfilSolicitante": "BASICO"
    },
    {
      "monto": 999999,
      "plazo": 60,
      "tipoCredito": "HIPOTEKARIO",
      "perfilSolicitante": "PREMIUM"
    }
  ],
  "decisionTables": [
    {
      "condiciones": [
        {"monto": 10000, "plazo": 12},
        {"monto": 20000, "plazo": 24}
      ],
      "acciones": [
        {"estado": "APROBADO"},
        {"estado": "RECHAZADO"}
      ]
    }
  ]
}

// === ARCHIVO: src/test/resources/config/serenity.conf ===
system.properties.webdriver.chrome.driver=chromedriver
serenity.take.screenshots=FOR_FAILURES
serenity.outputDirectory=target/site/serenity

# Base URL for the application
serenity.project.name=Creditos
webdriver.base.url=http://localhost:8080

# Timeouts
serenity.webdriver.timeouts.implicitlywait=10
serenity.webdriver.timeouts.pageloadtimeout=30
serenity.webdriver.timeouts.scripttimeout=30

# Reporting
serenity.jira.project.key=CREDITOS
serenity.jira.url=https://your-jira-instance.com

# Serenity BDD features
serenity.features.include.tags=@regression

# Cucumber options
serenity.cucumber.options=--glue com.pragma.creditos.steps

// === ARCHIVO: src/test/java/com/pragma/creditos/steps/CommonSteps.java ===
package com.pragma.creditos.steps;


import com.pragma.creditos.models.CreditoData;
import com.pragma.creditos.tasks.SolicitarCredito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Patch;
import net.serenitybdd.screenplay.rest.interactions.WaitUntilResponseStatusIs;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CommonSteps extends ScenarioSteps {

    @Step("El actor solicita un crédito.")
    public void elActorSolicitaUnCredito(Actor actor, CreditoData creditoData) {
        actor.attemptsTo(
            SolicitarCredito.con(creditoData)
        );
    }

    @Step("El actor verifica que la solicitud de crédito fue creada.")
    public void elActorVerificaQueLaSolicitudDeCreditoFueCreada(Actor actor) {
        actor.attemptsTo(
            Get.resource("/creditos"),
            Ensure.that(Text.of(LastResponse.body()).asString()).contains("Solicitud creada")
        );
    }

    @Step("El actor espera {0} segundos.")
    public void elActorEsperaSegundos(int seconds) {
        actor.attemptsTo(
            WaitUntilResponseStatusIs.ok().forSeconds(seconds)
        );
    }

    @Step("El actor limpia la base de datos.")
    public void elActorLimpiaLaBaseDeDatos(Actor actor) {
        actor.attemptsTo(
            Delete.from("/creditos")
        );
    }
}
```
