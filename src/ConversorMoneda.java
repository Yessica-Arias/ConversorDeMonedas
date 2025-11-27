import java.util.Map;

public class ConversorMoneda {
    public double convertir(double monto, double tasa) {
        return monto*tasa;

    }
    public double convertirInverso(double monto, double tasa){
        return monto/tasa;
    }

}
