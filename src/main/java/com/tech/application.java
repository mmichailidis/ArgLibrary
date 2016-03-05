/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech;

import com.tech.arglibrary.Lib;
import com.tech.arglibrary.inneritems.exceptions.NoParserException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KuroiTenshi
 */
public class application {
    
    /**
     * for this DEMO to work create a "params.ini" file on the same folder with the jar. 
     * the format of the ini file should be 1 parameter on each line
     * @param args
     * @throws NoParserException
     * @throws IOException 
     */
    public static void main(String[] args) throws NoParserException, IOException{
        System.out.println("Starting ");
        List<String> params = new ArrayList<>();
        Lib myLib = Lib.getInstance();
        myLib.registerDefaultParser();
        
        FileReader fileReader = new FileReader("params.ini");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        
        while((line = bufferedReader.readLine()) != null){
            params.add(line);
        }        
        bufferedReader.close();
        
        boolean l = myLib.registerParam(params);
        
        if(!l){
            System.out.println("Invalid param");
            System.exit(1);
        }
        
        boolean o = myLib.inputParams(args);      
        
        if(o){
            for(String vLookUp:params){
                System.out.println("For " + vLookUp + " : " + myLib.getParamData(vLookUp));                
            }
        }else{
            System.out.println("something went wrong. Restart");
        }        
    }
}
