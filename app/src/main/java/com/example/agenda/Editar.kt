package com.example.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Editar : AppCompatActivity() {

    lateinit var edNombre: EditText
    lateinit var edApellido: EditText
    lateinit var edEdad: EditText

    var posicion=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar)

        //recuperar los datos enviados
        val nombre = intent.getStringExtra("nombre")
        val apellido = intent.getStringExtra("apellido")
        val edad = intent.getIntExtra("edad",0).toString()
        val id = intent.getIntExtra("id",0)
        posicion = id

        edNombre = findViewById(R.id.edNombre)
        edApellido = findViewById(R.id.edApellido)
        edEdad = findViewById(R.id.edEdad)

        edNombre.setText(nombre)
        edApellido.setText(apellido)
        edEdad.setText(edad)

    }
    fun guardar(v: View){
        val gNombre = edNombre.text.toString()
        val gApellido = edApellido.text.toString()
        val gEdad = edEdad.text.toString().toInt()

        val listaPersona = Provisional.listaPersona
        val persona = listaPersona[posicion]
        val nPersona = Persona(gNombre,gApellido,gEdad,persona.id)
        listaPersona[posicion] = nPersona

        Toast.makeText(this,"Cambios guardados correctamente", Toast.LENGTH_LONG).show()
        finish()
    }
}