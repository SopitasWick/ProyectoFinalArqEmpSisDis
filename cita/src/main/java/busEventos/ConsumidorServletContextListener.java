//package busEventos;
//
//import jakarta.servlet.ServletContextEvent;
//import jakarta.servlet.ServletContextListener;
//import jakarta.servlet.annotation.WebListener;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
////SE NECESITA EN WEB-INF/WEB.XML
////    <servlet>
////        <servlet-name>consumidor</servlet-name>
////        <servlet-class>busEventos.ConsumidorServletContextListener</servlet-class>
////        <load-on-startup>1</load-on-startup>
////    </servlet>
//@WebListener
//public class ConsumidorServletContextListener implements ServletContextListener {
//
//    private ExecutorService executor;
//
//    @Override
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        executor = Executors.newFixedThreadPool(5); // Pool de 5 hilos
//        executor.submit(() -> {
//            try {
//                Consumidor.main(new String[]{});
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//        if (executor != null) {
//            executor.shutdown();
//        }
//    }
//}
