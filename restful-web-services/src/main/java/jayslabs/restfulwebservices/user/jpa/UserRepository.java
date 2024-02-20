package jayslabs.restfulwebservices.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import jayslabs.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
