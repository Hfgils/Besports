/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.besports.util;

/**
 *
 * @author gorditos
 */
public class WorkFiles {

    private Consola Cmd = new Consola();

    private String mensaje;

    public String copiyFiles(String Os, String[] cmd) {
        if ("Linux".equals(Os)) {
            this.Cmd.ejecute(cmd);
            this.mensaje = "";
        } else if ("Windows".equals(Os)) {
            this.Cmd.ejecute(cmd);
            this.mensaje = "";
        }
        return this.mensaje;
    }

    public String DeleteFiles(String Os, String[] cmd) {
        if ("Linux".equals(Os)) {
            this.Cmd.ejecute(cmd);
            this.mensaje = "";
        } else if ("Windows".equals(Os)) {
            this.Cmd.ejecute(cmd);
            this.mensaje = "";
        }
        return this.mensaje;
    }

    public String CompressFiles(String Os, String[] cmd) {
        if ("Linux".equals(Os)) {
            this.Cmd.ejecute(cmd);
            this.mensaje = "";
        } else if ("Windows".equals(Os)) {
            this.Cmd.ejecute(cmd);
            this.mensaje = "";
        }
        return this.mensaje;
    }

    public String CreateFolder(String Os, String[] cmd) {
        if ("Linux".equals(Os)) {
            this.Cmd.ejecute(cmd);
            this.mensaje = "";
        } else if ("Windows".equals(Os)) {
            this.Cmd.ejecute(cmd);
            this.mensaje = "";
        }
        return this.mensaje;
    }
}
