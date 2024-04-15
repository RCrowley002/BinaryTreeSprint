package com.keyin.bstsprint.controller;

import com.keyin.bstsprint.dao.TreeRepo;
import com.keyin.bstsprint.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class htmlController {
    @Autowired
    private TreeRepo treeRepo;

    @GetMapping("/enter-numbers")
    public String showEnterNumbers() {
        return "enter-numbers";
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        List<Tree> trees = treeRepo.findAll();
        if (trees.isEmpty()) {
            // Handle empty case, perhaps showing a friendly message or redirecting
            model.addAttribute("message", "No previous trees available.");
            return "previous-trees";
        } else {
            model.addAttribute("trees", trees);
            return "previous-trees";  // Make sure this template exists and is correctly named
        }
    }


}
