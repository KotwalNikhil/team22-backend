package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = ["http://localhost:3000","https://pets-webapp-dot-db-grads-173c-group-22.nw.r.appspot.com"])
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity< Book > getBookById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + id));
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("/book")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity < Book > updateBook(@PathVariable(value = "id") Long id,
                                             @Valid @RequestBody Book bookDetails) throws ResourceNotFoundException {
        Book getBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + id));

        getBook.setBookName(bookDetails.getBookName());

        final Book updatedBook = bookRepository.save(getBook);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/book/{id}")
    public Map< String, Boolean > deleteBook(@PathVariable(value = "id") Long id)
            throws Exception {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + id));

        bookRepository.delete(book);
        Map < String, Boolean > response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/book/{bookid}/adduser/{userid}")
    public ResponseEntity < Book > addUserToBook(@PathVariable(value = "bookid") Long bookId,@PathVariable(value = "userid") Long userId
            ) throws ResourceNotFoundException {
Book getBook = bookRepository.findById(bookId)
.orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));

User getUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
Set<User> userSet = null;
userSet = getBook.getUsers();
userSet.add(getUser);
getBook.setUsers(userSet);

final Book updatedBook = bookRepository.save(getBook);
return ResponseEntity.ok(updatedBook);



    }

    @DeleteMapping("/book/{bookid}/removeuser/{userid}")
    public ResponseEntity < Book > removeUserFromBook(@PathVariable(value = "bookid") Long bookId,@PathVariable(value = "userid") Long userId
            ) throws ResourceNotFoundException {
Book getBook = bookRepository.findById(bookId)
.orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));

User getUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
Set<User> userSet = null;
userSet = getBook.getUsers();
userSet.remove(getUser);
getBook.setUsers(userSet);

final Book updatedBook = bookRepository.save(getBook);
return ResponseEntity.ok(updatedBook);

    }
}
