package com.sparta.hanghaeTest.service;

import com.sparta.hanghaeTest.dto.ItemDto;
import com.sparta.hanghaeTest.entity.Item;
import com.sparta.hanghaeTest.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public List<ItemDto> findAll() {
        List<Item> itemList = itemRepository.findAll();
        List<ItemDto> itemDtoList = new ArrayList<>();
        for (Item item : itemList) {
            ItemDto itemDto = ItemDto.builder()
                    .id(item.getId())
                    .username(item.getUsername())
                    .title(item.getTitle())
                    .content(item.getContent())
                    .price(item.getPrice())
                    .build();
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }

    public ItemDto create(ItemDto itemDto) {
        Item createItem = itemRepository.save(itemDto.toEntityForCreate());
        return ItemDto.builder()
                .id(createItem.getId())
                .username(createItem.getUsername())
                .title(createItem.getTitle())
                .content(createItem.getContent())
                .price(createItem.getPrice())
                .build();
    }

    public ItemDto update(Long id, ItemDto itemDto) {
        Item updateItem = itemRepository.save(itemDto.toEntityForUpdate(id, itemDto));
        return ItemDto.builder()
                .id(updateItem.getId())
                .username(updateItem.getUsername())
                .title(updateItem.getTitle())
                .content(updateItem.getContent())
                .price(updateItem.getPrice())
                .build();
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }


}
