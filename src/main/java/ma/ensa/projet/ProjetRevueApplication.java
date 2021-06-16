package ma.ensa.projet;

import ma.ensa.projet.domain.Article;
import ma.ensa.projet.domain.Revue;
import ma.ensa.projet.service.ArticleService;
import ma.ensa.projet.service.Impl.ArticleServiceImpl;
import org.apache.log4j.*;
import org.apache.log4j.xml.XMLLayout;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

@SpringBootApplication
public class ProjetRevueApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProjetRevueApplication.class, args);




    }

}
