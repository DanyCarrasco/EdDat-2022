/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjuntistas;

/**
 *
 * @author casa
 */
public class ArbolHeap {

    private Comparable[] heap;
    private int ultimo;
    private int TAMANIO = 20;

    public ArbolHeap() {
        this.heap = new Comparable[TAMANIO];
        this.ultimo = 0;
    }

    public boolean insertar(Comparable elem) {
        boolean res = false;
        Comparable a;
        //Incrementa el ultimo de ArbolHeap
        this.ultimo++;
        if (this.ultimo < TAMANIO) {
            if (ultimo == 1) {
                //Si es la raiz, ingresa el elemento
                this.heap[ultimo] = elem;
                res = true;
            } else {
                //Ingresa el nuevo elemento como ultima hoja
                this.heap[ultimo] = elem;
                // reestablece la propiedad de heap minimo
                hacerSubir(ultimo);
                res = true;
            }
        }
        return res;
    }

    public void hacerSubir(int posHijo) {
        int posP;
        boolean salir = false;

        while (!salir) {
            posP = posHijo / 2;
            Comparable temp = this.heap[posHijo];
            if (posP > 0) {
                if (this.heap[posHijo].compareTo(this.heap[posP]) < 0) {
                this.heap[posHijo] = this.heap[posP];
                this.heap[posP] = temp;
                posHijo = posP;
            } else {
                //el hijo es mayor que su padre, esta bien ubicado 
                salir = true;
            }
            } else {
                // el temp es raiz, esta bien ubicado
                salir = true;
            }
        }
    }

    public boolean eliminarCima() {
        boolean exito;
        if (this.ultimo == 0) {
            //estructura vacia
            exito = false;
        } else {
            // saca la raiz y pone la ultima hoja en su lugar
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            // reestablece la propiedad de heap minimo
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }

    private void hacerBajar(int posPadre) {
        int posH;
        Comparable temp = this.heap[posPadre];
        boolean salir = false;

        while (!salir) {
            posH = posPadre * 2;
            if (posH <= this.ultimo) {
                //temp tiene al menos un hijo (izq) y lo considera menor

                if (posH < this.ultimo) {
                    //hijoMenor tiene hermano derecho

                    if (this.heap[posH + 1].compareTo(this.heap[posH]) < 0) {
                        // el hijo derecho es el menor de los dos
                        posH++;
                    }
                }

                //compara al hijo menor con el padre, los intercambia
                if (this.heap[posH].compareTo(temp) < 0) {
                    // el hijo menor que el padre, los intercambia
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                    posPadre = posH;
                } else {
                    // el padre es menor que sus hijos, esta bien ubicado
                    salir = true;
                }
            } else {
                // el temp es hoja, esta bien ubicado
                salir = true;
            }
        }
    }
    
    public Comparable recuperarCima(){
        return this.heap[1];
    }

    public boolean esVacio() {
        return this.ultimo == 0;
    }

    public String toString() {
        String cadena = "Arbol vacio";
        if (this.ultimo != 0) {
            cadena = "[";
            for (int i = 1; i <= ultimo; i++) {
                cadena = cadena + this.heap[i].toString();
                if (i < ultimo) {
                    cadena = cadena + ", ";
                }
            }
            cadena = cadena + "]";
        }
        return cadena;
    }
}
