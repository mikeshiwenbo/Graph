import java.util.PriorityQueue;

public class AComparator {
	//�Ƚ��������ڸ���ıȽϣ��磺Array.sort(����Դ,new AComparator<Student>());
Student[] sts = new Student[]{  
            new Student("С��",60),  
            new Student("С��",90),  
            new Student("����",80),  
            new Student("С��",95)  
    };  
	
	public void sort(){
		java.util.Arrays.sort(sts,new StudentComparator());
	}
	//new StudentComparator() ��Ϊ�Ƚ�ԭ��ŵ�PriorityQueue�У����γɴ���ѻ���С����
	PriorityQueue<Student> a=new PriorityQueue<>(new StudentComparator());
}

class Student {  
    private String name;  
    private double score;  
    public Student(String name,double score){  
        this.name = name;  
        this.score = score;  
    }  
    public double getScore(){  
        return this.score;  
    }  
    @Override  
    public String toString() {  
        return "����:"+this.name+",����:"+this.score;  
    }  
      
}  
class StudentComparator implements java.util.Comparator<Student> {  
    @Override  
    public int compare(Student o1,Student o2) {  
        if(o1.getScore() > o2.getScore()){  
            return 1;  
        }else if(o1.getScore() < o2.getScore()){  
            return -1;  
        }else{  
            return 0;  
        }  
    }  
} 