package com.example.demo.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "usuario_id")
    private Long usuarioId;
    
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    @Column
    private String password;

    //transient --> se va a omitir.
    //confirm es un campo en el formulario pero NO en la base de datos.
    @Transient
    private String confirmPassword;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))

    // Set: la diferencia con utilizar cualquier otro tipo de colecciones es q con el set obligamos a q no se repita ningun valor.
    //no admitira 2 veces el rol admin por ej.
    private Set<Role>  roles;


    //constructores
    public Usuario() {

        }

    public Usuario(Long  usuarioId) {
        super();
        this. usuarioId =  usuarioId;
    }
    

        @Override
        public String toString() {
            return "Usuario [confirmPassword=" + confirmPassword + ", email=" + email + ", firstName=" + firstName
                    + ", id=" +  usuarioId + ", lastName=" + lastName + ", password=" + password + ", roles=" + roles
                    + ", username=" + username + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
            result = prime * result + ((email == null) ? 0 : email.hashCode());
            result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
            result = prime * result + (( usuarioId == null) ? 0 : usuarioId.hashCode());
            result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
            result = prime * result + ((password == null) ? 0 : password.hashCode());
            result = prime * result + ((roles == null) ? 0 : roles.hashCode());
            result = prime * result + ((username == null) ? 0 : username.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Usuario other = (Usuario) obj;
            if (confirmPassword == null) {
                if (other.confirmPassword != null)
                    return false;
            } else if (!confirmPassword.equals(other.confirmPassword))
                return false;
            if (email == null) {
                if (other.email != null)
                    return false;
            } else if (!email.equals(other.email))
                return false;
            if (firstName == null) {
                if (other.firstName != null)
                    return false;
            } else if (!firstName.equals(other.firstName))
                return false;
            if ( usuarioId == null) {
                if (other. usuarioId != null)
                    return false;
            } else if (! usuarioId.equals(other.usuarioId))
                return false;
            if (lastName == null) {
                if (other.lastName != null)
                    return false;
            } else if (!lastName.equals(other.lastName))
                return false;
            if (password == null) {
                if (other.password != null)
                    return false;
            } else if (!password.equals(other.password))
                return false;
            if (roles == null) {
                if (other.roles != null)
                    return false;
            } else if (!roles.equals(other.roles))
                return false;
            if (username == null) {
                if (other.username != null)
                    return false;
            } else if (!username.equals(other.username))
                return false;
            return true;
        }

        public Long getUsuarioId() {
            return  usuarioId;
        }

        public void setUsuarioId(Long usuarioId) {
            this. usuarioId =  usuarioId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Set<Role> getRoles() {
            return roles;
        }

        public void setRoles(Set<Role> roles) {
            this.roles = roles;
        }

        public String getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
        }

        

   

    
}