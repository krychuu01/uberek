package pl.uberek.ubereats.dish;

import java.math.BigDecimal;

public record DishUpdateDto(String name, BigDecimal price,
                            String description, Integer weight) {
}
