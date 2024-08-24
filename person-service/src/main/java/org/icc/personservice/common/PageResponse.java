package org.icc.personservice.common;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -5663332588888818832L;
    
    private List<?> elements;
    private Long elementCount;
    private Long innerElementCount;

}
