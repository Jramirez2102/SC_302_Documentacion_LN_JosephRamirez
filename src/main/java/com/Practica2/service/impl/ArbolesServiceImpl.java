package com.Practica2.service.impl;

import com.Practica2.dao.ArbolesDao;
import com.Practica2.domain.Arboles;
import com.Practica2.service.ArbolesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class ArbolesServiceImpl implements ArbolesService{
    @Autowired
    private ArbolesDao arbolesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Arboles> getArboles(boolean activos){
        var lista = arbolesDao.findAll();
        /*if(activos){
           lista.removeIf(e -> !e.isActivo());
        }*/
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Arboles getArboles(Arboles arboles){
       return arbolesDao.findById(arboles.getIdArbol()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Arboles arboles) {
        arbolesDao.save(arboles);
    }
    
    @Override
    @Transactional
    public void delete(Arboles arboles) {
        arbolesDao.delete(arboles);
    }
}
