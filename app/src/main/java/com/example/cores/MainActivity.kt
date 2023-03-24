package com.example.cores
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView

class MainActivity : AppCompatActivity() {
  
    private lateinit var tvVermelho: TextView
    private lateinit var tvVerde: TextView
    private lateinit var tvAzul: TextView  
    private lateinit var sbVermelho: SeekBar
    private lateinit var sbVerde: SeekBar
    private lateinit var sbAzul: SeekBar
    private lateinit var llCor: LinearLayout
    private lateinit var tvCor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        this.tvVermelho = findViewById(R.id.tvVermelho)
        this.tvVerde = findViewById(R.id.tvVerde)
        this.tvAzul = findViewById(R.id.tvAzul)
        
        this.sbVermelho = findViewById(R.id.sbVermelho)
        this.sbVerde = findViewById(R.id.sbVerde)
        this.sbAzul = findViewById(R.id.sbAzul)


        this.llCor = findViewById(R.id.llCor)
        this.llCor.setBackgroundColor(this.criarCor())

        this.tvCor = findViewById(R.id.tvCor)

        this.sbVermelho.setOnSeekBarChangeListener(mudandocor())
        this.sbVerde.setOnSeekBarChangeListener(mudandocor())
        this.sbAzul.setOnSeekBarChangeListener(mudandocor())
    }

    fun criarCor(): Int{
        val vermelho = this@MainActivity.sbVermelho.progress
        val verde = this@MainActivity.sbVerde.progress
        val Azul = this@MainActivity.sbAzul.progress
        return Color.rgb(vermelho, verde, Azul)
    }


    inner class mudandocor: OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            val vermelho = this@MainActivity.sbVermelho.progress
            val verde = this@MainActivity.sbVerde.progress
            val azul = this@MainActivity.sbAzul.progress

            this@MainActivity.tvVermelho.text = vermelho.toString()
            this@MainActivity.tvVerde.text = verde.toString()
            this@MainActivity.tvAzul.text = azul.toString()
            this@MainActivity.llCor.setBackgroundColor(this@MainActivity.criarCor())
            this@MainActivity.tvCor.setTextColor(this@MainActivity.criarCor())
            this@MainActivity.tvCor.text = String.format("%02x%02x%02x", vermelho, verde,azul)

        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {}

        override fun onStopTrackingTouch(seekBar: SeekBar?) {}

    }
}
