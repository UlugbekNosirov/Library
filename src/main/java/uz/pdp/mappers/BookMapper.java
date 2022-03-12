package uz.pdp.mappers;

import org.springframework.stereotype.Component;
import uz.pdp.dto.book.BookCreateDto;
import uz.pdp.dto.book.BookUpdateDto;
import uz.pdp.models.Book;

import java.util.UUID;

@Component
public class BookMapper {

    public Book toEntity(BookCreateDto dto) {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        book.setDescription(dto.getDescription());
        book.setPageCount(dto.getPageCount());
        return book;
    }
    public Book toEntity(BookUpdateDto dto) {
        Book book = new Book();
        book.setId(dto.getUuid());
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        book.setDescription(dto.getDescription());
        book.setPageCount(dto.getPageCount());
        return book;
    }
}
