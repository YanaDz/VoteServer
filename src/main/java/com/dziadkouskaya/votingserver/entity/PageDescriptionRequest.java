package com.dziadkouskaya.votingserver.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dziadkouskaya.votingserver.utils.Constants.COLON;
import static com.dziadkouskaya.votingserver.utils.Constants.PAGE_NEGATIVE_NUMBER;
import static com.dziadkouskaya.votingserver.utils.Constants.PAGE_NEGATIVE_SIZE;
import static java.util.Objects.isNull;

@Getter
@Setter
@EqualsAndHashCode
public class PageDescriptionRequest {
    @PositiveOrZero(message = PAGE_NEGATIVE_NUMBER)
    private int page = 0;

    @Positive(message = PAGE_NEGATIVE_SIZE)
    private int size = 15;
    //e.g. "name:asc,address:desc" (asc/desc could be omited)
    private String sort;

    public PageRequest getPageRequest() {
        if (isNull(sort)) {
            return PageRequest.of(page, size);
        }
        return PageRequest.of(page, size, calculateSort());
    }

    public Sort calculateSort() {
        return Sort.by(calculateOrders());
    }

    public List<Sort.Order> calculateOrders() {
        var sortParts = Arrays.asList(sort.split(","));
        List<Sort.Order> orders = new ArrayList<>(sortParts.size());
        for (String sortPart : sortParts) {
            orders.add(calculateOrder(sortPart));
        }
        return orders;
    }

    private Sort.Order calculateOrder(String orderStr) {
        String[] orderParts = orderStr.split(COLON);
        String name = getOrderMapping(orderParts[0]);
        String direction = Sort.Direction.ASC.name();
        if (orderParts.length > 1) {
            direction = orderParts[1];
        }

        return new Sort.Order(Sort.Direction.fromString(direction), name);
    }

    public String getOrderMapping(String orderStr) {
        return orderStr;
    }
}
