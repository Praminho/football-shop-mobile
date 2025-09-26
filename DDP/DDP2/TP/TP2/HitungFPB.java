public class HitungFPB {
    public static void main (String[] args){

        int x = 3;
        int y = 4;
        int hasil = hitungFPB(x, y);
        System.out.println(hasil);
    }
    public static int hitungFPB(int x, int y) {
        int pembagi = (x > y)? y:x;

           while (!(((x % pembagi) == 0 )&& (((y % pembagi) == 0)))){
                pembagi -= 1;
           }
           
           return pembagi;
        
    }
}