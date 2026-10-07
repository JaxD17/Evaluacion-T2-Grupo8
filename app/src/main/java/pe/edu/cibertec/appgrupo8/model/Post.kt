package pe.edu.cibertec.appgrupo8.model

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("posts") val posts: List<Post>,
    @SerializedName("total") val total: Int,
    @SerializedName("skip") val skip: Int,
    @SerializedName("limit") val limit: Int
)

data class Post(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String,
    @SerializedName("views") val views: Int,
    @SerializedName("userId") val userId: Int
)
