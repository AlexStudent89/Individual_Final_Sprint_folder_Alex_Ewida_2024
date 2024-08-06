// Tree Service

package com.alexewida.service;

import com.alexewida.model.BinarySearchTree;
import com.alexewida.model.TreeNode;
import com.alexewida.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreeService {

    @Autowired
    private TreeRepository treeRepository;

    private List<BinarySearchTree> treeDatabase = new ArrayList<>();

    public BinarySearchTree processNumbers(String numbers) {
        String[] numberArray = numbers.split(",");
        BinarySearchTree tree = new BinarySearchTree();
        for (String number : numberArray) {
            TreeNode node = new TreeNode(Integer.parseInt(number.trim()));
            tree.insert(node.getValue());
            treeRepository.save(node);
        }
        treeDatabase.add(tree);
        return tree;
    }

    public List<BinarySearchTree> getPreviousTrees() {
        return treeDatabase;
    }
}