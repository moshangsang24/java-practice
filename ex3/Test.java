public class Test {

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();

        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a1.show(b));
        System.out.println(a1.show(c));
        System.out.println(a1.show(d));
        System.out.println("============");
        System.out.println(a2.show(b));
        System.out.println(a2.show(c));
        System.out.println(a2.show(d));
        System.out.println("============");
        System.out.println(b.show(b));
        System.out.println(b.show(c));
        System.out.println(b.show(d));
        
    }

}


class A {
    public String show(D d) {
        return "A and D";
    }

    public String show(A a) {
        return "A and A";
    }
}

class B extends A {
    public String show(B b) {
        return "B and B";
    }

    @Override
    public String show(A a) {
        return "B and A";
    }
}

class C extends B {}
class D extends B {}
