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
    
    @Override
    public List<Pair<String,String>> getData(){
        return newData;
    }
    
    private boolean validateListLenght(String[] args){
        return args.length % 2 == 0;
    }
    
    private boolean validateParamNames(List<String> paramNames){
        for(Pair<String,String> vLookUp:newData){
            if(!paramNames.contains(vLookUp.getLeft())){
                return false;
            }
        }
        return true;
    }
}
