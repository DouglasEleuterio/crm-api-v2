package br.com.tresptecnologia.core.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public final class PaginateUtils {

    private PaginateUtils() {
    }

    public static Pageable of(Integer page, Integer size, Sort sort){
        if(page == null && size != null){
            return PageRequest.ofSize(size)
                    .withSort(sort);
        }
        if(page != null && size != null){
            return PageRequest.of(page, size, sort);
        }
        return Pageable.unpaged();
    }

}
