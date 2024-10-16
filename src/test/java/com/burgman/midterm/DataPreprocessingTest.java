package com.burgman.midterm;

import org.junit.Before;
import org.junit.Test;
import weka.core.Instances;

import static org.junit.Assert.*;

public class DataPreprocessingTest {

    private DataPreprocessing dataPreprocessing;
    private Instances data;

    @Before
    public void setUp() throws Exception {
        dataPreprocessing = new DataPreprocessing();
        // Load a small subset of data for testing
        data = dataPreprocessing.loadDataset("data/train.csv");
    }

    @Test
    public void testHandleMissingValues() throws Exception {
        Instances processedData = dataPreprocessing.handleMissingValues(data);
        // Verify no missing values are present
        for (int i = 0; i < processedData.numInstances(); i++) {
            assertFalse(processedData.instance(i).hasMissingValue());
        }
    }

    @Test
    public void testConvertStringToNominal() throws Exception {
        Instances processedData = dataPreprocessing.convertStringToNominal(data);
        // Check if string attributes are converted to nominal
        for (int i = 0; i < processedData.numAttributes() - 1; i++) {
            if (processedData.attribute(i).isString()) {
                assertTrue(processedData.attribute(i).isNominal());
            }
        }
    }
}
