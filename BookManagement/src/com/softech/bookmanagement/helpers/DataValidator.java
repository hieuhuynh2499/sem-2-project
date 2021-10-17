/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.bookmanagement.helpers;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Nguyen Bae
 */
public class DataValidator {
    public static void validateEmpty (JTextField field, StringBuilder sb, String errorMessage){
        if(field.getText().equals("")){
            sb.append(errorMessage).append("\n");
            Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED);
            field.setBorder(border);
            field.requestFocus();
        }else{
            Border border = BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(51,102,255));
            field.setBorder(border);
        }
    }
    public static void validateEmpty (JPasswordField field, StringBuilder sb, String errorMessage){
        String password = new String(field.getPassword());
        if(password.equals("")){
            sb.append(errorMessage).append("\n");
            Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED);
            field.setBorder(border);
            field.requestFocus();
        }else{
            Border border = BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(51,102,255));
            field.setBorder(border);
        }
    }
}
