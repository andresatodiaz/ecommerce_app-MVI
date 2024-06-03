package com.mvi.ecommmerceapp.data.Service

import android.util.Log
import com.mvi.ecommmerceapp.domain.Entities.Usuario
import com.mvi.ecommmerceapp.data.DataSource.Interface.UserClient

class UsuarioService {

    suspend fun showUsers(){
        try{
            val userResponse = UserClient.instance.getUsers()
            Log.i("resp",userResponse.toString())
        }catch (e:Exception){
            Log.e("Error de showUsers",e.toString())
        }
    }

    suspend fun login(correo:String, contrasena:String): Usuario?{
        try{
            val userResponse = UserClient.instance.login(correo, contrasena)
            return if(userResponse!=null){
                userResponse
            }else{
                null
            }
        }catch (e:Exception){
            Log.e("Error logging",e.toString())
            return null
        }
    }

    suspend fun agregarUsuario(usuario: Usuario){
        try{
            UserClient.instance.agregarUsuario(usuario)
        }catch (e:Exception){
            Log.e("Error agregarUsuario",e.toString())
        }
    }

    suspend fun miUsuario(id:String): Usuario?{
        try{
            return if(UserClient.instance.myUser(id)!=null){
                UserClient.instance.myUser(id)
            }else{
                return null
            }
        }catch (e:Exception){
            Log.e("Error encontrando usuario",e.message.toString())
            return null
        }
    }

    suspend fun getVendedor(id:String): Usuario?{
        try{
            return if(UserClient.instance.getVendedor(id)!=null){
                UserClient.instance.getVendedor(id)
            }else{
                null
            }
        }catch (e:Exception){
            Log.e("Error obteniendo usuario",e.message.toString())
            return null
        }
    }

}