package com.forcelate.service;

import com.forcelate.model.Article;

import java.util.List;


public interface ArticleService {

    List<Article> getAllArticles();

    void saveArticle(Article article);
}
