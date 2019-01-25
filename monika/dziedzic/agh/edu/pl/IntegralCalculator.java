package monika.dziedzic.agh.edu.pl;

import org.jblas.FloatMatrix;

import java.util.ArrayList;

class IntegralCalculator{ //to calculate integrals and return them as a matrix
    //ArrayList<Float> integrals;//integrals are stored here
    private int n; //no of rows in the matrixes
    private float k;
    protected FloatMatrix matrixB;
    protected FloatMatrix matrixL;

    public IntegralCalculator(FloatMatrix matrixB, FloatMatrix matrixL, int n, float k){
       // this.integrals=new ArrayList<>();
        this.n=n;
        this.k=k;
        this.matrixB=matrixB;
        this.matrixL=matrixL;
    }
    protected FloatMatrix calculateMatrixB(){
        //...calculate integrals with help of Apache - to be developed - use FirstDerivative, SecondDerivative and DerivativeHandler!!!

        //put values into matrixB
        for(int i=0; i<n; i++) //most values are 0 because of the character of base functions
            for(int j=0; j<n; j++)
                matrixB.put(i,j,0);
        for(int i=1; i<n; i++) //values on the diagonal
            matrixB.put(i,i,2*k*n);
        for(int i=1; i<n-1; i++) //values over the diagonal
            matrixB.put(i,i+1,(float)1/2-k*n);
        for(int i=1; i<n; i++) //values below the diagonal
            matrixB.put(i,i-1,(float)-1/2-k*n);

        //special cases for boundaries
        matrixB.put(0,0,1);
        matrixB.put(n-1,n-1, k*n+(float)1/2);

        return matrixB;
    }
    protected FloatMatrix calculateMatrixL(){
        //put values into matrixL
        for(int i=1; i<n; i++)
            matrixL.put(i,(float)5*(i-n)/(n*n));

        //special cases for boundaries
        matrixL.put(0,0);
        matrixL.put(n-1,(float)-5/(6*n*n)+8*k);

        return matrixL;
    }
}