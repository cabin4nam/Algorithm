import java.io.*;
import java.util.StringTokenizer;
class Counsel {
    private int period;
    private int price;

    public Counsel(int period, int price){
        this.period = period;
        this.price = price;
    }

    public int getPeriod() {
        return period;
    }

    public int getPrice() {
        return price;
    }
}

class Main {
    private static int maxPrice = 0;
    private static int totalDay = 0;
    private static Counsel[] counsels;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        totalDay = Integer.parseInt(st.nextToken());

        counsels = new Counsel[totalDay+1];
        for(int i=1; i<=totalDay; i++){
            st = new StringTokenizer(br.readLine());
            int period = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            counsels[i] = new Counsel(period, price);
        }

        for(int i=1; i<=totalDay; i++){
            doCounsel(i, 0);
        }

        System.out.println(maxPrice);
    }

    private static void doCounsel(int startDay, int price){
        // 상담 진행 -> price 업데이트
        int prePrice = price + counsels[startDay].getPrice();

        // 다음 상담 가능한 날짜로 이동
        int nextDay = startDay + counsels[startDay].getPeriod();

        // 만약 다음 상담 가능한 날짜가 totalDay 보다 크면, maxPrice = prePrice, return
        if(nextDay-1 <= totalDay){
            maxPrice = Math.max(maxPrice, prePrice);
        }

        if(nextDay > totalDay) return;

        for(int i=nextDay; i<=totalDay; i++){
            doCounsel(i, prePrice);
        }

    }
}