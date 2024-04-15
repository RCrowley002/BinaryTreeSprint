package com.keyin.bstsprint.model;

public class BinarySearchTree {
    private Node root;

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public String toJson() {
        return toJsonRec(root);
    }

    private String toJsonRec(Node root) {
        if (root == null) {
            return "{}";
        }
        return "{\n" +
                "  \"value\": " + root.value + ",\n" +
                "  \"left\": " + toJsonRec(root.left) + ",\n" +
                "  \"right\": " + toJsonRec(root.right) + "\n" +
                "}";
    }

}