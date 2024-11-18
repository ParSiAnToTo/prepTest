package com.sparta.hanghaeTest.controller;

import com.sparta.hanghaeTest.dto.ItemDto;
import com.sparta.hanghaeTest.dto.MsgResponse;
import com.sparta.hanghaeTest.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("")
    public ResponseEntity<?> getItems() {
        try {
            List<ItemDto> list = itemService.findAll();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createItem(@RequestBody ItemDto itemDto) {
        try {
            return ResponseEntity.ok(itemService.create(itemDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        try {
            return ResponseEntity.ok(itemService.update(id, itemDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        try {
            itemService.delete(id);
            return ResponseEntity.ok(new MsgResponse("삭제완료"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
