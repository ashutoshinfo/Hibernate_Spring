package info.ashutosh.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ashutosh.entity.Post;

public interface PostRposetory extends JpaRepository<Post, Long> {

}
