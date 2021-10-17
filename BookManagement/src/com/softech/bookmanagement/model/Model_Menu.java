/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.bookmanagement.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Nguyen Bae
 */
public class Model_Menu {
    String icon;
    String name;
    MenuType type;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public Model_Menu() {
    }

    public Model_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }
    
    public Icon toIcon(){
        return new ImageIcon(getClass().getResource("/com/softech/bookmanagement/icon/" + icon + ".png"));
    }
    public Icon toIconSeleted(){
        return new ImageIcon(getClass().getResource("/com/softech/bookmanagement/icon/" + icon + "_selected.png"));
    }
    public static enum MenuType{
        MENU,EMPTY  
    }
}
