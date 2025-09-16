# 🧪 Servicio de Descuentos - Pruebas Unitarias

Este proyecto contiene pruebas unitarias para la clase `DiscountService`, la cual aplica descuentos según el monto de compra:

- **Monto < 50.000** → Sin descuento.
- **50.000 ≤ Monto ≤ 100.000** → 10% de descuento.
- **Monto > 100.000** → 15% de descuento.
- **Montos ≤ 0** → Lanza `IllegalArgumentException`.

Las pruebas están escritas en Java utilizando **JUnit 5** y cubren casos típicos, casos borde y validaciones de entrada.


## 📁 Estructura del Proyecto

```
src/
└── test/
    └── java/
        └── cl.equipo1/
            └── DiscountServiceTest.java
```


## ✅ Pruebas Implementadas

| Prueba | Descripción | Caso |
|--------|-------------|------|
| `testCalcularDescuentoEnMontoMayorA100000` | Verifica 15% de descuento para montos > 100.000 | Típico |
| `testCalcularDescuentoEnMontoEntre50000Y100000` | Verifica 10% de descuento para montos entre 50.000 y 100.000 | Típico |
| `testCalcularDescuentoEnMontoMenorA50000` | Verifica que no se aplique descuento para montos < 50.000 | Típico |
| `testCalcularDescuentoEnMontoIgualA100000` | Verifica 10% de descuento en el límite superior | Borde |
| `testCalcularDescuentoEnMontoIgualA50000` | Verifica 10% de descuento en el límite inferior | Borde |
| `testCalcularDescuentoEnMontoNegativo` | Verifica que lance excepción si el monto es negativo | Validación |
| `testCalcularDescuentoEnMontoCero` | Verifica que lance excepción si el monto es cero | Validación |


## 🛠️ Requisitos

- Java 8 o superior
- JUnit 5 (incluido en la mayoría de entornos modernos como Maven, Gradle o IDEs como IntelliJ/Eclipse)


## ▶️ Ejecutar las Pruebas

### Con Maven

```bash
mvn test
```

### Con Gradle

```bash
gradle test
```

### Desde tu IDE

Simplemente ejecuta la clase `DiscountServiceTest.java` como una prueba JUnit.


## 📌 Notas Importantes

- Asegúrate de que la clase `DiscountService` exista en el mismo paquete (`cl.equipo1`) y tenga un método público:
  ```java
  public double calculateDiscount(double monto)
  ```
- El método debe lanzar `IllegalArgumentException` si el monto es ≤ 0.


## 📊 Cobertura de Pruebas

Estas pruebas garantizan cobertura de:

- Todos los rangos de descuento.
- Casos límite (50.000 y 100.000).
- Validación de entradas inválidas (negativas o cero).


## 🤝 Contribuir

Si deseas mejorar las pruebas o agregar nuevos casos:

1. Haz un fork del repositorio.
2. Crea una rama con tu mejora: `git checkout -b feature/nueva-prueba`.
3. Realiza tus cambios y escribe pruebas adicionales si es necesario.
4. Haz commit y push a tu rama.
5. Abre un Pull Request.


## 📄 Licencia

Este proyecto es de código abierto y está bajo la licencia MIT. ¡Úsalo libremente!
