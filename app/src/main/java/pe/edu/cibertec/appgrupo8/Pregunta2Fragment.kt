package pe.edu.cibertec.appgrupo8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import pe.edu.cibertec.appgrupo8.databinding.FragmentPregunta2Binding
import java.util.Locale

class Pregunta2Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPregunta2Binding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v?.id != binding.btnCalcular.id) {
            return
        }

        val diasTexto = binding.etDiasUso.text.toString().trim()

        if (diasTexto.isEmpty()) {

            Toast.makeText(
                requireContext(),
                "Por favor, ingresa los días transcurridos",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        val dias = diasTexto.toIntOrNull()

        if (dias == null || dias < 0) {

            Toast.makeText(
                requireContext(),
                "Ingresa una cantidad válida de días",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        binding.cardResultados.visibility = View.VISIBLE

        if (dias <= 7) {

            binding.tvMensajePrincipal.text =
                "Contenedor retornado dentro de los días libres."

            binding.tvMensajePrincipal.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.p1_bg_success
                )
            )

            binding.tvMensajePrincipal.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.p1_text_success
                )
            )

            binding.layoutDetalles.visibility = View.GONE

        } else {

            val diasMora = dias - 7

            val montoDemurrage = 200.0 + (75.0 * diasMora)

            binding.tvMensajePrincipal.text =
                "Demurrage generado"

            binding.tvMensajePrincipal.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.p1_bg_error
                )
            )

            binding.tvMensajePrincipal.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.p1_text_error
                )
            )

            binding.tvDiasTotales.text =
                "Días totales transcurridos: $dias"

            binding.tvDiasMora.text =
                "Días de mora: $diasMora"

            binding.tvMontoTotal.text =
                String.format(
                    Locale.US,
                    "Monto de demurrage liquidado: S/ %.2f",
                    montoDemurrage
                )

            binding.layoutDetalles.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}