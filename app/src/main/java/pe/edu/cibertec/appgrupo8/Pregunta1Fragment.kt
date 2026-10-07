package pe.edu.cibertec.appgrupo8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import pe.edu.cibertec.appgrupo8.databinding.FragmentPregunta1Binding
import java.util.Locale

class Pregunta1Fragment : Fragment() {

    private var _binding: FragmentPregunta1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPregunta1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalcular.setOnClickListener {
            calcularSobrecargo()
        }
    }

    private fun calcularSobrecargo() {
        val inputLongitud = binding.etLongitud.text.toString()

        if (inputLongitud.isEmpty()) {
            Toast.makeText(requireContext(), "Por favor, ingresa la longitud", Toast.LENGTH_SHORT).show()
            return
        }

        val longitud = inputLongitud.toDoubleOrNull() ?: 0.0

        binding.cardResultados.visibility = View.VISIBLE

        if (longitud <= 12.0) {
            binding.tvMensajePrincipal.text = getString(R.string.p1_msg_permitido)
            binding.tvMensajePrincipal.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.p1_bg_success))
            binding.tvMensajePrincipal.setTextColor(ContextCompat.getColor(requireContext(), R.color.p1_text_success))

            binding.layoutDetalles.visibility = View.GONE
        } else {
            val exceso = longitud - 12.0
            val sobrecargo = 400.0 + (120.0 * exceso)

            binding.tvMensajePrincipal.text = "Carga con sobredimensión"
            binding.tvMensajePrincipal.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.p1_bg_error))
            binding.tvMensajePrincipal.setTextColor(ContextCompat.getColor(requireContext(), R.color.p1_text_error))

            binding.tvLongitudIngresada.text = String.format(Locale.US, "Longitud ingresada: %.2f m", longitud)
            binding.tvExceso.text = String.format(Locale.US, "Exceso de metros: %.2f m", exceso)
            binding.tvMontoTotal.text = String.format(Locale.US, "Sobrecargo total calculado: S/ %.2f", sobrecargo)

            binding.layoutDetalles.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}