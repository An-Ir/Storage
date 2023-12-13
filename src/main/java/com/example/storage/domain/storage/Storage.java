package com.example.storage.domain.storage;

import com.example.storage.domain.type.Type;
import com.example.storage.domain.location.Location;
import com.example.storage.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "storage", schema = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotNull
    @Column(name = "area", nullable = false)
    private Integer area;

    @NotNull
    @Column(name = "price", nullable = false)
    private Integer price;

    @Size(max = 600)
    @NotNull
    @Column(name = "description", nullable = false, length = 600)
    private String description;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", user=" + user +
                ", type=" + type +
                ", location=" + location +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}