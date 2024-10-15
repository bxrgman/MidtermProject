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

        // Set the target attribute as the last attribute in the dataset
        data.setClassIndex(data.numAttributes() - 1);
        return data;
    }

    // Handle missing values
    public Instances handleMissingValues(Instances data) throws Exception {
        ReplaceMissingValues replaceMissing = new ReplaceMissingValues();
        replaceMissing.setInputFormat(data);
        return Filter.useFilter(data, replaceMissing);
    }

    // Convert string attributes to nominal (excluding the target attribute)
    public Instances convertStringToNominal(Instances data) throws Exception {
        StringToNominal stringToNominal = new StringToNominal();

        // Set range to convert all attributes except the last one (target)
        stringToNominal.setAttributeRange("first-" + (data.numAttributes() - 2));
        stringToNominal.setInputFormat(data);
        return Filter.useFilter(data, stringToNominal);
    }

    // Convert numeric attributes that are categorical to nominal (excluding the target)
    public Instances convertToNominal(Instances data) throws Exception {
        NumericToNominal convert = new NumericToNominal();

        // Convert only the relevant numeric attributes that are categorical (not target)
        convert.setAttributeIndices("first-" + (data.numAttributes() - 2));
        convert.setInputFormat(data);
        return Filter.useFilter(data, convert);
    }
}
