package com.example.listadecompras

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import com.example.listadecompras.produtosGlobal as produtosGloba1


class MainActivity : AppCompatActivity() {

    override fun onResume() {
        super.onResume()


        val adapter = list_view_produtos.adapter as ProdutoAdapter
        adapter.clear()
        adapter.addAll(produtosGloba1)
        {
            setContentView(R.layout.activity_main)

            btn_adicionar.setOnClickListener{
                val intent = Intent(this,CadastroActivity::class.java)
                startActivity(intent)
            }

            val produtosAdapter = ProdutoAdapter(this)


            list_view_produtos.adapter = produtosAdapter


            list_view_produtos.setOnItemLongClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->
                val item = produtosAdapter.getItem(position)
                produtosAdapter.remove(item)
                Toast.makeText(this, "Deletando $item", Toast.LENGTH_SHORT).show()
                true

            }
        }
    }
}
