package ma.najid.demojwtspringboot.Controller;


import lombok.RequiredArgsConstructor;
import ma.najid.demojwtspringboot.entities.AppRole;
import ma.najid.demojwtspringboot.entities.AppUser;
import ma.najid.demojwtspringboot.service.AccountService;
import ma.najid.demojwtspringboot.utils.RoleUserForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService accountService;
    @GetMapping("/users")
    public List<AppUser>appUsers(){
        return  accountService.listUsers();
    }

    @PostMapping("/user")
    public AppUser addUser(@RequestBody AppUser appUser){
        return accountService.addUser(appUser);
    }

    @PostMapping("/role")
    public AppRole addRole(@RequestBody AppRole appRole){
        return accountService.addRole(appRole);
    }

    @PostMapping("/addRoleToUser")
    public void addRole(@RequestBody RoleUserForm roleUserForm){
         accountService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRolename());
    }


}

