/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsi;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
//import java.util.Base64;

/**
 * Created by user on 23/02/2018.
 */
public class Utils {

    public static void encrypt(byte[] key, File inputFile, File outputFile) throws IOException {
        byte[] iv={4,5,7,8,9,1,4,5};
        Rabbit rabbit = new Rabbit();
        rabbit.setupIV(iv);
        rabbit.setupKey(key);

        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) inputFile.length()];
        inputStream.read(inputBytes);
        byte[] ct=rabbit.crypt(inputBytes);
        //byte[] encodedBytes = Base64.getEncoder().encode(ct);
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(ct);

        inputStream.close();
        outputStream.close();
    }

    public static void decrypt(byte[] key, File encryptedFile, File decryptedFile) throws IOException {
        FileInputStream inputStream = new FileInputStream(encryptedFile);
        byte[] inputBytes = new byte[(int) encryptedFile.length()];
        inputStream.read(inputBytes);
        //byte[] decodedBytes = Base64.getDecoder().decode(inputBytes);

        Rabbit rabbit1 = new Rabbit();
        byte[] iv={4,5,7,8,9,1,4,5};
        rabbit1.setupIV(iv);
        rabbit1.setupKey(key);
        byte[] decrypted=rabbit1.crypt(inputBytes);

        FileOutputStream outputStream = new FileOutputStream(decryptedFile);
        outputStream.write(decrypted);

        inputStream.close();
        outputStream.close();
    }
    
    public static void putFile(String host, int port, String username, String password, String localFilename, String remoteFilename) {
    try {
      FTPClient ftpClient = new FTPClient();
      // Connect to host
      ftpClient.connect(host, port);
      int reply = ftpClient.getReplyCode();
      if (FTPReply.isPositiveCompletion(reply)) {

        // Login
        if (ftpClient.login(username, password)) {
          // Enter local passive mode
          ftpClient.enterLocalPassiveMode();

          // Store file on host
	  InputStream is = new FileInputStream(localFilename);
	  if (ftpClient.storeFile(remoteFilename, is)) {
	    is.close();
	  } else {
	    System.out.println("Could not store file");
	  }
	  // Logout
	  ftpClient.logout();

        } else {
          System.out.println("FTP login failed");
        }

        // Disconnect
    	ftpClient.disconnect();

      } else {
        System.out.println("FTP connect to host failed");
      }
    } catch (IOException ioe) {
      System.out.println(ioe);
    }
  }
}
