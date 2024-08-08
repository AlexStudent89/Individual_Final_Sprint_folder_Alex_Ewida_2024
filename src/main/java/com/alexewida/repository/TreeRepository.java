package com.alexewida.repository;

import com.alexewida.model.BinarySearchTree;
import com.alexewida.model.TreeNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface TreeRepository extends JpaRepository<TreeNode, Long> {
}