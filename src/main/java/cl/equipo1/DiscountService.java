package cl.equipo1;

public class DiscountService {
  public double calculateDiscount(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("El monto debe ser mayor a cero");
    }
    if (amount > 100000) {
      return amount * 0.85; // 15% de descuento
    } else if (amount >= 50000) {
      return amount * 0.90; // 10% de descuento
    } else {
      return amount; // Sin descuento
    }
  }

}
