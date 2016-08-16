package ItemsPackage;

import Characters.Personajes;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddItemToPlayer {
    public static List<Item>createItemList(Item...args){
        int i=0;
        Item[] items=new Item[args.length];
        for (Item list:args) {
            items[i]=list;
            i++;
        }
        List<Item>itemList=new ArrayList<Item>(Arrays.asList(items));
        return itemList;
    }
    public static Multimap<Personajes,List<Item>> addItemToPlayer1(Personajes pj1,List<Item>listpj1){
        Multimap<Personajes,List<Item>>list= ArrayListMultimap.create();
        list.put(pj1,listpj1);
        return list;
    }
}
