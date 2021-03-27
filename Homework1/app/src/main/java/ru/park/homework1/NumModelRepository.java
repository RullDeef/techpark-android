package ru.park.homework1;

import android.os.Bundle;

import java.util.ArrayList;

public class NumModelRepository {

    private static final int START_NUMS_COUNT = 100;
    private static final String BUNDLE_REPO_STATE = "bundle_repo_state";
    private static NumModelRepository instance;
    private final ArrayList<NumModel> data = new ArrayList<>();

    private NumModelRepository() {
        for (int i = 1; i <= START_NUMS_COUNT; i++)
            data.add(new NumModel(i));
    }

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

    public static void saveRepo(Bundle outState) {
        outState.putInt(BUNDLE_REPO_STATE, getInstance().data.size());
    }

    public static void initRepo(Bundle state) {
        if (state == null)
            instance = new NumModelRepository();
        else {
            int dataSize = state.getInt(BUNDLE_REPO_STATE, 0);
            for (int i = getInstance().data.size(); i < dataSize; i++)
                appendNum();
        }
    }
}
