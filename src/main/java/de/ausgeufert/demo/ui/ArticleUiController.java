package de.ausgeufert.demo.ui;

import de.ausgeufert.demo.api.ArticleRepository;
import de.ausgeufert.demo.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/web/articles")
public class ArticleUiController {

    @Autowired
    private ArticleRepository articleRepository;

    @ModelAttribute("auth")
    public Authentication isLoggedIn() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping("")
    public String articles(Model model) {
        model.addAttribute("articles", articleRepository.findAllByOrderByCreatedAtDesc());
        return "articles";
    }

    @GetMapping("add")
    public String addArticle(Model model) {
        model.addAttribute("article", new Article());
        return "add-article";
    }

    @GetMapping("{id}/edit")
    public String updateArticle(Model model, @PathVariable Long id) {
        Optional<Article> article = this.articleRepository.findById(id);
        if (!article.isPresent()) return "404";
        model.addAttribute("article", article);
        return "add-article";
    }

    @GetMapping("{id}")
    public String articleDetails(Model model, @PathVariable Long id) {
        Optional<Article> a = this.articleRepository.findById(id);
        if (!a.isPresent()) return "404";
        model.addAttribute("article", a.get());
        return "article-details";
    }

    @PostMapping("save")
    public String saveArticle(@ModelAttribute Article article, Model model) {
        this.articleRepository.save(article);
        model.addAttribute("articles", articleRepository.findAll());
        return "articles";
    }
}
