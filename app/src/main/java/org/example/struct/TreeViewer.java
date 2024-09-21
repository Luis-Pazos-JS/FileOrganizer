package org.example.struct;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;


public class TreeViewer<T> {

    public static void main(String[] args) {
        Tree<String> tree = new Tree<>("Root");

        JFrame frame = new JFrame("Tree Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTree jtree = new JTree(convertToTreeNode(tree.root));
        JScrollPane treeView = new JScrollPane(jtree);
        frame.add(treeView);

        frame.setSize(300, 400);
        frame.setVisible(true);
    }

    // Convierte el nodo personalizado en un nodo JTree
    private static <T> DefaultMutableTreeNode convertToTreeNode(Tree<T>.Node node) {
        DefaultMutableTreeNode jtreeNode = new DefaultMutableTreeNode(node.value);
        for (Tree<T>.Node child : node.childrens) {
            jtreeNode.add(convertToTreeNode(child));
        }
        return jtreeNode;
    }
}
