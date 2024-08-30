import java.io.*;
import java.util.StringTokenizer;

class Main {
    static class Trading {
        private int coin;
        private int stock;

        public Trading(int coin, int stock){
            this.coin = coin;
            this.stock = stock;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public int getCoin() {
            return coin;
        }

        public int getStock() {
            return stock;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int coin = Integer.parseInt(st.nextToken());

        // 준현이의 현금, 주식 수
        Trading JH = new Trading(coin, 0);
        // 성민이의 현금, 주식 수
        Trading SM = new Trading(coin, 0);

        int upCnt = 1;
        int downCnt = 1;

        // 주식 가격 변동 입력
        int[] prices = new int[14];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<14; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<14; i++){
            // 준현 매매
            if(JH.coin >= prices[i]) {
                JH.setStock(JH.coin/prices[i]);
                JH.setCoin(JH.coin - (prices[i] * JH.getStock()));
            }

            // 성민 매매
            if(i==0) continue;

            // 전일 대비 상승
            if(prices[i-1] < prices[i]){
                upCnt ++;
                downCnt = 0;

                // 매도
                if(upCnt == 3){
                    if(SM.getStock() == 0) continue;

                    SM.setCoin(SM.getCoin() + SM.getStock()*prices[i]);
                    SM.setStock(0);
                }
            }

            // 전일 대비 하락
            else if(prices[i-1] > prices[i]){
                upCnt = 0;
                downCnt ++;

                // 매수
                if(downCnt == 3){
                    if(SM.getCoin() == 0) continue;

                    SM.setStock(SM.coin/prices[i]);
                    SM.setCoin(SM.coin - (prices[i] * SM.getStock()));
                }
            }
        }

        // 마지막 날 보유 자산 계산
        int assetJH = JH.getCoin() + (prices[13] * JH.getStock());
        int assetSM = SM.getCoin() + (prices[13] * SM.getStock());

        if(assetJH > assetSM) System.out.println("BNP");
        else if(assetJH < assetSM) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }


}