package org.example;

public class RedBlackTree {
    private Node root;

    public boolean add(int value){
        if(root!= null){
            boolean result = addNode(root, value);
            System.out.println("Node added");
            root = rebalance(root);
            System.out.println("Rebalance complete");
            root.color = Color.BLACK;
            return result;
        }else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            System.out.println("First element created");
            return true;
        }
    }
    private boolean addNode (Node node, int value){
        if(node.value == value){
            return false;
        }else{
            if(node.value>value){
                if(node.leftChild != null){
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                }else{
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            }else {
                if(node.rightChild!= null){
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                }else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }

    }

    private Node rebalance(Node node) {
        boolean needRebalance = true;
        while(needRebalance){
            needRebalance = false;
            if(node.rightChild!= null && node.rightChild.color == Color.RED &&
                    (node.leftChild == null || node.leftChild.color == Color.BLACK)){
                needRebalance = true;
                node = swapRight(node);
            }
            if(node.leftChild!= null && node.leftChild.color == Color.RED &&
                    node.leftChild.leftChild != null && node.leftChild.leftChild.color == Color.RED){
                needRebalance = true;
                node = swapLeft(node);
            }
            if(node.leftChild!= null && node.leftChild.color == Color.RED &&
                    node.rightChild != null && node.leftChild.color == Color.RED){
                needRebalance = true;
                swapColor(node);
            }
        }
        return node;

    }

    private void swapColor(Node node){
        node.leftChild.color = Color.BLACK;
        node.rightChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node swapLeft(Node node){
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private Node swapRight(Node node){
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private class Node{
        private int value;
        private Color color;
        private Node leftChild;
        private Node rightChild;

    }
}
