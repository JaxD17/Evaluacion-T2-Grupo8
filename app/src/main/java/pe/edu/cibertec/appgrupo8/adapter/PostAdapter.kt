package pe.edu.cibertec.appgrupo8.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import pe.edu.cibertec.appgrupo8.R
import pe.edu.cibertec.appgrupo8.databinding.ItemPostBinding
import pe.edu.cibertec.appgrupo8.model.Post

class PostAdapter(private var posts: List<Post> = emptyList()) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updatePosts(newPosts: List<Post>) {
        posts = newPosts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size

    inner class PostViewHolder(val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        private var currentPost: Post? = null

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(post: Post) {
            currentPost = post
            val context = binding.root.context
            binding.tvTitle.text = post.title
            binding.tvBody.text = post.body
            binding.tvUserId.text = context.getString(R.string.p4_item_user_id, post.userId)
            binding.tvViews.text = context.getString(R.string.p4_item_views, post.views)
        }

        override fun onClick(v: View?) {
            currentPost?.let { post ->
                val context = v?.context ?: return
                val message = context.getString(
                    R.string.p4_item_toast,
                    post.id,
                    post.userId,
                    post.views
                )
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
