package com.example.tutorial02madd

object MyCredentials {
    var username =""
    private var password =""
    var email =""

    fun setPassword(password:String, retypePassword:String):Boolean{

        return if(password==retypePassword){
            this.password = password
            true
        }else{
            false
        }

    }

    fun authenticate(password: String):Boolean{

        return if (this.password == password){
            true
        }else{
            false
        }

    }

}