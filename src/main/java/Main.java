public class Main {

    public static void main(String[] args) {
        Student student = new Student("Mike", "id-1", 1, 1.3f);
        University university = new University("id-1", "Standford", "SU", 1990, StudyProfile.IT);

        System.out.println(student);
        System.out.println(university);
    }
}
