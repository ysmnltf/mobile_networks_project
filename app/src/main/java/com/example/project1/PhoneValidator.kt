package com.example.project1

class PhoneValidator {

    companion object {

        val phoneRegex : Regex = "(\\+989)?\\d{9}".toRegex()

        fun IsPhoneValid(phone: String) : Boolean {
            return phoneRegex.matches(phone)
        }
    }
}