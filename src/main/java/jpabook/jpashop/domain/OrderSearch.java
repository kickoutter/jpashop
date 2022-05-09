package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

/** 검색조건 파라미터 OrderSearch */

@Getter @Setter
public class OrderSearch {

    private String memberName; //회원 이름
    private OrderStatus orderStatus; //주문 산태[ORDER, CANCEL]

    // Getter, Setter
}
