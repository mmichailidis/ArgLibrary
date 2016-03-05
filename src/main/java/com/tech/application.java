/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech;

import com.tech.arglibrary.Lib;
import com.tech.inneritems.exceptions.NoParserException;

/**
 *
 * @author KuroiTenshi
 */
public class application {
    public static void main(String[] args) throws NoParserException{
        System.out.println("Starting ");
        Lib myLib = Lib.getInstance();
        myLib.registerDefaultParser();
        myLib.registerParam("-f");
        myLib.registerParam("-w");
        boolean o = myLib.inputParams(args);
        
        if(o){
            System.out.println("For f : " + myLib.getParamData("-f"));
            System.out.println("For w : " + myLib.getParamData("-w"));
        }else{
            System.out.println("something went wrong. Restart");
        }        
    }
}
