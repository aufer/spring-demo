package de.ausgeufert.demo.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class EntityController<T, REPO extends JpaRepository<T, Long>> {
    @Autowired
    REPO repository;

    @RequestMapping("")
    public String list(Model model) {
        List<T> entities = repository.findAll();
        System.out.println(entities);
        model.addAttribute("entities", entities);
        return getViewName() + "/list";
    }

    @RequestMapping("{id}/edit")
    public String edit(Model model, @PathVariable Long id) {
        T entity = repository.findById(id).get();
        model.addAttribute("entity", entity);
        return getViewName() + "/form";
    }

    @GetMapping("{id}")
    public String articleDetails(Model model, @PathVariable Long id) {
        Optional<T> entity = this.repository.findById(id);
        if (!entity.isPresent()) return "404";
        model.addAttribute("entity", entity.get());
        return getViewName() + "/details";
    }

    @PostMapping("save")
    public String saveArticle(@ModelAttribute T entity, Model model) {
        this.repository.save(entity);
        model.addAttribute("entities", repository.findAll());
        return getViewName();
    }

    protected abstract String getViewName();
}
