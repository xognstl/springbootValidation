package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.*;

public class MessageCodesResolverTest {

    /*
    * MessageCodesResolver : errorCode 를 넣으면 여러개를 반환해줌.
    * */
    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
            /*
            * System.out.println("messageCodes = " + messageCode);
            * 결과 :
            * messageCodes = required.item
            * messageCodes = required
            * detail 한게 먼저 나옴.
            * */
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodesResolverField() {
        /* bindingResult.rejectValue("itemName", "required"); 를 호출하면
        * rejectValue 안에서 codesResolver 호출해서 new FieldError를 만든다.
        * new FieldError("item", "itemName", null, false, messageCodes, null, null);
        * messageCode 에는 new String[]{"required.item.itemName", "required.itemName", "required.java.lang.String", "required"}
        * */
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);

        assertThat(messageCodes).containsExactly("required.item.itemName", "required.itemName", "required.java.lang.String", "required");
    }
}
