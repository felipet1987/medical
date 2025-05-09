package cl.talavera.medical.adapter.repository.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity representing a User.
 */
@Entity
public class UserDao {
    /**
     * Unique identifier for the User.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Username chosen by the User.
     */
    private String username;
    /**
     * Password for the User's account.
     */
    private String password;
    /**
     * Role of the User in the system.
     */
    private String role;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
