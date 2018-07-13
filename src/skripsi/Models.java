/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsi;

/**
 *
 * @author Hani Nurlilah
 */
public class Models {
    public static String inputFile;
    public static String encryptedFile;

    // ini method setter
    public void setInputFile(String inputFile){
        this.inputFile = inputFile;
    }

    public void setEncryptedFile(String encryptedFile){
        this.encryptedFile = encryptedFile;
    }

    // ini method getter
    public String getInputFile(){
        return this.inputFile;
    }

    public String getEncryptedFile(){
        return this.encryptedFile;
    }
}
