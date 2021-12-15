package com.xx.test.po;

import lombok.Data;
import java.io.Serializable;

@Data
public class OooPO implements Serializable {
	private static final long serialVersionUID =  6572940434569433574L;

	private Long id;
	private String name;
	private String nameLike;
	private String orderBy;
}
