package com.Practica2.service;

import com.Practica2.domain.Arboles;
import java.util.List;

public interface ArbolesService {
    
    public List<Arboles> getArboles(boolean activos);
    
    public Arboles getArboles (Arboles arboles);
    
    public void save(Arboles arboles);
    
    public void delete(Arboles arboles);
}
