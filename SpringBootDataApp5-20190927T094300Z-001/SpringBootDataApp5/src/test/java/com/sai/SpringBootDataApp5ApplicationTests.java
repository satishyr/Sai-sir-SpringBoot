package com.sai;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sai.entities.Blog;
import com.sai.entities.Comments;
import com.sai.repositories.BlogRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDataApp5ApplicationTests {

	@Autowired
	private BlogRepository blogRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	public void createBlog_withComments() {
 		Comments comments1=new Comments();
 		comments1.setName("comment1");
 		comments1.setCommentedBy("sai");
 		comments1.setComment("this is not good");

		Comments comments2=new Comments();
		comments2.setName("comment2");
		comments2.setCommentedBy("john");
		comments2.setComment("better to improve");
		
		
		Blog blog=new Blog();
		blog.setName("blog9");
		
		comments1.setBlog(blog);
		comments2.setBlog(blog);
		
		ArrayList<Comments> commentsList=new ArrayList<>();
		commentsList.add(comments1);
		commentsList.add(comments2);
		
		blog.setCommentsList(commentsList);
		
		blogRepository.save(blog);
	}

}
