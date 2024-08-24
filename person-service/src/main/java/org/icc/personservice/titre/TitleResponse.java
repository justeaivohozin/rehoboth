package org.icc.personservice.titre;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class TitleResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 5095885605099940236L;
    private Long titleId;

    private String titleName;
}
