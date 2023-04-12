package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000",
//message = "총합이 10000원을 넘어야합니다.")
public class Item_bak {

    // 수정시 id 값이 필수여아한다.
    @NotNull(groups = UpdateCheck.class)
    private Long id;

    // message : default 4단계 다 없으면 이 메세지 나옴 . 이것도 안해놓으면 기본메시지
    @NotBlank(message = "공백은 입력할 수 없습니다.", groups = {SaveCheck.class, UpdateCheck.class})
    private String itemName;

    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
    @Range(min = 1000, max = 1000000, groups = {SaveCheck.class, UpdateCheck.class})
    private Integer price;

    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
    @Max(value = 9999, groups = SaveCheck.class)
    private Integer quantity;

    public Item_bak() {
    }

    public Item_bak(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
