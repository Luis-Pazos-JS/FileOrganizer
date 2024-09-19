package org.example.controllers;

import java.io.File;

import org.example.struct.Tree;

public class FileOrganizer {
    private Tree<File> tree ;

    public FileOrganizer(String path){
        tree =  new Tree<File>(new File(path));
    }

    public File getRoot() {
        return tree.root.value;
    }

}
