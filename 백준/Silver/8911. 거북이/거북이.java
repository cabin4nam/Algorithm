import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Point{
        int x;
        int y;
        int d; // 방향 0:상, 1:우, 2:하, 3:좌

        public Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int[] moveY = {1, 0, -1, 0};
    static int[] moveX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int T = Integer.parseInt(br.readLine());

       for(int t = 0; t<T; t++){
           String command = br.readLine();
           char[] commandArr = command.toCharArray();

           System.out.println(moveTurtle(commandArr));

       }

    }

    private static int moveTurtle(char[] command){
        int max_x = 0, max_y = 0;
        int min_x = 0, min_y = 0;

        Point turtle = new Point(0,0,0);

        for(char c : command){
            if(c == 'L' || c == 'R'){
                turtle.d = c=='L' ? (turtle.d + 3) % 4 :  (turtle.d + 1) % 4;
                continue;
            }

            if(c=='F'){
                turtle.x +=  moveX[turtle.d];
                turtle.y += moveY[turtle.d];
            }
            else if(c=='B'){
                turtle.x -= moveX[turtle.d];
                turtle.y -= moveY[turtle.d];
            }

            if(max_x < turtle.x) max_x = turtle.x;
            if(min_x > turtle.x) min_x = turtle.x;
            if(max_y < turtle.y) max_y = turtle.y;
            if(min_y > turtle.y) min_y = turtle.y;
        }
        return (max_x - min_x) * (max_y - min_y);
    }

}