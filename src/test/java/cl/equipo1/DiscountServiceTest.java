package cl.equipo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountServiceTest {

    private DiscountService discountService;

    @BeforeEach
    void setUp() {
        discountService = new DiscountService();
    }

    @Test
    @DisplayName("Calcular descuento en monto mayor a 100.000 -> 15% de descuento")
    void testCalcularDescuentoEnMontoMayorA100000() {
        // Arrange
        double monto = 120000;
        double descuentoEsperado = monto * 0.85; // 15% de descuento
        // Act
        double result = discountService.calculateDiscount(monto);
        // Assert
        assertEquals(descuentoEsperado, result, "Monto mayor a 100.000 debe aplicar 15% de descuento");
    }

    // Caso típico: entre 50.000 y 100.000
    @Test
    @DisplayName("Calcular descuento en monto entre 50.000 y 100.000 -> 10% de descuento")
    void testCalcularDescuentoEnMontoEntre50000Y100000() {
        // Arrange
        double monto = 75000;
        double descuentoEsperado = monto * 0.90; // 10% de descuento
        // Act
        double result = discountService.calculateDiscount(monto);
        // Assert
        assertEquals(descuentoEsperado, result, "Monto entre 50.000 y 100.000 debe aplicar 10% de descuento");
    }

    // Caso típico: menos de 50.000
    @Test
    @DisplayName("Calcular descuento en monto menor a 50.000 -> Sin descuento")
    void testCalcularDescuentoEnMontoMenorA50000() {
        // Arrange
        double monto = 30000;
        // Act
        double result = discountService.calculateDiscount(monto);
        // Assert
        assertEquals(monto, result, "Monto menor a 50.000 no debe aplicar descuento");
    }

    // Caso borde: exactamente 100.000
    @Test
    @DisplayName("Calcular descuento en monto igual a 100.000 -> 10% de descuento")
    void testCalcularDescuentoEnMontoIgualA100000() {
        // Arrange
        double monto = 100000;
        double descuentoEsperado = monto * 0.90; // 10% de descuento
        // Act
        double result = discountService.calculateDiscount(monto);
        // Assert
        assertEquals(descuentoEsperado, result, "Monto igual a 100.000 debe aplicar 10% de descuento");
    }

    // Caso borde: exactamente 50.000
    @Test
    @DisplayName("Calcular descuento en monto igual a 50.000 -> 10% de descuento")
    void testCalcularDescuentoEnMontoIgualA50000() {
        // Arrange
        double monto = 50000;
        double descuentoEsperado = monto * 0.90; // 10% de descuento
        // Act
        double result = discountService.calculateDiscount(monto);
        // Assert
        assertEquals(descuentoEsperado, result, "Monto igual a 50.000 debe aplicar 10% de descuento");
    }

    // Validación: monto negativo debe lanzar excepción
    @Test
    @DisplayName("Calcular descuento en monto negativo -> Debe lanzar IllegalArgumentException")
    void testCalcularDescuentoEnMontoNegativo() {
        // Arrange
        double montoNegativo = -1000;

        // Act & Assert

        // Verificamos que se lance IllegalArgumentException al pasar un monto negativo
        assertThrows(IllegalArgumentException.class, () ->
            discountService.calculateDiscount(montoNegativo), "Monto negativo debería lanzar IllegalArgumentException");
    }

    // Validación: monto cero debe lanzar excepción
    @Test
    @DisplayName("Calcular descuento en monto cero -> Debe lanzar IllegalArgumentException")
    void testCalcularDescuentoEnMontoCero() {
        // Arrange
        double montoCero = 0;
        assertThrows(IllegalArgumentException.class, () ->
            discountService.calculateDiscount(montoCero), "Monto igual a 0 debería lanzar IllegalArgumentException");
    }

}
