package product;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
@ToString
@Getter
public class Product {
    private int price;
    private String categoryTitle;
    private Integer id;
    private String title;

}
