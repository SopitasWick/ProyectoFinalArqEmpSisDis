/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package cifrado;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author DELL
 */
public final class CifradoInformacionSin implements ICifrado{
    private String KEY_CIFRADO;
    private  SecretKeySpec claveSecreta;
    private Cipher cifrador;
   // private String mensajeOriginal;
   // private byte[] mensajeCifrado;
    
    private CifradoInformacionSin() {
        this.KEY_CIFRADO = "IONOnojjobNISPnpknpNPos9856KHvhv";
        this.claveSecreta=new SecretKeySpec(this.getKEY_CIFRADO().getBytes(), "AES");
        try {
            this.cifrador = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException ex) {
            Logger.getLogger(CifradoInformacionSin.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public static CifradoInformacionSin getInstance() {
        return CifradoInformacionSinHolder.INSTANCE;
    }

    @Override
    public String CifrarMensaje(String mensajeOriginal) {
        try {
             this.getCifrador().init(Cipher.ENCRYPT_MODE, this.getClaveSecreta());
             byte[] mensajeCifrado = this.getCifrador().doFinal(mensajeOriginal.getBytes());
             String mensajeCifradoBase64 = Base64.getEncoder().encodeToString(mensajeCifrado);
             return mensajeCifradoBase64;
             
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(CifradoInformacionSin.class.getName()).log(Level.SEVERE, null, ex);
           return "Ocurrio algo en el cifrado";
        }
        
    }

    @Override
    public String descifrarMensaje(String mensajeCifrado) {
        try {
            this.getCifrador().init(Cipher.DECRYPT_MODE, this.getClaveSecreta());
            byte[] mensajeDescifrado = this.getCifrador().doFinal(Base64.getDecoder().decode(mensajeCifrado));
            String mensajeOriginalRecuperado = new String(mensajeDescifrado);
            return mensajeOriginalRecuperado;
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(CifradoInformacionSin.class.getName()).log(Level.SEVERE, null, ex);
            return "paso algo en el descifrado";
        }
        
    }
    
    private static class CifradoInformacionSinHolder {

        private static final CifradoInformacionSin INSTANCE = new CifradoInformacionSin();
    }

    private String getKEY_CIFRADO() {
        return KEY_CIFRADO;
    }

    private SecretKeySpec getClaveSecreta() {
        return claveSecreta;
    }

    private Cipher getCifrador() {
        return cifrador;
    }
    
}
