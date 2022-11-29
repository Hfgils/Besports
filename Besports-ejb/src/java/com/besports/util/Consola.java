/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.besports.util;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author gorditos
 */
public class Consola {

    public void ejecute(String[] cmd) {
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            OutputStream outputStream = process.getOutputStream();
            System.out.println(outputStream);
            process.waitFor();
            System.out.println(process.exitValue());
            process.destroy();
        } catch (IOException ioe) {
            System.out.println(ioe);
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
    }
}
