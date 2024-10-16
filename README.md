# Midterm Project: House Price Prediction

## Overview
This project implements a **house price prediction application** using **Java** and **Weka**. It demonstrates the full software development lifecycle with tools such as **Maven**, **GitHub**, **Jenkins**, and **Docker** to automate, build, test, and deploy the solution.

The focus is on **development workflow**, leveraging Continuous Integration/Continuous Deployment (CI/CD) practices to ensure smooth builds and deployments.

---

## Tools and Technologies
- **Development Environment**: IntelliJ IDEA
- **Version Control**: GitHub
- **Build Automation**: Maven
- **Unit Testing**: JUnit
- **Machine Learning**: Weka (Linear Regression)
- **CI/CD**: Jenkins (GitHub Webhooks for automation)
- **Containerization**: Docker

---

## How It Works

1. **Data Preprocessing**:
   - The `DataPreprocessing` class loads and cleans the dataset using Weka.
   - It handles missing values and converts features to the required format.

2. **Model Training**:
   - The `ModelTrainer` class trains a **Linear Regression model** using the Weka library.

3. **Application Execution**:
   - The main logic in `Main.java` handles:
     - Dataset loading and preprocessing.
     - Model training and evaluation.
     - Printing results to the console.

4. **CI/CD Pipeline**:
   - **Jenkins** triggers the build and test process on each code push to GitHub.
   - Docker is used to package and run the application in a container.

---

## How to Build and Run the Project

### Prerequisites
- **Java** 8 or higher
- **Maven** installed
- **Docker** installed

### Clone the Repository
```bash
git clone https://github.com/aa32808/MidtermProject.git
cd MidtermProject
