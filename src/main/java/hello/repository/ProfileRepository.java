package hello.repository;


import hello.data.Profile;
import hello.data.User;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Profile findById(Integer id);
    Profile findByUser(User user);
}
