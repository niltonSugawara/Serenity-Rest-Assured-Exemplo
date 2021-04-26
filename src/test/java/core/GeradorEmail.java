package core;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class GeradorEmail {

    public static String gerarEmailUsuarioAleatorio() {
        int tamanho = new Random().nextInt(10);
        return RandomStringUtils.random(tamanho,true,false) + "@email.com";
    }
}
