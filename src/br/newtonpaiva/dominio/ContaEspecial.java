package br.newtonpaiva.dominio;

public class ContaEspecial extends Conta {
    private Double limite;

    @Override

    public Double sacar(Double valor) {
        if (saldo + limite - valor < 0)
            throw new IllegalStateException();
        saldo -= valor;
        return saldo;

//    public Double sacar(Double valor) {
//        if (getSaldo() + limite - valor < 0)
//            throw new IllegalStateException();
//        setSaldo(getSaldo() - valor);
//        return getSaldo();
//    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }
}
