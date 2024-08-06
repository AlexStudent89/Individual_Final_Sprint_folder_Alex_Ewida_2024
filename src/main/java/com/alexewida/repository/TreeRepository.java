package com.alexewida.repository;

import com.alexewida.model.TreeNode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends CrudRepository<TreeNode, Long> {
}