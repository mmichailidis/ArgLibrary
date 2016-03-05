package com.tech.arglibrary;

import com.tech.arglibrary.interfaces.IParser;
import com.tech.arglibrary.inneritems.Pair;
import com.tech.arglibrary.inneritems.exceptions.NoParserException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KuroiTenshi
 */
public class Lib {
    private IParser parser;
    private List<Pair<String,String>> currentParams;
    private List<String> availableParameters = new ArrayList<>();
    
    //<editor-fold defaultstate="collapsed" desc="singleton"> 
    
    private static Lib myInstance;
    
    public static Lib getInstance(){
        if(myInstance == null){
            myInstance = new Lib();            
        }
        return myInstance;
    }
    
    private Lib(){}    
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="parameterRegister"> 
    
    /**
     * Register only one parameter at the time
     * @param paramName
     * @return Returns true if the parameter was registered successfully else it returns false so the program will stop
     */
    public boolean registerParam(String paramName){        
        if(availableParameters.contains(paramName)){
            return false;
        }
        availableParameters.add(paramName);
        return true;
    }
    
    /**
     * Register a list of parameters by overloading the single parameter registerParam
     * @param paramName
     * @return Returns true if all the parameters were registered successfully else it returns false so the program will stop
     */
    public boolean registerParam(List<String> paramName){ 
        boolean temp;
        for(String vLookUp:paramName){
            temp = registerParam(vLookUp);
            if(!temp){
                return false;
            }
        }
        return true;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="parserRegister"> 
    
    /**
     * Choose the parser you want to use
     * @param p 
     */
    public void registerParser(IParser p){
        parser = p;
    }
    
    /**
     * The default parser
     */
    public void registerDefaultParser(){
        parser = new Parser();
    }
    
    //</editor-fold>
    
    /**
     * what the String ... str mean?
     * @param params 
     * @return  
     * @throws com.tech.arglibrary.inneritems.exceptions.NoParserException  
     */
    public boolean inputParams(String[] params) throws NoParserException{
        if(parser == null){
            throw new NoParserException();
        }
        
        boolean ans = parser.parse(params,availableParameters);
        if(ans){
            currentParams = parser.getData();
        }else{
            return false;
        }
        return true;
    }
    
    /**
     * Expects a parameter in string format 
     * @param param
     * @return returns the data for that parameter. If the parameter doesn't exist it returns null
     */
    public String getParamData(String param){
        if(currentParams == null || param == null){
            return null;
        }
        
        for(Pair<String,String> vLookUp:currentParams){
            if(vLookUp.getLeft().equals(param)){
                return vLookUp.getRight();
            }
        }
        return null;
    }
}
