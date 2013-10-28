package workshop2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SearchEngine {

    public static <E extends Searchable<E>, T extends List<E>> int getPosition(T list, E search, int searchParameter) {
        //Se obtiene el Comparator correspondiente al método de búsqueda seleccionado
        Comparator<E> c = search.getSearchingComparator(searchParameter);
        //Se ordena la lista usando el Comparator obtenido
        Collections.sort(list, c);
        //Inicio de la búsqueda binaria
        int start = 0;
        int end = list.size() - 1;
        int mid = -1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            int comparation = c.compare(search, list.get(mid));
            if (comparation < 0) {
                end = mid - 1;
            } else if (comparation > 0) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        //Si no se encontró el objeto se retorna la posición del siguiente objeto en la lista "mayor" que el ingresado como argumento
        return mid;
    }

    public static Student searchStudentByGPA(ArrayList<Student> students, double gpa, int upperPosition) {
        int pos = getPosition(students, new Student("", "", gpa), Student.SEARCH_PARAMETER_GPA);
        if (students.get(pos).getGPA()> gpa) {
            pos++;
        }
        
        int resultPosition = pos - upperPosition;
        if (resultPosition < 0 || resultPosition >= students.size()) {
            return null;
        }
        return students.get(resultPosition);
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Villamizar", "286037", 4.2));
        students.add(new Student("Vallejo", "286036", 4.6));
        students.add(new Student("Cuervo", "286035", 4.3));
        students.add(new Student("Gomez", "286034", 3.4));
        students.add(new Student("Sarmiento", "286033", 4.1));
        Collections.sort(students, Student.BY_NAME);

        System.out.println("Listado original de estudianes:\n");

        for (Student s : students) {
            System.out.println(s + "-" + s.getGPA());
        }
        //Captura de los valores
        double prom = 4.15;
        int upperPos = 2;

        System.out.println("\nEl estudiante número " + upperPos + " con un promedio superior a " + prom + " es " + searchStudentByGPA(students, prom, upperPos));
    }
}
