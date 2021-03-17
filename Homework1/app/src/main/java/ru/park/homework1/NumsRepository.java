package ru.park.homework1;

import java.util.ArrayList;

public class NumsRepository {

    public static int getNumAt(int position) {
        return getInstance().numsList.get(position);
    }

    public static int getNumsCount() {
        return getInstance().numsList.size();
    }

    public static int appendNum() {
        ArrayList<Integer> nums = getInstance().numsList;
        nums.add(nums.size() + 1);
        return nums.size() - 1;
    }

    private static NumsRepository getInstance() {
        if (instance == null)
            instance = new NumsRepository();
        return instance;
    }

    private NumsRepository() {
        for (int i = 0; i < 100; i++)
            numsList.add(i + 1);
    }

    private ArrayList<Integer> numsList = new ArrayList<>();
    private static NumsRepository instance;
}
