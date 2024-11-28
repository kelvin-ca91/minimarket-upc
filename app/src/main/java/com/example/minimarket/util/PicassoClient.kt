import android.content.Context
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

object PicassoClient {
    private var instance: Picasso? = null

    fun getInstance(context: Context): Picasso {
        if (instance == null) {
            instance = Picasso.Builder(context)
                .downloader(OkHttp3Downloader(context)) // Usar OkHttp para manejo eficiente de la red
                .loggingEnabled(true) // Opcional: activar logs
                .build()
        }
        return instance!!
    }
}


