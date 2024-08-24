package org.icc.personservice.titre;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class TitleDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8348346813795714399L;
    private String titleName;
}
