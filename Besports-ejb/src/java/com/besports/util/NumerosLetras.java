/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.besports.util;

import java.math.BigDecimal;

/**
 *
 * @author hgil
 */
public class NumerosLetras {

    public static String cantidadConLetra(String s) {
        StringBuilder result = new StringBuilder();
        BigDecimal totalBigDecimal = new BigDecimal(s).setScale(2, 1);
        long parteEntera = totalBigDecimal.toBigInteger().longValue();
        int triUnidades = (int) (parteEntera % 1000L);
        int triMiles = (int) (parteEntera / 1000L % 1000L);
        int triMillones = (int) (parteEntera / 1000000L % 1000L);
        int triMilMillones = (int) (parteEntera / 1000000000L % 1000L);
        if (parteEntera == 0L) {
            result.append("Cero ");
            return result.toString();
        }
        if (triMilMillones > 0) {
            result.append(triTexto(triMilMillones).toString() + "Mil ");
        }
        if (triMillones > 0) {
            result.append(triTexto(triMillones).toString());
        }
        if ((triMilMillones == 0) && (triMillones == 1)) {
            result.append("Mill�n ");
        } else if ((triMilMillones > 0) || (triMillones > 0)) {
            result.append("Millones ");
        }
        if (triMiles > 0) {
            result.append(triTexto(triMiles).toString() + "Mil ");
        }
        if (triUnidades > 0) {
            result.append(triTexto(triUnidades).toString());
        }
        return result.toString();
    }

    private static StringBuilder triTexto(int n) {
        StringBuilder result = new StringBuilder();
        int centenas = n / 100;
        int decenas = n % 100 / 10;
        int unidades = n % 10;
        switch (centenas) {
            case 0:
                break;
            case 1:
                if ((decenas == 0) && (unidades == 0)) {
                    result.append("Cien ");
                    return result;
                }
                result.append("Ciento ");

                break;
            case 2:
                result.append("Doscientos ");
                break;
            case 3:
                result.append("Trescientos ");
                break;
            case 4:
                result.append("Cuatrocientos ");
                break;
            case 5:
                result.append("Quinientos ");
                break;
            case 6:
                result.append("Seiscientos ");
                break;
            case 7:
                result.append("Setecientos ");
                break;
            case 8:
                result.append("Ochocientos ");
                break;
            case 9:
                result.append("Novecientos ");
        }
        switch (decenas) {
            case 0:
                break;
            case 1:
                if (unidades == 0) {
                    result.append("Diez ");
                    return result;
                }
                if (unidades == 1) {
                    result.append("Once ");
                    return result;
                }
                if (unidades == 2) {
                    result.append("Doce ");
                    return result;
                }
                if (unidades == 3) {
                    result.append("Trece ");
                    return result;
                }
                if (unidades == 4) {
                    result.append("Catorce ");
                    return result;
                }
                if (unidades == 5) {
                    result.append("Quince ");
                    return result;
                }
                result.append("Dieci");

                break;
            case 2:
                if (unidades == 0) {
                    result.append("Veinte ");
                    return result;
                }
                result.append("Veinti");

                break;
            case 3:
                result.append("Treinta ");
                break;
            case 4:
                result.append("Cuarenta ");
                break;
            case 5:
                result.append("Cincuenta ");
                break;
            case 6:
                result.append("Sesenta ");
                break;
            case 7:
                result.append("Setenta ");
                break;
            case 8:
                result.append("Ochenta ");
                break;
            case 9:
                result.append("Noventa ");
        }
        if ((decenas > 2) && (unidades > 0)) {
            result.append("y ");
        }
        switch (unidades) {
            case 0:
                break;
            case 1:
                result.append("Un ");
                break;
            case 2:
                result.append("Dos ");
                break;
            case 3:
                result.append("Tres ");
                break;
            case 4:
                result.append("Cuatro ");
                break;
            case 5:
                result.append("Cinco ");
                break;
            case 6:
                result.append("Seis ");
                break;
            case 7:
                result.append("Siete ");
                break;
            case 8:
                result.append("Ocho ");
                break;
            case 9:
                result.append("Nueve ");
        }
        return result;
    }
}
