package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryType {
    FOOD("Food", 1),
    ELECTRONIC("Electronic", 2),
    FURNITURE("Furniture", 3);

    private final String title;
    private final Integer id;




}
