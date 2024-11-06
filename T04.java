// 12S24008 - ROSPIKA SARAH YOSEFIN SIREGAR
// 12S24013 - ADRYANN JULIANTO PANJAITAN


import java.util.*;
import java.lang.Math;

public class Program {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] arrISBN = new String[3];
        String iSBN;
        double[] arrharga = new double[3];
        double harga;
        int[] arrquantity = new int[3];
        int quantity;
        double totalharga;
        boolean var_continue;
        int x, y;

        x = 3;
        for (y = 0; y <= x - 1; y++) {
            arrISBN[y] = "";
            arrharga[y] = 0;
            arrquantity[y] = 0;
        }
        totalharga = 0;
        var_continue = true;
        while (var_continue == true) {
            iSBN = input.nextLine();
            if (iSBN.equals("---")) {
                var_continue = false;
            } else {
                harga = input.nextDouble();
                quantity = input.nextInt();
                boolean exist;

                exist = false;
                y = 0;
                do {
                    if (arrISBN[y].equals(iSBN)) {
                        arrquantity[y] = arrquantity[y] + quantity;
                        exist = true;
                    } else {
                        y = y + 1;
                    }
                } while (!exist && y < x);
                if (!exist) {
                    boolean tepat;

                    tepat = false;
                    int z;

                    z = 0;
                    do {
                        if (arrquantity[z] == 0) {
                            tepat = true;
                        } else {
                            z = z + 1;
                        }
                    } while (!tepat && z < x);
                    arrISBN[z] = iSBN;
                    arrharga[z] = harga;
                    arrquantity[z] = quantity;
                    z = z + 1;
                }
            }
        }
        for (y = 0; y <= x - 1; y++) {
            double hargaproduk;

            hargaproduk = arrharga[y];
            if (arrquantity[y] >= 20) {
                hargaproduk = arrharga[y] - 12 / 100 * arrharga[y];
            } else {
                if (arrquantity[y] >= 10) {
                    hargaproduk = arrharga[y] - 10 / 100 * arrharga[y];
                } else {
                    if (arrquantity[y] >= 5) {
                        hargaproduk = arrharga[y] - 2 / 100 * arrharga[y];
                    }
                }
                totalharga = totalharga + hargaproduk * arrquantity[y];
            }
        }
        System.out.println(toFixed(totalharga,2));
    }
    
    private static String toFixed(double value, int digits) {
        return String.format("%." + digits + "f", value);
    }
}
