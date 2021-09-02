package com.example.adivinarnumerorandom

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.set

class MainActivity : AppCompatActivity() {
    var intentos: Int = 1
    var intentosTotal: Int=1
    var numeroAdivinar:Int = (0..1000).random()
    var listaResultado: List <View> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this.applicationContext, ""+this.numeroAdivinar, Toast.LENGTH_SHORT).show()

    }

    fun validarNumero(view: View)
    {

        var numeroIngresadoPantalla: EditText = findViewById(R.id.editTextEntradaNumero)
        var numeroIngresado: Int = numeroIngresadoPantalla.text.toString().toInt()



        if (this.intentos== 8)
        {
            Toast.makeText(this.applicationContext, "8 intentos el numero cambio", Toast.LENGTH_SHORT).show()
            this.numeroAdivinar=(0..1000).random()
            var tableRow : View = LayoutInflater.from(this).inflate(R.layout.table_item,null,false)
            var turno : TextView = tableRow.findViewById(R.id.turnoAdivinar)
            var pista : TextView = tableRow.findViewById(R.id.Pista)
            var numeroUsado : TextView = tableRow.findViewById(R.id.NumeroIntroducido)
            turno.text=""+this.intentosTotal
            pista.text="Cambio de Numero"
            numeroUsado.text=""+numeroIngresado
            this.listaResultado +=tableRow

            this.intentos=0
            Toast.makeText(this.applicationContext, ""+this.numeroAdivinar, Toast.LENGTH_SHORT).show()

        }
        else if (numeroIngresado == this.numeroAdivinar)
        {
            var tablaResultados= findViewById<TableLayout>(R.id.tableLayoutResults)
            tablaResultados.removeAllViews()
            Toast.makeText(this.applicationContext, "Numero adivinado", Toast.LENGTH_SHORT).show()
            var tableRow : View = LayoutInflater.from(this).inflate(R.layout.table_item,null,false)
            var turno : TextView = tableRow.findViewById(R.id.turnoAdivinar)
            var pista : TextView = tableRow.findViewById(R.id.Pista)
            var numeroUsado : TextView = tableRow.findViewById(R.id.NumeroIntroducido)
            turno.text=""+this.intentosTotal
            pista.text="Adivinado"
            numeroUsado.text=""+numeroIngresado
            this.listaResultado +=tableRow
            for(i in this.listaResultado)
            {
                tablaResultados.addView(i)
            }

            onRestart()
        }
        else if (numeroIngresado < this.numeroAdivinar)
        {
            Toast.makeText(this.applicationContext, "Numero ingresado es menor", Toast.LENGTH_SHORT).show()
            var tableRow : View = LayoutInflater.from(this).inflate(R.layout.table_item,null,false)
            var turno : TextView = tableRow.findViewById(R.id.turnoAdivinar)
            var pista : TextView = tableRow.findViewById(R.id.Pista)
            var numeroUsado : TextView = tableRow.findViewById(R.id.NumeroIntroducido)
            turno.text=""+this.intentosTotal
            pista.text="Inferior"
            numeroUsado.text=""+numeroIngresado
            this.listaResultado +=tableRow
        }
        else if (numeroIngresado > this.numeroAdivinar)
        {
            Toast.makeText(this.applicationContext, "Numero ingresado es mayor", Toast.LENGTH_SHORT).show()
            var tableRow : View = LayoutInflater.from(this).inflate(R.layout.table_item,null,false)
            var turno : TextView = tableRow.findViewById(R.id.turnoAdivinar)
            var pista : TextView = tableRow.findViewById(R.id.Pista)
            var numeroUsado : TextView = tableRow.findViewById(R.id.NumeroIntroducido)
            turno.text=""+this.intentosTotal
            pista.text="Mayor"
            numeroUsado.text=""+numeroIngresado
            this.listaResultado +=tableRow
        }

        this.intentos++
        this.intentosTotal++
    }

    override fun onRestart() {
        super.onRestart()
    }

    fun ReiniciarJuego(view: View)
    {
        var tablaResultados= findViewById<TableLayout>(R.id.tableLayoutResults)
        tablaResultados.removeAllViews()
        this.numeroAdivinar=(0..1000).random()
        this.intentos=1
        Toast.makeText(this.applicationContext, ""+this.numeroAdivinar, Toast.LENGTH_SHORT).show()
        this.listaResultado= emptyList()
        this.intentosTotal=1


    }
}