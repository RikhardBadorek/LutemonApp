package com.badorek.luemon_app;

import android.content.Context;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    public void removeSelectedLutemons() {
        selectedLutemonPositions.clear();
    }
    public ArrayList<Lutemon> getSelectedLutemons() {
        ArrayList<Lutemon> selcetedLutemons = new ArrayList<>();
        for (Integer i: selectedLutemonPositions) {
            selcetedLutemons.add(lutemons.get(i));
        }
        return selcetedLutemons;
    }

    public Integer getSelectedLutemonsCount() {
        int i = getSelectedLutemons().size();
        return i;
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

    public void saveLutemons(Context context){
        ObjectOutputStream lutemoWriter = null;
        try {
            lutemoWriter = new ObjectOutputStream(context.openFileOutput("lutemons.data", Context.MODE_PRIVATE));
            lutemoWriter.writeObject(lutemons);
            lutemoWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void loadLutemons(Context context){
        ObjectInputStream lutemonReader = null;
        try {
            lutemonReader = new ObjectInputStream(context.openFileInput("lutemons.data"));
            lutemons = (ArrayList<Lutemon>) lutemonReader.readObject();
            lutemonReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
