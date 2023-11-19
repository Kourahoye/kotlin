import retrofit2.Call
import retrofit2.http.GET

// Interface définissant les points d'entrée de l'API
interface ApiService {
    // Annotation GET indiquant que cette méthode effectue une requête GET vers l'endpoint "users"
    @GET("users")
    fun getUsers(): Call<List<Users>>
}