package workshop2;

import java.util.Comparator;

public class Student implements Searchable<Student> {

    private String lstNam;//Apellido
    private String id;//Identificación
    private Double gpa;//Promedio académico (Grade Point Average)
    public static final int SEARCH_PARAMETER_NAME = 1;
    public static final int SEARCH_PARAMETER_GPA = 2;
    public static final int SEARCH_PARAMETER_ID = 3;
    public static final Comparator<Student> BY_NAME = new ByNameComparator();
    public static final Comparator<Student> BY_ID = new ByIdComparator();
    public static final Comparator<Student> BY_GPA = new ByGPAComparator();

    public String getLstNam() {
        return lstNam;
    }

    public String getId() {
        return id;
    }

    public Double getGPA() {
        return gpa;
    }

    public Student(String lastName, String idNumber, double gpa) {
        this.lstNam = lastName;
        this.id = idNumber;
        this.gpa = gpa;
    }

    @Override
    public Comparator<Student> getSearchingComparator(int searchParameter) {
        //El método puede retornar diferentes Comparator's dependiendo del tipo de búsqueda que se desee usar
        switch (searchParameter) {
            case SEARCH_PARAMETER_NAME:
                return BY_NAME;
            case SEARCH_PARAMETER_ID:
                return BY_ID;
            case SEARCH_PARAMETER_GPA:
                return BY_GPA;
            default:
                return BY_ID;//Por defecto el método de búsqueda y ordenamiento es por identificación
        }
    }

    @Override
    public String toString() {
        return this.lstNam + "-" + this.getId();
    }

    public static class ByNameComparator implements Comparator<Student> {

        @Override
        public int compare(Student t, Student t1) {
            return t.getLstNam().compareTo(t1.getLstNam());
        }
    }

    public static class ByGPAComparator implements Comparator<Student> {

        @Override
        public int compare(Student t, Student t1) {
            return -1 * Double.compare(t.getGPA(), t1.getGPA());
        }
    }

    public static class ByIdComparator implements Comparator<Student> {

        @Override
        public int compare(Student t, Student t1) {
            return t.getId().compareTo(t1.getId());
        }
    }
}
