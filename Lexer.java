class Lexer {
    static final int ERROR = -1;
    static final int ACEPTAR = 0;

    private String[] entradas = {"abaab", "abaaa", "bbabb"};
    private int entradaActual = 0;
    private int indice = 0;

    char obtenerCaracter() {
        if (entradaActual < entradas.length && indice < entradas[entradaActual].length()) {
            return entradas[entradaActual].charAt(indice++);
        } else {
            entradaActual++;
            indice = 0;
            if (entradaActual < entradas.length) {
                return entradas[entradaActual].charAt(indice++);
            }
        }
        return '\0'; // Retorna '\0' cuando todas las entradas se han agotado.
    }

    int estado_0() {
        char c = obtenerCaracter();
        switch (c) {
            case 'a':
                return estado_1();
            case 'b':
                return estado_4();
            default:
                return ERROR;
        }
    }

    int estado_1() {
        char c = obtenerCaracter();
        switch (c) {
            case 'a':
                return estado_1();
            case 'b':
                return estado_2();
            default:
                return ERROR;
        }
    }

    int estado_2() {
        char c = obtenerCaracter();
        switch (c) {
            case 'a':
                return estado_1();
            case 'b':
                return estado_3();
            default:
                return ERROR;
        }
    }

    int estado_3() {
        return ACEPTAR;
    }

    int estado_4() {
        char c = obtenerCaracter();
        switch (c) {
            case 'a':
                return estado_1();
            case 'b':
                return estado_4();
            default:
                return ERROR;
        }
    }

    public static void main(String[] args) {
        Lexer lexer = new Lexer();

        for (int i = 0; i < 3; i++) {
            System.out.println("Resultado " + (i + 1) + ": " + lexer.estado_0());
        }
    }
}
