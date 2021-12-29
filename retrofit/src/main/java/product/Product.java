package product;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class Product {
    private int price;
    private String categoryTitle;
    private Integer id;
    private String title;

}
