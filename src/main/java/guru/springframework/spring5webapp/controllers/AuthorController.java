package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//Controller done for the List of Authors assigment
//Controller used as a "middle-man" between database and view
@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        //it'll take model provided from spring,
        //we attach list of authors to the property and return the view name
        model.addAttribute("authors", authorRepository.findAll());

        return "authors";//the view name
    }
}
