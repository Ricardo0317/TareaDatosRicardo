package data;

import domain.Curso;
import java.util.LinkedList;

public class GestorCursos {
    private LinkedList<Curso> listaCursos;
    
    public GestorCursos() {
        listaCursos = new LinkedList<>();
        cargarCursosIniciales();
    }
    
    private void cargarCursosIniciales() {
        agregarCurso("EIF-204", "Programación 2", 4);
        agregarCurso("MAT-002", "Cálculo", 4);
    }
    
    public boolean agregarCurso(String sigla, String nombre, int creditos) {
        Curso nuevo = new Curso(sigla, nombre, creditos);
        return listaCursos.add(nuevo);
    }
    
    public Curso obtenerCurso(String sigla) {
        for (Curso curso : listaCursos) {
            if (curso.getInitials().equalsIgnoreCase(sigla)) {
                return curso;
            }
        }
        return null;
    }
    
    public boolean eliminarCurso(String sigla) {
        for (int i = 0; i < listaCursos.size(); i++) {
            if (listaCursos.get(i).getInitials().equalsIgnoreCase(sigla)) {
                listaCursos.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public int contarCursosRecursivo() {
        return contarRecursivo(listaCursos.size() - 1);
    }
    
    private int contarRecursivo(int indice) {
        if (indice < 0) {
            return 0;
        }
        return 1 + contarRecursivo(indice - 1);
    }
    
    public String mostrarTodosCursos() {
        if (listaCursos.isEmpty()) {
            return "No hay cursos registrados.";
        }
        
        StringBuilder sb = new StringBuilder();
        for (Curso curso : listaCursos) {
            sb.append("• ").append(curso.toString()).append("\n");
        }
        return sb.toString();
    }
    
    public LinkedList<Curso> getListaCursos() {
        return listaCursos;
    }
}