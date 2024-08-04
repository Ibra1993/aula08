package com.fourcatsdev.aula08.excecao;

public class CrimeNotFoundException extends Exception {
    public CrimeNotFoundException(String message) {
        super(message);
    }
}
