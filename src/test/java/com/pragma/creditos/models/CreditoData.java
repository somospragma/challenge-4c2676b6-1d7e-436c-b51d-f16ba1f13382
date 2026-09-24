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