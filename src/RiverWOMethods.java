import java.util.Scanner;
class River {
    String name;
    String place;
    double lengthD;
}
public class RiverWOMethods {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in,"UTF-8");

    System.out.println("Введіть кількість річок => ");
    int n=sc.nextInt();
    River reka[]=new River[n];
    System.out.println("Введіть інформацію про річки:");

    for (int i=0;i<reka.length;i++) {
        sc.nextLine();
        reka[i]=new River();
        System.out.print("Назва "+(i+1)+"-ї річки => ");
        reka[i].name=sc.nextLine();
        System.out.print("Місце росташування "+(i+1)+"-ї річки => ");
        reka[i].place=sc.nextLine();
        System.out.print("Довжина "+(i+1)+"-ї річки => ");
        reka[i].lengthD =sc.nextDouble();
    }
    System.out.println("\nХарактеристика річок: ");
    for (River riv: reka)
        System.out.println(" "+riv.name+"\t"+riv.place+"\t"+riv.lengthD +" км");

    int nommin=0;
    double min = reka[nommin].lengthD;
    for(int i=0;i<reka.length;i++)
        if(reka[i].lengthD <min) {
            min = reka[i].lengthD;
            nommin=i;
        }
    System.out.println("\nРічка з мінімальною довжиною");
    System.out.println(""+reka[nommin].name+"\t"+reka[nommin].place+"\t"+reka[nommin].lengthD +" км");

    double sl = 0;
    for(int i=0;i<reka.length;i++)
        sl+=reka[i].lengthD;
    double mid = sl/reka.length;
    System.out.println("Середня площа = "+sl);
    System.out.println("\nРічки, з площею більше середньої: ");
    for(int i=0;i<reka.length;i++){
        if(reka[i].lengthD >sl)
            System.out.println(reka[i].name+"\t"+reka[i].place+"\t"+reka[i].lengthD +" км");

    }

    for(int i=0;i<reka.length-1; i++)
        for(int j=0;j<reka.length-i-1;j++)
            if(reka[j].name.compareTo(reka[i+1].name)>0) {
                River rab=reka[j];
                reka[j]=reka[j+1];
                reka[j+1]=rab;
            }
    System.out.println("\nВідсортований список за назвою: ");
    for(int i=0;i<reka.length;i++)
        System.out.println(""+reka[i].name+"\t"+reka[i].place+"\t"+reka[i].lengthD+" км");

    sc.nextLine();
    System.out.println("Введіть назву шуканої річки => ");
    String name = sc.nextLine();
    int nom=-1;
    for(int i=0;i<reka.length;i++)
        if(name.equalsIgnoreCase(reka[i].name)) nom=i;
    if(nom!=-1) {
        System.out.println("Така річка є у списку. Це "+reka[nom].name+"\t"+reka[nom].place+"\t"+reka[nom].lengthD+" км");
        System.out.println("Чи бажаєте ви редагувати інформацію про річку? 1 = так / 2 = ні");
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice==1) {
            System.out.println("Що саме ви бажаєте редагувати? 1 = назву / 2 = місце / 3 = довжину");
            int choice2 = sc.nextInt();
            sc.nextLine();
            if(choice2==1){
                System.out.println("Введіть нову назву: ");
                reka[nom].name = sc.nextLine();
            }
            if(choice2==2){
                System.out.println("Введіть нове місце: ");
                reka[nom].place = sc.nextLine();
            }
            if(choice2==3){
                System.out.println("Введіть нову довжину: ");
                reka[nom].lengthD = sc.nextDouble();
            }
            System.out.println("Нова характеристика річки: "+reka[nom].name+"\t"+reka[nom].place+"\t"+reka[nom].lengthD+" км");
        }
        else {
            System.out.println("Ви не бажаєте редагувати інформацію про річку.");
        }
    }
 }
}






















