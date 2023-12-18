package org.demointernetshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Email {

    private String to;
    private String subject;
    private String text;


}
