package oop.inheritance.hunters;

import fileworks.DataImport;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Loviste {
    static void randomJob(Hunter h, String job){
            switch (job){
                case "Hunter": {
                    h.hunt();
                }
                case "Soldier":{
                    if (h instanceof Soldier){
                        ((Soldier) h).killBandit();
                    } else h.setGolds(h.golds - 10);

                }
                case "Witcher":{
                    if (h instanceof Witcher) {
                        ((Witcher) h).killMonster();
                    } else h.setGolds(h.golds - 10);
                }
            }
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/hunters.txt");
        List<Hunter> hunters = new ArrayList<>();

        while (di.hasNext()){
            int i=0;
            String[] lineParts = di.readLine().split(",");
            switch (lineParts[1]){
                case "Hunter": hunters.add(new Hunter(lineParts[0]));
                case "Soldier": hunters.add(new Soldier(lineParts[0]));
                case "Witcher": hunters.add(new Witcher(lineParts[0]));
            }
            for (int j = 0; j < lineParts.length-2; j++) {

            }
            i++;
        }


        int topGold = Integer.MIN_VALUE;
        String topGoldName ="";

        for (Hunter h : hunters){
            System.out.println(h.name +" made "+ h.golds);
            if (h.golds > topGold){
                topGoldName = h.name;
                topGold=h.golds;
            }
        }
        System.out.println("Most golds made "+topGoldName+" and it was "+ topGold);

        di.finishImport();
    }
}
