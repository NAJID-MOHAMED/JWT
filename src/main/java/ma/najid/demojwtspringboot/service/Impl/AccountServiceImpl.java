package ma.najid.demojwtspringboot.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ma.najid.demojwtspringboot.entities.AppRole;
import ma.najid.demojwtspringboot.entities.AppUser;
import ma.najid.demojwtspringboot.repo.AppRoleRepo;
import ma.najid.demojwtspringboot.repo.AppUserRepo;
import ma.najid.demojwtspringboot.service.AccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AppUserRepo appUserRepo;
    private final AppRoleRepo appRoleRepo;

    private  final PasswordEncoder passwordEncoder;

    @Override
    public AppUser addUser(AppUser user) {
        String pw=user.getPassword();
        user.setPassword(passwordEncoder.encode(pw));
        return appUserRepo.save(user);
    }

    @Override
    public AppRole addRole(AppRole role) {
        return appRoleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleNmae) {
      AppUser user = appUserRepo.findByUsername(username);
      AppRole role=appRoleRepo.findByRoleName(roleNmae);
      user.getAppRoles().add(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepo.findAll();
    }
}
