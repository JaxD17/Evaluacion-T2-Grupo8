package pe.edu.cibertec.appgrupo8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.cibertec.appgrupo8.databinding.FragmentPregunta1Binding

class Pregunta1Fragment : Fragment() {

    private var _binding: FragmentPregunta1Binding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPregunta1Binding.inflate(
            inflater,container,false)

        return binding.root

    }

}