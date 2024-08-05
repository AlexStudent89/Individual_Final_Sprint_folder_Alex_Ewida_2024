// Binery Search Tree

package com.alexewida.model;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
    }

    public void insert(int value) {
        this.root = this.insertRecursive(this.root, value);
    }

    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        } else {
            if (value < node.getValue()) {
                node.setLeft(this.insertRecursive(node.getLeft(), value));
            } else if (value > node.getValue()) {
                node.setRight(this.insertRecursive(node.getRight(), value));
            }

            return node;
        }
    }

    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList();
        this.inOrderRecursive(this.root, result);
        return result;
    }

    private void inOrderRecursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            this.inOrderRecursive(node.getLeft(), result);
            result.add(node.getValue());
            this.inOrderRecursive(node.getRight(), result);
        }

    }
}
