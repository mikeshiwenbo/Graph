import java.util.PriorityQueue;

public class AComparator {
	//比较器可用于个体的比较，如：Array.sort(数据源,new AComparator<Student>());
Student[] sts = new Student[]{  
            new Student("小戴",60),  
            new Student("小王",90),  
            new Student("老王",80),  
            new Student("小萱",95)  
    };  
	
	public void sort(){
		java.util.Arrays.sort(sts,new StudentComparator());
	}
	//new StudentComparator() 作为比较原则放到PriorityQueue中，可形成大根堆或者小根堆
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
        return "姓名:"+this.name+",分数:"+this.score;  
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