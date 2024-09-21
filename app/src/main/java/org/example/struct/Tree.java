package org.example.struct;
import java.util.*;


public class Tree<T> implements Iterable<T>{
    public Node root;

    @Override
    public Iterator<T> iterator(){
        return  new IteratorTree(root);
    }


    public Tree(T value){
        this.root = new Node(value);
    }

    public boolean insert(T value){
        return insert(new Node(value));
    }
    public boolean insert(T value, T parent){
        Node parentNode = searchNode(parent);
        Node node = new Node(value);
        if(! insert(node, parentNode)){

            insert(parentNode);
            insert(node, parentNode);
        }
        return true;
        
    }
    private boolean insert(Node node){
    if(root == null) {
            root = node;
        } else {
            node.parent = root;
            root.childrens.add(node);
        }
        return true;
    }
    private boolean insert(Node node, Node parentNode){
        if(parentNode == null) return false;
            node.parent = parentNode;
            parentNode.childrens.add(node);
            return true;
        }
    
    
    public T search(T value){
        Node result = search(root, value);
        
        return (result == null)
        ? null
        : result.value;
    }
    private Node searchNode(T value){
        return search(root, value);
    }
    private Node search(Node node, T search){

        if(node == null) return null;
        if(node.value.equals(search)) return node;

        for(Node children : node.childrens){
            Node result = search(children, search);
            if(result != null){
                return result;
            }
        }
        return null;
    }

    public class Node {
        public Node parent;
        public T value;
        public LinkedList<Node> childrens;
        public int levels;

        public Node(T value){
            this.value = value;
            childrens = new LinkedList<>();
        }
    }

    private class IteratorTree implements Iterator<T> {
        private Stack<Node> pila;

        public IteratorTree(Node root) {
            pila = new Stack<>();
            if(root != null) pila.push(root);
        }
        @Override
        public boolean hasNext(){
            return !pila.isEmpty();
        }
        @Override
        public T next(){
            Node node = pila.pop();
            for(int i = node.childrens.size() - 1 ; i >= 0; i--){
                pila.push(node.childrens.get(i));
            }
            return node.value;
        }
    }
}
