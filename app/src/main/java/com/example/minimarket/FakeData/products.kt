import com.example.minimarket.Interfaces.IProduct
import com.example.minimarket.R

object ProductsRepository {
    private val products = listOf(
        IProduct(1, 1, "Coca Cola 600ml", R.drawable.coca_cola, 3.00),
        IProduct(2, 2, "Choco chips", R.drawable.cookies, 2.00),
        IProduct(3, 3, "Jamonada", R.drawable.embutidos, 4.00)
    )

    fun filterProductsByCategory(id: Int): List<IProduct> {
        return products.filter { it.categoryId == id }
    }

    fun findProductById(id: Int): IProduct? {
        return products.find { it.id == id }
    }
}
