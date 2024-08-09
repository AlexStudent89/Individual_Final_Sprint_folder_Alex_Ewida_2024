// Tree Node

package com.alexewida.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class TreeNode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  // Added ID for JPA

    private int value;

    @Transient
    private TreeNode left;  // Marked as transient since these are not stored in the database

    @Transient
    private TreeNode right; // Marked as transient since these are not stored in the database

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode() {
        // Default constructor for JPA
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}