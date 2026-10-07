package pe.edu.cibertec.appgrupo8.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.cibertec.appgrupo8.databinding.ItemPregunta3Binding
import pe.edu.cibertec.appgrupo8.model.Pais

class PaisAdapter(private var listaPais: List<Pais>)
    : RecyclerView.Adapter<PaisAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPregunta3Binding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemPregunta3Binding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(listaPais[position]){
                binding.tvnombre.text = nombre
                binding.tvhora.text = hora
                binding.tvmensaje.text = mensaje
                Glide.with(itemView.context)
                    .load(urlImagen)
                    .into(binding.ivfoto)
            }
        }
    }

    override fun getItemCount() = listaPais.size
}
