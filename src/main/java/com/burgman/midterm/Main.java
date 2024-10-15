package com.burgman.midterm;

import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
public class Main {

    public static void main(String[] args) {
        try {
            // Initializes Data Preprocessing
            DataPreprocessing preprocessing = new DataPreprocessing();

            // Load the dataset
            Instances data = preprocessing.loadDataset("data/train.csv");

            // Handles any missing values
            data = preprocessing.handleMissingValues(data);

            // Converts attributes to nominal (if necessary)
            data = preprocessing.convertToNominal(data);

            // Model Training
            ModelTrainer trainer = new ModelTrainer();

            // Linear Regression Model here and evaluates
            LinearRegression model = trainer.trainModel(data);
            trainer.evaluateModel(model, data);

            System.out.println("Model Training and Evaluation Complete!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
