package com.example.storage.domain.location;

import com.example.storage.domain.county.County;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "location", schema = "storage")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "county_id", nullable = false)
    private County county;

    @Column(name = "longitude", precision = 16, scale = 14)
    private BigDecimal longitude;

    @Column(name = "latitude", precision = 16, scale = 14)
    private BigDecimal latitude;

}