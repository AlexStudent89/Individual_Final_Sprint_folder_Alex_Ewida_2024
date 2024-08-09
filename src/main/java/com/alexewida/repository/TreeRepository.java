// Tree Repository
package com.alexewida.repository;

import com.alexewida.model.TreeNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends JpaRepository<TreeNode, Long> {
}