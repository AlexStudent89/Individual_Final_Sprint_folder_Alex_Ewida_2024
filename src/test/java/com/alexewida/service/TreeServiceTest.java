// Tree Service Test

package com.alexewida.service;

import com.alexewida.model.BinarySearchTree;
import com.alexewida.model.TreeNode;
import com.alexewida.repository.TreeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TreeServiceTest {

    @Mock
    private TreeRepository treeRepository;

    @InjectMocks
    private TreeService treeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessNumbers() {
        // Mock the save method
        when(treeRepository.save(any(TreeNode.class))).thenAnswer(i -> i.getArguments()[0]);

        BinarySearchTree tree = treeService.processNumbers("4, 2, 5, 1, 3");
        assertNotNull(tree);
        assertEquals("[1, 2, 3, 4, 5]", tree.inOrder().toString());

        // Verify that the save method was called
        verify(treeRepository, times(5)).save(any(TreeNode.class));
    }

    @Test
    public void testGetPreviousTrees() {
        treeService.processNumbers("4, 2, 5, 1, 3");

        Assertions.assertEquals(1, treeService.getPreviousTrees());
    }
}