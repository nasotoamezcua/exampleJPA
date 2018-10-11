package com.example.demo.utils;

import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

@Component
public class BaseUtil {
    /**
     * Este metodo copia todas las propiedades en cascada que sean identicas en nombre  y tipo de retorno de un object a otro
     * @param to
     * @param from
     */
    public static void copyProperties(Object to, Object from) {
        
    	Method[] metodos = from.getClass().getMethods();
        Class<?>[] types = new Class[]{};
        Object[] args = new Object[]{};
       
        for(Method metodo: metodos) {
            String name = metodo.getName();
            Method metodoGetTo = null;
            Method metodoSetTo = null;
            Method metodoGetFrom = null;
            Object objFrom = null;
            Object objAux = null;
            String get = null;
            String is = null;
            
            if (name.startsWith("set")){
            	try {
                    get = name.replaceFirst("set", "get");
                    metodoGetTo = to.getClass().getMethod(get, types);
                    metodoSetTo = to.getClass().getMethod(name, metodoGetTo.getReturnType());
                    metodoGetFrom = from.getClass().getMethod(get, types);
                    objFrom = metodoGetFrom.invoke(from, args);
                    metodoSetTo.invoke(to, objFrom);
                } catch(NoSuchMethodException method){
                	try {
                        is = name.replaceFirst("set", "is");
                        metodoGetTo = to.getClass().getMethod(is, types);
                        metodoSetTo = to.getClass().getMethod(name, metodoGetTo.getReturnType());
                        metodoGetFrom = from.getClass().getMethod(is, types);
                        objFrom = metodoGetFrom.invoke(from, args);
                        metodoSetTo.invoke(to, objFrom);
                    } catch(Exception ex){ }
                } catch(IllegalArgumentException ilegal){
                	try {
                        objAux = metodoGetTo.getReturnType().newInstance();
                        copyProperties(objAux, objFrom);
                        metodoSetTo.invoke(to, objAux);
                	} catch(Exception ex){ }
                } catch(Exception e) { }
            }
        }
        
    }
    
    
}
