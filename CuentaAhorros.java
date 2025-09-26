package Model;

public class CuentaAhorros extends CuentaBancaria{

    private boolean activa;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.activa= saldo >= 10000;
    }
    private void actualizarEstado(){
        this.activa = getSaldo() >= 10000;
    }

    @Override
    public void consignarDinero(float monto) {
        if(activa){
        super.consignarDinero(monto);
        actualizarEstado();
    }else{
            System.out.println("No se puede consignar, la cuenta esta inactiva");
        }
    }

    @Override
    public void retirarDinero(float monto) {
        if(activa){
        super.retirarDinero(monto);
        actualizarEstado();
        }else {
            System.out.println("No se puede retirar, la cuenta esta inactiva");
        }
    }

    @Override
    public void calcularInteresMensual() {
          if(activa){
        super.calcularInteresMensual();
        actualizarEstado();
    }else{
              System.out.println("No se puede calcular el interes mensual, la cuenta esta inactiva");
          }
    }

    @Override
    public void extractoMensual() {
        if(getNumeroRetiros() >4 ){
            int retirosExtra= getNumeroRetiros()-4;
        float nuevaComision= getComisionMensual()+ (retirosExtra*1000);
        setComisionMensual(nuevaComision);
        }

    super.extractoMensual();
        actualizarEstado();
    }

    @Override
    public void imprimir() {
        int TotalTransacciones= getNumeroRetiros() + getNumeroConsignaciones();
        System.out.println("Saldo: "+getSaldo());
        System.out.println("Comision mensual: "+getComisionMensual());
        System.out.println("Numero total de transacciones: "+TotalTransacciones);
    }


}
