package com.example.example

import android.media.Image

public class Asset(private val newName: String, private val newDescription : String) {


    val name : String = newName
    val description : String = newDescription
    val imageUrl : String = "https://picsum.photos/300?random=1"
}