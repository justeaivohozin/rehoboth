package org.icc.campusservice.common;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponse implements Serializable {
    private List<?> elements;
    private Long elementCount;
    private Long innerElementCount;

}
