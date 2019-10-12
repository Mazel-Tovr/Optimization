package lab_2;

public class Task7
{
    private int D1;
    private int D2;
    private int D3;

    private int [][] hessMatrix = {
            {-2,2,0},
            {2,-12,20},
            {0,20,-46}
    };

    private void calculateDiagonalMinors() {
        D1 = hessMatrix[0][0];
        D2 = hessMatrix[0][0] * hessMatrix[1][1] - hessMatrix[0][1] * hessMatrix[1][0];
        D3 = hessMatrix[0][0] * hessMatrix[1][1] * hessMatrix[2][2] - hessMatrix[0][2] * hessMatrix[1][1] * hessMatrix[2][0];
    }

    public void getConclusionAboutThePresenceOfExtremes() {
        System.out.println("Диагональные миноры:");
        calculateDiagonalMinors();
        System.out.println("D1: " +D1);
        System.out.println("D2: " +D2);
        System.out.println("D3: " +D3);

        // has different signs
        if ((D1<0 && D2>0 && D3<0)||(D1>0 && D2>0 && D3<0)||(D1<0 && D2>0 && D3>0)||(D1<0 && D2<0 && D3>0))
            System.out.println("Поскольку диагональные миноры имеют различные знаки, то о выпуклости или вогнутости функции ничего сказать нельзя.");
    }






}
