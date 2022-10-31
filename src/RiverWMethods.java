import java.util.Scanner;

class RiverM {
    String name;
    String place;
    double lengthD;
}
public class RiverWMethods {
    public static void main(String[] args) {
        RiverM reka[] = setRiverArr();
        showArray(reka);
        minInArr(reka);
        showMoreMid(reka);
        sortArray(reka);
        FindAndRedactE(reka);
    }

    public static RiverM[] setRiverArr() {
        Scanner sc = new Scanner(System.in,"UTF-8");
        System.out.println("Введіть кількість річок: ");
        int n = sc.nextInt();
        RiverM reka[]=new RiverM[n];
        System.out.println("Введіть інформацію про річки:");

        for (int i=0;i<reka.length;i++) {
            sc.nextLine();
            reka[i]=new RiverM();
            System.out.print("Назва "+(i+1)+"-ї річки => ");
            reka[i].name=sc.nextLine();
            System.out.print("Місце росташування "+(i+1)+"-ї річки => ");
            reka[i].place=sc.nextLine();
            System.out.print("Довжина "+(i+1)+"-ї річки => ");
            reka[i].lengthD =sc.nextDouble();
        }
        return reka;
    }
    public static void showArray(RiverM[] riv) {
        for(int i =0;i<riv.length;i++)
            System.out.println(" "+riv[i].name+"\t"+riv[i].place+"\t"+riv[i].lengthD +" км");
    }
    public static void minInArr(RiverM[] riv) {
        int nommin=0;
        double min = riv[nommin].lengthD;
        for(int i=0;i<riv.length;i++)
            if(riv[i].lengthD <min) {
                min = riv[i].lengthD;
                nommin=i;
            }
        System.out.println("\nРічка з мінімальною довжиною");
        System.out.println(""+riv[nommin].name+"\t"+riv[nommin].place+"\t"+riv[nommin].lengthD +" км");
    }
    public static void showMoreMid(RiverM[] riv) {
        double sl = 0;
        for(int i=0;i<riv.length;i++)
            sl+=riv[i].lengthD;
        double mid = sl/riv.length;
        System.out.println("Середня площа = "+mid);
        System.out.println("\nРічки, з площею більше середньої: ");
        for(int i=0;i<riv.length;i++){
            if(riv[i].lengthD >mid)
                System.out.println(riv[i].name+"\t"+riv[i].place+"\t"+riv[i].lengthD +" км");

        }
    }
    public static void sortArray(RiverM[] riv) {
        for(int i=0;i<riv.length-1; i++)
            for(int j=0;j<riv.length-i-1;j++)
                if(riv[j].name.compareTo(riv[i+1].name)>0) {
                    RiverM rab=riv[j];
                    riv[j]=riv[j+1];
                    riv[j+1]=rab;
                }
        System.out.println("\nВідсортований список за назвою: ");
        for(int i=0;i<riv.length;i++)
            System.out.println(""+riv[i].name+"\t"+riv[i].place+"\t"+riv[i].lengthD+" км");
    }
    public static void FindAndRedactE(RiverM[] riv) {
        Scanner sc = new Scanner(System.in,"UTF-8");
        sc.nextLine();
        System.out.println("Введіть назву шуканої річки => ");
        String name = sc.nextLine();
        int nom=-1;
        for(int i=0;i<riv.length;i++)
            if(name.equalsIgnoreCase(riv[i].name)) nom=i;
        if(nom!=-1) {
            System.out.println("Така річка є у списку. Це "+riv[nom].name+"\t"+riv[nom].place+"\t"+riv[nom].lengthD+" км");
            System.out.println("Чи бажаєте ви редагувати інформацію про річку? 1 = так / 2 = ні");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice==1) {
                System.out.println("Що саме ви бажаєте редагувати? 1 = назву / 2 = місце / 3 = довжину");
                int choice2 = sc.nextInt();
                sc.nextLine();
                if(choice2==1){
                    System.out.println("Введіть нову назву: ");
                    riv[nom].name = sc.nextLine();
                }
                if(choice2==2){
                    System.out.println("Введіть нове місце: ");
                    riv[nom].place = sc.nextLine();
                }
                if(choice2==3){
                    System.out.println("Введіть нову довжину: ");
                    riv[nom].lengthD = sc.nextDouble();
                }
                System.out.println("Нова характеристика річки: "+riv[nom].name+"\t"+riv[nom].place+"\t"+riv[nom].lengthD+" км");
            }
            else {
                System.out.println("Ви не бажаєте редагувати інформацію про річку.");
            }
        }
    }
}
