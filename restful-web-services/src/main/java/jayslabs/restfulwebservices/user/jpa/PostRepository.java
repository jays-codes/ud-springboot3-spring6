package jayslabs.restfulwebservices.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import jayslabs.restfulwebservices.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
