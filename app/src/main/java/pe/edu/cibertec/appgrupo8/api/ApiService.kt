package pe.edu.cibertec.appgrupo8.api

import pe.edu.cibertec.appgrupo8.model.PostResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<PostResponse>
}
