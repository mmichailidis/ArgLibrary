package com.tech.arglibrary;

import com.tech.arglibrary.interfaces.IParser;
import com.tech.arglibrary.inneritems.Pair;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KuroiTenshi
 */
public class Parser implements IParser {
    List<Pair<String,String>> newData = new ArrayList<>();
    
    /**
     * Parses the input arguments so they will be placed with their parameters in a Pair
     * @param args
     * @param params
     * @return returns true if the arguments were processed successfully. The getData should be used after this function 
     *         returns true
     */
    @Override
    public boolean parse(String[] args,List<String> params){
        int i;
        if(validateListLenght(args)){
            for(i=0 ; i<args.length ; i = i + 2){
                newData.add(Pair.of(args[i], args[i+1]));
            }            
            return validateParamNames(params);          
        } else {
            return false;
        }        
    }
    
    /**
     * 
     * @return Returns the data or an empty list.. depends on when u call it
     */
    @Override
    public List<Pair<String,String>> getData(){
        return newData;
    }
    
    /**
     * 
     * @param args
     * @return Validates that the list of the arguments that went into the program are even number
     *         which is the currently processable number of arguments
     */
    private boolean validateListLenght(String[] args){
        return args.length % 2 == 0;
    }
    
    /**
     * 
     * @param paramNames
     * @return Validates that the names of the parameters are included in the parameter list
     *         and that they are not random
     */
    private boolean validateParamNames(List<String> paramNames){
        for(Pair<String,String> vLookUp:newData){
            if(!paramNames.contains(vLookUp.getLeft())){
                return false;
            }
        }
        return true;
    }
}
