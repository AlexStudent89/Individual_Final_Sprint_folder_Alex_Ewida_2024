// Tree Service

package com.alexewida.service;

import com.alexewida.model.BinarySearchTree;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreeService {

    // Initialize the mock database
    private List<BinarySearchTree> treeDatabase = new ArrayList<>();

    public BinarySearchTree processNumbers(String numbers) {
        String[] numberArray = numbers.split(",");
        BinarySearchTree tree = new BinarySearchTree();
        for (String number : numberArray) {
            tree.insert(Integer.parseInt(number.trim()));
        }
        treeDatabase.add(tree);
        return tree;
    }

    public List<BinarySearchTree> getPreviousTrees() {
        return treeDatabase;
    }
}
