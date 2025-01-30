# Practica-evaluable-5.2-Entornos

**- Clases**: Cada entidad del sistema se representa como una clase en Kotlin. Por ejemplo, Cliente, Pedido, Producto y Pago son clases que encapsulan los datos y el comportamiento asociado.

**- Atributos**: Se han convertido en propiedades dentro de cada clase, como nombre, precio, stock, etc.

**- Métodos**: Se han implementado como funciones dentro de las clases, como calcularTotal() en Pedido o actualizarStock() en Producto.

**- Herencia**: La clase Pago actúa como clase base, mientras que PagoTarjeta, PagoEfectivo y PagoCheque heredan de ella, aprovechando la reutilización de código.

**- Asociaciones**: Se han traducido en referencias entre clases. Por ejemplo, Pedido tiene una lista de ProductoPedido y una lista de Pago, lo que refleja su relación con Producto y Pago.

## Herramienta Utilizada para el Diagrama UML

Para la creación del diagrama UML, He utilizado el programa DIA el cual es una Herramienta de creación de diagramas UML capaz de generar clases y relaciones con todos los detalles especificados.

## Conversión del Diagrama UML a Kotlin

El proceso de conversión del diagrama UML a Kotlin sigue una serie de pasos:

**-Identificación de clases**: Se crean clases en Kotlin basadas en el diagrama UML.

**-Definición de atributos**: Se añaden los atributos con sus respectivos tipos de datos.

**-Implementación de métodos**: Se programan las funciones necesarias según el comportamiento descrito en el diagrama.

**-Relaciones entre clases**: Se establecen asociaciones utilizando referencias a otras clases.

**-Uso de la herencia**: Se implementan clases base y derivadas cuando sea necesario.

