package com.example.example.models

import android.view.View

enum class ButtonType {
    ButtonWithIcon, RoundedButton,
}

public class CustomButton(private val _name: String, private val _onClickListener : View.OnClickListener, private val _buttonType : ButtonType,) {
    val name = _name
    val onClickListener = _onClickListener
    val buttonType = _buttonType
}