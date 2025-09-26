package App;

import Model.CuentaAhorros;

public class App {
    public static void main(String[] args){
        CuentaAhorros cuentaAhorros= new CuentaAhorros(10000,12);
    System.out.println(" Cuenta de ahorros ");
    cuentaAhorros.imprimir();
    cuentaAhorros.consignarDinero(8000);
    cuentaAhorros.retirarDinero(3000);
    cuentaAhorros.extractoMensual();
    cuentaAhorros.imprimir();


}
}