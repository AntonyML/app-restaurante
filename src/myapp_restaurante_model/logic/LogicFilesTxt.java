package myapp_restaurante_model.logic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class LogicFilesTxt {

    public LogicFilesTxt() {

    }

    public String[] gteOnlyPosicion0theData(String data, int size) {
        String[] result = new String[size];
        String[] dataOneComplete = getInformation(data);
        String[] dataSplitImcomplete;

        for (int i = 0; i < dataOneComplete.length; i++) {
            dataSplitImcomplete = getInformationIndividual(dataOneComplete[i]);
            for (int j = 0; j < dataSplitImcomplete.length; j++) {
                if (j == 0) {
                    result[i] = (dataSplitImcomplete)[j];
                }
            }

        }
        return result;
    }

    public String[] gteOnlyPosicion0theDataController(String data, int size) {
        String[] result = new String[size];
        String[] dataOneComplete = getInformation(data);
        String[] dataSplitImcomplete;

        for (int i = 0; i < dataOneComplete.length; i++) {
            dataSplitImcomplete = getInformationIndividual(dataOneComplete[i]);
            for (int j = 0; j < dataSplitImcomplete.length; j++) {
                if (j == 1) {
                    result[i] = (dataSplitImcomplete)[j];
                }
            }

        }
        return result;
    }

    public String deteleSpace(String[] data) {
        String result = "";
        System.out.print(" Delete { " + "\n");
        for (int i = 0; i < data.length; i++) {
            if (!(data)[i].equals("\n")) {
                if ((data)[i].contains(" ")) {
                    System.out.print(" if   data : " + i + "  " + (data)[i] + "\n");
                    result += (data)[i] + "\n";
                }

            }

        }
        System.out.print(" FinDelete } " + "\n");
        return result;
    }

    public String deteleData(String[] data, int n) {
        String result = "";

        System.out.print(" DeleteData { " + "\n");
        for (int i = 0; i < data.length; i++) {
            if (i == n) {
                System.out.print(" ifdeletedata : " + i + "  " + (data)[i] + "\n");
            } else {
                result += (data)[i] + "\n";
            }
        }
        System.out.print(" FinDeleteData } " + "\n");
        return result;
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

    public String editInformation(String data) {
        String result = "b";
        if (data.charAt(0) == 'p' && data.charAt(1) == 'p') {
            result = "pp";
        }
        if (data.charAt(0) == 'p' && data.charAt(1) == 'o') {
            result = "po";
        }
        return result;
    }

    public String getPersonInformation(String data[], String address) {
        String personInformation = "";

        for (int i = 0; i < data.length; i++) {
            System.out.println("no entra");
            System.out.println(data[i] + "\n =data" + address + " =direccion");
            if (data[i].contains(address)) {
                personInformation += data[i] + "\n";
                System.out.println("entra pero f");
            }
        }
        return personInformation;

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

    //obtener el numero de jugadores
    public int getNumberPerson(String data[]) {
        int personInformation = 0;

        for (int i = 0; i < data.length; i++) {
            personInformation++;
        }
        return personInformation;
    }

    //metodo para obtener el jugadoes aleatorios
    public String getPlayer(String data[]) {

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

    public void getPdf() {

        try {
            File path = new File("src\\documents\\ProyectoII.pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
        }
    }

    public Object[][] getObject(int size, String data) {
        System.out.println("GetObject" + "\n");
        Object[][] date = new Object[size][7];
        String[] dataInformationV;
        // [0] a1, Ana González Torres, 867555959, WERTS,300000
        // [1] a2, Gilberto Chacón Pérez, 88445$34, DGFDD, 350000
        String[] InformationIndividualV;
        // [0] a1
        // [1] Ana González

        for (int i = 0; i < size; i++) {
            dataInformationV = getInformation(data);
            //System.out.println("Data1: "+i+" "+dataInformationV[i] + "\n");
            InformationIndividualV = getInformationIndividual(dataInformationV[i]);

            for (int j = 0; j < InformationIndividualV.length; j++) {
                System.out.println("Data2: " + j + " " + InformationIndividualV[j] + "\n");

                date[i][j] = InformationIndividualV[j];
                // System.out.println(date[i][j] + "\n");

            }

        }
        return date;
    }

    public Object[][] getObjectReservation(int size, String data) {
        System.out.println("GetObject" + "\n");
        Object[][] date = new Object[size][6];
        String[] dataInformationV;
        //[0]p1, 7/11/2022, c1, pp2|po1|b2, 9500, entregado
        //[1]p2, 7/11/2022, c2, pp1| |b1, 4000, pendiente
        String[] InformationIndividualV;
        // [0] p1
        // [1] 7/11/2022

        for (int i = 0; i < size; i++) {
            dataInformationV = getInformation(data);
            //System.out.println("Data1: "+i+" "+dataInformationV[i] + "\n");
            InformationIndividualV = getInformationIndividual(dataInformationV[i]);

            for (int j = 0; j < InformationIndividualV.length; j++) {
                System.out.println("Data2: " + j + " " + InformationIndividualV[j] + "\n");

                date[i][j] = InformationIndividualV[j];
                // System.out.println(date[i][j] + "\n");

            }

        }
        return date;
    }
    // se obtiene una matriz de tipo Object

    public String getObjetsConverString(Object[][] matriz) {
        // Convertir el contenido de la matriz a una cadena de texto
        String contenidoMatriz = "";
        if (matriz == null) {
            contenidoMatriz = null;
        } else {

            for (Object[] matriz1 : matriz) {
                for (Object matriz11 : matriz1) {
                    contenidoMatriz += matriz11 + ",";
                }
                contenidoMatriz += "\n";
            }

            // Mostrar el contenido de la matriz como una cadena de texto
            System.out.println(contenidoMatriz);
        }

        return contenidoMatriz;
    }
}
