package br.newtonpaiva.dominio;

import java.util.Objects;
import java.util.Scanner;

public class Conta implements Trasferencia {

    private Integer numero;
    protected Double saldo;

    public Conta() {
        this(null);
    }

    public Conta(Integer numero) {
        this(numero, 0.0);
    }

    public Conta(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public Double sacar(Double valor) {
        return 0.0;

    }

    public Double depositar(Double valor) {
        if (valor == null || valor <= 0)
            throw new IllegalArgumentException("Valor menor do que 0");

        saldo += valor;
        return saldo;
    }

    public void transferir(Conta destino, Double valor) {
        if (valor == null || valor <= 0)
            if (this.getSaldo() < valor)
                throw new IllegalArgumentException("não ha saldo na caonta");
            if (this.equals(destino))
                throw new IllegalArgumentException(" conta mesma de destino invalido");

        this.sacar(valor);
        destino.depositar(valor);

    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(numero, conta.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}

