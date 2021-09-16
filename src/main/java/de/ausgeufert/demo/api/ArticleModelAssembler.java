package de.ausgeufert.demo.api;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import de.ausgeufert.demo.model.Article;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ArticleModelAssembler implements RepresentationModelAssembler<Article, EntityModel<Article>> {

    @Override
    public EntityModel<Article> toModel(Article article) {
        return EntityModel.of(article,
                linkTo(methodOn(ArticleController.class).one(article.getId())).withSelfRel(),
                linkTo(methodOn(ArticleController.class).findAll()).withRel("articles"));
    }
}
