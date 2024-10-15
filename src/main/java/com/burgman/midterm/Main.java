package com.burgman.midterm;

import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;

public class Main {

    public static void main(String[] args) {
        try {
            // Step 1: Initialize Data Preprocessing
            DataPreprocessing preprocessing = new DataPreprocessing();

            // Step 2: Load the dataset from CSV file located in the data directory
            Instances data = preprocessing.loadDataset("data/train.csv");

            // Step 3: Handle any missing values in the dataset
            data = preprocessing.handleMissingValues(data);

            // Step 4: Convert string attributes to nominal (categorical), required for Linear Regression
            // String attributes (if present) are converted to nominal to avoid issues in model training
            data = preprocessing.convertStringToNominal(data);

            // Step 5: Convert numeric or other attributes to nominal if necessary
            // This ensures categorical attributes are handled correctly by the model
            data = preprocessing.convertToNominal(data);

            // Step 6: Initialize Model Trainer for Linear Regression
            ModelTrainer trainer = new ModelTrainer();

            // Step 7: Train the Linear Regression model on the preprocessed dataset
            LinearRegression model = trainer.trainModel(data);

            // Step 8: Evaluate the trained model using cross-validation and print evaluation metrics
            trainer.evaluateModel(model, data);

            // Final output: Notify that model training and evaluation are complete
            System.out.println("Model Training and Evaluation Complete!");
        } catch (Exception e) {
            // Handle any exceptions that occur during data preprocessing, model training, or evaluation
            e.printStackTrace();
        }
    }
}
