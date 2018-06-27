package com.forcelate.contoller;

import com.forcelate.model.Article;
import com.forcelate.model.Color;
import com.forcelate.repositpry.UserRepository;
import com.forcelate.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public ResponseEntity listOfArticles() {
        List<Article> articleList = articleService.getAllArticles();
        return new ResponseEntity(articleList, HttpStatus.OK);
    }

    @RequestMapping(value = "/savearticle", method = RequestMethod.POST)
    public ResponseEntity saveArticle(@RequestParam("text") String text, Color color, @RequestParam("id") long userId) {
        Article article = new Article(text, color, userRepository.getOne(userId));
        articleService.saveArticle(article);
        return new ResponseEntity(article, HttpStatus.OK);
    }

}
