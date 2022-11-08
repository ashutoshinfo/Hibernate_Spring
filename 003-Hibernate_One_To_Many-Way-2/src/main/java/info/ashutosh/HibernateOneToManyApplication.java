package info.ashutosh;

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

		// New PArent Object Created
		Post post = new Post();
		post.setTitle("Post Title-1");
		// post.setComments(List.of(comments1, comments2, comments3));

		Comments comments1 = new Comments("Comment Description-1--");
		post.setComments(comments1);

		// Persist Without Child
		postRposetory.save(post);

		// Child Object(s) are created

		Comments comments2 = new Comments("Comment Description-2-");
		Comments comments3 = new Comments("Comment Description-3-");

		// Set child object(s) in Parent Object
		post.setComments(comments2);
		post.setComments(comments3);

		// again save Parent Object with newly set values
		postRposetory.save(post);

//		Optional<Post> post1 = postRposetory.findById(1L);
//		if (post1.isPresent()) {
//			Post post2 = post1.get();
//			Comments comments4 = new Comments("Comment Description-4");
//			List<Comments> comments = post2.getComments();
//			comments.add(comments4);
//			postRposetory.save(post2);
//		}
//
//		Optional<Post> post3 = postRposetory.findById(1L);
//		if (post3.isPresent()) {
//			Post post2 = post3.get();
//
//			post2.getComments().forEach(comment -> System.out.println(comment));
//
//		}

	}

}
