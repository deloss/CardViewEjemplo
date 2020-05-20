package com.example.textinputlayoutejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarSesion.setOnClickListener {
            val usuario = nombreUsuario.editText!!.text.toString()
            val passwordText = password.editText!!.text.toString()

            val usuarioValidado = validarUsuario(usuario)
            if(!usuarioValidado) {
                nombreUsuario.error = "El nombre de usuario no puede tener mas de 15 caracteres"
            } else {
                nombreUsuario.error = null
            }
            val passwordValida = validarPassword(passwordText)
            if(!passwordValida) {
                password.error = "La password tiene que tener al menos 8 caracteres"
            } else {
                password.error = null
            }

            if(usuarioValidado && passwordValida) {
                Toast.makeText(this, "Campos validos", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validarUsuario(usuario: String): Boolean {
        return usuario.length <= 15
    }

    private fun validarPassword(password: String): Boolean {
        return password.length >= 8
    }
}
