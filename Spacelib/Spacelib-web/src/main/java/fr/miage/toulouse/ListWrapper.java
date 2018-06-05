/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jb
 */
@XmlRootElement
public class ListWrapper<T> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private List<T> list;
    
    public ListWrapper(){}
    
    public ListWrapper(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
