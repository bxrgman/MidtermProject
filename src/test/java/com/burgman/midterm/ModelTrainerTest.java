package com.burgman.midterm;

import org.junit.Before;
import org.junit.Test;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;

import static org.junit.Assert.*;

public class ModelTrainerTest {

    private ModelTrainer modelTrainer;
    private DataPreprocessing dataPreprocessing;
    private Instances data;

    @Before
    public void setUp() throws Exception {
        modelTrainer = new ModelTrainer();
        dataPreprocessing = new DataPreprocessing();
        // Load and preprocess the dataset
        data = dataPreprocessing.loadDataset("data/trainmvn.csv");
        data = dataPreprocessing.handleMissingValues(data);
        data = dataPreprocessing.convertStringToNominal(data);
        data = dataPreprocessing.convertToNominal(data);
    }

    @Test
    public void testTrainModel() throws Exception {
        LinearRegression model = modelTrainer.trainModel(data);
        // Ensure model is not null and built
        assertNotNull(model);
    }

    @Test
    public void testModelEvaluation() throws Exception {
        LinearRegression model = modelTrainer.trainModel(data);
        modelTrainer.evaluateModel(model, data);
    }
}
