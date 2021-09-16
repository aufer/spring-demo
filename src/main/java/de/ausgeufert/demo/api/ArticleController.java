package de.ausgeufert.demo.api;

import de.ausgeufert.demo.model.Article;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleRepository repository;
    private final ArticleModelAssembler assembler;

    ArticleController(ArticleRepository repository, ArticleModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("")
    CollectionModel<EntityModel<Article>> findAll() {
        List<EntityModel<Article>> articles = this.repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(articles,
                linkTo(methodOn(ArticleController.class).findAll()).withSelfRel());
    }

    @GetMapping("/{id}")
    EntityModel<Article> one(@PathVariable Long id) {
        Article article = this.repository.findById(id).orElseThrow();
        return assembler.toModel(article);
    }

    @PostMapping("")
    Article addOne(@RequestBody Article body) {
        return this.repository.save(body);
    }
}
