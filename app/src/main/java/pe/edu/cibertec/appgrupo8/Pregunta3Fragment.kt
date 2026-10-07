package pe.edu.cibertec.appgrupo8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appgrupo8.adapter.PaisAdapter
import pe.edu.cibertec.appgrupo8.databinding.FragmentPregunta3Binding
import pe.edu.cibertec.appgrupo8.model.Pais

class Pregunta3Fragment : Fragment() {

    private var _binding: FragmentPregunta3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvpaises.layoutManager = LinearLayoutManager(requireContext())
        binding.rvpaises.adapter = PaisAdapter(getPaises())
    }
    //Lista de paises europeos :v
    private fun getPaises(): List<Pais> {
        return listOf(
            Pais(1, "Alemania", "Capital: Berlín", "Europa Central", "https://picsum.photos/id/10/300/300"),
            Pais(2, "España", "Capital: Madrid", "Europa Sur", "https://picsum.photos/id/11/300/300"),
            Pais(3, "Francia", "Capital: París", "Europa Occidental", "https://picsum.photos/id/12/300/300"),
            Pais(4, "Italia", "Capital: Roma", "Europa Sur", "https://picsum.photos/id/13/300/300"),
            Pais(5, "Portugal", "Capital: Lisboa", "Europa Sur", "https://picsum.photos/id/14/300/300"),
            Pais(6, "Reino Unido", "Capital: Londres", "Europa Norte", "https://picsum.photos/id/15/300/300"),
            Pais(7, "Países Bajos", "Capital: Ámsterdam", "Europa Occidental", "https://picsum.photos/id/16/300/300"),
            Pais(8, "Suiza", "Capital: Berna", "Europa Central", "https://picsum.photos/id/17/300/300"),
            Pais(9, "Bélgica", "Capital: Bruselas", "Europa Occidental", "https://picsum.photos/id/18/300/300"),
            Pais(10, "Austria", "Capital: Viena", "Europa Central", "https://picsum.photos/id/19/300/300"),
            Pais(11, "Polonia", "Capital: Varsovia", "Europa Oriental", "https://picsum.photos/id/20/300/300"),
            Pais(12, "Grecia", "Capital: Atenas", "Europa Sur", "https://picsum.photos/id/21/300/300"),
            Pais(13, "Suecia", "Capital: Estocolmo", "Europa Norte", "https://picsum.photos/id/22/300/300"),
            Pais(14, "Noruega", "Capital: Oslo", "Europa Norte", "https://picsum.photos/id/23/300/300"),
            Pais(15, "Dinamarca", "Capital: Copenhague", "Europa Norte", "https://picsum.photos/id/24/300/300"),
            Pais(16, "Finlandia", "Capital: Helsinki", "Europa Norte", "https://picsum.photos/id/25/300/300"),
            Pais(17, "Irlanda", "Capital: Dublín", "Europa Norte", "https://picsum.photos/id/26/300/300"),
            Pais(18, "República Checa", "Capital: Praga", "Europa Central", "https://picsum.photos/id/27/300/300"),
            Pais(19, "Hungría", "Capital: Budapest", "Europa Central", "https://picsum.photos/id/28/300/300"),
            Pais(20, "Rumanía", "Capital: Bucarest", "Europa Oriental", "https://picsum.photos/id/29/300/300")
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
