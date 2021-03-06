package be.zelda.projects.reactiveapplication.rest;

import be.zelda.projects.reactiveapplication.data.Book;
import be.zelda.projects.reactiveapplication.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookRestController {

    private  IBookService bookService;

//    public BookRestController(IBookService bookService) {
//        this.bookService = bookService;
//    }

    @GetMapping
    public Flux<Book> list() {
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Book> finById(@PathVariable Long id) {
        Flux.just("");
        Flux.fromIterable(Arrays.asList("a", "b", "c"));
        return  Mono.just(new Book());
//        return  this.bookService.findOne(id).subscribe( x => {
//
//        });
        // return this.bookService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> create(@RequestBody BookDto bookDto) {
        return this.bookService.save(bookDto);
    }
//
    @GetMapping("/author")
    public Flux<Book> findByAuthor(String author) {
        return this.bookService.findByAuthor(author);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        this.bookService.delete(id);
    }

}
