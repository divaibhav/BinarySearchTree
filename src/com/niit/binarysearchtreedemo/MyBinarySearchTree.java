package com.niit.binarysearchtreedemo;

public class MyBinarySearchTree {
    private Node root;
    //search
    public boolean search(int searchElement){
        boolean response = false;
        if(!isEmpty()){
           Node currentNode = root;
           while (currentNode != null){
               if(currentNode.getData() == searchElement){
                   response = true;
                   break;
               }
               if(searchElement < currentNode.getData()){
                   // proceed to left child
                   currentNode = currentNode.getLeft();
               }
               else{
                   currentNode = currentNode.getRight();
               }
           }
        }

        return response;
    }

    private boolean isEmpty() {
        return root == null;
    }
    // insert
    public void insert(int element){
        Node node = new Node(element);
        if(isEmpty()){
            root = node;
        }
        else{
            Node currentNode = root;
            Node parent = null;
            while (currentNode != null){
                parent = currentNode;
                if(element <= currentNode.getData()){
                    currentNode = currentNode.getLeft();
                }
                else{
                    currentNode = currentNode.getRight();
                }
            }
           if(element <= parent.getData()){
               parent.setLeft(node);
           }
           else{
               parent.setRight(node);
           }
        }
    }
    // traverse
        // inorder
    public void inorder(Node node){
        if(node != null){
            //left, root, right
            //inorder traversing left sub tree
            inorder(node.getLeft());
            //processing root
            System.out.print(node.getData() + ",");
            //inorder traversing right subtree
            inorder(node.getRight());
        }
    }
        // preorder
    public void preorder(Node node){
        if(node != null){
            //root, left, right
            System.out.print(node.getData() + ",");
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }
        // post order
    public void postorder(Node node){
        if(node != null){
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.print(node.getData() + ",");
        }
    }
    // delete


    public Node getRoot() {
        return root;
    }
}
