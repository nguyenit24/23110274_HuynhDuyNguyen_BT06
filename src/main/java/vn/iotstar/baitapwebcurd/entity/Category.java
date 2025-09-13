package vn.iotstar.baitapwebcurd.entity;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="categories")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="categoryName",columnDefinition = "NVARCHAR(255)")
    private String categoryName;
}