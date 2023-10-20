package day01_Lambda_Practice;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda01 {
    public static void main(String[] args) {

        List<Integer> sayi =new ArrayList<>(Arrays.asList(-5,-8,-12,0,1,12,5,5,6,9,15,8));
        ciftVePozitifLambdaExpression(sayi);
        System.out.println("\n ****************");
        ciftVePozitifMethodReferences(sayi);
        System.out.println("\n ****************");
        kare(sayi);
        System.out.println("\n ****************");
        kareTekrarsız(sayi);
        System.out.println("\n ****************");
        buyuktenKucuge(sayi);
        System.out.println("\n ****************");
        pozitifKupBirlerBasamagı(sayi);
        System.out.println("\n ****************");
        toplamiMethodReferance(sayi);
        System.out.println("\n ****************");
        toplamiLambdaExpretion(sayi);
        System.out.println("\n ****************");
        System.out.println(pozitifCarpimLambdaExpression(sayi));
        System.out.println("\n ****************");
        System.out.println(ciftElemanlarınKaeleri(sayi));

    }
//SORU1: List elemanlarının çift ve pozitif olanlarını,
// Lambda Expression kullanarak aralarında bosluk olacak sekilde yazdırın

    public static void ciftVePozitifLambdaExpression(List<Integer>sayi){
     //1.yol
        sayi.stream().filter(t->t%2==0 && t>0).forEach(t-> System.out.print(t+" "));
      //2.yol
        sayi.stream().filter(t->t%2==0).filter(t->t>0).forEach(t-> System.out.print(t+" "));
    }

//SORU2: List elemanlarının çift ve pozitif olanlarını,
// Method Referances kullanarak aralarında bosluk olacak sekilde yazdırın

public static void ciftVePozitifMethodReferences(List<Integer>sayi){
      sayi.stream().filter(Utils::ciftPozitifBul).forEach(Utils::yazdir);

}
//SORU3: List elemanlarının karelerini, aralarında boşluk olacak şekilde yazdırın
    public static void kare (List<Integer>sayi){
sayi.stream().map(t->t*t).forEach(Utils::yazdir);
    }
//SORU4 : List elemanlarının karelerini, tekrarsiz yazdırın
    public static void kareTekrarsız (List<Integer>sayi){
       sayi.stream().map(t->t*t).distinct().forEach(Utils::yazdir);
    }

//SORU5: List elemanlarını büyükten küçüğe sıralayarak yazdırın

    public static void buyuktenKucuge (List<Integer>sayi){
       sayi.stream().sorted(Comparator.reverseOrder()).forEach(Utils::yazdir);
    }
// SORU6 : List elemanlarının pozitif olanlarının, kuplerini bulup,
// birler basamagı 5 olanları yazdırınız

public static void pozitifKupBirlerBasamagı (List<Integer>sayi){
        sayi.
                stream().
                filter(t->t>0).
                map(t->t*t*t).
                filter(t->t%10==5).//bir sayının 10 a bölümünden birler basamağı 5 olanlarını yazdı.
                forEach(Utils::yazdir);
}
// SORU7: List elemanlarının Method References ile toplamını bulun ve yazdırın
public static void toplamiMethodReferance(List<Integer>sayi){
   //1.yol
    Optional<Integer> sonuc= sayi.stream().reduce(Integer::sum);
    System.out.println(sonuc);

    //2.yol
  int sonucc=  sayi.stream().reduce(Integer::sum).get();
}
// SORU8: List elemanlarının Lambda Expression
// ile toplamını bulun ve yazdırın
    public static void toplamiLambdaExpretion (List<Integer>sayi){
      int sonucc=  sayi.stream().reduce(0,(a,b)->a+b);
        System.out.println(sonucc);
    }
//SORU9 : Listin pozitif elemanlarının, carpımını
// Lambda Expression ile return ederek yazdırın
public static int pozitifCarpimLambdaExpression(List<Integer>sayi){
     int sonuc= sayi.stream().filter(t->t>0).reduce(1,(a,b)->a*b);
     return sonuc;
}

//SORU10 : Listin cift elemanlarının, karelerini, kucukten buyuge sıralayıp
// list halinde return ederek yazdırınız
    public static List<Integer> ciftElemanlarınKaeleri (List<Integer>sayi){
      List<Integer> list=  sayi.stream().filter(t->t%2==0).map(t->t*t).sorted().collect(Collectors.toList());
        return list;
    }

}