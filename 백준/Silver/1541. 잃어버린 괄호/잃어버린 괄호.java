import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ex = br.readLine();
        String[] minus_items = ex.split("-");

        int min_result = 0;

        for(int i=0; i< minus_items.length; i++){
            String[] plus_items = minus_items[i].split("\\+");
            int minus_sum = 0;
            for(int j=0; j< plus_items.length; j++){
                minus_sum += Integer.parseInt(plus_items[j]);
            }
            if(i == 0) min_result += minus_sum;
            else min_result -= minus_sum;

        }

        System.out.println(min_result);
    }
}