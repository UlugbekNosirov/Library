package uz.pdp.dto.book;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class BookUpdateDto {
    private UUID uuid;
    private String name;
    private String author;
    private String description;
    private Integer pageCount;
}
