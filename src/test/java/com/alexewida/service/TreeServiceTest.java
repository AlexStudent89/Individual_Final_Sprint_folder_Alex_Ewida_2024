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

import java.util.List;

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
        // Mock the behavior of the repository to return a list containing one tree
        when(treeRepository.findAll()).thenReturn(List.of(new TreeNode()));

        // Convert the Iterable to a List
        List<TreeNode> previousTrees = (List<TreeNode>) treeService.getPreviousTrees();

        // Call the method and check if it returns the expected size
        assertEquals(1, previousTrees.size());

        // Verify that the findAll method was called once
        verify(treeRepository, times(1)).findAll();
    }

    @Test
    public void testProcessEmptyNumbers() {
        // Call the method with an empty string and expect a null or empty tree
        BinarySearchTree tree = treeService.processNumbers("");

        // Assert that the tree is null or empty
        assertNull(tree);

        // Verify that the save method was never called
        verify(treeRepository, never()).save(any(TreeNode.class));
    }

}