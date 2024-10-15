package com.burgman.midterm;

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.RemoveUseless;
import weka.filters.unsupervised.attribute.ReplaceMissingValues;
import weka.filters.unsupervised.attribute.NumericToNominal;
import java.io.File;

public class DataPreprocessing {

    // Load the dataset from the CSV file
    public Instances loadDataset(String filepath) throws Exception {
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File(filepath));
        Instances data = loader.getDataSet();
        return data;
    }

    // Handle missing values
    public Instances handleMissingValues(Instances data) throws Exception {
        ReplaceMissingValues replaceMissing = new ReplaceMissingValues();
        replaceMissing.setInputFormat(data);
        Instances newData = Filter.useFilter(data, replaceMissing);
        return newData;
    }

    // Scale numeric features (using WEKA's built-in scaling)
    public Instances scaleNumericFeatures(Instances data) throws Exception {
        RemoveUseless removeUseless = new RemoveUseless();
        removeUseless.setInputFormat(data);
        Instances scaledData = Filter.useFilter(data, removeUseless);
        return scaledData;
    }

    // Convert categorical attributes to nominal (if required)
    public Instances convertToNominal(Instances data) throws Exception {
        NumericToNominal convert = new NumericToNominal();
        convert.setInputFormat(data);
        Instances nominalData = Filter.useFilter(data, convert);
        return nominalData;
    }
}
