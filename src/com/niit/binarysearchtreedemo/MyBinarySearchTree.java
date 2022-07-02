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
    public boolean delete(int deletingElement){
        boolean response = false;
        if(!isEmpty()) {
            Node currentNode = root;
            Node parent = null;
            //locating deleting element
            while (currentNode != null && currentNode.getData() != deletingElement) {
                parent = currentNode;
                if(deletingElement < currentNode.getData()){
                    //left child
                    currentNode = currentNode.getLeft();
                }
                else{
                    currentNode = currentNode.getRight();
                }
            }
            //if deleting element not present, then next line will not execute
            if(currentNode != null){
                response = true;
                //case 1 : leaf node
                if(isLeaf(currentNode)){
                    //root case
                    if(parent == null){
                        root = null;
                    }
                    else {
                        // updating parent
                        if (deletingElement < parent.getData()) {
                            parent.setLeft(null);
                        } else {
                            parent.setRight(null);
                        }
                    }
                }
                // case 2: single child either right or left
                // first exploring left child case
                else if(hasLeftChild(currentNode)){
                    //root
                    if(parent == null){
                        root = currentNode.getLeft();
                    }
                    else{
                        //checking whether deleting element is left or right child
                        if(deletingElement < parent.getData()){
                            parent.setLeft(currentNode.getLeft());
                        }
                        else{
                            parent.setRight(currentNode.getLeft());
                        }
                    }
                }
                else if(hasRightChild(currentNode)){
                    //root
                    if(parent == null){
                        //updating the root
                        root = currentNode.getRight();
                    }
                    else {
                        //checking whether deleting element is left or right child of parent
                        if(deletingElement < parent.getData()){
                            parent.setLeft(currentNode.getRight());
                        }
                        else{
                            parent.setRight(currentNode.getRight());
                        }
                    }
                }
                //case 3 : two child
                else{
                    Node inorderSuccessor = getSuccessor(currentNode);
                    //delete successor
                    delete(inorderSuccessor.getData());
                    //deleting currentNode
                    // deleting by updating data
                    currentNode.setData(inorderSuccessor.getData());
                    /*// root case
                    inorderSuccessor.setLeft(currentNode.getLeft());
                    inorderSuccessor.setRight(currentNode.getRight());
                    if(parent == null){
                        // deleting root

                        root = inorderSuccessor;
                    }
                    else {
                        // non root case
                        if(deletingElement < parent.getData()){
                            parent.setLeft(inorderSuccessor);
                        }
                        else{
                            parent.setRight(inorderSuccessor);
                        }
                    }*/
                }
            }
        }
       return response;
    }

    private Node getSuccessor(Node currentNode) {

        Node  temp = currentNode.getRight();
        while(temp.getLeft() != null){
            temp = temp.getLeft();
        }
        return temp;
    }

    private boolean hasRightChild(Node currentNode) {
        return currentNode.getRight() != null && currentNode.getLeft() == null;
    }

    private boolean hasLeftChild(Node currentNode) {
        return currentNode.getLeft() != null && currentNode.getRight() == null;
    }

    private boolean isLeaf(Node currentNode) {
        return currentNode.getLeft() == null && currentNode.getRight() == null;
    }


    public Node getRoot() {
        return root;
    }
}
