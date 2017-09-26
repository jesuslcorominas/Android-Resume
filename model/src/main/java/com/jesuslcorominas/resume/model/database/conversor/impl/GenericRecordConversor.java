package com.jesuslcorominas.resume.model.database.conversor.impl;

import com.jesuslcorominas.resume.commons.util.TextUtils;
import com.jesuslcorominas.resume.model.database.conversor.RecordConversor;
import com.orm.SugarRecord;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus Lopez Corominas
 * 23/09/2017.
 */
// TODO hacer anotacion para indicar el nombre del metodo a utilizar (ojo que solo se agregan los set)-> Anotaciones Get y Set
// TODO agregar anotacion para indicar como convertir sin son de tipos distintos.
// TODO hacer anotacion para poder ignorar un campo -> Anotacion Ignore
public class GenericRecordConversor<V, R extends SugarRecord> implements RecordConversor<V, R> {

    private Class<V> voClazz;
    private Class<R> recordClazz;

    public GenericRecordConversor(Class<V> voClazz, Class<R> recordClazz) {
        this.voClazz = voClazz;
        this.recordClazz = recordClazz;
    }

    @Override
    public V toValueObject(R record) {
        String error = "Error al convertir de " + recordClazz.getSimpleName() + " a " + voClazz.getSimpleName() + ".\n ";

        List<Field> fields = new ArrayList<>();
        List<Method> methods = new ArrayList<>();
        Method[] voMethods = voClazz.getDeclaredMethods();
        for (Method m : voMethods) {
            if (m.getName().startsWith("set") && !Modifier.isStatic(m.getModifiers())) {
                methods.add(m);
            }
        }

        Class<?> clazz = recordClazz;
        do {
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field f : declaredFields) {
                if (!Modifier.isStatic(f.getModifiers()) && !Modifier.isFinal(f.getModifiers())) {
                    fields.add(f);
                }
            }

            clazz = clazz.getSuperclass();
        } while (clazz != Object.class);

        V instance;

        try {
            instance = voClazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(error + e.getClass().getSimpleName() +
                    ": No se ha podido instanciar la clase.", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(error + e.getClass().getSimpleName() +
                    ": No se ha podido acceder a la clase.", e);
        }

        for (Field fieldRecord : fields) {
            // El nombre del campo tal como esta definido en la clase
            String fieldName = fieldRecord.getName();

            // El nombre del campo con la inicial en mayuscula
            String capitalizedField = TextUtils.capitalize(fieldName);

            // El metodo get en el record
            Method getter;

            // El metodo set en el vo
            Method setter = null;

            // El tipo devuelto por el get
            Class<?> getReturnType;

            // El valor obtenido en el get
            Object value;

            try {
                getter = recordClazz.getMethod("get" + capitalizedField);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(error + e.getClass().getSimpleName() +
                        ": No hay metodo get para el campo " + fieldName + " en " +
                        recordClazz.getSimpleName());
            }

            try {
                value = getter.invoke(record);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(error + e.getClass().getSimpleName() +
                        ": No se ha podido acceder al metodo get para " + fieldName + " en " + recordClazz.getSimpleName());
            } catch (InvocationTargetException e) {
                throw new RuntimeException(error + e.getClass().getSimpleName() +
                        ": No se ha podido invocar al metodo get para " + fieldName + " en " + recordClazz.getSimpleName());
            }

            getReturnType = getter.getReturnType();

            for (int i = 0; i < methods.size() && setter == null; i++) {
                Method m = methods.get(i);
                if (m.getName().equals("set" + capitalizedField)) {
                    // Si el metodo es set y el campo
                    Class<?>[] parametersTypes = m.getParameterTypes();
                    if (parametersTypes.length == 1) {
                        // Si solo recibe un parametro
                        Class<?> parameterType = parametersTypes[0];
                        if (parameterType.equals(getReturnType)) {
                            // Si son del mismo tipo
                            setter = m;
                            try {
                                setter.invoke(instance, value);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido acceder al metodo set para " + fieldName + " en " + voClazz.getSimpleName());
                            } catch (InvocationTargetException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido invocar el metodo set para " + fieldName + " en " + voClazz.getSimpleName());
                            }
                        } else if (parameterType.isEnum() && (getReturnType.equals(int.class) || getReturnType.equals(Integer.class))) {
                            // Pasamos de entero a enumerado
                            setter = m;
                            Method getValueMethod;
                            Object enumValue;

                            try {
                                getValueMethod = parameterType.getDeclaredMethod("get" + parameterType.getSimpleName(), int.class);
                            } catch (NoSuchMethodException e) {
                                throw new RuntimeException();
                            }

                            try {
                                enumValue = getValueMethod.invoke(null, value);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido acceder al metodo getValue en " + parameterType.getSimpleName());
                            } catch (InvocationTargetException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido invocar el metodo getValue en " + parameterType.getSimpleName());
                            }

                            try {
                                setter.invoke(instance, enumValue);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido acceder al metodo set para " + fieldName + " convirtiendo de entero a " +
                                        parameterType.getSimpleName() + " en " + voClazz.getSimpleName());
                            } catch (InvocationTargetException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido invocar el metodo set para " + fieldName + " convirtiendo de entero a " +
                                        parameterType.getSimpleName() + " en " + voClazz.getSimpleName());
                            }
                        } else if (getReturnType.isEnum() && (parameterType.equals(int.class) || parameterType.equals(Integer.class))) {
                            // Pasamos de enumerado a entero
                            setter = m;
                            Method getValueMethod;
                            Object enumValue;

                            try {
                                getValueMethod = getReturnType.getDeclaredMethod("getValue");
                            } catch (NoSuchMethodException e) {
                                throw new RuntimeException();
                            }

                            try {
                                enumValue = getValueMethod.invoke(value);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido acceder al metodo getValue en " + getReturnType.getSimpleName());
                            } catch (InvocationTargetException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido invocar el metodo getValue en " + getReturnType.getSimpleName());
                            }

                            try {
                                setter.invoke(instance, enumValue);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido acceder al metodo set para " + fieldName +
                                        " convirtiendo " + parameterType.getSimpleName() + " a entero en " +
                                        voClazz.getSimpleName());
                            } catch (InvocationTargetException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido invocar el metodo set para " + fieldName +
                                        " convirtiendo " + parameterType.getSimpleName() + " a entero en " +
                                        voClazz.getSimpleName());
                            }
                        }
                    }
                }
            }

            if (setter == null) {
                throw new RuntimeException(error + "NoShuchMethodException: No hay metodo set para el campo " + fieldName + " en " + voClazz);
            }
        }

        return instance;
    }

    @Override
    public R toRecord(V vo) {
        String error = "Error al convertir de " + voClazz.getSimpleName() + " a " + recordClazz.getSimpleName() + ".\n ";

        List<Field> fields = new ArrayList<>();
        List<Method> methods = new ArrayList<>();

        Class<?> clazz = recordClazz;
        do {
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field f : declaredFields) {
                if (!Modifier.isStatic(f.getModifiers()) && !Modifier.isFinal(f.getModifiers())) {
                    fields.add(f);
                }
            }

            Method[] clazzMethods = clazz.getDeclaredMethods();
            for (Method m : clazzMethods) {
                if (m.getName().startsWith("set") && !Modifier.isStatic(m.getModifiers())) {
                    methods.add(m);
                }
            }

            clazz = clazz.getSuperclass();
        } while (clazz != Object.class);

        R instance;

        try {
            instance = recordClazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(error + e.getClass().getSimpleName() +
                    ": No se ha podido instanciar la clase.", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(error + e.getClass().getSimpleName() +
                    ": No se ha podido acceder a la clase.", e);
        }

        for (Field fieldRecord : fields) {
            // El nombre del campo tal como esta definido en la clase
            String fieldName = fieldRecord.getName();

            // El nombre del campo con la inicial en mayuscula
            String capitalizedField = TextUtils.capitalize(fieldName);

            // El metodo get en el vo
            Method getter;

            // El metodo set en el record
            Method setter = null;

            // El tipo devuelto por el get
            Class<?> getReturnType;

            // El valor obtenido en el get
            Object value;

            try {
                getter = voClazz.getMethod("get" + capitalizedField);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(error + e.getClass().getSimpleName() +
                        ": No hay metodo get para el campo " + fieldName + " en " + voClazz.getSimpleName());
            }

            try {
                value = getter.invoke(vo);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(error + e.getClass().getSimpleName() +
                        ": No se ha podido acceder al metodo get para " + fieldName + " en " + voClazz.getSimpleName());
            } catch (InvocationTargetException e) {
                throw new RuntimeException(error + e.getClass().getSimpleName() +
                        ": No se ha podido invocar al metodo get para " + fieldName + " en " + voClazz.getSimpleName());
            }

            getReturnType = getter.getReturnType();

            for (int i = 0; i < methods.size() && setter == null; i++) {
                Method m = methods.get(i);
                if (m.getName().equals("set" + capitalizedField)) {
                    // Si el metodo es set y el campo
                    Class<?>[] parametersTypes = m.getParameterTypes();
                    if (parametersTypes.length == 1) {
                        // Si solo recibe un parametro
                        Class<?> parameterType = parametersTypes[0];
                        if (parameterType.equals(getReturnType)) {
                            // Si son del mismo tipo
                            setter = m;
                            try {
                                setter.invoke(instance, value);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido acceder al metodo set para " + fieldName + " en " + recordClazz.getSimpleName());
                            } catch (InvocationTargetException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido invocar el metodo set para " + fieldName + " en " + recordClazz.getSimpleName());
                            }
                        } else if (parameterType.isEnum() && (getReturnType.equals(int.class) || getReturnType.equals(Integer.class))) {
                            // Pasamos de entero a enumerado
                            setter = m;
                            Method getValueMethod;
                            Object enumValue;

                            try {
                                getValueMethod = parameterType.getDeclaredMethod("get" + parameterType.getSimpleName(), int.class);
                            } catch (NoSuchMethodException e) {
                                throw new RuntimeException();
                            }

                            try {
                                enumValue = getValueMethod.invoke(null, value);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido acceder al metodo getValue en " + parameterType.getSimpleName());
                            } catch (InvocationTargetException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido invocar el metodo getValue en " + parameterType.getSimpleName());
                            }

                            try {
                                setter.invoke(instance, enumValue);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido acceder al metodo set para " + fieldName + " convirtiendo de entero a " +
                                        parameterType.getSimpleName() + " en " + recordClazz.getSimpleName());
                            } catch (InvocationTargetException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido invocar el metodo set para " + fieldName + " convirtiendo de entero a " +
                                        parameterType.getSimpleName() + " en " + recordClazz.getSimpleName());
                            }
                        } else if (getReturnType.isEnum() && (parameterType.equals(int.class) || parameterType.equals(Integer.class))) {
                            // Pasamos de enumerado a entero
                            setter = m;
                            Method getValueMethod;
                            Object enumValue;

                            try {
                                getValueMethod = getReturnType.getDeclaredMethod("getValue");
                            } catch (NoSuchMethodException e) {
                                throw new RuntimeException();
                            }

                            try {
                                enumValue = getValueMethod.invoke(value);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido acceder al metodo getValue en " + getReturnType.getSimpleName());
                            } catch (InvocationTargetException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido invocar el metodo getValue en " + getReturnType.getSimpleName());
                            }

                            try {
                                setter.invoke(instance, enumValue);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido acceder al metodo set para " + fieldName +
                                        " convirtiendo " + parameterType.getSimpleName() + " a entero en " +
                                        recordClazz.getSimpleName());
                            } catch (InvocationTargetException e) {
                                throw new RuntimeException(error + e.getClass().getSimpleName() +
                                        ": No se ha podido invocar el metodo set para " + fieldName +
                                        " convirtiendo " + parameterType.getSimpleName() + " a entero en " +
                                        recordClazz.getSimpleName());
                            }
                        }
                    }
                }
            }

            if (setter == null) {
                throw new RuntimeException(error + "NoShuchMethodException: No hay metodo set para el campo " + fieldName + " en " + recordClazz);
            }
        }

        return instance;
    }
}
