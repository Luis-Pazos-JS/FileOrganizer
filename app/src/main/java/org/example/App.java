/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;


import java.util.*;

import org.example.controllers.FileOrganizer;



public class App {
    

    public static void main(String[] args) {
        var tree = new FileOrganizer("/home/luispazos/Documentos");
        //tree.insert(new File("/home/luispazos"));
        tree.constructTree();
        
        tree.showTreeInterfaces();

        
    }
}

/* FileOrganizer root = new FileOrganizer("/home/luispazos/Descargas/");
        System.out.println(root.getRoot().getAbsolutePath());
        System.out.println(root.getRoot().exists());
        
        File[] list = root.getRoot().listFiles();

        for (File data : list) {
            System.out.println(data + "isdirectory?" + data.isDirectory());

        } */
