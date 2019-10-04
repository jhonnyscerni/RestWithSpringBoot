package br.com.siberius.restwithspringboot.security;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class AccountCredentialsVO implements Serializable {

    private static final long serialVersionUID= 6641520444482156291L;

    private String username;

    private String password;
}
