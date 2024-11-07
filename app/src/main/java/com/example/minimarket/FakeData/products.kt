import com.example.minimarket.Interfaces.IProduct
import com.example.minimarket.R

object ProductsRepository {
    private val products = listOf(
        IProduct(1, 1, "Coca Cola 600ml", R.drawable.coca_cola, 3.00),
        IProduct(2, 1, "Inca Kola 600ml", R.drawable.incakola_600ml, 3.00),
        IProduct(3, 1, "Inca Kola 2.5L", R.drawable.incakola225l, 8.00),
        IProduct(3, 1, "Yogurt 1L", R.drawable.yogurt_laive_lucuma_1l, 6.00),
        IProduct(5, 2, "Choco chips", R.drawable.cookies, 2.00),
        IProduct(6, 3, "Jamonada", R.drawable.embutidos, 4.00)
    )

    fun filterProductsByCategory(id: Int): List<IProduct> {
        return products.filter { it.categoryId == id }
    }

    fun findProductById(id: Int): IProduct? {
        return products.find { it.id == id }
    }
}
