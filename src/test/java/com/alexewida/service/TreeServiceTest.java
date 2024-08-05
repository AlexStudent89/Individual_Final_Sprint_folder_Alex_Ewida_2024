// Tree Service Test

package com.alexewida.service;

import com.alexewida.model.BinarySearchTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TreeServiceTest {

    private TreeService treeService;

    @BeforeEach
    public void setUp() {
        treeService = new TreeService();
    }

    @Test
    public void testProcessNumbers() {
        BinarySearchTree tree = treeService.processNumbers("4, 2, 5, 1, 3");
        assertNotNull(tree);
        assertEquals("[1, 2, 3, 4, 5]", tree.inOrder().toString());
    }

    @Test
    public void testGetPreviousTrees() {
        treeService.processNumbers("4, 2, 5, 1, 3");
        assertEquals(1, treeService.getPreviousTrees().size());
    }
}
