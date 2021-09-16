package de.ausgeufert.demo;

import de.ausgeufert.demo.model.Article;
import de.ausgeufert.demo.api.ArticleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ArticleRepository repository) {
        Date now = new Date();
        return args -> {
            repository.save(
                    new Article(
                            "My First Entry",
                            "It feels amazing to start the day with a fresh hair cut and a nice cup of coffee. Therefore i really love to get up early at around 06:45 to have enough time for this kind of luxury.",
                            "Andre Ufer",
                            Date.from(LocalDate.of(2021, 8, 29).atStartOfDay(ZoneId.systemDefault()).toInstant())
                    )
            );
            repository.save(new Article(
                    "Java is chatty",
                    "No discussion wanted. But you cannot avoid it anyway... so... ok.?",
                    "Andre Ufer", now));
        };
    }
}
