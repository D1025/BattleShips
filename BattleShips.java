package BattleShips;
import java.util.Random;

import javax.lang.model.util.ElementScanner14;

public class BattleShips
{

    public class List
    {
        Obiekt first;
        Integer size = 0;

        public void AddObj(Integer xn, Integer yn)
        {
            if(first == null)
            {
                first = new Obiekt(xn, yn);
                size++;
            }
            else
            {
                Obiekt temp = first;
                while(temp.next !=null)
                {
                    temp = temp.next;
                }
                temp.next = new Obiekt(xn, yn);
                size++;
            }
        }
        public void AddAllOver(Integer xn, Integer yn)
        {
            if (!Compare(xn, yn))
                AddObj(xn, yn);
            if (!Compare(xn+1, yn))
                AddObj(xn+1, yn);
            if (!Compare(xn+1, yn+1))
                AddObj(xn+1, yn+1);
            if (!Compare(xn+1, yn-1))
                AddObj(xn+1, yn-1);
            if (!Compare(xn, yn+1))
                AddObj(xn, yn+1);
            if (!Compare(xn-1, yn+1))
                AddObj(xn-1, yn+1);
            if (!Compare(xn-1, yn-1))
                AddObj(xn-1, yn-1);
            if (!Compare(xn-1, yn))
                AddObj(xn-1, yn);
            if (!Compare(xn, yn-1))
                AddObj(xn, yn-1);
        }
        public boolean Compare(Integer xn, Integer yn)
        {
            Obiekt temp = first;
            while(temp != null)
            {
                if (temp.x.equals(xn) && temp.y.equals(yn))
                {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }

    
    }
    public class Obiekt
    {
        Integer x;
        Integer y;
        Obiekt next;

        Obiekt(Integer xn, Integer yn)
        {
            x=xn;
            y=yn;
        }
    }

    public class Macierz
    {
        Integer[][] macierz;
        Macierz()
        {
            macierz = new Integer [10][10];

            for (int i=0; i<10; i++)
            {
                for(int j=0; j<10; j++)
                {
                    macierz[i][j]=0;
                }
            }
        }


        public void SetStatki()
        {
            Random Ran = new Random();
            List list = new List();
            int j1 = 10;
            int j2 = 10;
            int d1 = 4;
            int j1_ran;
            int j2_ran;
            int direction;
            //czteromasztowiec
            j1_ran = Ran.nextInt(j1);
            j2_ran = Ran.nextInt(j2);
            list.AddAllOver(j1_ran, j2_ran);
            macierz[j1_ran][j2_ran]=-1;
            direction = Ran.nextInt(d1) +1;
            switch(direction)
            {
                case 1:
                    for(int i = 0; i<3; i++)
                    {
                        if(j1_ran-1 < 0)
                        {
                            j1_ran+=4;

                        }
                        macierz[j1_ran-1][j2_ran]=-1;
                        list.AddAllOver(j1_ran-1, j2_ran);
                        j1_ran--;
                    }
                    break;
                case 2:
                    for(int i = 0; i<3; i++)
                    {
                        if(j1_ran+1 > 9)
                        {
                            j1_ran-=4;
                        }
                        macierz[j1_ran+1][j2_ran]=-1;
                        list.AddAllOver(j1_ran+1, j2_ran);
                        j1_ran++;
                    }
                    break;
                case 3:
                    for(int i = 0; i<3; i++)
                    {
                        if(j2_ran-1 < 0)
                        {
                            j2_ran+=4;
                        }
                        macierz[j1_ran][j2_ran-1]=-1;
                        list.AddAllOver(j1_ran, j2_ran-1);
                        j2_ran--;
                    }
                    break;
                case 4:
                    for(int i = 0; i<3; i++)
                    {
                        if(j2_ran+1 > 9)
                        {
                            j2_ran-=4;
                        }
                        macierz[j1_ran][j2_ran+1]=-1;
                        list.AddAllOver(j1_ran, j2_ran+1);
                        j2_ran++;
                    }
                    break;
                    
            }


            //2 - trzymasztowe
            for(int j = 0; j<2; j++)
            {
                j1_ran = Ran.nextInt(j1);
                j2_ran = Ran.nextInt(j2);
                direction = Ran.nextInt(d1) +1;
                if(!list.Compare(j1_ran, j2_ran))
                {
                    switch(direction)
                    {
                        case 1:
                            if(j1_ran-1 < 0)
                            {
                                if(list.Compare(j1_ran+1, j2_ran) || list.Compare(j1_ran+2, j2_ran))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran+1][j2_ran]=-1;
                                list.AddAllOver(j1_ran+1, j2_ran);     
                                macierz[j1_ran+2][j2_ran]=-1;
                                list.AddAllOver(j1_ran+2, j2_ran);       
                            }
                            else
                            {
                                if(list.Compare(j1_ran-1, j2_ran) || list.Compare(j1_ran-2, j2_ran))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran-1][j2_ran]=-1;
                                list.AddAllOver(j1_ran-1, j2_ran);
                                macierz[j1_ran-2][j2_ran]=-1;
                                list.AddAllOver(j1_ran-2, j2_ran);
                            }
                            break;
                        case 2:
                            if(j1_ran+1 > 9)
                            {
                                if(list.Compare(j1_ran-1, j2_ran) || list.Compare(j1_ran-2, j2_ran))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran-1][j2_ran]=-1;
                                list.AddAllOver(j1_ran-1, j2_ran);
                                macierz[j1_ran-2][j2_ran]=-1;
                                list.AddAllOver(j1_ran-2, j2_ran);
                            }
                            else 
                            {
                                if(list.Compare(j1_ran+1, j2_ran) || list.Compare(j1_ran+2, j2_ran))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran+1][j2_ran]=-1;
                                list.AddAllOver(j1_ran+1, j2_ran);
                                macierz[j1_ran+2][j2_ran]=-1;
                                list.AddAllOver(j1_ran+2, j2_ran);
                            }
                            break;
                        case 3:
                            if(j2_ran-1 < 0)
                            {
                                if(list.Compare(j1_ran, j2_ran+1) || list.Compare(j1_ran, j2_ran+2))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran][j2_ran+1]=-1;
                                list.AddAllOver(j1_ran, j2_ran+1);
                                macierz[j1_ran][j2_ran+2]=-1;
                                list.AddAllOver(j1_ran, j2_ran+2);
                            }
                            else 
                            {
                                if(list.Compare(j1_ran, j2_ran-1) || list.Compare(j1_ran, j2_ran-2))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran][j2_ran-1]=-1;
                                list.AddAllOver(j1_ran, j2_ran-1);
                                macierz[j1_ran][j2_ran-2]=-1;
                                list.AddAllOver(j1_ran, j2_ran-2);
                            }
                            break;
                        case 4:
                            if(j2_ran+1 > 9)
                            {
                                if(list.Compare(j1_ran, j2_ran-1) || list.Compare(j1_ran, j2_ran-2))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran][j2_ran-1]=-1;
                                list.AddAllOver(j1_ran, j2_ran-1);
                                macierz[j1_ran][j2_ran-2]=-1;
                                list.AddAllOver(j1_ran, j2_ran-2);
                            }
                            else 
                            {
                                if(list.Compare(j1_ran, j2_ran+1) || list.Compare(j1_ran, j2_ran+2))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran][j2_ran+1]=-1;
                                list.AddAllOver(j1_ran, j2_ran+1);
                                macierz[j1_ran][j2_ran+2]=-1;
                                list.AddAllOver(j1_ran, j2_ran+2);
                            }
                            break;
                            
                    }
                    list.AddAllOver(j1_ran, j2_ran);
                    macierz[j1_ran][j2_ran] = -1;
                }
                else
                {
                    j--;
                    continue;
                }
    
            }


            //3 dwumasztowe
            for(int j = 0; j<3; j++)
            {
                j1_ran = Ran.nextInt(j1);
                j2_ran = Ran.nextInt(j2);
                direction = Ran.nextInt(d1) +1;
                if(!list.Compare(j1_ran, j2_ran))
                {
                    switch(direction)
                    {
                        case 1:
                            if(j1_ran-1 < 0)
                            {
                                if(list.Compare(j1_ran+1, j2_ran))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran+1][j2_ran]=-1;
                                list.AddAllOver(j1_ran+1, j2_ran);        
                            }
                            else
                            {
                                if(list.Compare(j1_ran-1, j2_ran))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran-1][j2_ran]=-1;
                                list.AddAllOver(j1_ran-1, j2_ran);
                            }
                            break;
                        case 2:
                            if(j1_ran+1 > 9)
                            {
                                if(list.Compare(j1_ran-1, j2_ran))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran-1][j2_ran]=-1;
                                list.AddAllOver(j1_ran-1, j2_ran);
                            }
                            else 
                            {
                                if(list.Compare(j1_ran+1, j2_ran))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran+1][j2_ran]=-1;
                                list.AddAllOver(j1_ran+1, j2_ran);
                            }
                            break;
                        case 3:
                            if(j2_ran-1 < 0)
                            {
                                if(list.Compare(j1_ran, j2_ran+1))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran][j2_ran+1]=-1;
                                list.AddAllOver(j1_ran, j2_ran+1);
                            }
                            else 
                            {
                                if(list.Compare(j1_ran, j2_ran-1))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran][j2_ran-1]=-1;
                                list.AddAllOver(j1_ran, j2_ran-1);
                            }
                            break;
                        case 4:
                            if(j2_ran+1 > 9)
                            {
                                if(list.Compare(j1_ran, j2_ran-1))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran][j2_ran-1]=-1;
                                list.AddAllOver(j1_ran, j2_ran-1);
                            }
                            else 
                            {
                                if(list.Compare(j1_ran, j2_ran+1))
                                {
                                    j--;
                                    continue;
                                }
                                macierz[j1_ran][j2_ran+1]=-1;
                                list.AddAllOver(j1_ran, j2_ran+1);
                            }
                            break;
                            
                    }
                    list.AddAllOver(j1_ran, j2_ran);
                    macierz[j1_ran][j2_ran] = -1;
                }
                else
                {
                    j--;
                    continue;
                }
    
            }



            //jedno-masztowe - na koniec
            for(int i = 0; i<4; i++)
            {
                j1_ran = Ran.nextInt(j1);
                j2_ran = Ran.nextInt(j2);

                if(!list.Compare(j1_ran, j2_ran))
                {
                    list.AddAllOver(j1_ran, j2_ran);
                    macierz[j1_ran][j2_ran] = -1;
                }
                else
                {
                    i--;
                    continue;
                }

            }
        }

    }

    Macierz macierz_s = new Macierz();
    public void Rysuj()
    {
        macierz_s.SetStatki();
        for(Integer i=0; i<11; i++)
        {
            for(Integer n=0; n<11; n++)
            {
                if (i.equals(0))
                {
                    System.out.print("   ");
                    for(int j = 0; j<10; j++)
                    {
                        System.out.printf(" %c ", 'A'+j);
                    }
                    break;
                }
                else if(n.equals(0))
                {
                    System.out.printf(" %d ", i-1);
                }
                else 
                {
                    if (macierz_s.macierz[i-1][n-1].equals(1)) // Miss
                    {
                        System.out.print("[*]");
                    }
                    else if (macierz_s.macierz[i-1][n-1].equals(-1)) //Destoyed
                    {
                        System.out.print("[X]");
                    }
                    else 
                    {
                        System.out.print("[ ]"); //Not checked
                    }

                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");

    }

    public static void main(String[] args)
    {
        BattleShips obj = new BattleShips();
        obj.Rysuj();

    }
    
}
