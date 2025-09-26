package Model;


public abstract class CuentaBancaria {
    private float saldo;
    private int numeroConsignaciones = 0;
    private int numeroRetiros= 0;
    private float tasaAnual;
    private float comisionMensual= 0;

    public CuentaBancaria(float saldo,float tasaAnual){
        this.saldo = saldo;
        this.tasaAnual= tasaAnual;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getNumeroConsignaciones() {
        return numeroConsignaciones;
    }

    public void setNumeroConsignaciones(int numeroConsignaciones) {
        this.numeroConsignaciones = numeroConsignaciones;

    }

    public int getNumeroRetiros() {
        return numeroRetiros;
    }

    public void setNumeroRetiros(int numeroRetiros) {
        this.numeroRetiros = numeroRetiros;
    }

    public float getTasaAnual() {
        return tasaAnual;
    }

    public void setTasaAnual(float tasaAnual) {
        this.tasaAnual = tasaAnual;
    }

    public float getComisionMensual() {
        return comisionMensual;
    }

    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }
    public void consignarDinero(float monto){
        if(monto>0){
            saldo += monto;
            numeroConsignaciones++;
        } else{
            System.out.println("el monto debe ser mayor a 0");
        }
    }
    public void retirarDinero(float monto){
        if(monto<=saldo){
            saldo-=monto;
            numeroRetiros++;
        }else{
            System.out.println("El monto a retirar debe ser menor al saldo");
        }
    }
    public void calcularInteresMensual() {
        float tasaMensual= tasaAnual/12/100;
        float interes= saldo*tasaMensual;
        saldo+= interes;
    }
    public void extractoMensual(){
        saldo-= comisionMensual;
        calcularInteresMensual();
    }

    public void imprimir(){
        System.out.println("Saldo: "+saldo);
        System.out.println("Numero de consignaciones: "+numeroConsignaciones);
        System.out.println("Numero de retiros: "+numeroRetiros);
        System.out.println("Tasa anual: "+tasaAnual);
        System.out.println("Comision mensual: "+comisionMensual);
    }
}
