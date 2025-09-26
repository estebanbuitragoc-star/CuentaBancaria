package Model;

public class CuentaCorriente extends CuentaBancaria{
    private float sobreGiro=0;

    public CuentaCorriente(float saldo, float tasaAnual){
        super(saldo, tasaAnual);
    }

    @Override
    public void retirarDinero(float monto) {
        if(monto<=getSaldo()){
        super.retirarDinero(monto);
        }else{
            float diferencia= monto- getSaldo();
            super.retirarDinero(getSaldo());
            sobreGiro+=diferencia;
        }
    }

    @Override
    public void consignarDinero(float monto) {
        if(sobreGiro > 0){
            if(monto > sobreGiro){
            float restante= monto-sobreGiro;
            sobreGiro=0;
            if(restante > 0){
        super.consignarDinero(restante);
            }
        }else{
                sobreGiro-=monto;
            }
            }else{
            super.consignarDinero(monto);
        }
        }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public void imprimir() {
        int TotalTransacciones= getNumeroConsignaciones()+getNumeroRetiros();
        System.out.println("Saldo: "+getSaldo());
        System.out.println("Comision mensual: "+getComisionMensual());
        System.out.println("Numero total de transacciones: "+TotalTransacciones);
        System.out.println("Sobre giro: "+sobreGiro);
    }
}




