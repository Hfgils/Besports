/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.icarus.view;

/**
 *
 * @author Herney
 */
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ThemeView
        implements Serializable {

    private String color;

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void change(String color) {
        if (color.equals("orange")) {
            this.color = null;
        } else {
            this.color = "-" + color;
        }
    }
}
