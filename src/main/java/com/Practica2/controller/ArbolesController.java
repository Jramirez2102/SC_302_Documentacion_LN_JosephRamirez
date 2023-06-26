/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Practica2.controller;

import com.Practica2.domain.Arboles;
import com.Practica2.service.ArbolesService;
import com.Practica2.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/arboles")
public class ArbolesController {

    @Autowired
    private ArbolesService arbolesService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var arboles = arbolesService.getArboles(false);
        model.addAttribute("arboles", arboles);
        model.addAttribute("totalArboles", arboles.size());

        return "/arbol/lsitado";
    }

    @GetMapping("/nuevo")
    public String arbolesNuevo(Arboles arboles) {
        return "/arboles/modifica";

    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String arbolesGuardar(Arboles arboles,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            arbolesService.save(arboles);
            arboles.setRutaImagen(
                    firebaseStorageService.cargaImagen(imagenFile, "arboles", arboles.getIdArbol())
            );
        }
        arbolesService.save(arboles);
        return"redirect:/arboles/listado";
    }
@GetMapping("/eliminar/{idArbol}")
public String arbolesEliminar(Arboles arboles){
    arbolesService.delete(arboles);
    return"redirect:/arboles/listado";
    
}
@GetMapping("/modificar/{idArbol}")
public String arbolesModificar(Arboles arboles, Model model){
    arboles=arbolesService.getArboles(arboles);
    model.addAttribute("arboles",arboles);
    return "/arboles/modificar";
}


}
