package com.myapp.controller;

import com.myapp.model.shopping.ShoppingItem;
import com.myapp.repository.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopping-items")
@CrossOrigin(origins = "*")
public class ShoppingItemController {

    @Autowired
    private ShoppingItemRepository itemRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate; // <-- UNEALTA DE SOCKETS

    // 1. Get items for a list
    @GetMapping("/list/{listId}")
    public List<ShoppingItem> getItems(@PathVariable int listId) {
        return itemRepository.findByListId(listId);
    }

    // 2. Add item
    @PostMapping("/add")
    public ShoppingItem addItem(@RequestBody ShoppingItem item) {
        ShoppingItem saved = itemRepository.save(item);
        // Notificăm toți userii care se uită la această listă
        messagingTemplate.convertAndSend("/topic/list/" + item.getListId(), "UPDATE");
        return saved;
    }

    // 3. Toggle Check (Bifează/Debifează) - Req #4 Sockets
    @PutMapping("/toggle/{id}")
    public ShoppingItem toggleItem(@PathVariable int id) {
        return itemRepository.findById(id).map(item -> {
            item.setChecked(!item.isChecked());
            ShoppingItem saved = itemRepository.save(item);

            // --> TRIMITE MESAJ PRIN SOCKET <--
            System.out.println("Socket: Trimit notificare pentru lista " + item.getListId());
            messagingTemplate.convertAndSend("/topic/list/" + item.getListId(), "UPDATE");

            return saved;
        }).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    // 4. Delete item
    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable int id) {
        ShoppingItem item = itemRepository.findById(id).orElse(null);
        if(item != null) {
            int listId = item.getListId(); // Salvăm ID-ul listei înainte să ștergem itemul
            itemRepository.deleteById(id);

            // Notificăm userii
            messagingTemplate.convertAndSend("/topic/list/" + listId, "UPDATE");
        }
    }
}