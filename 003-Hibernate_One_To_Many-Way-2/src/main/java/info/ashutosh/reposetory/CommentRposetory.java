package info.ashutosh.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ashutosh.entity.Comments;

public interface CommentRposetory extends JpaRepository<Comments, Long> {

}
