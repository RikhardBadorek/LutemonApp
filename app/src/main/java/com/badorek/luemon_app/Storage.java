package com.badorek.luemon_app;

import java.util.ArrayList;

public class Storage {
    ArrayList<Lutemon> lutemons = new ArrayList<>();

    ArrayList<Integer> selectedLutemonPositions = new ArrayList<>();

    private static Storage lutemonStorage = null;

    public Storage(){

    }

    public static Storage getInstance() {
        if(lutemonStorage == null){
            lutemonStorage = new Storage();
        }
        return lutemonStorage;
    }
    public void addSelectedLutemons(Integer position) {
        if (selectedLutemonPositions.indexOf(position) == -1){
            selectedLutemonPositions.add(position);
        }
    }
    public void removeSelectedLutemons(Integer position) {
        selectedLutemonPositions.remove(selectedLutemonPositions.indexOf(position));
    }
    public ArrayList<Lutemon> getSelectedLutemons() {
        ArrayList<Lutemon> selcetedLutemons = new ArrayList<>();
        for (Integer i: selectedLutemonPositions) {
            selcetedLutemons.add(lutemons.get(i));
        }
        return selcetedLutemons;
    }
    public void addLutemon(Lutemon lutemon){
        lutemons.add(lutemon);
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public void removeLutemon(String name){
        int i = 0;
        for(Lutemon l : lutemons){
            if (l.getName().equals(name)){
                break;
            }
            i++;
        }
        lutemons.remove(i);
    }
}
