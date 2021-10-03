package com.tolgakmbl.hrms.core.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Image {
	private String id;
	private String url;
	private int bytes;
	private String format;
	private int height;
	private int width;
}
