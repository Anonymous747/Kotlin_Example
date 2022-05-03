package com.example.example.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.example.R
import com.example.example.models.ButtonType
import com.example.example.models.CustomButton

class ButtonAdapter(private val context: Context, private val buttons: List<CustomButton>) :
    RecyclerView.Adapter<ButtonAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.single_button, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("TAG", "onBindViewHolder: ")
        val button = buttons[position]
        holder.bind(button)
    }

    override fun getItemCount() = buttons.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(button: CustomButton) {
            val buttonView = itemView.findViewById<TextView>(R.id.navigation_button)

            Log.d("TAG", "ViewHolder: button = ${button.buttonType}")
            when (button.buttonType) {
                ButtonType.RoundedButton -> {
                    buttonView.text = button.name
                    buttonView.setOnClickListener(button.onClickListener)
                }
                ButtonType.ButtonWithIcon -> {
                    buttonView.text = button.name
                    buttonView.setOnClickListener(button.onClickListener)
                }
            }
        }
    }
}