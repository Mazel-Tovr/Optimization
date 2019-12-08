using System;

namespace Lab6
{
    class Program
    {
        static int N;
        static double Z;
        static Double[] X; 
        static double GO;

        static double function2000() { return Math.Pow(X[0] - 1, 2) + Math.Pow(X[1] - 3, 2) + 4 * Math.Pow(X[2] + 5, 2); }
        static void Main(string[] args)
        {
            Console.WriteLine("Метод наискорейшего спуска");
            Console.WriteLine("Функция Z = F(x1,x2,..xn) вычисляется в строке 2000 ");
            Console.WriteLine("Одномерный поиск производится методом квадратичной интерполяции");
            Console.WriteLine("Введите число переменных");
            string Input = Console.ReadLine();
            N = int.Parse(Input);

            X = new Double[N]; 
            Double[] Y = new Double[N];
            Double[] G = new Double[N];
            Double[] D = new Double[N];
            Double[] Arr_L = new Double[4];
            Double[] FF = new Double[4];

 
            Console.WriteLine("Введите начальные точки");

            for (int i = 0; i < N; i++)
            {
                X[i] = double.Parse(Console.ReadLine());
            }

            Console.WriteLine("Введите начальный шаг");
            double L = double.Parse(Console.ReadLine());

            Console.WriteLine("Текущие значения");

            for (int i = 0; i < N; i++) 
            {
                Y[i] = X[i];
            }

            Z = function2000();

            GO = 0;

            if (GO < 0.000001) goto label_1200;

            label_340:

            for (int i = 0; i < N; i++)
                D[i] = -G[i] / GO;  

            Arr_L[0] = 0;
            FF[0] = Z;
            double ZZ = Z;

            label_400:
                Arr_L[2] = L;

            for (int i = 0; i < N; i++)
                X[i] = Y[i] + Arr_L[2] * D[i];

            Z = function2000();

            FF[2] = Z;

            GO = 0;

            double G2 = 0;

            for (int i = 0; i < N; i++)
                G2 = G2 + G[i] * D[i];

            if (FF[2] >= FF[0] || G2 >= 0) goto label_520;

            L *= 2;
            goto label_400;

            label_520:
                Arr_L[1] = L / 2;

            for (int i = 0; i < N; i++) X[i] = Y[i] + Arr_L[1] * D[i];

            Z = function2000();

            FF[1] = Z;

            Arr_L[3] = L * (FF[1] - 0.75 * FF[0] - 0.25 * FF[2]) /
                (2 * FF[1] - FF[0] - FF[2]);      

            if (Arr_L[3] < 0)Console.WriteLine("Внимание");

            for (int i = 0; i < N; i++)
                X[i] = Y[i] + Arr_L[3] * D[i];

            Z = function2000();

            FF[3] = Z;

            label_700:

            for (int j = 0; j < 2; j++)    
            {
                for (int k = j + 1; k < 3; k++)   
                {
                    if (!(FF[j] <= FF[k]))    
                    {
                        double LL = Arr_L[j];
                        Arr_L[j] = Arr_L[k];
                       Arr_L[k] = LL;    

                        Double F0 = FF[j];
                        FF[j] = FF[k];
                        FF[k] = F0;    
                    }
                }
            }

            if (Math.Abs(Arr_L[0] - Arr_L[1]) < 0.00005) goto label_1000;    

            Double S1 = Math.Sign(Arr_L[1] - Arr_L[0]);
            Double S2 = Math.Sign(Arr_L[2] - Arr_L[0]);      

            Double S3 = Math.Sign(Arr_L[3] - Arr_L[0]);       

            if (S1 == S2 && S1 == -S3)
            {
                Arr_L[2] = Arr_L[3];
                FF[2] = FF[3];
            }                       

            Double DN = (Arr_L[1] - Arr_L[2]) * FF[0] + (Arr_L[2] - Arr_L[0])
                * FF[1] + (Arr_L[0] - Arr_L[1]) * FF[2];      

            Double F = (FF[0] - FF[1]) / (2 * DN);    

            F = F * (Arr_L[1] - Arr_L[2]) * (Arr_L[2] - Arr_L[0]);    

            Arr_L[3] = (Arr_L[0] + Arr_L[1]) / 2 + F;        

            for (int i = 0; i < N; i++)
                X[i] = Y[i] + Arr_L[3] * D[i];    

            Z = function2000();
            FF[3] = Z;      

            goto label_700;     

            label_1000:

            for (int i = 0; i < N; i++)
            {
                X[i] = Y[i] + Arr_L[0] * D[i];    

                Y[i] = X[i];
                Console.WriteLine($"x{i} = {X[i]}");    
            }                                

            Z = function2000();
            GO = 0;

            Console.WriteLine($"F = {Z}");   

            L /= 2;    

            if (GO > 0.00001) goto label_340;      

            label_1200: 
            
            Console.WriteLine();       

            for (int i = 0; i < N; i++)
                Console.WriteLine($"x{i} = {X[i]}");      

            Console.WriteLine($"\nМинимум функции" +
                $" F(x1, x2, x3, ..., xN) = {Z}");      




        }
    }
}
