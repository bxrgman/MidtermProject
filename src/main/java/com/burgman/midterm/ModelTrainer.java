package com.burgman.midterm;

import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;
import java.util.Random;

public class ModelTrainer {

    // linear regression model
    public LinearRegression trainModel(Instances data) throws Exception {
        data.setClassIndex(data.numAttributes() - 1);

        LinearRegression model = new LinearRegression();

        model.buildClassifier(data);
        return model;
    }

    public void evaluateModel(LinearRegression model, Instances data) throws Exception {
        Evaluation evaluation = new Evaluation(data);
        evaluation.crossValidateModel(model, data, 10, new Random(1));

        System.out.println(evaluation.toSummaryString("\nEvaluation Results\n======\n", false));
        System.out.println("Correlation Coefficient: " + evaluation.correlationCoefficient());
    }
}
