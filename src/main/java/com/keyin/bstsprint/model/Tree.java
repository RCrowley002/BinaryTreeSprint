package com.keyin.bstsprint.model;

import jakarta.persistence.*;

@Entity
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numbers")
    private String numbers;

    @Column(name = "tree_structure")
    private String tree_structure;

    public Tree() {}

    public Tree(String numbers, String tree_structure) {
        this.numbers = numbers;
        this.tree_structure = tree_structure;
    }


    //setters and getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getTreeStructure() {
        return tree_structure;
    }

    public void setTreeStructure(String tree_structure) {
        this.tree_structure = tree_structure;
    }
}
