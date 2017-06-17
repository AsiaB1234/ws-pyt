package pyt.repository;

import org.springframework.stereotype.Repository;
import pyt.model.User;

@Repository
public interface UserRepository extends AbstractRepository<User> {

    public abstract User findUserByEmail(String email);
}
