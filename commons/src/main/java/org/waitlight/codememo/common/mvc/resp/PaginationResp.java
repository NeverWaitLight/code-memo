package org.waitlight.codememo.common.mvc.resp;

import lombok.Getter;
import lombok.Setter;
import org.waitlight.codememo.common.mvc.query.PaginationQuery;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
public class PaginationResp<T> extends AbstractResp {
    private long page;
    private long perPage;

    private long count;
    private List<T> data = Collections.emptyList();

    private PaginationResp() {
    }

    public long getTotalPage() {
        return count / perPage + (count % perPage > 0L ? 1L : 0L);
    }

    public static <T> PaginationResp<T> success(PaginationQuery query) {
        return success(query, 0L, Collections.emptyList());
    }

    public static <T> PaginationResp<T> success(PaginationQuery query, Long total, List<T> data) {
        if (Objects.isNull(query)) {
            throw new RuntimeException("Query is required!");
        }

        PaginationResp<T> resp = new PaginationResp<>();
        resp.setCode(DEF_SUCCESS_CODE);
        resp.setMessage(DEF_SUCCESS_MESSAGE);

        resp.page = query.getPage();
        resp.perPage = query.getPerPage();
        resp.count = total;
        resp.setData(data);
        return resp;
    }

}