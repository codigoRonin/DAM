open class ElectronicProduct(
    val name: String,
    val price: Double
)

class MobilePhone(
    name: String,
    price: Double,
    val model: String,
    val storage: Int,
    val carrier: String
) : ElectronicProduct(name, price)

class Laptop(
    name: String,
    price: Double,
    val brand: String,
    val processor: String,
    val ram: Int
) : ElectronicProduct(name, price)

data class Customer(
    val firstName: String,
    val lastName: String,
    val email: String
)

fun calculatePriceWithTax(product: ElectronicProduct): Double {
    val taxRate = 0.1
    return product.price * (1 + taxRate)
}

fun makeSale(product: ElectronicProduct, customer: Customer, quantity: Int) {
    val totalPrice = calculatePriceWithTax(product) * quantity
    println("Sale made to ${customer.firstName} ${customer.lastName}")
    println("Product sold: ${product.name} - Quantity: $quantity")
    println("Total price with taxes: $totalPrice")
}

fun main() {
    val mobilePhone = MobilePhone("iPhone 13", 1000.0, "iPhone 13 Pro", 256, "Apple")
    val customer = Customer("John", "Doe", "john@example.com")

    makeSale(mobilePhone, customer, 2)
}