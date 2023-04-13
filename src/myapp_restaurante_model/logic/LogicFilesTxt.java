package myapp_restaurante_model.logic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class LogicFilesTxt {

    public LogicFilesTxt() {

    }

    public String deleteInformation(String data, int coord) {
        String aux = "";
        for (int i = 0; i < getInformation(data).length; i++) {

            if (i != coord) {
                aux += getInformation(data)[i] + "\n";
            }
        }
        return aux;
    }

    public String[] getInformation(String data) {
        return data.split("\n");
        // [0] a1, Ana González Torres, 867555959, WERTS,300000
        // [1] a2, Gilberto Chacón Pérez, 88445$34, DGFDD, 350000
    }

    public String[] getInformationIndividual(String data) {
        return data.split(",");
        // [0] a1
        // [1] Ana González
    }

    //obtener el numero de veces jugadas
    public int getPersonInformation(String data[]) {
        int personInformation = 0;

        for (int i = 0; i < data.length; i++) {

            if (data[i].contains("juego" + "#" + i)) {

                personInformation++;
                System.out.println(personInformation);
            }
        }
        return personInformation;

    }
    //metodo para obtener el jugadores con coordenadas

    public String getPlayerCoord(String data[], int coord) {

        String personInformation = "";

        for (int i = 0; i < data.length; i++) {
            if (data[coord].contains(data[i])) {
                personInformation += data[i];
            }
        }
        return personInformation;
    }

    //metodo para obtener id
    public boolean isId(String data, String id) {

        boolean result = false;

        for (int i = 0; i <= getInformation(data).length; i++) {
            if (getInformation(data)[0].contains(id)) {
                result = true;
            }

        }

        return result;
    }
    //metodo para obtener id

    public String getById(String data, String id) {
        String result = "";
        // [0] a1, Ana González Torres, 867555959, WERTS,300000
        // [1] a2, Gilberto Chacón Pérez, 88445$34, DGFDD, 350000
        String aux = "";
        for (int i = 0; i < getInformation(data).length; i++) {
            aux = getInformation(data)[i];

            if (getInformationIndividual(aux)[i].contains(id)) {
                result = aux;
                JOptionPane.showConfirmDialog(null, "aux " + result);
            }

        }
        return result;
    }

    //metodo para obtener el jugadoes aleatorios
    public String getPlayerRamdon(String data[]) {

        int number = (int) (Math.random() * 4 + 1);
        String personInformation = "";

        for (int i = 0; i < data.length; i++) {
            if (data[number].contains(data[i])) {
                personInformation += data[i];
            }
        }
        return personInformation;
    }

    //metodo para obtener Numero aleatorio
    public int numberA() {
        int number = (int) (Math.random() * 4 + 1);
        return number;
    }

    public void getPdf(String address) {

        try {
            File path = new File(address);
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
        }
    }

    public Object[][] getObject(String data) {
        String[] dataInformationV;
        // [0] a1, Ana González Torres, 867555959, WERTS,300000
        // [1] a2, Gilberto Chacón Pérez, 88445$34, DGFDD, 350000
        String[] InformationIndividualH;
        // [0] a1
        // [1] Ana González

        Object[][] date = new Object[getSizeObjetc(data)[0]][getSizeObjetc(data)[1]];

        for (int i = 0; i < getSizeObjetc(data)[0]; i++) {
            dataInformationV = getInformation(data);

            InformationIndividualH = getInformationIndividual(dataInformationV[i]);

            for (int j = 0; j < InformationIndividualH.length; j++) {
                System.out.println("Data2: " + j + " " + InformationIndividualH[j] + "\n");

                date[i][j] = InformationIndividualH[j];

            }

        }
        return date;
    }

    public int[] getSizeObjetc(String data) {
        int size[] = new int[2];
        // [0] a1, Ana González Torres, 867555959, WERTS,300000
        // [1] a2, Gilberto Chacón Pérez, 88445$34, DGFDD, 350000
        size[0] = getInformation(data).length;

        for (int i = 0; i <= getInformationIndividual(data).length; i++) {
            // [0] a1
            // [1] Ana González
            size[1] = i;
        }
        return size;
    }

    public String getObjetsConverString(Object[][] matriz) {
        StringBuilder contenidoMatriz = new StringBuilder();
        if (matriz == null) {
            contenidoMatriz.append("");
        } else {
            for (Object[] matriz1 : matriz) {
                for (Object matriz11 : matriz1) {
                    if (matriz11 != null) {
                        contenidoMatriz.append(matriz11).append(",");
                    }

                }
                contenidoMatriz.append("\n");
            }
        }
        return contenidoMatriz.toString();
    }

    public Object[][] obtenerContenidoTabla(JTable table) {
        TableModel model = table.getModel();
        int numRows = model.getRowCount();
        int numCols = model.getColumnCount();
        Object[][] matriz = new Object[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                matriz[row][col] = model.getValueAt(row, col);
            }
        }
        return matriz;
    }

    public String obtenerContenidoDesdeMatriz(Object[][] matriz) {
        StringBuilder contenidoMatriz = new StringBuilder();
        if (matriz == null) {
            contenidoMatriz.append("");
        } else {
            for (Object[] fila : matriz) {
                for (Object elemento : fila) {
                    if (elemento != null) {
                        contenidoMatriz.append(elemento).append(",");
                    }
                }
                contenidoMatriz.append("\n");
            }
        }
        return contenidoMatriz.toString();
    }

}
