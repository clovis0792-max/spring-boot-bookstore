package com.bookStore.bookStore.controller;
import com.bookStore.bookStore.model.Book;
import com.bookStore.bookStore.model.MyBookList;
import com.bookStore.bookStore.repository.MyBookRepo;
import com.bookStore.bookStore.service.BookService;
import com.bookStore.bookStore.service.MyBookListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@Controller
public class  BookController {
    @Autowired
    private BookService service;

    @Autowired
    private MyBookListsService myBookService;

    @GetMapping("/")
    public String home(){
        return "home"; // it will redirect to the home.html webpage
    }

    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    // it will redirect to the bookRegister.html webpage
    @GetMapping("/available_books")
    public ModelAndView getAllBook(){
        List<Book>list = service.getAllBook();
//        ModelAndView m = new ModelAndView();
//        m.setViewName("bookList");
//        m.addObject("book",list);
//
        return new ModelAndView("bookList","book",list);
    }
    @PostMapping("/save")   // actually reutrn the form data, in out book object, send the data from view to controller
    public String addBook(@ModelAttribute Book b){
        service.saveBook(b);
     return "redirect:/available_books";
    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBookList> list = myBookService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable int id){ // if it doesn't work then try it @PathVariable("id") int id
      Book b = service.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
      myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model) {
        Book b=service.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id) {
        service.deleteById(id);
        return "redirect:/available_books";
    }

}
