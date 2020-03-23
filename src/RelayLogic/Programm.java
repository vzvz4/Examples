package RelayLogic;

public class Programm {
    static boolean k1 = true;
    static boolean k2 = false;
    static boolean k3 = false;
    static boolean k4 = true;
    static boolean k5 = true;
    static boolean k6 = false;
    static boolean k7 = true;
    static boolean lamp = false;

 public static void mainLogic() {
     if (!k1){
         k3 = true;
         k4 = false;
         lamp = true;
     } else {
         k3 = false;
         k4 = true;
         lamp = false;
     }
     if (k2) {
         k3 = false;
         k4 = true;
         lamp = false;
     } else {
         k3 = true;
         k4 = false;
     }
     if (!k4) {
         k1 = false;
         lamp = true;
     }else {
         k1 = true;
         lamp = false;
     }
     if(k1&&!k2)
     System.out.println("Лампа включена");
     else System.out.println("Лампа выключена");
 }
    public static void main(String[] args) throws InterruptedException {
        mainLogic();

        k1 = false; //включили рубильник
        Thread.sleep(1000);
        mainLogic();

        k4 = true; //включили рубильник
        Thread.sleep(1000);
        mainLogic();
    }

}
