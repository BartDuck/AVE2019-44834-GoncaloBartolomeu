import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class App {

    static class A{}

    static class B extends A {}

    static class C extends B {
        public int x, y;
        public void Foo() {}
    }

    public static void main(String[] args){
        PrintBaseTypes("Ola");
        PrintBaseTypes(19);
        PrintBaseTypes(new C());
        //PrintBaseTypes(new FileSystemInfo("."));
        
        PrintMembers(new C());
        PrintMethods(new C());
        PrintFields(new C());
    }

    private static void PrintMembers(Object obj) {
        System.out.print("Members: ");
        for (Class curr :obj.getClass().getNestMembers()) {
            System.out.print(curr.toString() + " ");
        }
        System.out.println();
    }

    private static void PrintMethods(Object obj) {
        System.out.print("Methods: ");
        for (Method curr :obj.getClass().getMethods()) {
            System.out.print(curr.toString() + " ");
        }
        System.out.println();
    }

    private static void PrintFields(Object obj) {
        System.out.print("Fields: ");
        for (Field curr :obj.getClass().getFields()) {
            System.out.print(curr.toString() + " ");
        }
        System.out.println();
    }

    private static void PrintBaseTypes(Object obj) {
        Class t = obj.getClass();
        Type[] interfaces = t.getGenericInterfaces();
        do{
            System.out.print(t.toString() + " (");
            for (Type curr: interfaces) {
                System.out.print(curr.getTypeName() + " ");
            }
            System.out.print(")");
            t= t.getSuperclass();
        }while (t != Object.class);

        System.out.println();
    }
}
