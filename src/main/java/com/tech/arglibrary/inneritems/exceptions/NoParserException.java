/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.arglibrary.inneritems.exceptions;

/**
 *
 * @author KuroiTenshi
 */
public class NoParserException extends Exception{
    public NoParserException(){
        super("No parser was registered");
    }
}
