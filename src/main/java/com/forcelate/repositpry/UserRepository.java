package com.forcelate.repositpry;

import com.forcelate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByAgeGreaterThan(int age);

    @Query(value = "SELECT u.id, u.user_name, u.user_age, COUNT(u.id) FROM USERS u LEFT JOIN  ARTICLE a ON u.ID=a.ID " +
            "where a.COLOR=? GROUP BY u.id", nativeQuery = true)
    List<User> findUserByArticleColor(int color);

    @Query(value = "SELECT u.id, u.user_name, u.user_age, COUNT(a.article_id) FROM USERS u LEFT JOIN ARTICLE a ON u.ID=a.ID" +
            " GROUP BY u.ID HAVING COUNT(a.article_id) >3", nativeQuery = true)
    List<User> findUsersByArticleListGreaterThan();


}
