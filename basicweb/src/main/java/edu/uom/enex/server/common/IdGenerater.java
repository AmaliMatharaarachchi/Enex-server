/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uom.enex.server.common;

/**
 * Created by Himashi Nethinika on 5/11/16.
 */

public class IdGenerater {
    
    public static String generateId(String id, String prefix) {
        String lastId=id;

        if (lastId == null) {
            return prefix+"000"+1;
        } else {

            int num=Integer.parseInt(lastId.split("-")[1]);
            num++;
            if (num < 10) {
                return prefix+"000"+ num;
            } else if (num < 100) {
                return prefix+"00"+ num;
            } else if (num < 1000) {
                return prefix+"0"+ num;
            } else {
                return prefix+ num;
            }           
        }
    }
}
    

