package ru.park.homework1;

import java.util.ArrayList;

public class NumModelRepository {

    public static NumModel getNumAt(int position) {
        return getInstance().data.get(position);
    }

    public static int getNumsCount() {
        return getInstance().data.size();
    }

    public static int appendNum() {
        ArrayList<NumModel> nums = getInstance().data;
        int newNumber = nums.size() + 1;
        nums.add(new NumModel(newNumber));
        return nums.size() - 1;
    }

    private static NumModelRepository getInstance() {
        if (instance == null)
            instance = new NumModelRepository();
        return instance;
    }

    private NumModelRepository() {
        for (int i = 1; i <= 100; i++)
            data.add(new NumModel(i));
    }

    private final ArrayList<NumModel> data = new ArrayList<>();
    private static NumModelRepository instance;
}
