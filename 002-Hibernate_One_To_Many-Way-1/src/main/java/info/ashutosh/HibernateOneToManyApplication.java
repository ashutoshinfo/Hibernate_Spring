package info.ashutosh;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import info.ashutosh.entity.Comments;
import info.ashutosh.entity.Post;
import info.ashutosh.reposetory.CommentRposetory;
import info.ashutosh.reposetory.PostRposetory;

@SpringBootApplication
public class HibernateOneToManyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HibernateOneToManyApplication.class, args);
	}

	@Autowired
	PostRposetory postRposetory;

	@Autowired
	CommentRposetory commentRposetory;

	@Override
	public void run(String... args) throws Exception {

		// First Parent Object need to Create and Persist.
		Post post = new Post();
		post.setTitle("Post Title-1");

		// Child object create and Persist with parent object
		Comments comments1 = new Comments("Comment Description-1", post);
		Comments comments2 = new Comments("Comment Description-2", post);
		Comments comments3 = new Comments("Comment Description-3", post);

		// set child object inside Parent Object
		post.setComments(List.of(comments1, comments2, comments3));

		postRposetory.save(post);

		// Child object create and Persist with parent object
		Comments comments4 = new Comments("Comment Description-4", post);
		Comments comments5 = new Comments("Comment Description-5", post);
		Comments comments6 = new Comments("Comment Description-6", post);

		// set child object inside Parent Object
		post.setComments(List.of(comments4, comments5, comments6));
		postRposetory.save(post);

//		Optional<Post> post1 = postRposetory.findById(1L);
//		if (post1.isPresent()) {
//			Post post2 = post1.get();
//			Comments comments4 = new Comments("Comment Description-4", post2);
//			commentRposetory.save(comments4);
//			postRposetory.save(post);
//
//		}

		// Thread.currentThread().wait(1000000);

	}

}
