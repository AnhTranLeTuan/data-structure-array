public class Main {
    public static void main(String[] args) {
        Array<Student> array = new Array<>();
        Student student1 = new Student("David", 30);
        array.add(student1);
        array.add(new Student("David", 30));
        array.add(new Student("David", 30));
        Student student2 = new Student("Harry", 20);
        array.insert(student2, 2);
        array.print();
        System.out.println(array.indexOf(student1));
        System.out.println(array.indexOf(student2));

        }
    }
