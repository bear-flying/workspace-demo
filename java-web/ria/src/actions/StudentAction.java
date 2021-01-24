package actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vos.Student;

import daos.StudentDao;

public class StudentAction  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if(method.equals("queryStudent")){
			queryStudent(request,response);
		}else if(method.equals("saveStudent")){
			saveStudent(request,response);
		}else if(method.equals("querybyid")){
			querybyid(request,response);
		}else if(method.equals("updateStudent")){
			updateStudent(request,response);
		}else if(method.equals("deleteStudent")){
			deleteStudent(request,response);
		}else if(method.equals("delselect")){
			delselect(request,response);
		}
	}

	public void delselect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("ids");
		System.out.println(ids);
		String[] ss = ids.split(",");
		StudentDao dao = new StudentDao();
		PrintWriter out = response.getWriter();
		if(ss.length>0){
			for(int i=0;i<ss.length;i++){
				dao.deleteOne(new Integer(ss[i]));
			}
			out.println(1);
			out.flush();
			out.close();
		}else{
			out.println(0);
			out.flush();
			out.close();
		}
			
	}

	public void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		StudentDao dao = new StudentDao();
		dao.deleteOne(new Integer(id));
		request.getRequestDispatcher("student?method=queryStudent").forward(request, response);
		
	}

	public void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String names = new  String(name.getBytes("ISO-8859-1"),"utf-8");
		String age = request.getParameter("age");
		String hiredate = request.getParameter("hiredate");
		StudentDao dao = new StudentDao();
		dao.updateStudent(new Student(new Integer(id),names,new Integer(age),Date.valueOf(hiredate)));
		request.getRequestDispatcher("student?method=queryStudent").forward(request, response);
		
	}

	public void querybyid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		//System.out.println(id);
		StudentDao dao = new StudentDao();
		Student st = dao.queryById(new Integer(id));
		request.setAttribute("student", st);
		request.getRequestDispatcher("showone.jsp").forward(request, response);
		
	}

	public void saveStudent(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		String name = request.getParameter("name");
		String names = new  String(name.getBytes("ISO-8859-1"),"utf-8");
		String age = request.getParameter("age");
		String hiredate = request.getParameter("hiredate");
		
		StudentDao dao = new StudentDao();
		dao.insert(new Student(names,new Integer(age),Date.valueOf(hiredate)));
		request.getRequestDispatcher("student?method=queryStudent").forward(request, response);
		
	}

	public void queryStudent(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		StudentDao sd= new StudentDao();
		List<Student> list = sd.queryAll();
		request.setAttribute("list", list);
		HttpSession session = request.getSession();
		int one = (Integer)session.getAttribute("one");
		if(one==1){
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("normal.jsp").forward(request, response);
		}
	}

}
