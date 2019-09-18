package com.example.listadecompras

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.listadecompras.modelo.Produto
import kotlinx.android.synthetic.main.list_view_item.view.*
import java.text.FieldPosition
import java.text.NumberFormat
import java.util.*

class ProdutoAdapter (contexto: Context) : ArrayAdapter<Produto>(contexto, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val v: View

        if (convertView != null) {
            v = convertView

        } else {
            v = LayoutInflater.from(context).inflate(R.layout.list_view_item, parent, false)
        }

        val item = getItem(position)

        val txt_produto = v.findViewById<TextView>(R.id.txt_item_produto)
        val txt_qdt = v.findViewById<TextView>(R.id.txt_item_qtd)
        val txt_valor = v.findViewById<TextView>(R.id.txt_item_valor)
        val img_produto = v.findViewById<ImageView>(R.id.img_item_foto)

        txt_produto.text = item.nome
        txt_qdt.text = item.quantidade.toString()

        if (item.valor != null) {
            val f = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            txt_valor.text = f.format(item.valor)
        } else {
            Toast.makeText(context, "Insira um valor", Toast.LENGTH_LONG).show()
        }

        if (item.foto != null) {
            img_produto.setImageBitmap(item.foto)
        }

        return v
    }
}



