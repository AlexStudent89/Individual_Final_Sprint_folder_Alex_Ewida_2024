// Tree Controller

package com.alexewida.controller;

import com.alexewida.model.BinarySearchTree;
import com.alexewida.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TreeController {

    @Autowired
    private TreeService treeService;

    @GetMapping("/enter-numbers")
    public String enterNumbers() {
        return "enterNumbers";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam("numbers") String numbers, Model model) {
        String message= "hello";
        BinarySearchTree tree = treeService.processNumbers(numbers);
        model.addAttribute("inputNumbers", numbers);
        model.addAttribute("treeStructure", tree.toString());
        model.addAttribute("message", message);
        return "treeResult";
    }

    @GetMapping("/previous-trees")
    public String previousTrees(Model model) {
        model.addAttribute("trees", treeService.getPreviousTrees());
        return "previousTrees";
    }
}