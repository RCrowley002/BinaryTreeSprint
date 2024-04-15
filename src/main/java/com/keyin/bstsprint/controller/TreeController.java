package com.keyin.bstsprint.controller;

import com.keyin.bstsprint.dao.TreeRepo;
import com.keyin.bstsprint.model.BinarySearchTree;
import com.keyin.bstsprint.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TreeController {

    @Autowired
    private TreeRepo treeRepo;

    @PostMapping("/process-numbers")
    @ResponseBody  // This annotation ensures that the return type is directly written to the HTTP response body
    public ResponseEntity<?> processNumbers(@RequestBody NumbersDTO numbersDTO) {
        try {
            int[] numArray = parseNumbers(numbersDTO.getNumbers());

            BinarySearchTree bst = new BinarySearchTree();
            for (int num : numArray) {
                bst.insert(num);
            }

            String treeStructure = bst.toJson();

            Tree tree = new Tree(numbersDTO.getNumbers(), treeStructure);
            treeRepo.save(tree);

            return ResponseEntity.ok("Numbers processed and tree saved.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid input or server error.");
        }
    }

    private int[] parseNumbers(String numbers) {
        return java.util.Arrays.stream(numbers.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }


}

// A DTO class to help handle the data sent from the client
class NumbersDTO {
    private String numbers;

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }
}
