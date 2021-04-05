package Utils;

import java.lang.reflect.Method;


/**
 * This class is getting a method execute time and provide some other functions.
 *
 */
public class MethodExecuteTimeUtils {
    /**
     * Get a method execute time using millisecond and add some other service.
     *
     * @param beanClass The method is in this bean
     * @param params The parameter the method execute need
     * @param methodName The name of the method
     * @param beanClass The parameter type of the method
     * @throws Exception If <code>getMethod</code> or <code>invoke</code> fail.
     */
    public static void getMethodExecuteTime(Class<?> beanClass, Object[] params, String methodName, Class<?>[] paramTypes) throws Exception {
        Method method = null;
        Object instance = beanClass.getConstructor().newInstance();
        try {
            //如果方法不需要参数，则直接获得对应methodName的DeclaredMthod的class
            if (paramTypes == null) {
                method = beanClass.getDeclaredMethod(methodName);
            } else {
                //如果方法需要参数，则需要根据获得对应methodName+参数类型来获得的DeclaredMthod的class(避免方法重写导致的方法相同而参数不同的情况)
                method = beanClass.getDeclaredMethod(methodName, paramTypes);
            }
            //设置方法可见性
            method.setAccessible(true);
            System.out.println(method.getName()+"方法执行时间:"+getExecutionTimeAndResult(instance, params, method)+"s");
        } catch (Exception e) {
            throw new Exception("execution failed"+e.toString());
        }
    }

    /**
     * Get a method execute time, use millisecond. The method must has a return result will input
     * the return result in console ,If the method has not return result, please call
     * <code>getMethodExecuteTime</code> method.
     *
     * @param instance The method is in this bean
     * @param params The parameters the method execute need
     * @param method The Method entity
     * @return The millisecond the method execute spend
     * @throws Exception If the method invoke fail
     */
    private static double getExecutionTimeAndResult(Object instance, Object[] params, Method method)throws Exception {
        long startTime = System.nanoTime();
        Object result = (Object) method.invoke(instance, params);
        long endTime = System.nanoTime();
        System.out.println(method.getName()+"方法执行结果 " + result.toString());
        return (endTime - startTime)/1000000000.0;
    }
}