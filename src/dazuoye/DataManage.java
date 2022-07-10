package dazuoye;
import java.io.*;
import java.io.File;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;

public class DataManage {

    public DataManage() throws IOException {}
    public String [] name = new String[101];
    public String [] course = new String[101];
    public String [][] grade = new String[101][101];
    public int countProject = 0;
    public int countPerson = 0;

    public void addCourse(String str)
    {
        countProject++;
        course[countProject] = str;
        for(int i=1;i<=countPerson;i++)grade[i][countProject]="60";
    }

    public String getName(int i)
    {
        return name[i];
    }

    public String getCourse(int i) {return course[i];}
    public void changeCourse(String a,String b)
    {
        for(int i=1;i<=countProject;++i)
        {
            if(course[i].equals(a))
            {
                course[i] = b;break;
            }
        }
    }

    public void deleteCourse(String a)
    {
        for(int i=1;i<=countProject;i++)
        {
            if(course[i].equals(a))
            {
                if(i==countProject) countProject--;
                else {
                    for(int j=i;j<countProject;j++)
                    {
                        course[j]=course[j+1];
                        for(int l=1;l<=countPerson;l++)grade[l][j]=grade[l][j+1];
                    }
                    countProject--;
                }
            }
        }
    }
    public String getGrade(int i,int j) {return grade[i][j];}

    public void addGrade(String a)
    {
        countPerson++;
        name[countPerson] = a;
        for(int j=1;j<=countProject;j++)grade[countPerson][j] = "60";
    }

    public void changeGrade(String a,String b,String c)     //a是姓名，b是课程，c是分数
    {
        boolean judgeOne = false;
        boolean judgeTwo = false;
        int markA = 0;
        int markB = 0;
        for(int i=1;i<=countPerson;i++)
        {
            if(a.equals(name[i]))
            {
                markA = i;judgeOne = true;break;
            }
        }
        for(int j=1;j<=countProject;j++)
        {
            if(b.equals(course[j]))
            {
                markB = j;judgeTwo = true;break;
            }
        }
        if(judgeOne&&judgeTwo)grade[markA][markB] = c;
    }

    public void deleteGrade(String a)
    {
        for(int i=1;i<=countPerson;i++)
        {
            if(name[i].equals(a))
            {
                if(i==countPerson)countPerson--;
                else {
                    for(int j = i;j<countPerson;j++)
                    {
                        name[j]=name[j+1];
                        for(int l=1;l<=countProject;l++)grade[j][l]=grade[j+1][l];
                    }
                    countPerson--;
                }
            }
        }

    }


    public int get_countPerson()
    {
        return countPerson;
    }
    public int get_countProject()
    {
        return countProject;
    }




    public void readData() throws IOException {
        FileReader fr1 = new FileReader("Course.txt");
        BufferedReader br1 = new BufferedReader(fr1);
        String str1;
        while ((str1 = br1.readLine()) != null) {
            course[countProject + 1] = str1;
            countProject++;
        }
        br1.close();
        fr1.close();

        FileReader fr2 = new FileReader("Name.txt");
        BufferedReader br2 = new BufferedReader(fr2);
        String str2;
        while ((str2 = br2.readLine()) != null) {
            name[countPerson + 1] = str2;
            countPerson++;
        }
        br2.close();
        fr2.close();

        FileReader fr3 = new FileReader("Data.txt");
        BufferedReader br3 = new BufferedReader(fr3);
        //int a = countPerson;
        //int b = countProject;
        String str3;
        int i = 1;
        int j = 1;
        while ((str3 = br3.readLine()) != null) {
            if (j > countProject) {
                j = 1;
                i++;
            }
            if (i > countPerson) break;
            grade[i][j] = str3;
            j++;
        }
        br3.close();fr3.close();
    }

    public void clearData() {
        File file1 = new File("Data.txt");
        try {
            FileWriter fileWriter1 =new FileWriter(file1);
            fileWriter1.write("");
            fileWriter1.flush();
            fileWriter1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file2 = new File("Course.txt");
        try {
            FileWriter fileWriter2 =new FileWriter(file2);
            fileWriter2.write("");
            fileWriter2.flush();
            fileWriter2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file3 = new File("Name.txt");
        try {
            FileWriter fileWriter3 =new FileWriter(file3);
            fileWriter3.write("");
            fileWriter3.flush();
            fileWriter3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void writeData() throws IOException
    {
        try {
            BufferedWriter out1 = new BufferedWriter(new FileWriter("Name.txt"));
            for(int i=1;i<=countPerson;i++) out1.write(name[i]+"\r\n");
            out1.close();
        } catch (IOException e) {}

        try {
            BufferedWriter out2 = new BufferedWriter(new FileWriter("Course.txt"));
            for(int i=1;i<=countProject;i++) out2.write(course[i]+"\r\n");
            out2.close();
        } catch (IOException e) {}

        try {
            BufferedWriter out3 = new BufferedWriter(new FileWriter("Data.txt"));
            for(int i=1;i<=countPerson;i++)
                for(int j=1;j<=countProject;j++)out3.write(grade[i][j]+"\r\n");
            out3.close();
        } catch (IOException e) {}

    }


}
