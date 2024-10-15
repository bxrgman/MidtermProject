package com.burgman.midterm;

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.ReplaceMissingValues;
import weka.filters.unsupervised.attribute.StringToNominal;
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
        return Filter.useFilter(data, replaceMissing);
    }

    // Convert string attributes to nominal
    public Instances convertStringToNominal(Instances data) throws Exception {
        StringToNominal stringToNominal = new StringToNominal();
        stringToNominal.setAttributeRange("first-last"); // Apply to all string attributes
        stringToNominal.setInputFormat(data);
        return Filter.useFilter(data, stringToNominal);
    }

    // Convert categorical attributes to nominal (if necessary)
    public Instances convertToNominal(Instances data) throws Exception {
        NumericToNominal convert = new NumericToNominal();
        convert.setInputFormat(data);
        return Filter.useFilter(data, convert);
    }
}