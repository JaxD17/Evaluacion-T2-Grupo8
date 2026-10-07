package pe.edu.cibertec.appgrupo8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appgrupo8.adapter.PostAdapter
import pe.edu.cibertec.appgrupo8.api.RetrofitClient
import pe.edu.cibertec.appgrupo8.databinding.FragmentPregunta4Binding
import pe.edu.cibertec.appgrupo8.model.PostResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Pregunta4Fragment : Fragment() {

    private var _binding: FragmentPregunta4Binding? = null
    private val binding get() = _binding!!

    private lateinit var postAdapter: PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        fetchPosts()
    }

    private fun setupRecyclerView() {
        postAdapter = PostAdapter()
        binding.rvPosts.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = postAdapter
        }
    }

    private fun fetchPosts() {
        binding.pbLoading.visibility = View.VISIBLE
        binding.tvError.visibility = View.GONE
        binding.rvPosts.visibility = View.GONE

        RetrofitClient.instance.getPosts().enqueue(object : Callback<PostResponse> {
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                if (_binding == null) return

                binding.pbLoading.visibility = View.GONE

                if (response.isSuccessful && response.body() != null) {
                    val posts = response.body()!!.posts
                    postAdapter.updatePosts(posts)
                    binding.rvPosts.visibility = View.VISIBLE
                } else {
                    showError("Error en la respuesta del servidor: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                if (_binding == null) return

                binding.pbLoading.visibility = View.GONE
                showError("Error de conexión: ${t.message}")
            }
        })
    }

    private fun showError(message: String) {
        binding.tvError.text = message
        binding.tvError.visibility = View.VISIBLE
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
