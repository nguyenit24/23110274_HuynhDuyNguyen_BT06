package vn.iotstar.baitapwebcurd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT c FROM User c")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String userName;
    private String passWord;
    private String fullName;
    private String phone;
    private int roleid;
    @Column(name = "image", nullable = true)
    private String image;
}