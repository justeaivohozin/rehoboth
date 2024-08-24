package org.icc.personservice.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class Campus implements Serializable {
    @Serial
    private static final long serialVersionUID = -4913008324154316850L;
    private Long campusId;
    private String campusName;
}
