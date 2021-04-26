package core;

import org.json.JSONObject;

public class Request {

    public static String retornaParametrosBodyUsuario(String nome, String password, String administrador){
       return new JSONObject()
       .put("nome",nome)
       .put("email",password)
       .put("administrador",administrador).toString();
    }
}
