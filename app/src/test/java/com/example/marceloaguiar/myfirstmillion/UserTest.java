package com.example.marceloaguiar.myfirstmillion;

import com.example.marceloaguiar.myfirstmillion.Model.Exceptions.WrongPasswordException;
import com.example.marceloaguiar.myfirstmillion.Model.User;

import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

/**
 * Created by marceloaguiar on 11/24/16.
 */

public class UserTest {
    @Test
    public void newUserEmail(){
        User user = User.newInstance("marcelolajr@gmail.com","12345");
        assertEquals("marcelolajr@gmail.com",user.getEmail());
    }
    @Test
    public void newUserEncryption() throws NoSuchAlgorithmException {
        User user = User.newInstance("marcelolajr@gmail.com","12345");
        MessageDigest digest = MessageDigest.getInstance("md5");
        byte[] password = digest.digest("12345".getBytes());
        assertEquals(true,digest.isEqual(password,user.getPassword()));
    }

    @Test
    public void changePasswordOK() throws NoSuchAlgorithmException, WrongPasswordException {
        User user = User.newInstance("marcelolajr@gmail.com","12345");
        user.changePassword("12345","123456");

        MessageDigest digest = MessageDigest.getInstance("md5");
        byte[] password = digest.digest("123456".getBytes());
        assertEquals(true,digest.isEqual(user.getPassword(),password));
    }

    @Test
    public void changePasswordError() throws NoSuchAlgorithmException {
        User user = User.newInstance("marcelolajr@gmail.com","12345");
        try {
            user.changePassword("blablabla","123456");
        } catch (WrongPasswordException e) {
            e.printStackTrace();
        }

        MessageDigest digest = MessageDigest.getInstance("md5");
        byte[] password = digest.digest("12345".getBytes());
        assertEquals(true,digest.isEqual(password,user.getPassword()));
    }

    @Test
    public void changePasswordException() throws NoSuchAlgorithmException {
        User user = User.newInstance("marcelolajr@gmail.com","12345");
        try {
            user.changePassword("blablabla","123456");
        } catch (WrongPasswordException e) {
            e.printStackTrace();
            assertEquals("Senha antiga incorreta.",e.getMessage());
        }
    }

}
