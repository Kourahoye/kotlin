import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

fun main() {
    // Créer une instance de Retrofit pour effectuer des requêtes HTTP
    val retrofit = Retrofit.Builder()
        .baseUrl("https://655a651d6981238d054d7491.mockapi.io")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    // Créer une instance de l'interface ApiService pour définir les points d'entrée de l'API
    val apiService = retrofit.create(ApiService::class.java)

    // Effectuer la requête pour obtenir la liste des utilisateurs
    val response = apiService.getUsers().execute()

    // Vérifier si la requête a réussi
    if (response.isSuccessful) {
        response.body()?.forEachIndexed { index, users ->
            println("User: ${index + 1} | Name: ${users.name} | Email : ${users.email} | Password : ${users.password}")
        }
    } else {
        println("Erreur lors de la récupération des utilisateurs: ${response.code()}")
    }
}
