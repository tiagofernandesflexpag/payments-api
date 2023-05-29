package br.com.flexpag.payments.model.user;

import br.com.flexpag.payments.controller.dto.request.CreateUserData;
import br.com.flexpag.payments.model.BaseEntity;
import br.com.flexpag.payments.model.user.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;
import java.util.List;

@Table(name = "_user")
@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User extends BaseEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(CreateUserData createUserData, String encryptedPassword) {
        this.uuid = UUID.randomUUID();
        this.email = createUserData.email();
        this.password = encryptedPassword;
        this.role = createUserData.userRole();
        setCreatedAt(LocalDate.now());
        setUpdatedAt(LocalDate.now());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
