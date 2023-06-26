/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Practica2.service;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author rolan
 */
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoCliente, String carpeta, Long id);
   
    
    final String BucketName = "ea-08-practicas-3.appspot.com";
    final String rutaSuperiorStorage="arbol";
    final String rutaJsonFile="firebase";
     final String archivoJsonFile="ea-08-practicas-3-firebase-adminsdk-6567x-04c8fbb1e1";
}
