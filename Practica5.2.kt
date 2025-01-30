
class Cliente(
    val id: Int,
    val nombre: String,
    val email: String,
    val telefono: String,
    val direccion: String
)


enum class EstadoPedido {
    PDTE, PGDO, PCDO, ENVDO, ENTGDO
}


class Producto(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val impuestos: Double,
    var stock: Int
) {
    fun actualizarStock(cantidad: Int) {
        stock -= cantidad
    }
}


class ProductoPedido(
    val producto: Producto,
    val cantidad: Int
) {
    val subtotal: Double
        get() = cantidad * (producto.precio + producto.impuestos)
}


open class Pago(
    val id: Int,
    val fecha: String,
    val monto: Double
)


class PagoTarjeta(
    id: Int, fecha: String, monto: Double,
    val numeroTarjeta: String,
    val fechaCaducidad: String,
    val tipoTarjeta: String
) : Pago(id, fecha, monto)

class PagoEfectivo(
    id: Int, fecha: String, monto: Double,
    val tipoMoneda: String
) : Pago(id, fecha, monto)

class PagoCheque(
    id: Int, fecha: String, monto: Double,
    val nombre: String,
    val banco: String
) : Pago(id, fecha, monto)


class Pedido(
    val id: Int,
    val fecha: String,
    var estado: EstadoPedido,
    val cliente: Cliente,
    val productos: MutableList<ProductoPedido> = mutableListOf(),
    val pagos: MutableList<Pago> = mutableListOf()
) {
    fun calcularTotal(): Double {
        return productos.sumOf { it.subtotal }
    }

    fun actualizarEstado(nuevoEstado: EstadoPedido) {
        estado = nuevoEstado
    }
}

fun main() {
    val cliente = Cliente(1, "Juan Pérez", "juan@email.com", "123456789", "Calle Falsa 123")
    val producto = Producto(1, "Laptop", "Portátil potente", 1000.0, 180.0, 10)
    val pedido = Pedido(1, "2024-01-01", EstadoPedido.PDTE, cliente)

    val productoPedido = ProductoPedido(producto, 2)
    pedido.productos.add(productoPedido)

    val pago = PagoTarjeta(1, "2024-01-02", pedido.calcularTotal(), "1234-5678-9876-5432", "2026-12", "Visa")
    pedido.pagos.add(pago)

    pedido.actualizarEstado(EstadoPedido.PGDO)

    println("Pedido realizado por: ${pedido.cliente.nombre}")
    println("Estado del pedido: ${pedido.estado}")
    println("Total a pagar: ${pedido.calcularTotal()}")
}
