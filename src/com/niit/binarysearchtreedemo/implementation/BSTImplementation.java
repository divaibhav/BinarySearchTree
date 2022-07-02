package com.niit.binarysearchtreedemo.implementation;

import com.niit.binarysearchtreedemo.MyBinarySearchTree;

public class BSTImplementation {
    public static void main(String[] args) {
        MyBinarySearchTree binarySearchTree = new MyBinarySearchTree();
        binarySearchTree.insert(100);
        binarySearchTree.insert(500);
        binarySearchTree.insert(50);
        binarySearchTree.insert(25);
        binarySearchTree.insert(550);
        binarySearchTree.insert(150);

        System.out.println("binarySearchTree.search(150) = " + binarySearchTree.search(150));
        System.out.println("\ninorder");
        binarySearchTree.inorder(binarySearchTree.getRoot());
        System.out.println("\npreorder");
        binarySearchTree.preorder(binarySearchTree.getRoot());
        System.out.println("\npostorder");
        binarySearchTree.postorder(binarySearchTree.getRoot());
    }
}
