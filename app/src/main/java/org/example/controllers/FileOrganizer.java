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
    public void showTree(){

        for(var itr = tree.iterator(); itr.hasNext();){
            File file = itr.next();
            System.out.println(file.getName());
        }
    }

    public void constructTree() {
        recurConst(tree.root.value);
    }
    public void recurConst(File parent){
        if(parent == null) return;

        var files = parent.listFiles();

        if(files != null){
            for(var file : files){
                
                tree.insert(file, parent);
            }
            for(var file : files){
                recurConst(file);
            }
        }
    }
}
