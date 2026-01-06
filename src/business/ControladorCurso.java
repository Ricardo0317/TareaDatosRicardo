package business;

import data.GestorCursos;
import domain.Curso;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorCurso {
    
    private GestorCursos gestor = new GestorCursos();    
    @FXML private TextField txtSigla;
    @FXML private TextField txtNombre;
    @FXML private TextField txtCreditos;
    @FXML private TextArea txtAreaCursos;    
    @FXML private Button btnAgregar;
    @FXML private Button btnBuscar;
    @FXML private Button btnEliminar;
    @FXML private Button btnMostrar;
    @FXML private Button btnContarRecursivo;
    
    @FXML
    public void initialize() {
        mostrarCursos();
    }
    
    @FXML
    private void agregarCurso() {
        String sigla = txtSigla.getText().trim();
        String nombre = txtNombre.getText().trim();
        String strCreditos = txtCreditos.getText().trim();
        
        if (sigla.isEmpty() || nombre.isEmpty() || strCreditos.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios");
            return;
        }
        
        try {
            int creditos = Integer.parseInt(strCreditos);
            
            if (gestor.agregarCurso(sigla, nombre, creditos)) {
                mostrarAlerta("Éxito", "Curso agregado: " + sigla);
                limpiarCampos();
                mostrarCursos();
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Créditos debe ser número");
        }
    }
    
    @FXML
    private void buscarCurso() {
        String sigla = txtSigla.getText().trim();
        
        if (sigla.isEmpty()) {
            mostrarAlerta("Error", "Ingrese sigla a buscar");
            return;
        }
        
        Curso curso = gestor.obtenerCurso(sigla);
        if (curso != null) {
            txtNombre.setText(curso.getName());
            txtCreditos.setText(String.valueOf(curso.getCredits()));
            mostrarAlerta("Encontrado", "Curso: " + curso);
        } else {
            mostrarAlerta("No encontrado", "Sigla: " + sigla);
        }
    }
    
    @FXML
    private void eliminarCurso() {
        String sigla = txtSigla.getText().trim();
        
        if (sigla.isEmpty()) {
            mostrarAlerta("Error", "Ingrese sigla a eliminar");
            return;
        }
        
        if (gestor.eliminarCurso(sigla)) {
            mostrarAlerta("Éxito", "Curso eliminado: " + sigla);
            limpiarCampos();
            mostrarCursos();
        } else {
            mostrarAlerta("Error", "No se encontró: " + sigla);
        }
    }
    
    @FXML
    private void mostrarCursos() {
        txtAreaCursos.setText(gestor.mostrarTodosCursos());
    }
    
    @FXML
    private void contarRecursivo() {
        int total = gestor.contarCursosRecursivo();        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Conteo Recursivo");
        alert.setHeaderText("Método recursivo implementado");
        alert.setContentText("Total de cursos: " + total);
        alert.showAndWait();
    }
    
    @FXML
    private void limpiarCampos() {
        txtSigla.clear();
        txtNombre.clear();
        txtCreditos.clear();
    }
    
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}