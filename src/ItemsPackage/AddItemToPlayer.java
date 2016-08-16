package ItemsPackage;

import Characters.Personajes;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.List;

public class AddItemToPlayer {
    public static Multimap<Personajes,List<Item>> addItemToPlayer1(Personajes pj1,List<Item>listpj1){
        Multimap<Personajes,List<Item>>list= ArrayListMultimap.create();
        list.put(pj1,listpj1);
        return list;
    }
}
