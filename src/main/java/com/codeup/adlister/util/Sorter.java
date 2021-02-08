package com.codeup.adlister.util;

import com.codeup.adlister.models.Drink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorter {

    public static List<Drink> sortDrinkByVotes(List<Drink> drinkList){
        Drink[] drinkArr = stringListToArray(drinkList);
        for(int i = 0; i < drinkArr.length - 1; i++){
            int backwards = i;
            while(backwards >= 0 && drinkArr[backwards].getVotes() < drinkArr[backwards + 1].getVotes()){
                swap(backwards, backwards + 1, drinkArr);
                backwards--;
            }
        }
        return arrToStringList(drinkArr);
    }

    public static List<Drink> sortDrinksByName(List<Drink> drinkList){
        Drink[] drinkArr = stringListToArray(drinkList);
        for(int i = 0; i < drinkArr.length - 1; i++){
            int backwards = i;
            while(backwards >= 0 && drinkArr[backwards].getName().compareTo(drinkArr[backwards + 1].getName()) > 0){
                swap(backwards, backwards + 1, drinkArr);
                backwards--;
            }
        }
        return arrToStringList(drinkArr);
    }

    private static List<Drink> arrToStringList(Drink[] drinkArr){
        return new ArrayList<>(Arrays.asList(drinkArr));
    }
    private static Drink[] stringListToArray(List<Drink> drinkList){
        Drink[] out = new Drink[drinkList.size()];
        for(int i = 0; i < drinkList.size(); i++){
            out[i] = drinkList.get(i);
        }
        return out;
    }

    private static void swap(int i, int j, Drink[] drinkList){
        Drink temp = drinkList[i];
        drinkList[i] = drinkList[j];
        drinkList[j] = temp;
    }

}
