package hello.itemservice.domain.item;

/* 동일한 모델 객체를 각각 다르게 검증 할때
* beanValidation 의 groups를 사용하려면 각각 해당클래스처럼 인터페이스를 만든후
* groups=savecheck.class 이런식으로 사용하면 각각 검증을 다르게 할 수 있다.
*
* 이거말고는 모델 객체를 직접사용하지 않고 form 전송을 위한 별도 모델 객체사용도 함.
*  */
public interface SaveCheck {
}
