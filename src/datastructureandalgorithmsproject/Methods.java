/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructureandalgorithmsproject;

/**
 *
 * @author evrim
 */
public class Methods {

    public int getLength(String s) {
        int counter = 0;

        try {
            while (true) {
                s.charAt(counter);
                counter++;
            }
        } catch (Exception e) {
            return counter;
        }
    }

    public boolean isSameText(String s1, String s2) {
        int l1 = getLength(s1);
        int l2 = getLength(s2);

        if (l1 != l2) {
            return false;
        } else {
            for (int i = 0; i < l1; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isContainsComa(String line) {

        for (int i = 0; i < getLength(line); i++) {

            if (line.charAt(i) == ',') {
                return true;
            }
        }
        return false;
    }

    public String parse(String line, int index) {

        if (isContainsComa(line) == false) {

            return line;

        }

        int counter = 0;

        int commaCount = 0;

        String firstİndex = "";

        String secondİndex = "";

        String thirdİndex = "";

        String temp = "";

        while (counter < getLength(line)) {

            if (line.charAt(counter) == ',' && commaCount == 0) {
                firstİndex = temp;
                temp = "";
                commaCount++;
                counter += 2;
            } else if (line.charAt(counter) == ',' && commaCount == 1) {
                secondİndex = temp;
                temp = "";
                commaCount++;
                counter += 2;
            }

            temp += line.charAt(counter);

            counter++;

        }

        thirdİndex = temp;

        switch (index) {
            case 1:
                return firstİndex;

            case 2:
                return secondİndex;

            case 3:
                return thirdİndex;

            default:
                return "False Statement";
        }
    }

    public int dotCounter(String path) {

        int counter = 0;

        for (int i = 0; i < getLength(path); i++) {
            if (path.charAt(i) == '.') {
                counter++;
            }
        }

        return counter;

    }

}
