package pl.edu.agh;

import org.jblas.FloatMatrix;

class ReturnShift {
    private FloatMatrix matrixU;
    private FloatMatrix matrixW;
    private BaseFunctionsHandler baseFunctionsHandler;
    private int n;

    public ReturnShift(FloatMatrix matrixW, BaseFunctionsHandler baseFunctionsHandler, int n) {
        this.n=n;
        this.matrixU=FloatMatrix.zeros(n);
        this.matrixW=matrixW;
        this.baseFunctionsHandler=baseFunctionsHandler;
    }
    FloatMatrix getU(){
        float x, sumOfCoefMultByBaseFcts;
        for(int i=0; i<n; i++) { //diving the range into smaller pieces
            x=(float)i/n;
            sumOfCoefMultByBaseFcts=0;

            for(int j=0; j<n; j++)
                sumOfCoefMultByBaseFcts += matrixW.get(j) * baseFunctionsHandler.getBaseFunctions(x, n, j);

            matrixU.put(i, 5 * (1 - x) + sumOfCoefMultByBaseFcts);
        }
        return matrixU;
    }
}