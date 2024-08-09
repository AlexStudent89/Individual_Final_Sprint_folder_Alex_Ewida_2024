// Tree Service

package com.alexewida.service;

import com.alexewida.model.BinarySearchTree;
import com.alexewida.model.TreeNode;
import com.alexewida.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreeService {

    @Autowired
    private TreeRepository treeRepository;

    public BinarySearchTree processNumbers(String numbers) {
        String[] numberArray = numbers.split(",");
        BinarySearchTree tree = new BinarySearchTree();
        for (String number : numberArray) {
            TreeNode node = new TreeNode(Integer.parseInt(number.trim()));
            tree.insert(node.getValue());
            treeRepository.save(node);
        }

        return tree;
    }

    public Iterable<TreeNode> getPreviousTrees() {
        return treeRepository.findAll();
    }
}