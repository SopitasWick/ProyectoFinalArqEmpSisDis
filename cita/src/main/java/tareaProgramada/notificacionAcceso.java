package tareaProgramada;

import java.util.Timer;
import java.util.TimerTask;

public class notificacionAcceso {

    public static boolean ejecutarTareaProgramada() {
        final boolean[] enviarNotificacion = {false}; // Array de un solo elemento
        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                if (verificarFechaBaseDatos()) {
                    enviarNotificacion[0] = true; // Cambia a true si se debe enviar notificación
                }
            }
        };
        timer.schedule(tarea, 0, 0);

        return enviarNotificacion[0];
    }

    public static boolean ejecutarTareaPrueba() {
        if (verificarFechaBaseDatos()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean verificarFechaBaseDatos() {
        // Implementación temporal: siempre retornar true
        return true;
    }
}
