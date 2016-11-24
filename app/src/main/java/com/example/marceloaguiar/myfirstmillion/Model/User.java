package com.example.marceloaguiar.myfirstmillion.Model;

import com.example.marceloaguiar.myfirstmillion.Model.Exceptions.WrongPasswordException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by marceloaguiar on 11/24/16.
 */

public class User {

    private byte[] password;
    private String email;
    private List<Month> months;

    private transient MessageDigest digest = null;

    private User() {
    }

    public static User newInstance(String email, String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("md5");
            return new User().setEmail(email).setPassword(digest.digest(password.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] getPassword() {
        return password;
    }

    private User setPassword(byte[] password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    private User setEmail(String email) {
        this.email = email;
        return this;
    }

    public void changePassword(String oldPassword, String newPassword) throws WrongPasswordException {
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] oldPasswordEncrypted = digest.digest(oldPassword.getBytes());
            if(digest.isEqual(oldPasswordEncrypted,this.getPassword())){
               this.setPassword(digest.digest(newPassword.getBytes()));
            } else {
                throw new WrongPasswordException("Senha antiga incorreta.");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
