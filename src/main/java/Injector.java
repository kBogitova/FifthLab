import java.lang.reflect.Field;
import java.io.FileInputStream;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;



public class Injector {

    public Object inject(Object object,String path) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        if (object==null) {
            throw new IOException();
        }
        Properties properties = new Properties();
        Class<?> anyClass = object.getClass();

        InputStream in =  new FileInputStream(path);

            properties.load(in);

            for (Field field : anyClass.getDeclaredFields()) {
                AutoInjectable annotation = field.getAnnotation(AutoInjectable.class);
                if (annotation != null ) {
                    field.setAccessible(true);
                    Object name = Class.forName(properties.getProperty(field.getName())).newInstance();
                    field.set(object, name);
                    }
                }

        return object;
    }
}