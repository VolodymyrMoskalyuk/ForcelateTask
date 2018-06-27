package com.forcelate.service.Impl;

import com.forcelate.model.Article;
import com.forcelate.repositpry.ArticleRepository;
import com.forcelate.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }
}
