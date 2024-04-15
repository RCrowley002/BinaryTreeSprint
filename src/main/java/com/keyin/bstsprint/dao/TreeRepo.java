package com.keyin.bstsprint.dao;

import com.keyin.bstsprint.model.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepo extends JpaRepository<Tree, Long> {
    // You can add custom database queries here if needed.
}
