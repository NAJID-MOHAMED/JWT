package ma.najid.demojwtspringboot.repo;

import ma.najid.demojwtspringboot.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username) ;
}
