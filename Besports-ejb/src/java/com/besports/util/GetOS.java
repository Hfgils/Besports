/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.besports.util;

/**
 *
 * @author hgil
 */
public class GetOS {

    public String getos() {
        String sSistemaOperativo = System.getProperty("os.name");

        String[] parts = sSistemaOperativo.split("(?=\\s)");
        String sSistemaOperativof = parts[0];
        return sSistemaOperativof;
    }
}
