package com.example.alertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alertdialog.databinding.ActivityMainBinding
import com.example.alertdialog.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupButton()
    }

    private fun setupButton() {
        binding.buttonAlert.setOnClickListener {
            showAlertSimple()
        }
        binding.buttonList.setOnClickListener { showListDialog() }
        binding.buttonPersonal.setOnClickListener { showCustomDialog() }
    }

    private fun showCustomDialog() {
        val bindingDialog = CustomDialogBinding.inflate(layoutInflater)

        val builder = AlertDialog.Builder(this)
        builder.setView(bindingDialog.root)

        builder.setTitle("Add dato")
        builder.setPositiveButton("Save", DialogInterface.OnClickListener { dialogInterface, id ->
            val dato= bindingDialog.editName.text.toString()
            val pass= bindingDialog.editPassw.text.toString()
            Toast.makeText(this, "dato: $dato", Toast.LENGTH_SHORT).show()  })


    }

    private fun showListDialog() {
        val animaList = arrayOf("Leon","Tigre","Oso")

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Lista de animales")
        builder.setItems(animaList, DialogInterface.OnClickListener{dialogInterface, id -> Toast.makeText(this, animaList[id], Toast.LENGTH_SHORT).show()})

        val dialogList = builder.create()
        dialogList.show()
    }

    private fun showAlertSimple() {
        val builder = AlertDialog.Builder(this)

        builder.setMessage("¿Quiere cerrar esta APP")

            .setCancelable(true)
            .setPositiveButton("Aceptar Teresa", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "dialogo aceptado", Toast.LENGTH_SHORT).show()  })
            .setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialogInterface, id -> Toast.makeText(this, "Dialogo no aceptado", Toast.LENGTH_SHORT).show()  })
            .setNeutralButton("Neutro", DialogInterface.OnClickListener { dialogInterface, i -> Toast.makeText(this, "Dialogo neutro", Toast.LENGTH_SHORT).show()  })

        val dialog = builder.create()
        dialog.show()


    }
}