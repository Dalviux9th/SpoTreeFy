public class ControlString {
    // Clase de manejo de String (agrega métodos)

    public boolean esMayor(String strA, String strB) {
        // Devuelve true si A es mayor que B en el orden alfanumérico.

        boolean resultado;
        int pos = 0;
        while (pos < strA.length() && pos < strB.length() && strA.charAt(pos) == strB.charAt(pos)) {
            pos ++;
        }

        // En este punto "pos" apunta al primer caracter discordante entre ambas.

        if (pos >= strA.length() || pos >= strB.length()) {     // Al menos una llegó a su fin.

            if (pos >= strA.length() && pos < strB.length()) {  // UNICO caso donde A será mayor
                resultado = true;                               // A es más corta que B siendo sus caracteres idénticos
            } else {
                resultado = false;
            }

        } else {                                                // Ambas tienen un carcater en "pos" (y son diferentes)
            resultado = (strA.charAt(pos) > strB.charAt(pos));
        }

        return resultado;
    }
}
