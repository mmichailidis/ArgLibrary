/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.arglibrary.interfaces;

import com.tech.arglibrary.inneritems.Pair;
import java.util.List;

/**
 *
 * @author KuroiTenshi
 */
public interface IParser {

    List<Pair<String, String>> getData();

    boolean parse(String[] args, List<String> params);
    
}
