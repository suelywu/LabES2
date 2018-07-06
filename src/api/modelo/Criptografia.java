package api.modelo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

    public String criptografar(String entrada) {
        String saida = entrada;
        if (saida != null) {
            MessageDigest messageDigest = null;
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            messageDigest.update(entrada.getBytes());
            BigInteger hash = new BigInteger(1, messageDigest.digest());
            saida = hash.toString(16);
            while (saida.length() < 32) {
                saida = "0" + saida;
            }
        }
        return saida;
    }

}
