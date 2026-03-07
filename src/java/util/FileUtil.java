/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.UUID;

/**
 *
 * @author DEV-PC
 */
public class FileUtil {
        public static String getRandomFileName(String name){
            String ext = "";
            int i = name.lastIndexOf('.');
            if(i > 0){
                ext = name.substring(i);
            }
            return UUID.randomUUID().toString() + ext;
        }
}
