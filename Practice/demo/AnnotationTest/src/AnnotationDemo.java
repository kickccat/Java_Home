import java.lang.annotation.Annotation;

public class AnnotationDemo {

    public static void main(String[] args) {

        IPhoneSeries iphone = new IPhoneSeries("7Plus", 899);

        Class clazz = iphone.getClass();
        Annotation annotation = clazz.getAnnotation(SmartPhone.class);
        SmartPhone phone = (SmartPhone) annotation;
        System.out.println(phone.os() + "-->" + phone.price());
    }
}
