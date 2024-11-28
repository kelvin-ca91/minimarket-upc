import com.example.minimarket.Interfaces.IProduct
import com.example.minimarket.R

object ProductsRepository {
    private val products = listOf(
        IProduct(1, 1, "Coca Cola 600ml", R.drawable.`coca_cola_600ml`, 3.00),
        IProduct(4, 1, "Yogurt 1L", R.drawable.yogurt_laive_lucuma_1l, 6.00),

    )

    fun filterProductsByCategory(id: Int): List<IProduct> {
        return products.filter { it.categoryId == id }
    }

    fun findProductById(id: Int): IProduct? {
        return products.find { it.id == id }
    }
}
