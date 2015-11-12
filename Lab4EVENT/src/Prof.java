/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Prof {
	private String name;
	private Date midtermDate;
	private List<CourseListener> cl;

	public Prof(String aName) {
		this.name = aName;
		this.cl = new ArrayList<>();
		
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date) {
		this.midtermDate = date;
		CourseEvent e = new CourseEvent(this);
		for(CourseListener c: this.cl){
			c.midtermAnnounced(e);
		}
	}
	
	public void postponeMidterm(Date date){
		this.midtermDate = date;
		CourseEvent e = new CourseEvent(this);
		for(CourseListener c: this.cl){
			c.midtermPostponed(e);
		}
		
	}
	/*
	public void setTA(TeachingAssistant theTA){
		this.ta = theTA;
	}
	
	public void addStudent(Student s){
		this.students.add(s);
	}*/
	
	public void addCourseListener(CourseListener c){
		this.cl.add(c);
	}
	public void removeCourseListener(CourseListener c){
		this.cl.remove(c);
		
	}


	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
	
	
		p.addCourseListener(s);
		p.addCourseListener(s2);
		p.addCourseListener(ta);
	
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}