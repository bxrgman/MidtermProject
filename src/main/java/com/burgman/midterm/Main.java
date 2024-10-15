package com.burgman.midterm;

import weka.core.Instances;
public class Main {

    public static void main(String[] args) {
        try {
            DataPreprocessing preprocessing = new DataPreprocessing();

            Instances data = preprocessing.loadDataset("data/train.csv");
            data = preprocessing.handleMissingValues(data);
            data = preprocessing.convertToNominal(data);
            System.out.println("Data Preprocessing is complete!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
