package com.myapp.controller;

import com.myapp.model.shopping.ShoppingList;
import com.myapp.model.users.User;
import com.myapp.repository.ShoppingListRepository;
import com.myapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shopping-lists")
@CrossOrigin(origins = "*")
public class ShoppingListController {

    @Autowired
    private ShoppingListRepository listRepository;

    @Autowired
    private UserRepository userRepository;

    // 1. Get Lists for User
    @GetMapping("/user/{email}")
    public List<ShoppingList> getUserLists(@PathVariable String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return listRepository.findByUserId(user.get().getUser_id());
        }
        return List.of();
    }

    // 2. Add New List
    @PostMapping("/add")
    public ShoppingList addList(@RequestBody ShoppingList list, @RequestParam String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            list.setUserId(user.get().getUser_id());
            return listRepository.save(list);
        }
        throw new RuntimeException("User not found");
    }

    // 3. Delete List
    @DeleteMapping("/delete/{id}")
    public String deleteList(@PathVariable int id) {
        listRepository.deleteById(id);
        return "Deleted";
    }
}