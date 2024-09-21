package org.example.controllers;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

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
    public void showTreeInterfaces(){
        JFrame frame = new JFrame("Tree Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTree jtree = new JTree(convertToTreeNode(tree.root));
        JScrollPane treeView = new JScrollPane(jtree);
        frame.add(treeView);

        frame.setSize(300, 400);
        frame.setVisible(true);
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
                recurConst(file);
            }
        }
    }
    private static <T> DefaultMutableTreeNode convertToTreeNode(Tree<T>.Node node) {
        DefaultMutableTreeNode jtreeNode = new DefaultMutableTreeNode(node.value);
        for (Tree<T>.Node child : node.childrens) {
            jtreeNode.add(convertToTreeNode(child));
        }
        return jtreeNode;
    }

}
