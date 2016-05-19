package edu.uom.enex.server.common;

import java.util.Random;

/**
 * Created by Himashi Nethinika on 5/12/2016.
 */
public class RandomString {

    public static String randomString(int len){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}
