package Enum;

import java.util.Arrays;

/*
 * 와일드카드 타입 예제 
 */
public class T07_WildCardTest {
	
	/**
	 * 모든과정 수강생 정보 조회
	 * @param course
	 */
	public static void listCourseInfo(Course<?> course) {//public static<T> void listCourseInfo(Course<?> course) {
		System.out.println(course.getName()              //같은 말
				+" 수강생: "
				+ Arrays.toString(course.getStudents()));
	}
	
	/**학생 과정 수강 정보 조회
	 * 
	 * @param course 학생
	 */
	public static void listStudentCourseInfo(Course<? extends Student> course) {
		System.out.println(course.getName()
				+" 수강생: "
				+ Arrays.toString(course.getStudents()));
	}
	
	/**
	 * 직장인 및 일반인 과정 수강 정보 조회
	 * @param course  직장인 및 일반인
	 */
	public static void listWorkerCourseInfo(Course<? super Worker> course) {
		System.out.println(course.getName()
				+" 수강생: "
				+ Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
		Course<Person> personCourse = new Course("일반인 과정", 5);
		personCourse.add(new Person("일반인1"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("학생1"));
		personCourse.add(new HighStudent("고등학생1"));
		
		Course<Worker> workerCourse = new Course("직장인 과정",5);
		workerCourse.add(new Worker("직장인"));
		
		Course<Student> studentCourse = new Course("학생과정",5);
		studentCourse.add(new Student("학생1"));
		studentCourse.add(new HighStudent("고등학생1"));
		
		Course<HighStudent> highStudentCourse = new Course("고등학생 과정", 5);
		highStudentCourse.add(new HighStudent("고등학생1"));
		
		listCourseInfo(personCourse);
		listCourseInfo(workerCourse);
		listCourseInfo(studentCourse);
		listCourseInfo(highStudentCourse);
		System.out.println("--------------------------------------------------");
		
		//listStudentCourseInfo(workerCourse); 오류
		//listStudentCourseInfo(personCourse); 오류
		listStudentCourseInfo(studentCourse);
		listStudentCourseInfo(highStudentCourse);
		System.out.println("---------------------------------------------------");
		
		listWorkerCourseInfo(workerCourse);
		listWorkerCourseInfo(personCourse);
		//listWorkerCourseInfo(highStudentCourse); 오류
		//listWorkerCourseInfo(studentCourse); 오류
		
	}
}

//일반인 
class Person {
	String name; //이름 
	public Person(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}

//직장인
class Worker extends Person{
	public Worker(String name) {
		super(name);
	}
}

//학생
class Student extends Person {
	public Student(String name) {
		super(name);
		
	}
}

//고등학생
class HighStudent extends Student {
	public HighStudent(String name) {
		super(name);
	}
}

//수강과정
class Course<T> {
	private String name; //과정명 
	private T[] students;//수강생(제네릭 배열)
	
	public Course(String name,int capcity) {
		this.name =name;
		
		//타입파라미터 배열을 생성시 오브젝트 배열을 생성후, 타입 파라미터 배열로 캐스팅처리해야함
		//students = new T[capcity]; //제네릭 배열 생성 실패 
									//=>new 연산자는 생성할 객체의 타입이 명확히 정의 되어야 객체생성가능
		students=(T[])(new Object[capcity]);
	}
	//과정명 조회 
	public String getName() {return name;}
	
	//수강생 조회 
	public T[] getStudents() {return students;}
	
	//수강생 등록 
	public void add(T t) {
		
		for (int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i]=t;
				break;
				
			}
		}
	}
}




























































































