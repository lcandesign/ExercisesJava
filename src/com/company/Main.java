package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        enterData(new Scanner(System.in));
    }

    private static void enterData(Scanner keyboard){
        String word;
        System.out.print("Introduzca la palabra a evaluar y presione ENTER: ");
        word = keyboard.nextLine();
        if (word.isEmpty()){
            System.out.println("Debe ingresar una palabra");
            enterData(new Scanner(System.in));
        } else {
            countWords(word);
        }
    }


    private static void countWords(String key){
        String [] exploded = key.split(" ");
        Arrays.sort(exploded);
        HashSet<String> hs = new HashSet<>(Arrays.asList(exploded));

        String [] explodedAux = hs.toArray(String[]::new);
        Arrays.sort(explodedAux);

        StringBuilder result = new StringBuilder();
        for (String aux : explodedAux) {
            int counter = 0;
            result.append("(").append(aux);
            for (String s : exploded) {
                if (s.equals(aux)) {
                    counter++;
                }
            }
            if (counter > 0) {
                result.append(") aparece ").append(counter).append(counter == 1 ? " vez\n" : " veces\n");
            }
        }
        System.out.println(result);
        enterData(new Scanner(System.in));
    }
}
