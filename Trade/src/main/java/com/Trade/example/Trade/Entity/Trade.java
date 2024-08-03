package com.Trade.example.Trade.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="trade")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer quantity;


    private BigDecimal price;


    private String Currency="JPY";


    private String buysell;

    private String asset_type="Equity";

    private String origin_country="JP";

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
