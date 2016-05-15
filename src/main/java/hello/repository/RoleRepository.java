package hello.repository;


import hello.data.Role;
import hello.data.User;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findById(Integer id);
}
