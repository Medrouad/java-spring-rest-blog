package com.pluralsight.blog.data;

import com.pluralsight.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public interface PostRepository extends JpaRepository<Post, Long> {

   /* default List<Post> findByTitleContaining(String title, List<Post> post) {
        return post.stream()
                .filter(x -> x.getTitle().contains(title))
                .collect(Collectors.toList());
    }*/
   @RestResource(rel="contains-title", path="containsTitle")
   List<Post> findByTitleContaining(String title);

}