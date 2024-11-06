import com.example.minimarket.Interfaces.ICategory
import com.example.minimarket.R

object CategoryRepository {
    // Fake data de categorías
    private val categories = listOf(
        ICategory(1, "Bebidas", R.drawable.coca_cola),
        ICategory(2, "Galletas y Golosinas", R.drawable.cookies),
        ICategory(3, "Embutidos", R.drawable.embutidos)
    )

    fun getCategories(): List<ICategory> {
        return categories
    }

    fun findCategoryById(id: Int): ICategory? {
        return categories.find { it.id == id }
    }
}
