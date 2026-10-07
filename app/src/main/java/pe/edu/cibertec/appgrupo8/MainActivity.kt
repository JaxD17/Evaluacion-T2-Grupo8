package pe.edu.cibertec.appgrupo8

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo8.databinding.ActivityMainBinding
import pe.edu.cibertec.appgrupo8.model.Usuario

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    private val listaUsuarios = listOf(
        Usuario("i202505855", "74320370"), // Luis Valverde
        Usuario("i202505835", "74249845"), // Yhuber
        Usuario("i202508599", "43648366"), // Héctor
        Usuario("i202500888", "75214693"), // Mary Cruz
        Usuario("i202506373", "70955635"), // Joaquin
        Usuario("i202504416", "40911952") // Maribel
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnlogin.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        login()
    }

    private fun login() {
        val userInput = binding.etusuario.text.toString().trim()
        val passInput = binding.etpassword.text.toString().trim()

        if (userInput.isEmpty() || passInput.isEmpty()) {
            Toast.makeText(
                this,
                "Complete todos los campos",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (verificarCredenciales(userInput, passInput)) {
            val intent = Intent(this, HomeActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(
                this,
                "Credenciales incorrectas",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun verificarCredenciales(user: String, pass: String): Boolean {
        return listaUsuarios.any { it.usuario == user && it.password == pass }
    }
}