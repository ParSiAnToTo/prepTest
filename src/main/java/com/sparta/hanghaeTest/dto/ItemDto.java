package com.sparta.hanghaeTest.dto;


import com.sparta.hanghaeTest.entity.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;

    @Builder
    public ItemDto(Long id, String username, String title, String content, int price) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.price = price;
    }

    public Item toEntityForCreate() {
        return Item.builder()
                .username(this.username)
                .title(this.title)
                .content(this.content)
                .price(this.price)
                .build();
    }

    public Item toEntityForUpdate(Long targetId, ItemDto dto) {
        return Item.builder()
                .id(targetId)
                .username(dto.getUsername())
                .title(dto.getTitle())
                .content(dto.getContent())
                .price(dto.getPrice())
                .build();
    }
}
