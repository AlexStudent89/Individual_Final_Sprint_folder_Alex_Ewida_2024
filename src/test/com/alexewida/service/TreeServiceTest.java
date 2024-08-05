// Tree Service Test

package com.alexewida.service;

import com.alexewida.model.BinarySearchTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreeServiceTest {
    public TreeServiceTest() {
    }

    @Test
    public void testProcessNumbers() {
        TreeService treeService = new TreeService();
        BinarySearchTree tree = treeService.processNumbers("4, 2, 5, 1, 3");
        Assertions.assertEquals("[1, 2, 3, 4, 5]", tree.inOrder().toString());
    }

    @Test
    public void testGetPreviousTrees() {
        TreeService treeService = new TreeService();
        treeService.processNumbers("4, 2, 5, 1, 3");
        Assertions.assertEquals(1, treeService.getPreviousTrees().size());
    }
}
