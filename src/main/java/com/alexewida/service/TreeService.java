// Tree Service

package com.alexewida.service;

import com.alexewida.model.BinarySearchTree;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TreeService {
    private List<BinarySearchTree> treeDatabase;

    public TreeService() {
    }

    public BinarySearchTree processNumbers(String numbers) {
        String[] numberArray = numbers.split(",");
        BinarySearchTree tree = new BinarySearchTree();
        String[] var7 = numberArray;
        int var6 = numberArray.length;

        for(int var5 = 0; var5 < var6; ++var5) {
            String number = var7[var5];
            tree.insert(Integer.parseInt(number.trim()));
        }

        this.treeDatabase.add(tree);
        return tree;
    }

    public List<BinarySearchTree> getPreviousTrees() {
        return this.treeDatabase;
    }
}
