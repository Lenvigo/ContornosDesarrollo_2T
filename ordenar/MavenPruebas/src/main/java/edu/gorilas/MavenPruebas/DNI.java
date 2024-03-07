package edu.gorilas.MavenPruebas;

public class DNI {
    public static char calcularLetraDNI(int numeroDNI) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indiceLetra = numeroDNI % 23;
        return letras.charAt(indiceLetra);
    }
}
